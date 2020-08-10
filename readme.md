# Desafio Back-end PicPay

Primeiramente, obrigado pelo seu interesse em trabalhar na melhor plataforma de pagamentos do mundo!
Abaixo você encontrará todos as informações necessárias para iniciar o seu teste.

## Avisos antes de começar

- Crie um repositório no seu GitHub **sem citar nada relacionado ao PicPay**.
- Faça seus commits no seu repositório.
- Envie o link do seu repositório para o email talentos_php@picpay.com.
- Você poderá consultar o Google, Stackoverflow ou algum projeto particular na sua máquina.
- Fique à vontade para perguntar qualquer dúvida aos recrutadores.
- Fique tranquilo, respire, assim como você, também já passamos por essa etapa. Boa sorte! :)

*Corpo do Email com o link do repositório do desafio*

>Seu Nome
>
>Nome do recrutador
>
>Link do repositório

## Setup do projeto

- Framework: Fique a vontade pra usar o framework que quiser
- Subir local ou Docker * (valorizamos uma boa estrutura de docker feita por você)


## Objetivo - PicPay Simplificado

Temos 2 tipos de usuários, os comuns e lojistas, ambos têm carteira com dinheiro e realizam transferências entre eles. Vamos nos atentar **somente** ao fluxo de transferência entre dois usuários.

Requisitos:

- Para ambos tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail.

- Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários. 

- Lojistas **só recebem** transferências, não enviam dinheiro para ninguém.

- Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este mock para simular (https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6).

- A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro deve voltar para a carteira do usuário que envia. 

- No recebimento de pagamento, o usuário ou lojista precisa receber notificação enviada por um serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. Use este mock para simular o envio (https://run.mocky.io/v3/b19f7b9f-9cbf-4fc6-ad22-dc30601aec04). 

- Este serviço deve ser RESTFul.

### Payload

POST /transaction

```json
{
    "value" : 100.00,
    "payer" : 4,
    "payee" : 15
}
```


# Avaliação

Caso você **não se sinta à vontade** com a arquitetura proposta, você pode apresentar sua solução utilizando frameworks diferentes.
Atente-se a cumprir a maioria dos requisitos, pois você pode cumprir-los parcialmente e durante a avaliação vamos bater um papo a respeito do que faltou.

Teremos 2 partes da avaliação:

A correção objetiva será realizada através da utilização de um script de correção automatizada.

A correção qualitativa será durante a entrevista e levará em conta os seguintes critérios:

## O que será avaliado e valorizamos
- Código limpo e organizado (Padrão de mercado PSRs)
- Ser consistente em suas escolhas
- Apresentar soluções que domina
- Modelagem de Dados
- Manutenibilidade do Código
- Tratamento de erros
- Cuidado com itens de segurança
- Arquitetura (estruturar o pensamento antes de escrever)
- Esboço da arquitetura usando o diagrama da sua escolha

## O que NÃO será avaliado
- Fluxo de cadastro de usuários e lojistas
- Autenticação
- Frontend (só avaliaremos a API Restful)

## O que será um diferencial
- Uso de Docker
- Testes de [integração](https://www.atlassian.com/continuous-delivery/software-testing/types-of-software-testing)
- Testes [unitários](https://www.atlassian.com/continuous-delivery/software-testing/types-of-software-testing)
- Uso de Design Patters
- Documentação
- Proposta de melhoria na arquitetura


## Critério de avaliação por níveis

Se você está se candidatando como:

### Júnior
Esperamos:

* Ótimo raciocínio
* Conhecimento básico de design patterns
* PSR2
* Boa modelagem de SQL/noSQL

### Pleno
Além do que esperamos de **júnior**, esperamos:

* Código desacoplado de controller/router (services, repository)
* Testes de API (integração)
* Síntaxe de PHP impecável
* Domínio avançado de design patterns
* Cleancode
* Métodos e variáveis em inglês

### Sênior

Além do que esperamos de **júnior** e **pleno**, também esperamos:

* Unit tests
* Transação assíncrona
* Evitar side effect (concorrência)
* Autonomia (_trick - você pode definir a arquitetura do seu transfer, como também definir um endpoint de acordo com o desafio da melhor forma_)
* Recursos avançados de REST
* **Nos surpreenda!**

## Materiais úteis
- http://br.phptherightway.com/
- https://www.php-fig.org/psr/psr-12/
- https://www.atlassian.com/continuous-delivery/software-testing/types-of-software-testing
- https://github.com/exakat/php-static-analysis-tools
- https://martinfowler.com/articles/microservices.html
- https://picpay.com/site/sobre-nos

## Avaliação

De acordo com os critérios acima, iremos avaliar seu teste para avançarmos para a entrevista técnica.
Caso não tenha atingido aceitavelmente o que estamos propondo acima, não iremos prosseguir com o processo.

## Para o dia da entrevista técnica
Na data marcada pelo recrutador tenha sua aplicação rodando na sua máquina local para execução dos testes e para nos mostrar os pontos desenvolvidos e possíveis questionamentos.

## Próximos Passos

  * Questionário comportamental
  * Entrevista com o TechManager
  * Sua proposta!
