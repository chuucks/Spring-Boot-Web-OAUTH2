package com.codesolt.springbootweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codesolt.springbootweb.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {}
