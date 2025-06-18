# Order Sales

Projeto capaz de aplicar descontos em vendas com base no valor total do pedido.

Trata-se de um pequeno projeto de estudo, onde foram aplicados os conceitos de
- TDD com o uso de testes unitários
- Desing pattern **Chain of responsability**.

## Tecnologias
- Java 21
- JUnit 4
- Maven

## Regra de negócio

- Se o valor total do pedido for mais que R$ 300,00, aplicar 4% de desconto.
- Se o valor total do pedido for mais que R$ 800,00, aplicar 6% de desconto.
- Se o valor total do pedido for mais que R$ 1000,00, aplicar 8% de desconto.