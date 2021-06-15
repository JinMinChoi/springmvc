package practice.springmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void 헬로() throws Exception {
        mockMvc.perform(get("/sample/hello"))
                .andDo(print())
                .andExpect(status().isOk());

        /*mockMvc.perform(post("/sample/hi"))
                .andDo(print())
                .andExpect(status().isOk());*/
    }

    @Test
    public void 미디어_타입_컨텐트타입() throws Exception {
        mockMvc.perform(get("/sample/mediaType")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    
    @Test
    public void 미디어_타입_억셉트타입() throws Exception {
        mockMvc.perform(get("/sample/mediaType")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void 옵션() throws Exception {
        mockMvc.perform(options("/sample/hi"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void 메타애노테이션() throws Exception {
        mockMvc.perform(get("/sample/meta"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}