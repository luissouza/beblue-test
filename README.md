
# Teste Beblue

* *Resultado do consumo do webservice http://localhost:8087/SpringRestCrud/beblue/user-transactions* 

```bash

[
  {
    "id": 2,
    "userCpf": "44444444444",
    "merchantId": 1,
    "transactionValue": 264.65,
    "transactionType": "TP_1",
    "transactionDate": "24/11/2016",
    "transactionCode": "ky543Hm833s3fs"
  },
  {
    "id": 3,
    "userCpf": "11111111111",
    "merchantId": 1,
    "transactionValue": 649.89,
    "transactionType": "TP_2",
    "transactionDate": "24/11/2016",
    "transactionCode": "jy556Hm833s3fs"
  },
  {
    "id": 4,
    "userCpf": "22222222222",
    "merchantId": 1,
    "transactionValue": 476.55,
    "transactionType": "TP_1",
    "transactionDate": "24/11/2016",
    "transactionCode": "hy9443m833s3fs"
  },
  {
    "id": 5,
    "userCpf": "33333333333",
    "merchantId": 1,
    "transactionValue": 188.2,
    "transactionType": "TP_2",
    "transactionDate": "24/11/2016",
    "transactionCode": "jy98hHmfs5s3fs"
  }
]
```

* *Output do Java ao gerar transação e calcular CashBack do webservice http://localhost:8087/SpringRestCrud/beblue/register-transaction* 


```bash

------------------------------------------------------------------------------------
==== TRANSAÇÃO REGISTRADA: {"code":1,"message":"Transacao inserida com sucesso!"}
------------------------------------------------------------------------------------
==== TRANSAÇÃO DO TIPO: CASHBACK
------------------------------------------------------------------------------------
==== SALDO DO CASHBACK ANTES DA COMPRA: 89.66
------------------------------------------------------------------------------------
==== VALOR DA COMPRA SEM DESCONTO DO CASHBACK: 264.65
------------------------------------------------------------------------------------
==== VALOR DA COMPRA COM DESCONTO DO CASHBACK: 174.98
------------------------------------------------------------------------------------
==== VALOR NOVO DO SALDO: 0.0



------------------------------------------------------------------------------------
==== TRANSAÇÃO REGISTRADA: {"code":1,"message":"Transacao inserida com sucesso!"}
------------------------------------------------------------------------------------
==== TRANSAÇÃO DO TIPO: DEBITO
------------------------------------------------------------------------------------
==== VALOR TOTAL DA COMPRA : 649.89
------------------------------------------------------------------------------------
==== VALOR DO NOVO CASHBACK GERADO: 129.97
------------------------------------------------------------------------------------
==== VALOR NOVO DO SALDO: 141.98



------------------------------------------------------------------------------------
==== TRANSAÇÃO REGISTRADA: {"code":1,"message":"Transacao inserida com sucesso!"}
------------------------------------------------------------------------------------
==== TRANSAÇÃO DO TIPO: CASHBACK
------------------------------------------------------------------------------------
==== SALDO DO CASHBACK ANTES DA COMPRA: 52.02
------------------------------------------------------------------------------------
==== VALOR DA COMPRA SEM DESCONTO DO CASHBACK: 476.55
------------------------------------------------------------------------------------
==== VALOR DA COMPRA COM DESCONTO DO CASHBACK: 424.53
------------------------------------------------------------------------------------
==== VALOR NOVO DO SALDO: 0.0




------------------------------------------------------------------------------------
==== TRANSAÇÃO REGISTRADA: {"code":1,"message":"Transacao inserida com sucesso!"}
------------------------------------------------------------------------------------
==== TRANSAÇÃO DO TIPO: DEBITO
------------------------------------------------------------------------------------
==== VALOR TOTAL DA COMPRA : 188.2
------------------------------------------------------------------------------------
==== VALOR DO NOVO CASHBACK GERADO: 37.64
------------------------------------------------------------------------------------
==== VALOR NOVO DO SALDO: 39.89








```

