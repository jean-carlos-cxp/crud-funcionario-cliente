package br.com.backproject.backproject.entities.funcionario;

import br.com.backproject.backproject.entities.Entidade;
import br.com.backproject.backproject.entities.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Tb_Funcionario")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Funcionario implements Serializable, Entidade {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, columnDefinition = "varchar(300)")
    private String nome;

    @Column(name = "cpf", nullable = false, columnDefinition = "char(11)")
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "cargo", nullable = false, columnDefinition = "varchar(100)")
    private String cargo;

    @OneToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    private Endereco endereco;

    @Column(name = "data_hora_cadastro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;

    @Column(name = "data_hora_alteracao", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraAlteracao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
