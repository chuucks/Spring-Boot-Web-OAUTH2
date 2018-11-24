package com.codesolt.springbootweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codesolt.springbootweb.domain.Attendee;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {}
