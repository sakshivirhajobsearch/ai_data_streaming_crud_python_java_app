package com.ai.data.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai.data.streaming.config.StreamConfig;

public interface StreamConfigRepository extends JpaRepository<StreamConfig, Long> {
}