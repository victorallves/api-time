package br.com.sistemas.magna.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemas.magna.dto.EstatisticaDTO;
import br.com.sistemas.magna.model.Estatistica;
import br.com.sistemas.magna.repository.EstatisticaRepository;

@Service
public class EstatisticaService {

    @Autowired
    private EstatisticaRepository estatisticaRepository;

    public List<EstatisticaDTO> getAllEstatisticas() {
        List<Estatistica> estatisticas = estatisticaRepository.findAll();
        return estatisticas.stream()
                          .map(this::convertToDTO)
                          .collect(Collectors.toList());
    }

    public Optional<EstatisticaDTO> getEstatisticaById(Long id) {
        Optional<Estatistica> estatistica = estatisticaRepository.findById(id);
        return estatistica.map(this::convertToDTO);
    }

    public EstatisticaDTO createEstatistica(EstatisticaDTO estatisticaDTO) {
        Estatistica estatistica = convertToEntity(estatisticaDTO);
        Estatistica createdEstatistica = estatisticaRepository.save(estatistica);
        return convertToDTO(createdEstatistica);
    }

    public Optional<EstatisticaDTO> updateEstatistica(Long id, EstatisticaDTO estatisticaDetailsDTO) {
        Optional<Estatistica> optionalEstatistica = estatisticaRepository.findById(id);
        if (optionalEstatistica.isPresent()) {
            Estatistica estatistica = optionalEstatistica.get();
            estatistica.setNumeroDeGols(estatisticaDetailsDTO.getNumeroDeGols());
            estatistica.setNumeroDeCartaoAmarelo(estatisticaDetailsDTO.getNumeroDeCartaoAmarelo());
            estatistica.setNumeroDeCartaoVermelho(estatisticaDetailsDTO.getNumeroDeCartaoVermelho());
            estatistica.setNomeCampeonato(estatisticaDetailsDTO.getNomeCampeonato());
            estatistica.setAtleta(estatisticaDetailsDTO.getAtleta());
            Estatistica updatedEstatistica = estatisticaRepository.save(estatistica);
            return Optional.of(convertToDTO(updatedEstatistica));
        } else {
            return Optional.empty();
        }
    }

    public void deleteEstatistica(Long id) {
        estatisticaRepository.deleteById(id);
    }

    private EstatisticaDTO convertToDTO(Estatistica estatistica) {
        return new EstatisticaDTO(
            estatistica.getNumeroDeGols(),
            estatistica.getNumeroDeCartaoAmarelo(),
            estatistica.getNumeroDeCartaoVermelho(),
            estatistica.getNomeCampeonato(),
            estatistica.getAtleta()
        );
    }

    private Estatistica convertToEntity(EstatisticaDTO estatisticaDTO) {
        Estatistica estatistica = new Estatistica();
        estatistica.setNumeroDeGols(estatisticaDTO.getNumeroDeGols());
        estatistica.setNumeroDeCartaoAmarelo(estatisticaDTO.getNumeroDeCartaoAmarelo());
        estatistica.setNumeroDeCartaoVermelho(estatisticaDTO.getNumeroDeCartaoVermelho());
        estatistica.setNomeCampeonato(estatisticaDTO.getNomeCampeonato());
        estatistica.setAtleta(estatisticaDTO.getAtleta());
        return estatistica;
    }
}
