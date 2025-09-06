package com.ai.data.streaming.config;

import jakarta.persistence.*;

@Entity
public class StreamConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String topic;
	private int intervalSeconds;
	private double anomalyThreshold;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getIntervalSeconds() {
		return intervalSeconds;
	}

	public void setIntervalSeconds(int intervalSeconds) {
		this.intervalSeconds = intervalSeconds;
	}

	public double getAnomalyThreshold() {
		return anomalyThreshold;
	}

	public void setAnomalyThreshold(double anomalyThreshold) {
		this.anomalyThreshold = anomalyThreshold;
	}

}
