package br.com.backproject.backproject.repositories.funcionario;

import br.com.backproject.backproject.entities.funcionario.Funcionario;
import br.com.backproject.backproject.repositories.EntidadeRepository;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class FuncionarioRepository extends EntidadeRepository {

    @Override
    public Funcionario buscarPorId(final Integer id) {
        return getEntityManager().find(Funcionario.class, id);
    }

    public List<Funcionario> buscarTodos() {
        return getEntityManager().createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
    }

}
