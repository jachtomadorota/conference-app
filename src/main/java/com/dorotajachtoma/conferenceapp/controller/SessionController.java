package com.dorotajachtoma.conferenceapp.controller;


import com.dorotajachtoma.conferenceapp.model.Session;
import com.dorotajachtoma.conferenceapp.model.Speaker;
import com.dorotajachtoma.conferenceapp.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/session")
public class SessionController {

    private final SessionRepository sessionRepository;

    public SessionController(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Session> getAllSpeakers(){
        return sessionRepository.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Session getOneSession(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Session createSession(@RequestBody Session session){
        return sessionRepository.save(session);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session,existingSession,"session_id");
        return sessionRepository.save(existingSession);
    }
}
