package br.com.backproject.backproject.utils.mappers;

import br.com.backproject.backproject.dto.request.funcionario.FuncionarioRequestDTO;
import br.com.backproject.backproject.dto.response.funcionario.FuncionarioResponseDTO;
import br.com.backproject.backproject.entities.funcionario.Funcionario;

import java.util.List;
import java.util.stream.Collectors;

public final class FuncionarioMapper {

    public static FuncionarioResponseDTO entidadeParaDTO(final Funcionario funcionario) {
        final FuncionarioResponseDTO funcionarioDTO = new FuncionarioResponseDTO();
        funcionarioDTO.setId(funcionario.getId());
        funcionarioDTO.setNome(funcionario.getNome());
        funcionarioDTO.setCargo(funcionario.getCargo());
        funcionarioDTO.setDataNascimento(funcionario.getDataNascimento());
        funcionarioDTO.setDataHoraCadastro(funcionario.getDataHoraCadastro());
        funcionarioDTO.setDataHoraAlteracao(funcionario.getDataHoraAlteracao());
        funcionarioDTO.setCpf(funcionario.getCpf());
        funcionarioDTO.setEndereco(EnderecoMapper.entidadeParaDTO(funcionario.getEndereco()));
        return funcionarioDTO;
    }

    public static Funcionario dtoParaEntidade(final FuncionarioRequestDTO funcionarioDTO) {
        final Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCargo(funcionarioDTO.getCargo());
        funcionario.setDataNascimento(funcionarioDTO.getDataNascimento());
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setEndereco(EnderecoMapper.dtoParaEntidade(funcionarioDTO.getEndereco()));
        return funcionario;
    }

    public static List<FuncionarioResponseDTO> entidadeParaDTO(final List<Funcionario> funcionarioList) {
        return funcionarioList
                .stream()
                .map(FuncionarioMapper::entidadeParaDTO)
                .collect(Collectors.toList());
    }

}
