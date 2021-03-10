package com.dorotajachtoma.conferenceapp.controller;


import com.dorotajachtoma.conferenceapp.model.Session;
import com.dorotajachtoma.conferenceapp.model.Speaker;
import com.dorotajachtoma.conferenceapp.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/speaker")
public class SpeakerController {

    private final SpeakerRepository speakerRepository;

    public SpeakerController(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Speaker> getAllSpeakers(){
        return speakerRepository.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Speaker getOneSpeaker(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker createSpeaker(@RequestBody final Speaker speaker){
        return speakerRepository.save(speaker);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker,existingSpeaker,"speaker_id");
        return speakerRepository.save(existingSpeaker);
    }


}
