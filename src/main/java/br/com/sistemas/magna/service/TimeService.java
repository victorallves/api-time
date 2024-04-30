package br.com.sistemas.magna.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemas.magna.dto.TimeDTO;
import br.com.sistemas.magna.model.Time;
import br.com.sistemas.magna.repository.TimeRepository;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public List<TimeDTO> getAllTimes() {
        List<Time> times = timeRepository.findAll();
        return times.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
    }

    public Optional<TimeDTO> getTimeById(Long id) {
        Optional<Time> time = timeRepository.findById(id);
        return time.map(this::convertToDTO);
    }

    public TimeDTO createTime(TimeDTO timeDTO) {
        Time time = convertToEntity(timeDTO);
        Time createdTime = timeRepository.save(time);
        return convertToDTO(createdTime);
    }

    public Optional<TimeDTO> updateTime(Long id, TimeDTO timeDetailsDTO) {
        Optional<Time> optionalTime = timeRepository.findById(id);
        if (optionalTime.isPresent()) {
            Time time = optionalTime.get();
            time.setNomeTime(timeDetailsDTO.getNomeTime());
            time.setNomeCentroDeTreinamento(timeDetailsDTO.getNomeCentroDeTreinamento());
            time.setNomeEstadio(timeDetailsDTO.getNomeEstadio());
            time.setTecnico(timeDetailsDTO.getTecnico());
            time.setAtletas(timeDetailsDTO.getAtletas());
            Time updatedTime = timeRepository.save(time);
            return Optional.of(convertToDTO(updatedTime));
        } else {
            return Optional.empty();
        }
    }


    public void deleteTime(Long id) {
        timeRepository.deleteById(id);
    }

    private TimeDTO convertToDTO(Time time) {
        TimeDTO timeDTO = new TimeDTO();
        timeDTO.setNomeTime(time.getNomeTime());
        timeDTO.setNomeCentroDeTreinamento(time.getNomeCentroDeTreinamento());
        timeDTO.setNomeEstadio(time.getNomeEstadio());
        timeDTO.setTecnico(time.getTecnico());
        timeDTO.setAtletas(time.getAtletas());
        return timeDTO;
    }

    private Time convertToEntity(TimeDTO timeDTO) {
        Time time = new Time();
        time.setNomeTime(timeDTO.getNomeTime());
        time.setNomeCentroDeTreinamento(timeDTO.getNomeCentroDeTreinamento());
        time.setNomeEstadio(timeDTO.getNomeEstadio());
        time.setTecnico(timeDTO.getTecnico());
        time.setAtletas(timeDTO.getAtletas());
        return time;
    }
}
