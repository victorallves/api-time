package br.com.sistemas.magna.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sistemas.magna.dto.AtletaDTO;
import br.com.sistemas.magna.model.Atleta;
import br.com.sistemas.magna.repository.AtletaRepository;

@Service
public class AtletaService {

	@Autowired
	private AtletaRepository atletaRepository;

	public List<AtletaDTO> getAllAtletas() {
		List<Atleta> atletas = atletaRepository.findAll();
		return atletas.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public Optional<AtletaDTO> getAtletaById(Long id) {
		Optional<Atleta> atleta = atletaRepository.findById(id);
		return atleta.map(this::convertToDTO);
	}

	public AtletaDTO createAtleta(AtletaDTO atletaDTO) {
		Atleta atleta = convertToEntity(atletaDTO);
		Atleta createdAtleta = atletaRepository.save(atleta);
		return convertToDTO(createdAtleta);
	}

	public Optional<AtletaDTO> updateAtleta(Long id, AtletaDTO atletaDetailsDTO) {
		Optional<Atleta> optionalAtleta = atletaRepository.findById(id);
		if (optionalAtleta.isPresent()) {
			Atleta atleta = optionalAtleta.get();
			atleta.setNomeCompleto(atletaDetailsDTO.getNomeCompleto());
			atleta.setCpf(atletaDetailsDTO.getCpf());
			atleta.setDataNascimento(atletaDetailsDTO.getDataNascimento());
			atleta.setTelefone(atletaDetailsDTO.getTelefone());
			atleta.setSalario(atletaDetailsDTO.getSalario());
			atleta.setValorAtleta(atletaDetailsDTO.getValorAtleta());
			atleta.setPosicaoAtleta(atletaDetailsDTO.getPosicaoAtleta());
			atleta.setNacionalidade(atletaDetailsDTO.getNacionalidade());
			atleta.setNomePai(atletaDetailsDTO.getNomePai());
			atleta.setNomeMae(atletaDetailsDTO.getNomeMae());
			atleta.setNumeroRegistro(atletaDetailsDTO.getNumeroRegistro());
			atleta.setNumeroCamisa(atletaDetailsDTO.getNumeroCamisa());
			atleta.setDataInicio(atletaDetailsDTO.getDataInicio());
			atleta.setDataTermino(atletaDetailsDTO.getDataTermino());
			atleta.setEstatisticas(atletaDetailsDTO.getEstatisticas());
			atleta.setTime(atletaDetailsDTO.getTime());
			Atleta updatedAtleta = atletaRepository.save(atleta);
			return Optional.of(convertToDTO(updatedAtleta));
		} else {
			return Optional.empty();
		}
	}

	public void deleteAtleta(Long id) {
		atletaRepository.deleteById(id);
	}

	private AtletaDTO convertToDTO(Atleta atleta) {
		AtletaDTO atletaDTO = new AtletaDTO();
		atletaDTO.setNomeCompleto(atleta.getNomeCompleto());
		atletaDTO.setCpf(atleta.getCpf());
		atletaDTO.setDataNascimento(atleta.getDataNascimento());
		atletaDTO.setTelefone(atleta.getTelefone());
		atletaDTO.setSalario(atleta.getSalario());
		atletaDTO.setValorAtleta(atleta.getValorAtleta());
		atletaDTO.setPosicaoAtleta(atleta.getPosicaoAtleta());
		atletaDTO.setNacionalidade(atleta.getNacionalidade());
		atletaDTO.setNomePai(atleta.getNomePai());
		atletaDTO.setNomeMae(atleta.getNomeMae());
		atletaDTO.setNumeroRegistro(atleta.getNumeroRegistro());
		atletaDTO.setNumeroCamisa(atleta.getNumeroCamisa());
		atletaDTO.setDataInicio(atleta.getDataInicio());
		atletaDTO.setDataTermino(atleta.getDataTermino());
		atletaDTO.setEstatisticas(atleta.getEstatisticas());
		atletaDTO.setTime(atleta.getTime());
		return atletaDTO;
	}

	private Atleta convertToEntity(AtletaDTO atletaDTO) {
		Atleta atleta = new Atleta();
		atleta.setNomeCompleto(atletaDTO.getNomeCompleto());
		atleta.setCpf(atletaDTO.getCpf());
		atleta.setDataNascimento(atletaDTO.getDataNascimento());
		atleta.setTelefone(atletaDTO.getTelefone());
		atleta.setSalario(atletaDTO.getSalario());
		atleta.setValorAtleta(atletaDTO.getValorAtleta());
		atleta.setPosicaoAtleta(atletaDTO.getPosicaoAtleta());
		atleta.setNacionalidade(atletaDTO.getNacionalidade());
		atleta.setNomePai(atletaDTO.getNomePai());
		atleta.setNomeMae(atletaDTO.getNomeMae());
		atleta.setNumeroRegistro(atletaDTO.getNumeroRegistro());
		atleta.setNumeroCamisa(atletaDTO.getNumeroCamisa());
		atleta.setDataInicio(atletaDTO.getDataInicio());
		atleta.setDataTermino(atletaDTO.getDataTermino());
		atleta.setEstatisticas(atletaDTO.getEstatisticas());
		atleta.setTime(atletaDTO.getTime());
		return atleta;
	}
}
