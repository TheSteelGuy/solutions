package com.sbapi;

import com.sbapi.controller.LoginController;
import com.sbapi.controller.RegisterController;
import com.sbapi.model.User;

import com.sbapi.security.CustomUserDetailsService;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.plugin2.util.PojoUtil.toJson;
// unit test
@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    CustomUserDetailsService customUserDetailsService;

    // tests if a user can log in successfully
    @Test
    public void loginUserTest() throws Exception {

        Map<String, Object> map = new HashMap<>();
        map.put("email", "collo@gmail.com");
        map.put("password", "mypasword123");


        mvc.perform(post("api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(map)))
                .andExpect(status().isOk());
    }
}