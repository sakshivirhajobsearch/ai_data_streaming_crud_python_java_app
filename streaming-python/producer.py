import json
import time
from kafka import KafkaProducer

# Load configuration from JSON file
try:
    with open("config.json", "r") as f:
        config = json.load(f)
except FileNotFoundError:
    print("Error: config.json file not found!")
    exit(1)
except json.JSONDecodeError:
    print("Error: config.json contains invalid JSON!")
    exit(1)

# Extract Kafka configuration
bootstrap_servers = config.get("bootstrap_servers", "localhost:9092")
topic = config.get("topic", "stream-data")

# Initialize Kafka producer
try:
    producer = KafkaProducer(
        bootstrap_servers=bootstrap_servers,
        value_serializer=lambda v: json.dumps(v).encode("utf-8")
    )
except Exception as e:
    print(f"Error connecting to Kafka: {e}")
    exit(1)

# Produce some test messages
for i in range(10):
    message = {"id": i + 1, "value": f"data-{i + 1}"}
    try:
        producer.send(topic, message)
        print(f"Sent: {message}")
    except Exception as e:
        print(f"Error sending message: {e}")
    time.sleep(1)

producer.flush()
print("All messages sent successfully!")
