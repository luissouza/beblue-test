package com.beblue.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "transacao")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "user_cpf")
	private String userCpf;

	@Column(name = "merchant_id")
	private Integer merchantId;

	@Column(name = "transaction_value")
	private Double transactionValue;

	@Column(name = "transaction_type")
	private String transactionType;
	
	@Column(name = "transaction_date")
	private Date transactionDate;
	
	@Column(name = "transaction_code")
	private String transactionCode;
	
	public Transacao() {
		
	}

	public Transacao(String userCpf, Integer merchantId, Double transactionValue, String transactionType,
			Date transactionDate, String transactionCode) {
		super();
		this.userCpf = userCpf;
		this.merchantId = merchantId;
		this.transactionValue = transactionValue;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionCode = transactionCode;
	}

	public String getUserCpf() {
		return userCpf;
	}

	public void setUserCpf(String userCpf) {
		this.userCpf = userCpf;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public Double getTransactionValue() {
		return transactionValue;
	}

	public void setTransactionValue(Double transactionValue) {
		this.transactionValue = transactionValue;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
