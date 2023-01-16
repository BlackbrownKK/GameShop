package com.example.gameshop.mvcTest;


import com.example.gameshop.model.Game;
import com.example.gameshop.repasitory.GameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest  // надо полнять контекст
@AutoConfigureMockMvc // все бины будут созданы но не будет трогаться сервак
@ActiveProfiles("dev")
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private GameRepository gameRepository;


    @Test
    public void getGame() throws Exception {
        var game = gameRepository
                .save(Game.builder()
                        .name("Doom")
                        .rating(14)
                        .type("shoter")
                        .build());

        MvcResult mvcResult = mockMvc.perform(get("/game/" + game.getId()))
                .andExpect(status().isOk())
                .andDo(print()).andReturn();
    }
}
