package br.com.backproject.backproject.repositories.endereco;

import br.com.backproject.backproject.entities.endereco.Endereco;
import br.com.backproject.backproject.repositories.EntidadeRepository;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class EnderecoRepository extends EntidadeRepository {

    @Override
    public Endereco buscarPorId(final Integer id) {
        return getEntityManager().find(Endereco.class, id);
    }

    public List<Endereco> buscarTodos() {
        return getEntityManager().createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
    }

}
