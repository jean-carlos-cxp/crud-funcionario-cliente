package br.com.backproject.backproject.repositories;

import br.com.backproject.backproject.entities.Entidade;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public abstract class EntidadeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(final Entidade entidade) {
        entityManager.persist(entidade);
    }

    public Entidade salvarOuAtualizar(final Entidade entidade) {
        return entityManager.merge(entidade);
    }

    public void excluir(final Integer id) {
        Entidade entidade = buscarPorId(id);
        if (entidade != null) {
            entityManager.remove(entidade);
        }
    }

    public abstract Entidade buscarPorId(final Integer id);

    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
