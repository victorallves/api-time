package br.com.sistemas.magna.Model.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.sistemas.magna.model.Atleta;
import br.com.sistemas.magna.model.Estatistica;
import br.com.sistemas.magna.model.Time;

public class AtletaTest {

    private Atleta atleta;

    @BeforeEach
    public void setUp() {
        atleta = new Atleta();
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        atleta.setId(id);
        assertEquals(id, atleta.getId());
    }

    @Test
    public void testSetAndGetNomeCompleto() {
        String nomeCompleto = "Fulano de Tal";
        atleta.setNomeCompleto(nomeCompleto);
        assertEquals(nomeCompleto, atleta.getNomeCompleto());
    }

    @Test
    public void testSetAndGetCpf() {
        String cpf = "12345678900";
        atleta.setCpf(cpf);
        assertEquals(cpf, atleta.getCpf());
    }

    @Test
    public void testSetAndGetDataNascimento() {
        Date dataNascimento = Date.valueOf("2000-01-01");
        atleta.setDataNascimento(dataNascimento);
        assertEquals(dataNascimento, atleta.getDataNascimento());
    }

    @Test
    public void testSetAndGetTelefone() {
        Integer telefone = 123456789;
        atleta.setTelefone(telefone);
        assertEquals(telefone, atleta.getTelefone());
    }

    @Test
    public void testSetAndGetSalario() {
        Double salario = 1500.0;
        atleta.setSalario(salario);
        assertEquals(salario, atleta.getSalario());
    }

    @Test
    public void testSetAndGetValorAtleta() {
        Double valorAtleta = 2000.0;
        atleta.setValorAtleta(valorAtleta);
        assertEquals(valorAtleta, atleta.getValorAtleta());
    }

    @Test
    public void testSetAndGetPosicaoAtleta() {
        String posicaoAtleta = "Atacante";
        atleta.setPosicaoAtleta(posicaoAtleta);
        assertEquals(posicaoAtleta, atleta.getPosicaoAtleta());
    }

    @Test
    public void testSetAndGetNacionalidade() {
        String nacionalidade = "Brasil";
        atleta.setNacionalidade(nacionalidade);
        assertEquals(nacionalidade, atleta.getNacionalidade());
    }

    @Test
    public void testSetAndGetNomePai() {
        String nomePai = "Pai do Atleta";
        atleta.setNomePai(nomePai);
        assertEquals(nomePai, atleta.getNomePai());
    }

    @Test
    public void testSetAndGetNomeMae() {
        String nomeMae = "Mãe do Atleta";
        atleta.setNomeMae(nomeMae);
        assertEquals(nomeMae, atleta.getNomeMae());
    }

    @Test
    public void testSetAndGetNumeroRegistro() {
        Integer numeroRegistro = 123;
        atleta.setNumeroRegistro(numeroRegistro);
        assertEquals(numeroRegistro, atleta.getNumeroRegistro());
    }

    @Test
    public void testSetAndGetNumeroCamisa() {
        Integer numeroCamisa = 10;
        atleta.setNumeroCamisa(numeroCamisa);
        assertEquals(numeroCamisa, atleta.getNumeroCamisa());
    }

    @Test
    public void testSetAndGetDataInicio() {
        Date dataInicio = Date.valueOf("2022-01-01");
        atleta.setDataInicio(dataInicio);
        assertEquals(dataInicio, atleta.getDataInicio());
    }

    @Test
    public void testSetAndGetDataTermino() {
        Date dataTermino = Date.valueOf("2023-12-31");
        atleta.setDataTermino(dataTermino);
        assertEquals(dataTermino, atleta.getDataTermino());
    }

    @Test
    public void testSetAndGetEstatisticas() {
        List<Estatistica> estatisticas = new ArrayList<>();
        Estatistica estatistica = mock(Estatistica.class);
        estatisticas.add(estatistica);
        atleta.setEstatisticas(estatisticas);
        assertEquals(estatisticas, atleta.getEstatisticas());
    }

    @Test
    public void testSetAndGetTime() {
        Time time = mock(Time.class);
        atleta.setTime(time);
        assertEquals(time, atleta.getTime());
    }
}
