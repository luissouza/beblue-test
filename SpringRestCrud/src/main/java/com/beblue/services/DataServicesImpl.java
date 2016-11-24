package com.beblue.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.beblue.dao.DataDao;
import com.beblue.model.Estabelecimento;
import com.beblue.model.TiposTransacao;
import com.beblue.model.Transacao;
import com.beblue.model.User;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;

	@Override
	public List<User> getUserList() throws Exception {
		return dataDao.getUserList();
	}
	
	@Override
	public boolean inserirUsuario(User user) throws Exception {
		return dataDao.inserirUsuario(user);
	}

	@Override
	public boolean inserirTransacao(Transacao transacao) throws Exception {
		return dataDao.inserirTransacao(transacao);
	}
	
	@Override
	public List<Estabelecimento> getEstabelecimentos() throws Exception {
		return dataDao.getEstabelecimentos();
	}

	@Override
	public User getUserByCpf(long cpf) throws Exception {
		return dataDao.getUserByCpf(cpf);
	}
	
	@Override
	public List<Transacao> getUserTransactions() throws Exception {
		return dataDao.getUserTransactions();
	}

}
