package com.example.matheval;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should successfully calculate a simple mathematical expression")
    public void testCalculateSuccess() throws Exception {
        String jsonRequest = "{\"expression\":\"2 + 2 * 5\"}";

        mockMvc.perform(post("/v1/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(12.0)));
    }

    @Test
    @DisplayName("Should successfully calculate a complex expression with parentheses")
    public void testCalculateComplexSuccess() throws Exception {
        String jsonRequest = "{\"expression\":\"(10 + 5) / 3\"}";

        mockMvc.perform(post("/v1/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(5.0)));
    }

    @Test
    @DisplayName("Should return 400 Bad Request when the expression is syntactically invalid")
    public void testCalculateInvalidExpression() throws Exception {
        String jsonRequest = "{\"expression\":\"2 + * 3\"}";

        mockMvc.perform(post("/v1/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Should return 400 Bad Request when the expression is empty")
    public void testCalculateEmptyExpression() throws Exception {
        String jsonRequest = "{\"expression\":\"\"}";

        mockMvc.perform(post("/v1/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isBadRequest());
    }
}
