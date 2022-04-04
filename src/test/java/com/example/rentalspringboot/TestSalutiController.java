package com.example.rentalspringboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static javax.swing.UIManager.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@ContextConfiguration(classes = Application.class) //entry point
public class TestSalutiController
{
    private MockMvc mvc; //simula specifica mvc

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach //il primo metodo eseguito all'avvio dell app
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(wac)


                .build();
    }


}
