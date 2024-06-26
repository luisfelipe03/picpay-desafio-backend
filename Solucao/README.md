| <h3> Solução do Desafio Backend do PicPay </h3> | <img align="right" alt="Felipe-java" height="60" width="60" src="https://brunograna.notion.site/image/https%3A%2F%2Fpbs.twimg.com%2Fprofile_images%2F1605198751085330434%2FUA6nxH1G_400x400.jpg?table=block&id=cf14e138-affe-4c34-b2d1-403d1f2a5443&spaceId=2fe2240a-665d-4d59-85b5-2d735afdb7d3&width=250&userId=&cache=v2"> |
|--------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## Objetivo 
O objetivo do desafio "PicPay Simplificado" é criar uma plataforma de pagamentos que permita a transferência de dinheiro entre diferentes tipos de usuários (comuns e lojistas) de forma segura e eficiente. 


## Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Docker
* Spring Cloud OpenFeign
* ControllerAdvice & Problem Details
* Hibernate Validator

## Passo a Passo da Implementação

### Comunicação com o Banco de Dados

1. **Inicializando o Projeto**:
   - Configuração inicial do projeto com as dependências necessárias: JPA, MySQL, Validator, OpenFeign.

2. **Configuração do MySQL no Docker**:
   - Configurar o MySQL em um contêiner Docker para facilitar a implantação e gerenciamento do banco de dados.

3. **Configuração da Comunicação do Spring Boot com o MySQL**:
   - Ajustar as propriedades do Spring Boot para conectar-se ao MySQL, garantindo que a aplicação consiga interagir com o banco de dados corretamente.

### Funcionalidade de Cadastro de Wallet

1. **Mapeamento das Entidades**:
   - Criar entidades `Wallet` e `WalletType` para representar as carteiras e seus tipos no banco de dados.

2. **Inicialização de WalletType no Banco de Dados**:
   - Preencher a tabela de tipos de carteira (`WalletType`) com dados iniciais para diferenciar usuários comuns e lojistas.

3. **Funcionalidade de Cadastro de Wallet**:
   - **Validação dos Dados Únicos**: Garantir que CPF/CNPJ e e-mail sejam únicos no sistema.
   - **Inserção na Base de Dados**: Implementar a lógica para inserir novos registros de carteiras no banco de dados.

4. **Tratamento de Exceções**:
   - Utilizar `ProblemDetails` e `RestExceptionHandler` para gerenciar e formatar as exceções de forma amigável e consistente.

5. **Validação de Dados de Entrada**:
   - Implementar validações para assegurar que os dados fornecidos pelos usuários estejam corretos e completos.

6. **Testes e Validação**:
   - Testar a API de cadastro de carteira e verificar se os dados estão sendo armazenados corretamente no banco de dados.

### Funcionalidade de Transferência

1. **Mapeamento da Entidade `Transaction`**:
   - Criar a entidade `Transaction` para representar as transferências de dinheiro entre carteiras.

2. **Criação dos Mocks do Autorizador e Notificador Externo**:
   - Utilizar [Mocky](https://designer.mocky.io/) para criar mocks dos serviços externos de autorização e notificação.

3. **Serviço de Consulta ao Autorizador Externo**:
   - Implementar o serviço que realiza a consulta ao autorizador externo antes de efetuar a transferência.

4. **Serviço de Notificação de Recebimento de Transferência**:
   - Implementar o serviço que notifica o receptor da transferência utilizando chamadas assíncronas (`CompletableFuture`).

5. **Funcionalidade de Transação**:
   - **Validação do Tipo de Carteira**: Verificar se a carteira é do tipo permitido para a operação.
   - **Validação do Saldo**: Confirmar que o remetente possui saldo suficiente para a transferência.
   - **Consulta ao Autorizador Externo**: Chamar o serviço externo de autorização para validar a transferência.
   - **Realização da Transferência**: Efetuar a transferência de dinheiro entre carteiras.
   - **Envio de Notificação para o Recebedor**: Notificar o recebedor da transferência de forma assíncrona.

6. **Tratamento de Exceções**:
   - Ajustar o `RestExceptionHandler` para capturar e tratar possíveis erros durante a operação de transferência.

7. **Testes e Validação**:
   - Testar a API de transferência e verificar se as transações estão sendo processadas corretamente e refletidas no banco de dados.

### Ajuste Final

1. **Aplicação de Logging**:
   - Utilizar SLF4J para adicionar logs ao projeto, facilitando o monitoramento e a depuração da aplicação.

## Endpoints

...
