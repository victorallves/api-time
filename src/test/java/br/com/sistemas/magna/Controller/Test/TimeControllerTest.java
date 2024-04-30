package br.com.sistemas.magna.Controller.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.sistemas.magna.controller.TimeController;
import br.com.sistemas.magna.dto.TimeDTO;
import br.com.sistemas.magna.service.TimeService;

@WebMvcTest(TimeController.class)
public class TimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TimeService timeService;

    @InjectMocks
    private TimeController timeController;

    @Test
    public void testGetAllTimes() throws Exception {
        List<TimeDTO> times = new ArrayList<>();
        when(timeService.getAllTimes()).thenReturn(times);

        mockMvc.perform(get("/times")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTimeById() throws Exception {
        Long timeId = 1L;
        TimeDTO time = new TimeDTO();
        when(timeService.getTimeById(timeId)).thenReturn(Optional.of(time));

        mockMvc.perform(get("/times/{id}", timeId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateTime() throws Exception {
        TimeDTO timeDTO = new TimeDTO();
        when(timeService.createTime(timeDTO)).thenReturn(timeDTO);

        mockMvc.perform(post("/times")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(timeDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateTime() throws Exception {
        Long timeId = 1L;
        TimeDTO timeDetailsDTO = new TimeDTO();
        when(timeService.updateTime(timeId, timeDetailsDTO)).thenReturn(Optional.of(timeDetailsDTO));

        mockMvc.perform(put("/times/{id}", timeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(timeDetailsDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteTime() throws Exception {
        Long timeId = 1L;
        mockMvc.perform(delete("/times/{id}", timeId))
                .andExpect(status().isNoContent());

        verify(timeService, times(1)).deleteTime(timeId);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
