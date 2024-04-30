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

import br.com.sistemas.magna.controller.EstatisticaController;
import br.com.sistemas.magna.dto.EstatisticaDTO;
import br.com.sistemas.magna.service.EstatisticaService;

@WebMvcTest(EstatisticaController.class)
public class EstatisticaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstatisticaService estatisticaService;

    @InjectMocks
    private EstatisticaController estatisticaController;

    @Test
    public void testGetAllEstatisticas() throws Exception {
        List<EstatisticaDTO> estatisticas = new ArrayList<>();
        when(estatisticaService.getAllEstatisticas()).thenReturn(estatisticas);

        mockMvc.perform(get("/estatisticas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetEstatisticaById() throws Exception {
        Long estatisticaId = 1L;
        EstatisticaDTO estatistica = new EstatisticaDTO();
        when(estatisticaService.getEstatisticaById(estatisticaId)).thenReturn(Optional.of(estatistica));

        mockMvc.perform(get("/estatisticas/{id}", estatisticaId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateEstatistica() throws Exception {
        EstatisticaDTO estatisticaDTO = new EstatisticaDTO();
        when(estatisticaService.createEstatistica(estatisticaDTO)).thenReturn(estatisticaDTO);

        mockMvc.perform(post("/estatisticas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(estatisticaDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateEstatistica() throws Exception {
        Long estatisticaId = 1L;
        EstatisticaDTO estatisticaDetailsDTO = new EstatisticaDTO();
        when(estatisticaService.updateEstatistica(estatisticaId, estatisticaDetailsDTO)).thenReturn(Optional.of(estatisticaDetailsDTO));

        mockMvc.perform(put("/estatisticas/{id}", estatisticaId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(estatisticaDetailsDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteEstatistica() throws Exception {
        Long estatisticaId = 1L;
        mockMvc.perform(delete("/estatisticas/{id}", estatisticaId))
                .andExpect(status().isNoContent());

        verify(estatisticaService, times(1)).deleteEstatistica(estatisticaId);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
