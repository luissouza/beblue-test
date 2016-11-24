package com.beblue.controller;

import java.util.List;

import org.apache.log4j.Logger;
import com.beblue.model.Status;
import com.beblue.model.Transacao;
import com.beblue.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beblue.model.Estabelecimento;
import com.beblue.services.DataServices;

@Controller
@RequestMapping("/beblue")
public class RestController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody List<User> getUserList() {

		List<User> userList = null;
		try {
			userList = dataServices.getUserList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	@RequestMapping(value = "getuser-cpf/{cpf}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User getUserByCpf(@PathVariable("cpf") long cpf) {
		User user = null;
		try {
			user = dataServices.getUserByCpf(cpf);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@RequestMapping(value = "/register-user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status inserirUsuario(@RequestBody User user) {
		try {
			dataServices.inserirUsuario(user);
			return new Status(1, "Usuario adicionado com sucesso!");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}


	@RequestMapping(value = "/register-transaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status inserirTransacao(@RequestBody Transacao transacao) {
		try {
			dataServices.inserirTransacao(transacao);
			return new Status(1, "Transacao inserida com sucesso!");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}
	}

	
	@RequestMapping(value = "/list-estabelecimento", method = RequestMethod.GET)
	public @ResponseBody List<Estabelecimento> getEstabelecimentos() {

		List<Estabelecimento> estabelecimentos = null;
		try {
			estabelecimentos = dataServices.getEstabelecimentos();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return estabelecimentos;
	}
	
	
	@RequestMapping(value = "/user-transactions", method = RequestMethod.GET)
	public @ResponseBody List<Transacao> getUserTransactions() {

		List<Transacao> userTransactions = null;
		try {
			userTransactions = dataServices.getUserTransactions();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userTransactions;
	}
	
	

}
