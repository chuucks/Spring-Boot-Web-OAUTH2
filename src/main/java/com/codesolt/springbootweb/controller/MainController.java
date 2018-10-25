package com.codesolt.springbootweb.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codesolt.springbootweb.domain.Event;
import com.codesolt.springbootweb.domain.Talk;
import com.codesolt.springbootweb.exception.EventNotFoundException;
import com.codesolt.springbootweb.repo.EventRepository;
import com.codesolt.springbootweb.repo.TalkRepository;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private EventRepository eventRepo;
	@Autowired
	private TalkRepository talkrepo;
	
    @GetMapping(value="/")
    public String getHomePage(Model model, Principal principal) {    	
    	if(principal!=null)
    		model.addAttribute("username", principal.getName());
        return "index";
    }
    
    @GetMapping(value="/event")
    public String getEvents(Model model) {
        List<Event> events = eventRepo.findAll();
        model.addAttribute("events", events);
        return "events-view";
    }
    
    @GetMapping(value="/event/{id}")
    public String getEvent(Model model, @PathVariable Long id) {
        Optional<Event> optional = eventRepo.findById(id);
        if(!optional.isPresent())
        	throw new EventNotFoundException("Event with Id: " + id + " not found");
    	List<Talk> talks = talkrepo.findAllByEventId(id);    	
    	model.addAttribute("event", optional.get());
        model.addAttribute("talks", talks);
        return "talks-view";
    }
    
    @GetMapping(value="/talks")
    public String getTalks(Model model) {
        List<Talk> talks = talkrepo.findAll();
        model.addAttribute("talks", talks);
        return "talks-view";
    }
}