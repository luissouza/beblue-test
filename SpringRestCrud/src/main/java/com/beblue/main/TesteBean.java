package com.beblue.main;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.beblue.model.Transacao;
import com.beblue.model.User;

public class TesteBean {

	private Integer cashBackDoDia;

	public TesteBean() {
		
	}

	/**
	 * Método utilizado para consumir os dados dos usuários.
	 * Após consumir é realizado a inserção dos dados na base através do método postUsuario();
	 */
	public void readUsuario() {
		final String uri = "https://quarkbackend.com/getfile/vilibaldo-neto/json-javatest-users";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		JSONArray jArray = new JSONArray(result);

		int n = jArray.length();
		for (int i = 0; i < n; i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			User user = new User(jObj.getString("name"), jObj.getLong("user_cpf"), jObj.getDouble("balance"));

			if (verificaExistenciaUser(jObj.getLong("user_cpf"))) {
				System.out.println("Usuário já existente...");
			} else {
				postUsuario(user);
			}
		}
	}
	
	/**
	 * Método utilizado para consultar o estabelecimento e suas porcentagens de cashack por dia da semana.
	 */
	public void readEstabelecimento() {
		final String uri = "http://localhost:8087/SpringRestCrud/beblue/list-estabelecimento";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		JSONArray jArray = new JSONArray(result);
		JSONObject jObj = jArray.getJSONObject(0);
		verificarDiaDaSemana(jObj);
	}
	
	/**
	 * Método utilizado para verificar o dia da semana.
	 * Utilizado também para escolher qual cashBack será utilizado, de acordo com o dia da semana.
	 * @param jObj
	 */
	public void verificarDiaDaSemana(JSONObject jObj) {
		
		Date now = new Date();
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("E");
		simpleDateformat = new SimpleDateFormat("EEEE"); 

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		
	
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			selecionaCashBackDia(jObj.getInt("cashBackDomingo"));
			break;
		case 2:
			selecionaCashBackDia(jObj.getInt("cashBackSegunda"));
			break;
		case 3:
			selecionaCashBackDia(jObj.getInt("cashBackTerca"));
			break;
		case 4:
			selecionaCashBackDia(jObj.getInt("cashBackQuarta"));
			break;
		case 5:
			selecionaCashBackDia(jObj.getInt("cashBackQuinta"));
			break;
		case 6:
			selecionaCashBackDia(jObj.getInt("cashBackSexta"));
			break;
		case 7:
			selecionaCashBackDia(jObj.getInt("cashBackSabado"));
			break;
		default:
			System.out.println("Dia inválido!");
		}
	}
	
	/**
	 * Repassa o valor do cashback do parametro do método para um atributo global, que será utilizado em outros métodos.
	 * @param pCashBack
	 * @return cashBackDoDia
	 */
	public Integer selecionaCashBackDia(Integer pCashBack) {
		cashBackDoDia = pCashBack;
		return cashBackDoDia;
	}
	
	/**
	 * Método utilizado para verificar se o usuário já existe no banco de dados.
	 * Processo realizado antes do consumo das informações de usuários.
	 * Processo realizado para evitar duplicações.
	 * @param cpf
	 * @return
	 */
	public boolean verificaExistenciaUser(long cpf) {

		final String uri = "http://localhost:8087/SpringRestCrud/beblue/getuser-cpf/" + cpf;
		System.out.println("uri " + uri);
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		System.out.println();
		JSONArray jArray = new JSONArray("[" + result + "]");
		int n = jArray.length();
		int cpfExistente = 0;
		
		if(!jArray.isNull(0)) {
			
			for (int i = 0; i < n; i++) {
				JSONObject jObj = jArray.getJSONObject(i);
				if (jObj.getLong("userCpf") == cpf) {
					cpfExistente++;
				}
			}
		}
		
		

		if (cpfExistente > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método utilizado para inserir o usuário na base de dados.
	 * Método é chamado pelo método readUsuario(), após a leitura os dados são persistidos.
	 * @param user
	 */
	public void postUsuario(User user) {
		RestTemplate restTemplate = new RestTemplate();
		String postUrl = "http://localhost:8087/SpringRestCrud/beblue/register-user";
		ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, user, String.class);
	}

	/**
	 * Método utilizado para consumir o tipo de transação.
	 * @param transactionType
	 * @return retornoTipoTransacao
	 */
	public String readTipoTransacao(String transactionType) {
		final String uri = "https://quarkbackend.com/getfile/vilibaldo-neto/json-javatest-transactiontypr";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		JSONArray jArray = new JSONArray(result);
		
		int n = jArray.length();
		String retornoTipoTransacao = "";

		for (int i = 0; i < n; i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			if (transactionType.equals(jObj.getString("transaction_type"))) {
				retornoTipoTransacao = jObj.getString("transaction_name");
			}
		}
		return retornoTipoTransacao;
	}
	
	/**
	 * Método utilizado para inserir a transação do usuário
	 * É verificado o tipo da transação.
	 */
	public void postTransacao() {
		RestTemplate restTemplate = new RestTemplate();
		String postUrl = "http://localhost:8087/SpringRestCrud/beblue/register-transaction";
		
		//TRANSAÇÃO TESTE, PARAMETROS TESTE
		//Transacao transacao = new Transacao("44444444444", 1, 264.65, "TP_1", new Date(), "ky543Hm833s3fs");
		//Transacao transacao = new Transacao("11111111111", 1, 649.89, "TP_2", new Date(), "jy556Hm833s3fs");
		//Transacao transacao = new Transacao("22222222222", 1, 476.55, "TP_1", new Date(), "hy9443m833s3fs");
		Transacao transacao = new Transacao("33333333333", 1, 188.20, "TP_2", new Date(), "jy98hHmfs5s3fs");
		
		
		ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, transacao, String.class);
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("==== TRANSAÇÃO REGISTRADA: " + postResponse.getBody());
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("==== TRANSAÇÃO DO TIPO: " + readTipoTransacao(transacao.getTransactionType()));
		System.out.println("------------------------------------------------------------------------------------");

		if (transacao.getTransactionType().equals("TP_1")) {
			
			Double saldoAtual = buscaSaldoUsuarioTransacao(Long.parseLong(transacao.getUserCpf()));
			Double valorCompraMenosSaldo = 0.00;
			System.out.println("==== SALDO DO CASHBACK ANTES DA COMPRA: " + saldoAtual);
			System.out.println("------------------------------------------------------------------------------------");
			
			if(saldoAtual > transacao.getTransactionValue()) {
				valorCompraMenosSaldo = saldoAtual - transacao.getTransactionValue();
				System.out.println("==== VALOR TOTAL DA COMPRA : " + transacao.getTransactionValue());
				System.out.println("------------------------------------------------------------------------------------");
				
			} else  {
				valorCompraMenosSaldo = transacao.getTransactionValue() - saldoAtual;
				System.out.println("==== VALOR DA COMPRA SEM DESCONTO DO CASHBACK: " + transacao.getTransactionValue());
				System.out.println("------------------------------------------------------------------------------------");
				System.out.println("==== VALOR DA COMPRA COM DESCONTO DO CASHBACK: " + valorCompraMenosSaldo);
				saldoAtual = 0.00;
			}
				System.out.println("------------------------------------------------------------------------------------");
				System.out.println("==== VALOR NOVO DO SALDO: " + saldoAtual);
			
			
		} else {
			System.out.println("==== VALOR TOTAL DA COMPRA : " + transacao.getTransactionValue());
			System.out.println("------------------------------------------------------------------------------------");
			Double valorCashBack = (transacao.getTransactionValue() * this.cashBackDoDia) / 100;
			System.out.println("==== VALOR DO NOVO CASHBACK GERADO: " + valorCashBack);
			System.out.println("------------------------------------------------------------------------------------");
			Double saldoAtual = buscaSaldoUsuarioTransacao(Long.parseLong(transacao.getUserCpf()));
			Double novoSaldo = (valorCashBack + saldoAtual);
			DecimalFormat df = new DecimalFormat("####0.00");
			
			System.out.println("==== VALOR NOVO DO SALDO: " + df.format(novoSaldo));
			
		}
	}
	
	/**
	 * Método utilizado para buscar o saldo do usuário.
	 * O método irá retornar o saldo, e será utilizado para somar com o seu novo cashBack gerado.
	 * @param cpf
	 * @return balance
	 */
	public Double buscaSaldoUsuarioTransacao(long cpf) {
		final String uri = "http://localhost:8087/SpringRestCrud/beblue/getuser-cpf/" + cpf;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		JSONArray jArray = new JSONArray("[" + result + "]");
		JSONObject jObj = jArray.getJSONObject(0);
		return jObj.getDouble("balance");
	}

}
