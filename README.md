
# Aplicación Mensajería

La solución propuesta para el problema planteado esta realizado con las siguientes tecnologías:

 - Api REST con Spring Boot.
 - Sistema de Colas con Apache MQ
 - Sistema de mensajería con JMS
 - Persistencia de Transacciones en MysQl.

## Correr proyecto

 1. mvn package 
 2. java -jar target/service-0.0.1-SNAPSHOT.jar

## Funcionalidad

1 La aplicación consta de una capa API, cuya entrada es un objeto JSON con los datos de la transacción, se debe realizar la siguiente petición:

- url:
[http://ec2-18-219-74-62.us-east-2.compute.amazonaws.com:3600/api/notifications](http://ec2-18-219-74-62.us-east-2.compute.amazonaws.com:3600/api/notifications) 
 -método: POST
- Headers: Content-Type: application/json

-Body (Objeto transacción)
{
  "transactionCode": 3463,
  "date": "050714",
  "accountNumber": "1223434534",
  "amount": 30000,
  "currencyType": "COP",
  "recipient": "nombre re",
  "branchOfficeCode": "12345",
  "transactionDetail" : "Descripción de la tx",
  "cashierId": "5324",
  "accountBalance": 400000,
  "checkNumber": 843643,
  "dateSCA": "05-07-14",
  "hour": 133050
}


----------

![enter image description here](http://preview.ibb.co/d8YKpR/post_a.png)

2. En este momento la aplicación utiliza el Apache Active MQ serializa el mensaje y lo mete en la cola, se puede verificar en la consola de administración de el MQ
[http://18.220.79.122:8161/admin/](http://18.220.79.122:8161/admin)
- user: admin
- psw: admin

![enter image description here](http://preview.ibb.co/fGvzpR/post_mq_a.png)

El consumidor de el mensaje toma el mensaje de la cola y guarda en base de datos el valor de la Transacción, si el proceso y los datos son correctos podremos visualizar el dato guardado haciendo la siguiente petición:

- url: http://ec2-18-219-74-62.us-east-2.compute.amazonaws.com:3600{transactionCode}
- Método: GET
- {transactionCode}: Código de la transacción
![enter image description here](http://preview.ibb.co/eD68G6/post_c3.png)

O se pueden listar todas las transacciones guardadas en la siguiente consulta:

-  url: http://ec2-18-219-74-62.us-east-2.compute.amazonaws.com:3600/transactions
Metodo: GET

![enter image description here](http://preview.ibb.co/fk3G3m/get_list.png%22)
