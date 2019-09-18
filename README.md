It's a project to practice, simulating a fast food system <br>
The main goal here is try to use some concepts of object oriented programming. 

To run it just use `mvn spring-boot:run` and it'll be available on `localhost:8080`

There are some endpoints to use it

For getting the sandwiches available `localhost:8080/lanches`

For getting a specific sandwich `localhost:8080/lanches/x-bacon` <br>
Available options:
<li>x-bacon</li>
<li>x-burguer</li>
<li>x-egg</li>
<li>x-egg-bacon</li>

For add a sandwich in an order `localhost:8080/pedido/{table_number}/item` <br>
Payload example: 
`{
      "nome": "X-Burguer",
      "ingredientes": [
          "Alface",
          "Hamburguer",
          "Hamburguer",
          "Hamburguer",
          "Queijo"
      ]
}`

For getting an order `localhost:8080/pedido/1`

For paying the bill `localhost:8080/pedido/1/baixa`

Before you ask... yes all the variables and classes are written in portuguese and there is no why for that :)