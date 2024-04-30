package br.com.sistemas.magna.Model.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.sistemas.magna.model.Atleta;
import br.com.sistemas.magna.model.Estatistica;

public class EstatisticaTest {

    private Estatistica estatistica;

    @BeforeEach
    public void setUp() {
        estatistica = new Estatistica();
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        estatistica.setId(id);
        assertEquals(id, estatistica.getId());
    }

    @Test
    public void testSetAndGetNumeroDeGols() {
        Integer numeroDeGols = 3;
        estatistica.setNumeroDeGols(numeroDeGols);
        assertEquals(numeroDeGols, estatistica.getNumeroDeGols());
    }

    @Test
    public void testSetAndGetNumeroDeCartaoAmarelo() {
        Integer numeroDeCartaoAmarelo = 2;
        estatistica.setNumeroDeCartaoAmarelo(numeroDeCartaoAmarelo);
        assertEquals(numeroDeCartaoAmarelo, estatistica.getNumeroDeCartaoAmarelo());
    }

    @Test
    public void testSetAndGetNumeroDeCartaoVermelho() {
        Integer numeroDeCartaoVermelho = 1;
        estatistica.setNumeroDeCartaoVermelho(numeroDeCartaoVermelho);
        assertEquals(numeroDeCartaoVermelho, estatistica.getNumeroDeCartaoVermelho());
    }

    @Test
    public void testSetAndGetNomeCampeonato() {
        String nomeCampeonato = "Campeonato Brasileiro";
        estatistica.setNomeCampeonato(nomeCampeonato);
        assertEquals(nomeCampeonato, estatistica.getNomeCampeonato());
    }

    @Test
    public void testSetAndGetAtleta() {
        Atleta atleta = mock(Atleta.class);
        estatistica.setAtleta(atleta);
        assertEquals(atleta, estatistica.getAtleta());
    }
}
