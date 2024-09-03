package br.com.backproject.backproject.utils.mappers;

import br.com.backproject.backproject.dto.request.endereco.EnderecoRequestDTO;
import br.com.backproject.backproject.dto.response.endereco.EnderecoResponseDTO;
import br.com.backproject.backproject.entities.endereco.Endereco;

import java.util.List;
import java.util.stream.Collectors;

public final class EnderecoMapper {

    public static EnderecoResponseDTO entidadeParaDTO(final Endereco endereco) {
        final EnderecoResponseDTO enderecoDTO = new EnderecoResponseDTO();
        enderecoDTO.setId(endereco.getId());
        enderecoDTO.setLogradouro(endereco.getLogradouro());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setBairro(endereco.getBairro());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setCidade(endereco.getCidade());
        enderecoDTO.setEstado(endereco.getEstado());
        return enderecoDTO;
    }

    public static Endereco dtoParaEntidade(final EnderecoRequestDTO enderecoDTO) {
        final Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstado(enderecoDTO.getEstado());
        return endereco;
    }

    public static List<EnderecoResponseDTO> entidadeParaDTO(final List<Endereco> enderecosList) {
        return enderecosList
                .stream()
                .map(EnderecoMapper::entidadeParaDTO)
                .collect(Collectors.toList());
    }

}
