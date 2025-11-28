package com.neel.FinalJournal.service;

import com.neel.FinalJournal.entity.User;
import com.neel.FinalJournal.repository.UserEntryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


public class UserDetailsServiceImplTests {


    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;


    @Mock
    private UserEntryRepository userEntryRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUsernameByUsernameTest(){
        when(userEntryRepository.findByUsername("Neel")).
                thenReturn(User.builder().username("Neel").password("abc").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("Neel");
        assertNotNull(user);
    }
}
