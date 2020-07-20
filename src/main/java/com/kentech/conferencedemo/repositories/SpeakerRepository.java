package com.kentech.conferencedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kentech.conferencedemo.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {

}
