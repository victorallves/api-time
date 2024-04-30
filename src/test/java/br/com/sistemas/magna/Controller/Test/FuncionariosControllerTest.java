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

import br.com.sistemas.magna.controller.FuncionariosController;
import br.com.sistemas.magna.dto.FuncionariosDTO;
import br.com.sistemas.magna.service.FuncionariosService;

@WebMvcTest(FuncionariosController.class)
public class FuncionariosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FuncionariosService funcionariosService;

    @InjectMocks
    private FuncionariosController funcionariosController;

    @Test
    public void testGetAllFuncionarios() throws Exception {
        List<FuncionariosDTO> funcionarios = new ArrayList<>();
        when(funcionariosService.getAllFuncionarios()).thenReturn(funcionarios);

        mockMvc.perform(get("/funcionarios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetFuncionariosById() throws Exception {
        Long funcionariosId = 1L;
        FuncionariosDTO funcionarios = new FuncionariosDTO();
        when(funcionariosService.getFuncionariosById(funcionariosId)).thenReturn(Optional.of(funcionarios));

        mockMvc.perform(get("/funcionarios/{id}", funcionariosId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateFuncionarios() throws Exception {
        FuncionariosDTO funcionariosDTO = new FuncionariosDTO();
        when(funcionariosService.createFuncionarios(funcionariosDTO)).thenReturn(funcionariosDTO);

        mockMvc.perform(post("/funcionarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(funcionariosDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateFuncionarios() throws Exception {
        Long funcionariosId = 1L;
        FuncionariosDTO funcionariosDetailsDTO = new FuncionariosDTO();
        when(funcionariosService.updateFuncionarios(funcionariosId, funcionariosDetailsDTO)).thenReturn(Optional.of(funcionariosDetailsDTO));

        mockMvc.perform(put("/funcionarios/{id}", funcionariosId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(funcionariosDetailsDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteFuncionarios() throws Exception {
        Long funcionariosId = 1L;
        mockMvc.perform(delete("/funcionarios/{id}", funcionariosId))
                .andExpect(status().isNoContent());

        verify(funcionariosService, times(1)).deleteFuncionarios(funcionariosId);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
