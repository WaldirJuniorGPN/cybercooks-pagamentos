# Pagamentos - Microsserviço de Gestão de Pagamentos

Microsserviço responsável pelo gerenciamento completo do ciclo de vida de pagamentos dentro do ecossistema Bytecooks.

## Visão Geral

Este serviço centraliza todas as operações relacionadas a pagamentos, incluindo processamento de transações, integração com gateways de pagamento, controle de status e histórico de pagamentos.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.6**
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - APIs RESTful
- **Hibernate** - ORM e validação
- **MySQL** - Banco de dados relacional
- **Lombok** - Redução de código boilerplate
- **Spring Boot DevTools** - Ferramentas de desenvolvimento

## Pré-requisitos

- JDK 17 ou superior
- Maven 3.6+
- MySQL 8.0+
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

## Configuração do Ambiente

### Banco de Dados

Crie um banco de dados MySQL para a aplicação:

```sql
CREATE DATABASE pagamentos_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

## Instalação e Execução

### Clonar o Repositório

```bash
git clone git@github.com:WaldirJuniorGPN/cybercooks-pagamentos.git
cd pagamentos
```

### Compilar o Projeto

```bash
mvn clean install
```

### Executar a Aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`


## Arquitetura

O microsserviço segue os princípios de **Clean Architecture** e **Domain-Driven Design (DDD)**, organizando o código em camadas bem definidas:

- **Controller**: Responsável por receber requisições HTTP e retornar respostas
- **Service**: Contém a lógica de negócio e regras de domínio
- **Repository**: Camada de acesso aos dados
- **Domain**: Entidades de negócio e objetos de valor
- **DTO**: Objetos de transferência para comunicação entre camadas

### Princípios Aplicados

- **SOLID**: Todos os princípios são seguidos rigorosamente
- **Object Calisthenics**: Código limpo e manutenível
- **Tell, Don't Ask**: Objetos encapsulam comportamento
- **DRY**: Evitar duplicação de código
- **YAGNI**: Implementar apenas o necessário

## API Endpoints

*Documentação dos endpoints será adicionada conforme desenvolvimento*

```
POST   /api/v1/pagamentos        # Criar novo pagamento
GET    /api/v1/pagamentos/{id}   # Buscar pagamento por ID
GET    /api/v1/pagamentos         # Listar pagamentos
PUT    /api/v1/pagamentos/{id}   # Atualizar pagamento
DELETE /api/v1/pagamentos/{id}   # Deletar pagamento
```

## Testes

### Executar Testes Unitários

```bash
mvn test
```

### Executar Testes de Integração

```bash
mvn verify
```

### Cobertura de Testes

```bash
mvn jacoco:report
```

O relatório será gerado em `target/site/jacoco/index.html`

## Boas Práticas Implementadas

- Validação de entrada de dados com Bean Validation
- Tratamento centralizado de exceções
- Logging estruturado
- Separação clara de responsabilidades
- Injeção de dependências via construtor
- Imutabilidade sempre que possível
- Testes automatizados
- Code review obrigatório

## Qualidade de Código

- **SonarQube**: Análise estática de código
- **Checkstyle**: Verificação de padrões de codificação
- **PMD**: Detecção de code smells
- **SpotBugs**: Identificação de bugs potenciais

## Monitoramento

*A ser implementado*

- Spring Boot Actuator
- Métricas com Micrometer
- Logs centralizados
- Health checks

## Contribuindo

1. Crie uma branch para sua feature (`git checkout -b feature/nova-funcionalidade`)
2. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
3. Push para a branch (`git push origin feature/nova-funcionalidade`)
4. Abra um Pull Request

### Convenção de Commits

Utilize [Conventional Commits](https://www.conventionalcommits.org/):

```
feat: adiciona novo endpoint de pagamento
fix: corrige validação de valor
docs: atualiza documentação da API
refactor: melhora estrutura do serviço
test: adiciona testes para controller
```

## Autores

- **Bytecooks Team**

## Licença

*MIT license*

## Contato

Para dúvidas ou sugestões, entre em contato com a equipe de desenvolvimento.

---

**Status do Projeto**: Em Desenvolvimento 🚧