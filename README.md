<h1> Digital Bank API </h1>

API REST para simulação de um banco digital, com suporte a transferência de valores entre contas, consulta de transações e processamento assíncrono de notificações.

<h3>Tecnologias utilizadas: </h3>

Java 21 <br/>
Spring Boot <br/>
Spring Data JPA <br/>
Apache Kafka <br/>
Flyway <br/>
PostgreSQL <br/>
Maven <br/>
Swagger (OpenAPI) <br/>
JUnit + Mockito

<h3>Como rodar o projeto </h3>

Java 21 <br/>
Maven 3.9 <br/>
Docker + Docker Compose <br/>
PostgreSQL rodando localmente <br/>

<h4>PostgreSQL </h4>

database: digital_bank_bd <br/>
user: postgres <br/>
password: postgres <br/>

<h4>Rodar Flyway </h4>

mvn -pl migration flyway:migrate -Dflyway.configFiles=src/main/resources/flyway-local.conf

<h4>Rodar Kafka </h4>

Subir kafka/zookeeper via docker: </br>
docker-compose up -d

Criar tópico kafka</br>
docker exec -it kafka kafka-topics --create --topic transfer-events --bootstrap-server localhost:9092

<h3>Acesso ao swagger </h3>
http://localhost:8080/digital-bank/swagger-ui

<h3>Decisões de design e arquitetura adotadas </h3>
Sistema multi-módulo, permitindo a separação de responsabilidades. </br>
* API - Entrada de dados
* Consumer - Processamento assíncrono
* Migration - versionamento do banco
* Domain - Regra de negócio

Kafka
* Desacoplamento entre transactions e notification
* Mais performatico por colocar parte do processo de forma assíncrona

Valor monetário em centavos, evitando problemas com casas decimais como operações matematicas que causem ponto flutuante

Flyway
* Histórico versionado do banco 
* Reprodutibilidade de ambiente 
* Facilidade de deploy

PostgreSQL
* Suporte robusto a transações (ACID)
* Suporte a concorrência (MVCC)
