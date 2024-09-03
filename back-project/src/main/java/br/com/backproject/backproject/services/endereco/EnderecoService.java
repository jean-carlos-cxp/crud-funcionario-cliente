package br.com.backproject.backproject.services.endereco;

import br.com.backproject.backproject.dto.request.endereco.EnderecoRequestDTO;
import br.com.backproject.backproject.dto.response.endereco.EnderecoResponseDTO;
import br.com.backproject.backproject.entities.endereco.Endereco;
import br.com.backproject.backproject.repositories.endereco.EnderecoRepository;
import br.com.backproject.backproject.utils.mappers.EnderecoMapper;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class EnderecoService {

    @Inject
    private EnderecoRepository enderecoRepository;

    public void salvar(final EnderecoRequestDTO enderecoRequestDTO) {
        enderecoRepository.salvar(EnderecoMapper.dtoParaEntidade(enderecoRequestDTO));
    }

    public EnderecoResponseDTO buscarPorId(final Integer id) {
        final Endereco endereco = enderecoRepository.buscarPorId(id);
        return EnderecoMapper.entidadeParaDTO(endereco);
    }

    public List<EnderecoResponseDTO> buscarTodos() {
        final List<Endereco> enderecos = enderecoRepository.buscarTodos();
        return EnderecoMapper.entidadeParaDTO(enderecos);
    }

    public void excluir(final Integer id) {
        enderecoRepository.excluir(id);
    }

}
