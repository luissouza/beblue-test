package com.beblue.services;

import java.util.List;

import com.beblue.model.Estabelecimento;
import com.beblue.model.TiposTransacao;
import com.beblue.model.Transacao;
import com.beblue.model.User;

public interface DataServices {
	
	//USER
	public List<User> getUserList() throws Exception;
	public User getUserByCpf(long cpf) throws Exception;
	public boolean inserirUsuario(User user) throws Exception;

	//TRANSAÇÃO
	public boolean inserirTransacao(Transacao transacao) throws Exception;
	public List<Transacao> getUserTransactions() throws Exception;
	
	//ESTABELECIMENTO
	public List<Estabelecimento> getEstabelecimentos() throws Exception;
}
