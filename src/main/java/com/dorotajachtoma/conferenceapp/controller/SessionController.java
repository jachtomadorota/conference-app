package com.dorotajachtoma.conferenceapp.controller;


import com.dorotajachtoma.conferenceapp.model.Session;
import com.dorotajachtoma.conferenceapp.repository.SessionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/session")
public class SessionController {

    private final SessionRepository sessionRepository;

    public SessionController(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Session> getAllSessions(){
        return sessionRepository.findAll();
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Session getOneSession(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Session createSession(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }
}
