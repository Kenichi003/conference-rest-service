package com.kentech.conferencedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kentech.conferencedemo.models.Session;

public interface SessionRepository extends JpaRepository<Session,Long>{

}
