package com.example.bd.controller;

import com.example.bd.model.Actor;
import com.example.bd.repo.ActorRepo;
import netscape.javascript.JSObject;
import org.json.JSONObject;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import java.nio.charset.StandardCharsets;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;
//import org.junit.Assert;
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
/*
@SpringBootTest
@AutoConfigureMockMvc
public class ActorControllerTest {
    @Autowired
    public ActorRepo actorRepo;
    @Autowired
    public MockMvc mvc;
    /**
     * Проверка получения актера по id
     */
    /*
    @Test
    public void getActor(){
        try{
            long id = 1;
            this.mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/actors?id="+id))
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful())
                    .andExpect(mvcResult -> {
                        String body = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
                        JSONObject jsonObject = new JSONObject(body);
                        assertEquals(actorRepo.findActorById(id).getId(), jsonObject.getLong("id"));
                        assertEquals(actorRepo.findActorById(id).getFirst_NameA(), jsonObject.getString("first_NameA"));
                        assertEquals(actorRepo.findActorById(id).getLast_NameA(), jsonObject.getInt("last_NameA"));
                        assertEquals(actorRepo.findActorById(id).getBirthdayA(), jsonObject.getString("birthdayA"));

                    })
                    .andReturn();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

     */


    /**
     * Проверка post-запроса на актера
     */
    /*
    @Test
    public void newTeatr() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("first_NameA", "Олег");
            jsonObject.put("last_NameA", "Орлов");
            jsonObject.put("birthdayA", "12.12.2001");
            this.mvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/teatrs")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonObject.toString())
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***
     * тестирование Delete-запрос на удаление мероприятия театра
     */
/*
    @Test
    public void deleteTest() {
        try{
            long id =1;
            this.mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/actors/"+id)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*
    @Test
    public void findById() {
        Optional<Actor> expected = Optional.of(new Actor());

        Mockito.doReturn(expected)
                .when(actorRepo)
                .findById((long) 1);

        Assert.assertEquals(expected, actorRepo.findById((long) 1));
    }


     */
/*
}

 */
