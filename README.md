# API de Sistema de Gerenciamento de Clínicas

## Descrição

A API do Sistema de Gerenciamento de Clínicas foi desenvolvida para fornecer uma solução eficiente e centralizada para o gerenciamento de uma clínica médica. Com esta API, é possível realizar operações relacionadas a pacientes, médicos, agendamentos e informações relevantes para o funcionamento da clínica.

## Tecnologias Utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- **Java**: Linguagem de programação orientada a objetos amplamente utilizada para o desenvolvimento de aplicativos empresariais.

- **Spring Boot**: Framework que simplifica o desenvolvimento de aplicativos Java, oferecendo configuração mínima e facilitando a criação de APIs RESTful.

- **MySQL**: Sistema de gerenciamento de banco de dados relacional, utilizado para armazenar os dados do sistema.

- **Flyway**: Ferramenta de versionamento de banco de dados que simplifica a migração e versionamento do esquema do banco de dados.

- **JWT (JSON Web Token)**: Tecnologia de autenticação baseada em tokens que permite a transmissão segura de informações entre as partes, proporcionando uma forma eficiente de autenticação.

- **Auth0**: Plataforma de autenticação e autorização que oferece serviços de identidade seguros e escaláveis, facilitando a integração de recursos avançados de autenticação no projeto.

## Funcionalidades

A API do Sistema de Gerenciamento de Clínicas oferece as seguintes funcionalidades:

1. **Cadastro de Pacientes**: Permite a inclusão, atualização, remoção e consulta de informações do paciente.

2. **Cadastro de Médicos**: Possibilita o gerenciamento completo das informações do médico, incluindo adição, edição, exclusão e consulta.

3. **Agendamento de Consultas**: Fornece recursos para agendar consultas, consultar agendamentos e cancelar consultas agendadas.

## Instruções de Uso

### Pré-requisitos

- Java 8 ou superior instalado
- MySQL instalado e configurado
- Maven instalado

### Configuração do Banco de Dados

1. Crie um banco de dados no MySQL para o projeto.
2. Configure as propriedades do banco de dados no arquivo `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## Executando o Projeto

1. Clone o repositório do projeto:

```bash
git clone https://github.com/AugustoSandrini/vollmed-api
```

2. Navegue até o diretório do projeto:

```bash
cd vollmed-api
```

3. Execute o projeto usando o Maven:

```bash
mvn spring-boot:run
```

- A API estará disponível em http://localhost:8080.

## Contribuições
- Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, sinta-se à vontade para criar uma issue ou enviar um pull request.

## Licença
- Este projeto está licenciado sob a Licença MIT.