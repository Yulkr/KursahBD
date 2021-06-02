package com.example.bd.controller;

import com.example.bd.model.Actor;
import com.example.bd.model.Teatr;
import com.example.bd.repo.TeatrRepo;
/*
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.nio.charset.StandardCharsets;
//import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

 */
import com.example.bd.service.TeatrService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import wearme.server.repository.AddressRepository;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

/*@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeatrControllerTest {
    @Autowired
    public MockMvc mvc;
    @Autowired
    public TeatrRepo teatrRepo;
    @Autowired
    TeatrService teatrService;
    /**
     * Проверка get-запроса все мероприятия театра
     */

    @Test
    public void getAllTeatrs() {
        try {
            this.mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/teatrs"))
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful())
                    .andExpect(mvcResult -> {
                        String body = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
                        JSONArray jsonArray = new JSONArray(body);
                        assertEquals(jsonArray.length(), this.teatrRepo.findAll().size());
                    })
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Проверка post-запроса театр
     */

    @Test
    public void newTeatr() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "Тест");
            jsonObject.put("genre", "Тест");
            jsonObject.put("author", "Тест");
            jsonObject.put("cost", 1000);
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

    /**
     * Проверка put-запроса на театр по id
     */

    @Test
    public void updateTeatrs() {
        try {
            long id = 1L;
            JSONObject jsonObject = new JSONObject();
            Teatr teatr = teatrRepo.findTeatrById(id);
            jsonObject.put("name",teatr.getName());
            jsonObject.put("id",teatr.getId());
            jsonObject.put("genre",teatr.getGenre());
            jsonObject.put("author",teatr.getAuthor());
            jsonObject.put("cost",teatr.getCost());
            this.mvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/teatrs/"+id)
                    .content(jsonObject.toString())
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


/* &&&&
    /***
     * тестирование PUT-запрос на обновление клиента
     */
/*
    @Test
    public void updateTeatr(){
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",1);
            jsonObject.put("name","Test");
            jsonObject.put("genre","Test");
            jsonObject.put("author", "Test");
            jsonObject.put("cost", "1111111111");
            this.mvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/teatrs/")
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

 */
    /***
     * тестирование Delete-запрос на удаление мероприятия театра
     */

    @Test
    public void deleteTest() {
        try{
            long id =1;
            this.mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/teatrs/"+id)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}


