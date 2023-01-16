package com.example.gameshop.mvcTest;

import com.example.gameshop.controller.HealthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestingWebApplicationTests {


    @Autowired
    private HealthController healthController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(healthController).isNotNull();
    }
}
