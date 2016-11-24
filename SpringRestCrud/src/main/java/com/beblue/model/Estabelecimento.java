package com.beblue.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "estabelecimento")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Estabelecimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "nome")
	private String nomeEstabelecimento;

	@Column(name = "cashback_segunda")
	private Integer cashBackSegunda;

	@Column(name = "cashback_terca")
	private Integer cashBackTerca;

	@Column(name = "cashback_quarta")
	private Integer cashBackQuarta;

	@Column(name = "cashback_quinta")
	private Integer cashBackQuinta;

	@Column(name = "cashback_sexta")
	private Integer cashBackSexta;

	@Column(name = "cashback_sabado")
	private Integer cashBackSabado;

	@Column(name = "cashback_domingo")
	private Integer cashBackDomingo;

	public Estabelecimento() {
		super();
	}

	public Estabelecimento(String nomeEstabelecimento, Integer cashBackSegunda, Integer cashBackTerca,
			Integer cashBackQuarta, Integer cashBackQuinta, Integer cashBackSexta, Integer cashBackSabado,
			Integer cashBackDomingo) {
		super();
		this.nomeEstabelecimento = nomeEstabelecimento;
		this.cashBackSegunda = cashBackSegunda;
		this.cashBackTerca = cashBackTerca;
		this.cashBackQuarta = cashBackQuarta;
		this.cashBackQuinta = cashBackQuinta;
		this.cashBackSexta = cashBackSexta;
		this.cashBackSabado = cashBackSabado;
		this.cashBackDomingo = cashBackDomingo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}

	public Integer getCashBackSegunda() {
		return cashBackSegunda;
	}

	public void setCashBackSegunda(Integer cashBackSegunda) {
		this.cashBackSegunda = cashBackSegunda;
	}

	public Integer getCashBackTerca() {
		return cashBackTerca;
	}

	public void setCashBackTerca(Integer cashBackTerca) {
		this.cashBackTerca = cashBackTerca;
	}

	public Integer getCashBackQuarta() {
		return cashBackQuarta;
	}

	public void setCashBackQuarta(Integer cashBackQuarta) {
		this.cashBackQuarta = cashBackQuarta;
	}

	public Integer getCashBackQuinta() {
		return cashBackQuinta;
	}

	public void setCashBackQuinta(Integer cashBackQuinta) {
		this.cashBackQuinta = cashBackQuinta;
	}

	public Integer getCashBackSexta() {
		return cashBackSexta;
	}

	public void setCashBackSexta(Integer cashBackSexta) {
		this.cashBackSexta = cashBackSexta;
	}

	public Integer getCashBackSabado() {
		return cashBackSabado;
	}

	public void setCashBackSabado(Integer cashBackSabado) {
		this.cashBackSabado = cashBackSabado;
	}

	public Integer getCashBackDomingo() {
		return cashBackDomingo;
	}

	public void setCashBackDomingo(Integer cashBackDomingo) {
		this.cashBackDomingo = cashBackDomingo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
