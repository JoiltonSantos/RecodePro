# AGENCIA DE VIAGEM - MIGRAR

## Banco de dados conceitual
![Banco de dados conceitual](https://github.com/JoiltonSantos/RecodePro/blob/main/migrar_bd/bd_conceitual.jpg)

## Banco de dados lógico
![Banco de dados lógico](https://github.com/JoiltonSantos/RecodePro/blob/main/migrar_bd/bd_logico.jpg)

## Banco de dados físico
Para conferir o banco de dados físico, clique aqui: [Banco de dados físico](https://github.com/JoiltonSantos/RecodePro/blob/main/migrar_bd/bd_fisico.sql)

## Diagrama de classes
![Diagrama de classes](https://github.com/JoiltonSantos/RecodePro/blob/main/migrar_bd/uml_diagrama_de_classes.jpg)

## Explicação do banco de dados

O banco de dados representa o sistema de uma agência de viagens que gerencia os clientes, as reservas e os destinos. As tabelas, os campos e as relações são explicados a seguir:

### Tabela `cliente`

A tabela `cliente` armazena os dados dos clientes que fazem reservas na agência. Os campos são:

- `idCliente`: é a chave primária da tabela, que identifica cada cliente de forma única.
- `nomeCliente`: é o nome completo do cliente.
- `cpfCliente`: é o número de CPF do cliente (campo com restrição `unique`).
- `emailCliente`: é o endereço de e-mail do cliente.
- `telefoneCliente`: é o número de telefone do cliente.

### Tabela `destino`

A tabela `destino` armazena os dados dos destinos oferecidos pela agência de viagens. Os campos são:

- `idDestino`: é a chave primária da tabela, que identifica cada destino de forma única.
- `localDestino`: é o local de destino, representando o local da viagem.
- `valorDestino`: é o valor da passagem para o destino.

### Tabela `reserva`

A tabela `reserva` é a tabela intermediária que liga os clientes aos destinos e armazena os detalhes das reservas. Os campos são:

- `idReserva`: é a chave primária da tabela, que identifica cada reserva de forma única.
- `dataReserva`: é a data em que a viagem irá acontecer, ou seja, a data da viagem.
- `statusReserva`: é o status da reserva, que pode ser "confirmada", "cancelada" ou "pendente".
- `idCliente`: é a chave estrangeira que referencia o cliente que fez a reserva na tabela `cliente`.
- `idDestino`: é a chave estrangeira que referencia o destino para o qual a reserva foi feita na tabela `destino`.

### Tabela `contato`

A tabela `contato` armazena os dados dos contatos feitos por qualquer pessoa que queira tirar dúvidas sobre a agência de viagens. Os campos são:

- `idContato`: é a chave primária da tabela, que identifica cada contato de forma única.
- `nomeContato`: é o nome da pessoa que fez o contato.
- `emailContato`: é o endereço de e-mail da pessoa que fez o contato.
- `telefoneContato`: é o número de telefone da pessoa que fez o contato.
- `mensagemContato`: é a mensagem enviada pela pessoa para a agência.

### Relações

As relações entre as tabelas são as seguintes:

- A tabela `cliente` tem uma relação de um para muitos com a tabela `reserva`, ou seja, um cliente pode fazer várias reservas, e cada reserva pertence a um único cliente.
- A tabela `destino` tem uma relação de um para muitos com a tabela `reserva`, o que significa que um destino pode ser reservado em várias reservas, e cada reserva está associada a um único destino.