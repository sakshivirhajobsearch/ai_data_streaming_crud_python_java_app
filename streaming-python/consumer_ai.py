import json
from kafka import KafkaConsumer

# Load config
try:
    with open("config.json", "r") as f:
        config = json.load(f)
except FileNotFoundError:
    print("Error: config.json file not found!")
    exit(1)
except json.JSONDecodeError:
    print("Error: config.json is empty or invalid!")
    exit(1)

bootstrap_servers = config.get("bootstrap_servers", "localhost:9092")
topic = config.get("topic", "stream-data")
group_id = config.get("group_id", "consumer-group-1")

# Create Kafka consumer
try:
    consumer = KafkaConsumer(
        topic,
        bootstrap_servers=[bootstrap_servers],
        auto_offset_reset='earliest',
        group_id=group_id,
        value_deserializer=lambda m: m.decode('utf-8')
    )
    print(f"Connected to Kafka topic '{topic}' at {bootstrap_servers} ...")
except Exception as e:
    print(f"Error connecting to Kafka: {e}")
    exit(1)

# Consume messages
print("Waiting for messages. Press Ctrl+C to exit.\n")
try:
    for message in consumer:
        print(f"Received message: {message.value}")
except KeyboardInterrupt:
    print("\nConsumer stopped.")
finally:
    consumer.close()
