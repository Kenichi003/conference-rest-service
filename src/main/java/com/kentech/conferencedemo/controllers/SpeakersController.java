package com.kentech.conferencedemo.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kentech.conferencedemo.models.Speaker;
import com.kentech.conferencedemo.repositories.SpeakerRepository;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
	
	@Autowired
	private SpeakerRepository speakersRepository;
	
	@GetMapping
	public List<Speaker> list() {
		return speakersRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Speaker get(@PathVariable Long id) {
		return speakersRepository.getOne(id);
	}
	
	@PostMapping
	public Speaker create(@RequestBody final Speaker speaker) {
		return speakersRepository.saveAndFlush(speaker);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		//check children records before deleting
		speakersRepository.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		//because this is a PUT, we expect all attributes replaced to be passed in or they become null. A PATCH would only replace what is needed
		//TODO: Add validation that all attributes are passed in, otherwise return a 400 bad pay load
		Speaker existingSpeaker = speakersRepository.getOne(id);
		BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
		//BeanUtils copies existing speaker and copies the incoming speaker data onto it, the third param is used to ignore that column
		return speakersRepository.saveAndFlush(existingSpeaker);
	}
}
