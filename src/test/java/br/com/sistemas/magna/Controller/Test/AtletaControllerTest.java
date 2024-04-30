package br.com.sistemas.magna.Controller.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.sistemas.magna.controller.AtletaController;
import br.com.sistemas.magna.dto.AtletaDTO;
import br.com.sistemas.magna.service.AtletaService;

@WebMvcTest(AtletaController.class)
public class AtletaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AtletaService atletaService;

    @InjectMocks
    private AtletaController atletaController;

    @Test
    public void testGetAllAtletas() throws Exception {
        List<AtletaDTO> atletas = new ArrayList<>();
        atletas.add(new AtletaDTO());
        atletas.add(new AtletaDTO());
        when(atletaService.getAllAtletas()).thenReturn(atletas);

        mockMvc.perform(MockMvcRequestBuilders.get("/atletas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAtletaById() throws Exception {
        Long atletaId = 1L;
        AtletaDTO atleta = new AtletaDTO();
        when(atletaService.getAtletaById(atletaId)).thenReturn(Optional.of(atleta));

        mockMvc.perform(MockMvcRequestBuilders.get("/atletas/{id}", atletaId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateAtleta() throws Exception {
        AtletaDTO atletaDTO = new AtletaDTO();
        when(atletaService.createAtleta(atletaDTO)).thenReturn(atletaDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/atletas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(atletaDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testUpdateAtleta() throws Exception {
        Long atletaId = 1L;
        AtletaDTO atletaDetailsDTO = new AtletaDTO();
        when(atletaService.updateAtleta(atletaId, atletaDetailsDTO)).thenReturn(Optional.of(atletaDetailsDTO));
        mockMvc.perform(MockMvcRequestBuilders.put("/atletas/{id}", atletaId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(atletaDetailsDTO)))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


    @Test
    public void testDeleteAtleta() throws Exception {
        Long atletaId = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/atletas/{id}", atletaId))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        verify(atletaService, times(1)).deleteAtleta(atletaId);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
