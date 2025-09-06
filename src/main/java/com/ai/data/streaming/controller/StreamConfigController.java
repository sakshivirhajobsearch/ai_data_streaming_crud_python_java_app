package com.ai.data.streaming.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.data.streaming.config.StreamConfig;
import com.ai.data.streaming.service.StreamConfigService;

@RestController
@RequestMapping("/api/config")
public class StreamConfigController {
	private final StreamConfigService service;

	public StreamConfigController(StreamConfigService service) {
		this.service = service;
	}

	@GetMapping
	public List<StreamConfig> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public StreamConfig getById(@PathVariable Long id) {
		return service.getById(id);
	}

	@PostMapping
	public StreamConfig create(@RequestBody StreamConfig config) {
		return service.save(config);
	}

	@PutMapping("/{id}")
	public StreamConfig update(@PathVariable Long id, @RequestBody StreamConfig config) {
		config.setId(id);
		return service.save(config);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}