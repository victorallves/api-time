package br.com.sistemas.magna.Model.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.sistemas.magna.model.Funcionarios;
import br.com.sistemas.magna.model.Time;

public class FuncionariosTest {

    private Funcionarios funcionarios;

    @BeforeEach
    public void setUp() {
        funcionarios = new Funcionarios();
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        funcionarios.setId(id);
        assertEquals(id, funcionarios.getId());
    }

    @Test
    public void testSetAndGetNomeCompleto() {
        String nomeCompleto = "João da Silva";
        funcionarios.setNomeCompleto(nomeCompleto);
        assertEquals(nomeCompleto, funcionarios.getNomeCompleto());
    }

    @Test
    public void testSetAndGetCargo() {
        String cargo = "Gerente";
        funcionarios.setCargo(cargo);
        assertEquals(cargo, funcionarios.getCargo());
    }

    @Test
    public void testSetAndGetSalario() {
        Double salario = 5000.0;
        funcionarios.setSalario(salario);
        assertEquals(salario, funcionarios.getSalario());
    }

    @Test
    public void testSetAndGetTime() {
        Time time = mock(Time.class);
        funcionarios.setTime(time);
        assertEquals(time, funcionarios.getTime());
    }
}
