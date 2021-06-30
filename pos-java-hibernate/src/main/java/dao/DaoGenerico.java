package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import mavenhibernate.HibernateUtil;
public class DaoGenerico<E> {
	
	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public Class<E> entityClass;
	
	public void setarEntidade(Class<E> entidade) {
		this.entityClass = entidade;
	}
	
	public Class<E> getEntityClass(){
		return this.entityClass;
	}
	/**
	 * Salvar Objeto
	 * @param entidade
	 */
	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
	}
	
	public E consultarPorChavePrimaria(Long id) {
		E objeto = (E) entityManager.find(getEntityClass(), id);		
		
		return objeto;
	}
	
	/**
	 * Salva ou Atualiza o objeto na base
	 * @param entidade
	 * @return Object
	 */
	public E updateMerge(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();
		
		return entidadeSalva;
	}
	
	/**
	 * Deleção de Objeto
	 * @param entidade
	 */
	public void deletar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(entidade);
		transaction.commit();
	}
}
