package com.sbapi;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.plugin2.util.PojoUtil.toJson;

@RunWith(SpringRunner.class)
@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {

    @Autowired MockMvc mvc;

    @MockBean CustomUserDetailsService customUserDetailsService;

    @Test
    public void registerUserTest() throws Exception {

        User user = new User("collins","colloo","collo@gmail.com", "mypasword123");

        mvc.perform(post("api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(user)))
                .andExpect(status().isCreated());
    }
}