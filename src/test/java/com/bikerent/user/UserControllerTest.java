package com.bikerent.user;

import com.google.gson.Gson;
import com.bikerent.exception.UserNotFoundException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest
@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockBean
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetUsers() throws Exception {
        //Given
        when(userService.getAllUsers()).thenReturn(List.of());

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/users/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void testGetUser() throws UserNotFoundException, Exception {
        //Given
        User user = new User(1L, "John", "Smith", "test@test.com", 123456789);
        UserDto userDto = new UserDto(1L, "John", "Smith", "test@test.com", 123456789);
        when(userService.getUser(1L)).thenReturn(user);
        when(userMapper.mapToUserDto(any())).thenReturn(userDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/users/{userId}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname", Matchers.is("John")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname", Matchers.is("Smith")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mail", Matchers.is("test@test.com")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone", Matchers.is(123456789)));
    }

    @Test
    void testDeleteUser() throws UserNotFoundException, Exception {
        //Given
        User user = new User(1L, "John", "Smith", "test@test.com", 123456789);
        when(userService.saveUser(any())).thenReturn(user);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/users/{userId}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testCreateUser() throws Exception {
        //Given
        UserDto userDto = new UserDto(1L, "John", "Smith", "test@test.com", 123456789);
        when(userService.saveUser(any())).thenReturn(new User(1L, "John", "Smith", "test@test.com", 123456789));

        Gson gson = new Gson();
        String json = gson.toJson(userDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .post("/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testUpdateUser() throws UserNotFoundException, Exception {
        //Given
        User user = new User(1L, "John", "Smith", "test@test.com", 123456789);
        UserDto userDto = new UserDto(1L, "John", "Smith", "test@test.com", 123456789);
        UserDto updatedUser = new UserDto(2L, "Kate", "Messer", "kate@test.com", 789456123);
        when(userService.saveUser(user)).thenReturn(new User(2L, "Kate", "Messer", "kate@test.com", 789456123));
        when(userMapper.mapToUserDto(any())).thenReturn(updatedUser);

        Gson gson = new Gson();
        String json = gson.toJson(userDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .put("/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(2L)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname", Matchers.is("Kate")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname", Matchers.is("Messer")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mail", Matchers.is("kate@test.com")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone", Matchers.is(789456123)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}