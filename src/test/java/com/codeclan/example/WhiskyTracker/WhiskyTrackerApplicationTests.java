package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskyOfParticularYear() {
		List<Whisky> whiskiesOfYear = whiskyRepository.ofYear(2018);
	}

//	@Test
//	public void canGetWhiskyOfParticularRegion() {
//		List<Whisky> whiskiesOfRegion = whiskyRepository.ofRegion("Highland");
//	}

	@Test
	public void canGetDistilleryByRegion() {
		List<Distillery> distilleriesByRegion = distilleryRepository.ofRegion("Speyside");
	}
}
