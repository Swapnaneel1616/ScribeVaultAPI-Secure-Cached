package com.neel.FinalJournal.controller;

import com.neel.FinalJournal.api.response.WeatherResponse;
import com.neel.FinalJournal.entity.User;
import com.neel.FinalJournal.repository.UserEntryRepository;
import com.neel.FinalJournal.service.UserService;
import com.neel.FinalJournal.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserEntryController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserEntryRepository userEntryRepository;

    @Autowired
    private WeatherService weatherService;


     @PutMapping
     public ResponseEntity<?> updateUser(@RequestBody User user){
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         String name = authentication.getName();
         User byUserName = userService.findByUserName(name);
         byUserName.setUsername(user.getUsername());
         byUserName.setPassword(user.getPassword());
         byUserName.setEmail(user.getEmail());
         userService.saveNewUser(byUserName);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

     @DeleteMapping
     public ResponseEntity<?> deleteUser(){
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

         userEntryRepository.deleteByusername(authentication.getName());

         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

    @GetMapping
    public ResponseEntity<?> greetings(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Kolkata");
        String greeting = "";
        if(weatherResponse!= null){
            greeting = "Weather feels like " + weatherResponse.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("HI "+ authentication.getName()+" "+ greeting ,HttpStatus.OK);
    }


}
