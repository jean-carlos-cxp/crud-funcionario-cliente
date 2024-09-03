package br.com.backproject.backproject.dto.response.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponseDTO {

    private Integer id;
    private String logradouro;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;

}
