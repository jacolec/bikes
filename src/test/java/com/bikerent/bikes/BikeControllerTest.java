package com.bikerent.bikes;

import com.google.gson.Gson;
import com.bikerent.exception.BikeNotFoundException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@WebMvcTest(BikeController.class)
class BikeControllerTest {

    @MockBean
    private BikeService bikeService;
    @MockBean
    private BikeMapper bikeMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetBikes() throws Exception {
        //Given
        when(bikeService.getAllBikes()).thenReturn(List.of());

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/bikes/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void testGetBike() throws BikeNotFoundException, Exception {
        //Given
        Bike bike = new Bike(1L, "racing", 21);
        BikeDto bikeDto = new BikeDto(1L, "racing", 21);
        when(bikeService.getBike(1L)).thenReturn(bike);
        when(bikeMapper.mapToBikeDto(any())).thenReturn(bikeDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/bikes/{bikeId}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.type", Matchers.is("racing")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size", Matchers.is(21)));
    }

    @Test
    void testDeleteBike() throws BikeNotFoundException, Exception {
        //Given
        Bike bike = new Bike(1L, "racing", 21);
        when(bikeService.saveBike(any())).thenReturn(bike);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/bikes/{bikeId}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testAddBike() throws Exception {
        //Given
        BikeDto bikeDto = new BikeDto(1L, "racing", 21);
        when(bikeService.saveBike(any())).thenReturn(new Bike(1L, "racing", 21));

        Gson gson = new Gson();
        String json = gson.toJson(bikeDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .post("/bikes/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testUpdateBike() throws BikeNotFoundException, Exception {
        //Given
        Bike bike = new Bike(1L, "racing", 21);
        BikeDto bikeDto = new BikeDto(1L, "racing", 21);
        BikeDto updatedBike = new BikeDto(2L, "trekking", 23);
        when(bikeService.saveBike(bike)).thenReturn(new Bike(2L, "trekking", 23));
        when(bikeMapper.mapToBikeDto(any())).thenReturn(updatedBike);

        Gson gson = new Gson();
        String json = gson.toJson(bikeDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .put("/bikes/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(2L)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.type", Matchers.is("trekking")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size", Matchers.is(23)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}