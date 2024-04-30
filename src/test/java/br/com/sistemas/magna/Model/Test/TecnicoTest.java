package br.com.sistemas.magna.Model.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.sistemas.magna.model.Tecnico;
import br.com.sistemas.magna.model.Time;

public class TecnicoTest {

    private Tecnico tecnico;

    @BeforeEach
    public void setUp() {
        tecnico = new Tecnico();
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        tecnico.setId(id);
        assertEquals(id, tecnico.getId());
    }

    @Test
    public void testSetAndGetNomeTecnico() {
        String nomeTecnico = "José Silva";
        tecnico.setNomeTecnico(nomeTecnico);
        assertEquals(nomeTecnico, tecnico.getNomeTecnico());
    }

    @Test
    public void testSetAndGetNacionalidade() {
        String nacionalidade = "Brasileira";
        tecnico.setNacionalidade(nacionalidade);
        assertEquals(nacionalidade, tecnico.getNacionalidade());
    }

    @Test
    public void testSetAndGetValorTecnico() {
        Double valorTecnico = 5000.0;
        tecnico.setValorTecnico(valorTecnico);
        assertEquals(valorTecnico, tecnico.getValorTecnico());
    }

    @Test
    public void testSetAndGetSalario() {
        Double salario = 7000.0;
        tecnico.setSalario(salario);
        assertEquals(salario, tecnico.getSalario());
    }

    @Test
    public void testSetAndGetAreaAtuacao() {
        String areaAtuacao = "Futebol";
        tecnico.setAreaAtuacao(areaAtuacao);
        assertEquals(areaAtuacao, tecnico.getAreaAtuacao());
    }

    @Test
    public void testSetAndGetTime() {
        Time time = mock(Time.class);
        tecnico.setTime(time);
        assertEquals(time, tecnico.getTime());
    }
}
