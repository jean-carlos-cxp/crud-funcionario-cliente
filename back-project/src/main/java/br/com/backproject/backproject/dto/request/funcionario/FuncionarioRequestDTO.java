package br.com.backproject.backproject.dto.request.funcionario;

import br.com.backproject.backproject.dto.request.endereco.EnderecoRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioRequestDTO {

    private String nome;
    private String cpf;

//    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate dataNascimento;

    private String cargo;
    private EnderecoRequestDTO endereco;

}
