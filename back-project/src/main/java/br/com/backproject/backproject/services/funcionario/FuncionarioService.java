package br.com.backproject.backproject.services.funcionario;

import br.com.backproject.backproject.dto.request.funcionario.FuncionarioRequestDTO;
import br.com.backproject.backproject.dto.response.funcionario.FuncionarioResponseDTO;
import br.com.backproject.backproject.entities.endereco.Endereco;
import br.com.backproject.backproject.entities.funcionario.Funcionario;
import br.com.backproject.backproject.repositories.endereco.EnderecoRepository;
import br.com.backproject.backproject.repositories.funcionario.FuncionarioRepository;
import br.com.backproject.backproject.utils.mappers.EnderecoMapper;
import br.com.backproject.backproject.utils.mappers.FuncionarioMapper;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Stateless
public class FuncionarioService {

    @Inject
    private FuncionarioRepository funcionarioRepository;

    @Inject
    private EnderecoRepository enderecoRepository;

    @Transactional
    public void salvar(final FuncionarioRequestDTO funcionarioRequestDTO) {
        Endereco endereco = EnderecoMapper.dtoParaEntidade(funcionarioRequestDTO.getEndereco());
        final Funcionario funcionario = FuncionarioMapper.dtoParaEntidade(funcionarioRequestDTO);
        funcionario.setDataHoraCadastro(new Date());

        endereco = (Endereco) enderecoRepository.salvarOuAtualizar(endereco);
        funcionario.setEndereco(endereco);

        funcionarioRepository.salvar(funcionario);
    }

    public FuncionarioResponseDTO buscarPorId(final Integer id) {
        final Funcionario funcionario = funcionarioRepository.buscarPorId(id);
        return FuncionarioMapper.entidadeParaDTO(funcionario);
    }

    public List<FuncionarioResponseDTO> buscarTodos() {
        final List<Funcionario> funcionarios = funcionarioRepository.buscarTodos();
        return FuncionarioMapper.entidadeParaDTO(funcionarios);
    }

    @Transactional
    public void excluir(final Integer id) {
        final Funcionario funcionario = funcionarioRepository.buscarPorId(id);
        if (funcionario != null) {
            enderecoRepository.excluir(funcionario.getEndereco().getId());
            funcionarioRepository.excluir(funcionario.getId());
        }
    }

}
