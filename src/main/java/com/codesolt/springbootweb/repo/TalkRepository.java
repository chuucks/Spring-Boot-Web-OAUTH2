package com.codesolt.springbootweb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codesolt.springbootweb.domain.Talk;

@Repository
@Transactional
public interface TalkRepository extends JpaRepository<Talk, Long> {
	List<Talk> findAllByEventId(Long id); 
}