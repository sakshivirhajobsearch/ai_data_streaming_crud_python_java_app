package com.ai.data.streaming.service;

import org.springframework.stereotype.Service;

import com.ai.data.streaming.config.StreamConfig;
import com.ai.data.streaming.repository.StreamConfigRepository;

import java.util.List;

@Service
public class StreamConfigService {
	private final StreamConfigRepository repo;

	public StreamConfigService(StreamConfigRepository repo) {
		this.repo = repo;
	}

	public List<StreamConfig> getAll() {
		return repo.findAll();
	}

	public StreamConfig getById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public StreamConfig save(StreamConfig cfg) {
		return repo.save(cfg);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
