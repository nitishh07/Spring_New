package com.telusko;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@Path ke jagah 

@RestController
public class AlienResource {
	
	@Autowired
	AlienRepository repo;
	
//	@RequestMapping("aliens")
//	@GetMapping("aliens")
//	public List<Alien> getAliens(){
//		List<Alien> aliens = new ArrayList<>();
//		
//		Alien a1 =new Alien();
//		a1.setId(101);
//		a1.setName("Nitish");
//		a1.setPoints(90);
//		
//		Alien a2 =new Alien();
//		a2.setId(102);
//		a2.setName("Pihu");
//		a2.setPoints(91);
//		
//		aliens.add(a1);
//		aliens.add(a2);
//		
//		return aliens;
//	}
	
	
	@GetMapping("aliens")
	public List<Alien> getAliens(){
		List<Alien> aliens = (List<Alien>) repo.findAll();
		
		return aliens;
	}
}
