package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/bottled/{year}")
    public List<Whisky> findAllWhiskyYear(@PathVariable int year){
        return whiskyRepository.ofYear(year);
    }

    @GetMapping(value = "/distillery/{distillery}/age/{age}")
    public List<Whisky> findWhiskyByDistilleryAndAge(@PathVariable int distillery, @PathVariable int age){
        return whiskyRepository.distilleryAndAge(distillery, age);
    }
}
