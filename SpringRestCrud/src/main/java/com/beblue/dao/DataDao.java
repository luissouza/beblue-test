package com.beblue.dao;

import java.util.List;

import com.beblue.model.Estabelecimento;
import com.beblue.model.TiposTransacao;
import com.beblue.model.Transacao;
import com.beblue.model.User;

public interface DataDao {
	
	//USER
	public List<User> getUserList() throws Exception;
	public User getUserByCpf(long cpf) throws Exception;
	public boolean inserirUsuario(User user) throws Exception;
	
	//TRANSACAO
	public boolean inserirTransacao(Transacao transacao) throws Exception;
	public List<Transacao> getUserTransactions() throws Exception;
	
	//ESTABELECIMENTOS
	public List<Estabelecimento> getEstabelecimentos() throws Exception;
	
}
