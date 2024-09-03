package br.com.backproject.backproject.dto.response.funcionario;

import br.com.backproject.backproject.dto.response.endereco.EnderecoResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioResponseDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String cargo;
    private Date dataHoraCadastro;
    private Date dataHoraAlteracao;
    private EnderecoResponseDTO endereco;

}
