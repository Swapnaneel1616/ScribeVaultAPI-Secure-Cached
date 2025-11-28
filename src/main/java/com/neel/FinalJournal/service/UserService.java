package com.neel.FinalJournal.service;

import com.neel.FinalJournal.entity.User;
import com.neel.FinalJournal.repository.UserEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserEntryRepository userEntryRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    public boolean saveNewUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userEntryRepository.save(user);
        } catch (Exception e) {
            log.error("Error occured" , e);
            return false;
        }
        return true;
    }

    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userEntryRepository.save(user);
    }

    public void saveUser(User user){
        userEntryRepository.save(user);

    }

    public List<User> getall(){
        return userEntryRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        if (id == null) return;
        userEntryRepository.deleteById(id);
    }

    public User findByUserName(String userName){
        if (userName == null) return null;
        return userEntryRepository.findByUsername(userName);
    }

}
