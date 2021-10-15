# Todo-list

Aplicação semelhante a uma todo list (lista de tarefas), onde será possível cadastrar tarefas, listar tarefas, buscar tarefas pelo id, editar e excluir tarefas (CRUD).



## Requisitos:

<h4>[Git](https://git-scm.com/).</h4>
<h4>[Comunidade IntelliJ](https://www.jetbrains.com/pt-br/idea/download/#section=windows).</h4>
<h4>[Java JDK](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html).</h4>
<h4>[Spring boot](https://start.spring.io/).</h4>
<h4>[Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli).</h4>
<h4>[H2](http://www.h2database.com/html/features.html).</h4>
<h4>[Swagger](https://swagger.io/).</h4>
<h4>[Postresql](https://www.postgresql.org/).</h4>

## Atualização de dependências:

<h4>[MVN Repository](https://mvnrepository.com/).</h4>

### Desenvolvendo o programa:

<h4>No site spring boot:</h4>

Em Project selecione Maven, para genciador de dependências.
Em Spring Boot selecione o mais atual, ou deixe o defalt.
Em Group escreva o nome do seu pacote, normalmente coloco meu github. (ex.: com.github.com.ludmilareis).
Em Artifact escreva o nome do seu projeto.
Em Packaging selecione Jar.
Em Java selecione java 11 ou superior, caso contrario vai dar erro nas suas dependências.
Em Dependências selecione:
Lombok
Spring Web
Spring Data JPA
H2 Database
Click em generate, salve sem seu workspace depois abre na sua idea.

<h4>Na idea:</h4>
Dentro de scr > main > java > "seu pacote" > crie pacotes controller, model, repository e service.

### Configuração de banco de dados:

Em src > main > java > resources > application.properties
Obs.: a # siginifica que o codigo está comentado, o banco h2 só é utilizado em produção, para fazer o deploy na nuvem(heroku) passamos para o Postresql.

//Habilita o console h2
spring.h2.console.enabled=true

//Nome da tabela
spring.datasource.url=jdbc:h2:mem:todolist
//Driver
spring.datasource.driverClassName=org.h2.Driver
//Login
spring.datasource.username=sa
spring.datasource.password=

//SQL
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update


#spring.datasource.url=${JDBC_DATASOURCE_URL}
#spring.jpa.show-sql=true
#spring.jpa.generate-ddl=true
#server.port=${PORT:8080}

#spring.datasource.driverClassName=org.postgresql.Driver
#spring.datasource.maxActive=10
#spring.datasource.maxIdle=5
#spring.datasource.minIdle=2
#spring.datasource.initialSize=5
#spring.datasource.removeAbandoned=true

extends JPARepository comunicação entre a task (camada de modelo, entidade de dados) e o banco de dados, fazendo o find, salve entre outos.
Criar os endpoints na controller
Os Mappings são os endponts
Controller chama a service, Service chama a repository, repository chama a camada de dados que comunica com o banco
http://localhost:8080/swagger-ui.html

###Heroku:
No PowerShell dentro da pasta do projeto 
git checkout -b master
heroku create
heroku apps:rename nome da aplicação

