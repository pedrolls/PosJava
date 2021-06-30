package dao;

import model.Pessoa;

public class PessoaDao<E> extends DaoGenerico<E>{

	@SuppressWarnings("unchecked")
	public PessoaDao() {
		setarEntidade((Class<E>) Pessoa.class);
	}
}
