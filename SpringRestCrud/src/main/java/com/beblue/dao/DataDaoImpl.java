package com.beblue.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.beblue.model.Estabelecimento;
import com.beblue.model.TiposTransacao;
import com.beblue.model.Transacao;
import com.beblue.model.User;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<User> userList = session.createCriteria(User.class).list();
		tx.commit();
		session.close();
		return userList;
	}
	
	public User getUserByCpf(long cpf) throws Exception {
		session = sessionFactory.openSession();
		User user = (User) session.createQuery("from User where userCpf = :cpf").setParameter("cpf", cpf).uniqueResult();
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return user;
	}
		
	@Override
	public boolean inserirUsuario(User user) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		return false;
	}
	
	
	@Override
	public boolean inserirTransacao(Transacao transacao) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(transacao);
		tx.commit();
		session.close();
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Estabelecimento> getEstabelecimentos() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Estabelecimento> estabelecimentoList = session.createCriteria(Estabelecimento.class).list();
		tx.commit();
		session.close();
		return estabelecimentoList;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Transacao> getUserTransactions() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Transacao> userTransactions = session.createCriteria(Transacao.class).list();
		tx.commit();
		session.close();
		return userTransactions;
	}

}
