package com.dorotajachtoma.conferenceapp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity(name = "session_speakers")
public class SessionSpeaker {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




}
