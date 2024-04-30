package br.com.sistemas.magna.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sistemas.magna.dto.FuncionariosDTO;
import br.com.sistemas.magna.model.Funcionarios;
import br.com.sistemas.magna.repository.FuncionariosRepository;

@Service
public class FuncionariosService {

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    public List<FuncionariosDTO> getAllFuncionarios() {
        List<Funcionarios> funcionariosList = funcionariosRepository.findAll();
        return funcionariosList.stream()
                               .map(this::convertToDTO)
                               .collect(Collectors.toList());
    }

    public Optional<FuncionariosDTO> getFuncionariosById(Long id) {
        Optional<Funcionarios> funcionarios = funcionariosRepository.findById(id);
        return funcionarios.map(this::convertToDTO);
    }

    public FuncionariosDTO createFuncionarios(FuncionariosDTO funcionariosDTO) {
        Funcionarios funcionarios = convertToEntity(funcionariosDTO);
        Funcionarios createdFuncionarios = funcionariosRepository.save(funcionarios);
        return convertToDTO(createdFuncionarios);
    }

    public Optional<FuncionariosDTO> updateFuncionarios(Long id, FuncionariosDTO funcionariosDetailsDTO) {
        Optional<Funcionarios> optionalFuncionario = funcionariosRepository.findById(id);
        if (optionalFuncionario.isPresent()) {
            Funcionarios funcionario = optionalFuncionario.get();
            funcionario.setNomeCompleto(funcionariosDetailsDTO.getNomeCompleto());
            funcionario.setDataNascimento(funcionariosDetailsDTO.getDataNascimento());
            funcionario.setCargo(funcionariosDetailsDTO.getCargo());
            funcionario.setSalario(funcionariosDetailsDTO.getSalario());
            Funcionarios updatedFuncionario = funcionariosRepository.save(funcionario);
            return Optional.of(convertToDTO(updatedFuncionario));
        } else {
            return Optional.empty();
        }
    }

    public void deleteFuncionarios(Long id) {
        funcionariosRepository.deleteById(id);
    }

    private FuncionariosDTO convertToDTO(Funcionarios funcionarios) {
        return new FuncionariosDTO(
            funcionarios.getNomeCompleto(),
            funcionarios.getDataNascimento(),
            funcionarios.getCargo(),
            funcionarios.getSalario(),
            funcionarios.getTime()
        );
    }

    private Funcionarios convertToEntity(FuncionariosDTO funcionariosDTO) {
        Funcionarios funcionarios = new Funcionarios();
        funcionarios.setNomeCompleto(funcionariosDTO.getNomeCompleto());
        funcionarios.setDataNascimento(funcionariosDTO.getDataNascimento());
        funcionarios.setCargo(funcionariosDTO.getCargo());
        funcionarios.setSalario(funcionariosDTO.getSalario());
        return funcionarios;
    }
}
