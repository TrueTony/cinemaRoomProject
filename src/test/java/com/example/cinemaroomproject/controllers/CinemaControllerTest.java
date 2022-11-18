package com.example.cinemaroomproject.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(CinemaController.class)
class CinemaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCinema() throws Exception {
        mockMvc.perform(get("/seats"))
                .andDo(print())
                .andExpect(content().json("{\"total_rows\":9,\"total_columns\":9," +
                        "\"available_seats\":[" +
                        "{\"row\":1,\"column\":1,\"price\":10},{\"row\":1,\"column\":2,\"price\":10},{\"row\":1,\"column\":3,\"price\":10}," +
                        "{\"row\":1,\"column\":4,\"price\":10},{\"row\":1,\"column\":5,\"price\":10},{\"row\":1,\"column\":6,\"price\":10}," +
                        "{\"row\":1,\"column\":7,\"price\":10},{\"row\":1,\"column\":8,\"price\":10},{\"row\":1,\"column\":9,\"price\":10}," +
                        "{\"row\":2,\"column\":1,\"price\":10},{\"row\":2,\"column\":2,\"price\":10},{\"row\":2,\"column\":3,\"price\":10}," +
                        "{\"row\":2,\"column\":4,\"price\":10},{\"row\":2,\"column\":5,\"price\":10},{\"row\":2,\"column\":6,\"price\":10}," +
                        "{\"row\":2,\"column\":7,\"price\":10},{\"row\":2,\"column\":8,\"price\":10},{\"row\":2,\"column\":9,\"price\":10}," +
                        "{\"row\":3,\"column\":1,\"price\":10},{\"row\":3,\"column\":2,\"price\":10},{\"row\":3,\"column\":3,\"price\":10}," +
                        "{\"row\":3,\"column\":4,\"price\":10},{\"row\":3,\"column\":5,\"price\":10},{\"row\":3,\"column\":6,\"price\":10}," +
                        "{\"row\":3,\"column\":7,\"price\":10},{\"row\":3,\"column\":8,\"price\":10},{\"row\":3,\"column\":9,\"price\":10}," +
                        "{\"row\":4,\"column\":1,\"price\":10},{\"row\":4,\"column\":2,\"price\":10},{\"row\":4,\"column\":3,\"price\":10}," +
                        "{\"row\":4,\"column\":4,\"price\":10},{\"row\":4,\"column\":5,\"price\":10},{\"row\":4,\"column\":6,\"price\":10}," +
                        "{\"row\":4,\"column\":7,\"price\":10},{\"row\":4,\"column\":8,\"price\":10},{\"row\":4,\"column\":9,\"price\":10}," +
                        "{\"row\":5,\"column\":1,\"price\":8},{\"row\":5,\"column\":2,\"price\":8},{\"row\":5,\"column\":3,\"price\":8}," +
                        "{\"row\":5,\"column\":4,\"price\":8},{\"row\":5,\"column\":5,\"price\":8},{\"row\":5,\"column\":6,\"price\":8}," +
                        "{\"row\":5,\"column\":7,\"price\":8},{\"row\":5,\"column\":8,\"price\":8},{\"row\":5,\"column\":9,\"price\":8}," +
                        "{\"row\":6,\"column\":1,\"price\":8},{\"row\":6,\"column\":2,\"price\":8},{\"row\":6,\"column\":3,\"price\":8}," +
                        "{\"row\":6,\"column\":4,\"price\":8},{\"row\":6,\"column\":5,\"price\":8},{\"row\":6,\"column\":6,\"price\":8}," +
                        "{\"row\":6,\"column\":7,\"price\":8},{\"row\":6,\"column\":8,\"price\":8},{\"row\":6,\"column\":9,\"price\":8}," +
                        "{\"row\":7,\"column\":1,\"price\":8},{\"row\":7,\"column\":2,\"price\":8},{\"row\":7,\"column\":3,\"price\":8}," +
                        "{\"row\":7,\"column\":4,\"price\":8},{\"row\":7,\"column\":5,\"price\":8},{\"row\":7,\"column\":6,\"price\":8}," +
                        "{\"row\":7,\"column\":7,\"price\":8},{\"row\":7,\"column\":8,\"price\":8},{\"row\":7,\"column\":9,\"price\":8}," +
                        "{\"row\":8,\"column\":1,\"price\":8},{\"row\":8,\"column\":2,\"price\":8},{\"row\":8,\"column\":3,\"price\":8}," +
                        "{\"row\":8,\"column\":4,\"price\":8},{\"row\":8,\"column\":5,\"price\":8},{\"row\":8,\"column\":6,\"price\":8}," +
                        "{\"row\":8,\"column\":7,\"price\":8},{\"row\":8,\"column\":8,\"price\":8},{\"row\":8,\"column\":9,\"price\":8}," +
                        "{\"row\":9,\"column\":1,\"price\":8},{\"row\":9,\"column\":2,\"price\":8},{\"row\":9,\"column\":3,\"price\":8}," +
                        "{\"row\":9,\"column\":4,\"price\":8},{\"row\":9,\"column\":5,\"price\":8},{\"row\":9,\"column\":6,\"price\":8}," +
                        "{\"row\":9,\"column\":7,\"price\":8},{\"row\":9,\"column\":8,\"price\":8},{\"row\":9,\"column\":9,\"price\":8}]}"))
                .andExpect(status().isOk());;
    }

    @Test
    void getSeat() throws Exception {
        mockMvc.perform(post("/purchase")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"row\": 5, \"column\": 7}")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.token", matchesPattern("\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}")))
                .andExpect(jsonPath("$.['ticket'].['row']", Matchers.is(5)))
                .andExpect(jsonPath("$.['ticket'].['column']", Matchers.is(7)))
                .andExpect(jsonPath("$.['ticket'].['price']", Matchers.is(8)))
                .andExpect(status().isOk());
    }

}