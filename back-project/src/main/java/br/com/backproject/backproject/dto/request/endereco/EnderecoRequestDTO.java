package br.com.backproject.backproject.dto.request.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequestDTO {

    private String logradouro;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;

}
