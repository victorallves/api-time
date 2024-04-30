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

import br.com.sistemas.magna.controller.TecnicoController;
import br.com.sistemas.magna.dto.TecnicoDTO;
import br.com.sistemas.magna.service.TecnicoService;

@WebMvcTest(TecnicoController.class)
public class TecnicoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TecnicoService tecnicoService;

    @InjectMocks
    private TecnicoController tecnicoController;

    @Test
    public void testGetAllTecnicos() throws Exception {
        List<TecnicoDTO> tecnicos = new ArrayList<>();
        when(tecnicoService.getAllTecnicos()).thenReturn(tecnicos);

        mockMvc.perform(get("/tecnicos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTecnicoById() throws Exception {
        Long tecnicoId = 1L;
        TecnicoDTO tecnico = new TecnicoDTO();
        when(tecnicoService.getTecnicoById(tecnicoId)).thenReturn(Optional.of(tecnico));

        mockMvc.perform(get("/tecnicos/{id}", tecnicoId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateTecnico() throws Exception {
        TecnicoDTO tecnicoDTO = new TecnicoDTO();
        when(tecnicoService.createTecnico(tecnicoDTO)).thenReturn(tecnicoDTO);

        mockMvc.perform(post("/tecnicos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(tecnicoDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateTecnico() throws Exception {
        Long tecnicoId = 1L;
        TecnicoDTO tecnicoDetailsDTO = new TecnicoDTO();
        when(tecnicoService.updateTecnico(tecnicoId, tecnicoDetailsDTO)).thenReturn(Optional.of(tecnicoDetailsDTO));

        mockMvc.perform(put("/tecnicos/{id}", tecnicoId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(tecnicoDetailsDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteTecnico() throws Exception {
        Long tecnicoId = 1L;
        mockMvc.perform(delete("/tecnicos/{id}", tecnicoId))
                .andExpect(status().isNoContent());

        verify(tecnicoService, times(1)).deleteTecnico(tecnicoId);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
