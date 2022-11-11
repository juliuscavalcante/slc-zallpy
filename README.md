# Grupo de Serviços SLC

## SLC - Serviço de Liquidação Centralizada

O SLC - Serviço de Liquidação Centralizada - é o grupo de serviços operado pela CIP para processamento da compensação e da liquidação das ordens eletrônicas de crédito ou de débito entre instituições financeiras e/ou instituições de pagamento participantes de um mesmo arranjo de pagamento integrante do SPB, conforme dispõem os arts. 25 e 26 do Regulamento Anexo à Circular nº 3.682, de 24 de novembro de 2013, com as alterações da Circular nº 3.765, de 25 de setembro de 2015.

As mensagens deste grupo de serviços pertencem ao domínio de sistema SPB01. As mensagens informativas referentes a arquivos deste grupo de serviço (por exemplo, GEN0015) trafegarão no domínio de sistema MES01.

## Liquidação Financeira Multilateral
SLC0001 - SLC informa movimentos bilaterais de liquidação multilateral no dia 

# O desafio

***Consiste em criar uma rotina que irá carregar o arquivo SLC0001-modelo.xml que se encontra nesse repositório para 
um banco de dados e disponibilizar em uma API.***

## Observações

* **O candidato é livre para escolher qual tecnologia vai usar, mas isso também será avaliado.**
* **Entregar o projeto em um repositório público (github) com o código fonte.**
* **Criar um arquivo README.md na raiz do projeto, com uma breve descrição sobre a solução implementada e instruções de execução do projeto.**

## Requisitos desejáveis
* **Entregar a API rodando em algum host (Exemplo: Heroku, AWS, etc) na porta 80 ou 443.**
* **Banco de dados em memória. (Exemplo: HSQLDB, H2, etc)**
* **Processo de build via Gradle ou Maven.**
* **Caso utilize Java, que seja apartir da versão 1.8** 
* **Testes unitários. (Exemplo: JUnit)**

## O que será avaliado
* **Qualidade de código. (Simplicidade x uso de padrões)**
* **Boas práticas. (Exemplo: OO ou FP / CleanCode**
* **Escrita dos testes. (Assertividade, simplicidade e relevância)**


# Sobre o Projeto

## Tecnologias Utilizadas
- Java 17
- Spring
- Spring Boot
- Spring Batch
- Spring Data JPA
- Hibernate
- JDBC
- MySQL
- H2
- Maven
- JUnit 5
- Mockito
- Swagger

## Como Rodar o Projeto

### Instalação
O projeto é gerenciado pelo Maven, então para usa-lo basta importa-lo para uma IDE.


### Configurações do Banco de Dados
Você pode criar um banco de dados MySQL com o nome o nome de sua preferência, porém é necessario adequar o projeto de acordo com as suas configurações. Para isso abra o arquivo application.properties.dev, localizado em src/main/resources/application.properties.dev e altere os seguintes comandos ao arquivo:

```properties
spring.datasource.url = jdbc:mysql://localhost:3306/nome-do-seu-banco-de-dados
spring.datasource.username = seu-usuario
spring.datasource.password = sua-senha
```

Também será necessário alterar as configurações de dataSource localizadas na src/main/resources/context-datasource.xml
```xml
<property name="url" value="jdbc:mysql://localhost:3306/nome-do-seu-banco-de-dados" />
<property name="username" value="seu-usuario" />
<property name="password" value="sua-senha" />
```

### Como o projeto funciona

1. A tabela que receberá os dados do arquivo .xml foi mapeada através do Spring Data JPA, essa entidade recebeu o nome de `Register`, e nela foram criados os atributos do arquivo a ser lido, no qual serão transformados em colunas no banco de dados (MySQL). Então, primeiramente é necessário executar o projeto através da `ZallpySlcApplication` para mapeamento de criação da tabela desejada.

2. Para relacionar-se com o banco de dados foi utilizado o **spring-jdbc** e o **spring-oxm** para interagir com o arquivo o .xml.
3. A classe `RegisterItemPreparedStatementSetter` é responsável por converter os dados para serem salvos no Banco de Dados.
4. O Bean `context-datasource.xml` é encarregado de fazer a comunicação entre os dados que serão lidos e a Database.

5. Já o Bean `spring-batch-context.xml` são onde as configurações do Spring Batch estão armazenadas, como às configurações de dataSource, e os beans para **reader**, chamado de `xmlItemReader`, no qual é configurado o arquivo a ser executada a leitura `SLC0001-modelo.xml`. Nesse mesmo contexto também está o Bean para escrita **(writer)**, marcado como, `databaseItemWriter`, nele foram determinados além da localização do Banco de Dados, como também os comandos SQL a serem executados para inserção dos dados no MySQL, logo abaixo está o Bean para tratamento de conversão desses dados e também o job nomeado de `registerResult` responsável  em executar a transaction.

6. Para executar a leitura do arquivo `SLC0001-modelo.xml` basta executar a classe `Main`, nela está a estrutura do JobLauncher para executar o `spring-batch-context.xml`. Após o processamento, os dados do arquivo .xml serão lidos e escritos corretamente na tabela correspondente no Banco de Dados.

7. Para disponibilizar uma API REST, foi usado o padrão MVC, empregando o uso da camada de Repository, o Service para proteger a lógica de negócios, no caso os seus métodos da aplicação, e o Controller com a responsabilidade de processar as requisições e gerar as respostas, com os seguintes métodos HTTP (GET/UPDATE/DELETE), com os endpoints findAll, findById, update e delete. Inclusive, também foi utilizado o padrão de arquitetura de DTOs (Data Transfer Objects). Além disso, foi criada uma Exception personalizadas para mensagens mais assertivas ao usuário.

8. Para disponibilizar essa API foi utilizado o Swagger, que pode ser acessado através do link: http://localhost:8080/swagger-ui/index.html caso esteja acessando a aplicação localmente. Porém também foi realizado o deploy do projeto no Heroku, no qual, pode ser acessado através deste link: https://slc-zallpy.herokuapp.com/swagger-ui/index.html

9. Também Foram construídos testes unitários com o Mockito e JUnit para os endpoints criados.










