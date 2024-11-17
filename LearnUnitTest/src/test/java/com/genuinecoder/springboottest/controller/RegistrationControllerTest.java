package com.genuinecoder.springboottest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genuinecoder.springboottest.model.MyUser;
import com.genuinecoder.springboottest.model.MyUserRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationControllerTest {

    private static final Logger log = Logger.getLogger(RegistrationControllerTest.class.getName());

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MyUserRepository myUserRepository;


//    @BeforeEach
//    public void setup() {
//        log.log(Level.INFO,"[BEFORE-EACH] Cleanup invoked");
//    }
//
//    @AfterEach
//    public void cleanup() {
//        log.log(Level.INFO,"[AFTER-EACH] Cleanup invoked");
//        myUserRepository.deleteAll();
//    }

    @Test
    public void testCreateUser_ValidUser() throws Exception {
        var user = new MyUser();
        user.setUsername("Aleena");
        user.setPassword("1234");
        user.setRole("USER");

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/register/user")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(user))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("Aleena"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value(Matchers.not("1234")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").exists());
    }

    @Test
    public void testCreateUser_UserWithoutPassword() throws Exception {
        var user = new MyUser();
        user.setUsername("Aleena");
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/register/user")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(user))
                )
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}
