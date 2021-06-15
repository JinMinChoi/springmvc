package practice.springmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void matrix() throws Exception {
        mockMvc.perform(get("/events/1;name=jinmin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("jinmin"));
    }

    @Test
    public void param() throws Exception {
        /*mockMvc.perform(get("/eventsParam?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value(null));*/

        mockMvc.perform(get("/events/param")
                .param("id", "1")
                .param("name", "jinmin")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("jinmin"));
    }

    @Test
    public void 바인딩오류_SOUT_확인() throws Exception {
        mockMvc.perform(post("/ma")
                .param("name", "jinmin")
                .param("limit", "-10"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}