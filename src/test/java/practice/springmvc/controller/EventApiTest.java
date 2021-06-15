package practice.springmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import practice.springmvc.Event;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EventApiTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createEvent() throws Exception {
        Event event = new Event();
        event.setName("jinmin");
        event.setLimit(-10);

        String eventJson = objectMapper.writeValueAsString(event);

        mockMvc.perform(
                post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(eventJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("jinmin"))
                .andExpect(jsonPath("limit").value(-10));
    }

}