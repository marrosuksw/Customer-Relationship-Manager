package com.java.clientmanager.clients;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.java.clientmanager.clients.*;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.List;

@SpringBootTest
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLoadClientData() throws Exception{

    }

}
