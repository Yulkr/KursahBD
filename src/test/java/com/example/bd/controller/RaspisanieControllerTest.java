package com.example.bd.controller;

import com.example.bd.model.Raspisanie;
import com.example.bd.repo.ActorRepo;
import com.example.bd.repo.RaspisanieRepo;
//import org.junit.runner.RunWith;
//import org.junit.Test;
import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RaspisanieControllerTest {
    @Autowired
    public RaspisanieRepo raspisanieRepo;
    @Autowired
    public MockMvc mvc;
    /***
     * тестирование GET-запрос на получение одного РАСПИСАНИЯ
     */

    @Test
    public void getRaspisanie() {
        try {
            long id = 1;
            this.mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/raspisanies/"+id))
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful())
                    .andExpect(mvcResult -> {
                        String body = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
                        JSONObject jsonObject = new JSONObject(body);
                        assertEquals(raspisanieRepo.findTeatrById(id).getId(), jsonObject.getLong("id"));
                        assertEquals(raspisanieRepo.findTeatrById(id).getData(), jsonObject.getString("data"));
                        assertEquals(raspisanieRepo.findTeatrById(id).getTime(), jsonObject.getString("time"));

                    })
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getRaspisanies() {
        try {
            long id = 2;
            this.mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080//raspisanies/{teatr_id}="+id))
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful())
                    .andExpect(mvcResult -> {
                        String body = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
                        JSONObject jsonObject = new JSONObject(body);
                        assertEquals(raspisanieRepo.findTeatrById(id).getId(), jsonObject.getLong("id"));
                        assertEquals(raspisanieRepo.findTeatrById(id).getData(), jsonObject.getString("data"));
                        assertEquals(raspisanieRepo.findTeatrById(id).getTime(), jsonObject.getString("time"));

                    })
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


