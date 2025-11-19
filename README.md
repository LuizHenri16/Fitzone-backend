# Fitzone-backend

Backend do projeto Fitzone, desenvolvido como Projeto Integrador do curso de Desenvolvimento de Sistemas do senac

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

## 🚀 Tecnologias utilizadas
- Java 17+
- Spring Boot
- Maven

### 📋 Pré-requisitos

Para rodar é preciso ter:
1. Java instalado, recomendo a versão 17+
2. MySQL instalado e configurado no projeto
3. Modificar application.yml para poder conectar ao mysql local configurado (url, username e password)
3. Schema criado no banco de dados com o nome do banco descrito no application.yml (nome: fitzone)

## ⚙️ Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/LuizHenri16/Fitzone-backend.git
   ```
   

2. Abra o projeto na IDE desejada, como o netbeans ou intellij.
3. Execute o projeto para ter o backend rodando.
4. Execute o script sql disponível para preencher com dados iniciais (login e utilidades)
5. Siga os passos do frontend para poder realizar login e utilizar o projeto: [Repositório Fitzone Frontend](https://github.com/LuizHenri16/fitzone-frontend)

## 📌 Endpoints principais

###  /customer
1. POST - Criar novo cliente
2. PUT /{id} - Atualizar dados do cliente pelo id
3. GET - Retornar lista de cliente
4. GET /{id} - Retornar cliente por id
5. DELETE /{id} - Deletar cliente por id
6. GET /birthday - Retornar aniversariantes do dia
7. GET /registeredcustomers - Retornar clientes cadastrados
8. GET /activecustomers - Retornar clientes  ativos


### /finance
1. POST /expense - Cadastrar despesa
2. GET /expense - Retornar lista de despesas
3. GET /expense/total - Retornar valor total de despesas em até 30 dias
4. POST /payment/{customerId} - Cadastrar pagamento pelo id do cliente
5. GET /payment - Retornar lista de pagamentos
6. GET /payment/{id} - Retonar pagamento
7. GET /payment/total - Retornar valor total de pagamentos em até 30 dias

### /user
1. POST -  Cadastrar novo usuário
2. GET - Retornar lista de usuários
3. PUT /{id} - Editar usuário por id 
4. DELETE /{id} - Apagar usuário por id

### /login
1. POST - Realizar login do usuário

## 🛠️ Construído com

* [Java](https://www.oracle.com/java/) - Linguagem usada
* [Springboot](https://spring.io/projects/spring-boot) - O framework utilizado
* [Maven](https://maven.apache.org/) - Gerente de Pacotes


## ✒️ Autores
* **Um desenvolvedor** - Elaboração e Execução

## 🎁 Mensagem final

* Este é um projeto especial, pois é o meu primeiro! Feito do 0, me ajudou a desenvolver habilidades para seguir na minha carreira de desenvolvedor 📢 ;

---
⌨️ com ❤️ por [Luiz Henrique](https://gist.github.com/LuizHenri16) 😊
