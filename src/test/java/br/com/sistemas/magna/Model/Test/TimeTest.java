package br.com.sistemas.magna.Model.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.sistemas.magna.model.Atleta;
import br.com.sistemas.magna.model.Tecnico;
import br.com.sistemas.magna.model.Time;

public class TimeTest {

    private Time time;

    @BeforeEach
    public void setUp() {
        time = new Time();
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        time.setId(id);
        assertEquals(id, time.getId());
    }

    @Test
    public void testSetAndGetName() {
        String nomeTime = "Time Magna";
        time.setNomeTime(nomeTime);
        assertEquals(nomeTime, time.getNomeTime());
    }

    @Test
    public void testSetAndGetCentroTreinamento() {
        String nomeCentroTreinamento = "CT Magna";
        time.setNomeCentroDeTreinamento(nomeCentroTreinamento);
        assertEquals(nomeCentroTreinamento, time.getNomeCentroDeTreinamento());
    }

    @Test
    public void testSetAndGetEstadio() {
        String nomeEstadio = "Estadio Magna";
        time.setNomeEstadio(nomeEstadio);
        assertEquals(nomeEstadio, time.getNomeEstadio());
    }

    @Test
    public void testSetAndGetTecnico() {
        Tecnico tecnico = mock(Tecnico.class);
        time.setTecnico(tecnico);
        assertEquals(tecnico, time.getTecnico());
    }

    @Test
    public void testSetAndGetAtletas() {
        List<Atleta> atletas = new ArrayList<>();
        Atleta atleta1 = mock(Atleta.class);
        Atleta atleta2 = mock(Atleta.class);
        atletas.add(atleta1);
        atletas.add(atleta2);
        time.setAtletas(atletas);
        assertEquals(atletas, time.getAtletas());
    }
}

