package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {

    List<Whisky> ofYear(int year);

    List<Whisky> ofRegion(String region);

    List<Whisky> distilleryAndAge(Distillery distillery, int age);
}
