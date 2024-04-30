package br.com.sistemas.magna.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemas.magna.dto.TecnicoDTO;
import br.com.sistemas.magna.model.Tecnico;
import br.com.sistemas.magna.repository.TecnicoRepository;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public List<TecnicoDTO> getAllTecnicos() {
        List<Tecnico> tecnicos = tecnicoRepository.findAll();
        return tecnicos.stream()
                      .map(this::convertToDTO)
                      .collect(Collectors.toList());
    }

    public Optional<TecnicoDTO> getTecnicoById(Long id) {
        Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
        return tecnico.map(this::convertToDTO);
    }

    public TecnicoDTO createTecnico(TecnicoDTO tecnicoDTO) {
        Tecnico tecnico = convertToEntity(tecnicoDTO);
        Tecnico createdTecnico = tecnicoRepository.save(tecnico);
        return convertToDTO(createdTecnico);
    }

    public Optional<TecnicoDTO> updateTecnico(Long id, TecnicoDTO tecnicoDetailsDTO) {
        Optional<Tecnico> optionalTecnico = tecnicoRepository.findById(id);
        if (optionalTecnico.isPresent()) {
            Tecnico tecnico = optionalTecnico.get();
            tecnico.setNomeTecnico(tecnicoDetailsDTO.getNomeTecnico());
            tecnico.setNacionalidade(tecnicoDetailsDTO.getNacionalidade());
            tecnico.setValorTecnico(tecnicoDetailsDTO.getValorTecnico());
            tecnico.setSalario(tecnicoDetailsDTO.getSalario());
            tecnico.setAreaAtuacao(tecnicoDetailsDTO.getAreaAtuacao());
            tecnico.setTime(tecnicoDetailsDTO.getTime());
            Tecnico updatedTecnico = tecnicoRepository.save(tecnico);
            return Optional.of(convertToDTO(updatedTecnico));
        } else {
            return Optional.empty();
        }
    }


    public void deleteTecnico(Long id) {
        tecnicoRepository.deleteById(id);
    }

    private TecnicoDTO convertToDTO(Tecnico tecnico) {
        TecnicoDTO tecnicoDTO = new TecnicoDTO();
        tecnicoDTO.setNomeTecnico(tecnico.getNomeTecnico());
        tecnicoDTO.setNacionalidade(tecnico.getNacionalidade());
        tecnicoDTO.setValorTecnico(tecnico.getValorTecnico());
        tecnicoDTO.setSalario(tecnico.getSalario());
        tecnicoDTO.setAreaAtuacao(tecnico.getAreaAtuacao());
        return tecnicoDTO;
    }

    private Tecnico convertToEntity(TecnicoDTO tecnicoDTO) {
        Tecnico tecnico = new Tecnico();
        tecnico.setNomeTecnico(tecnicoDTO.getNomeTecnico());
        tecnico.setNacionalidade(tecnicoDTO.getNacionalidade());
        tecnico.setValorTecnico(tecnicoDTO.getValorTecnico());
        tecnico.setSalario(tecnicoDTO.getSalario());
        tecnico.setAreaAtuacao(tecnicoDTO.getAreaAtuacao());
        return tecnico;
    }
}
