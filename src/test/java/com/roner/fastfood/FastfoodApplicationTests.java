package com.roner.fastfood;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class FastfoodApplicationTests {

  @Test
  public void contextLoads() {
  }

  @Test
  public void xbacon_testandoPreco() {
    Lanche lanche = new Lanche("X-Bacon", Lanches.X_BACON.getIngredientes());
    double valor = Ingrediente.BACON.getPreco() + Ingrediente.HAMBURGUER.getPreco()
        + Ingrediente.QUEIJO.getPreco();
    assertEquals(lanche.getPreco(), valor);
  }

  @Test
  public void xbacon_testandoMuitaCarne() {
    Lanche lanche = new Lanche("X-Bacon", Lanches.X_BACON.getIngredientes());
    lanche.adicionaIngrediente(Ingrediente.HAMBURGUER);
    lanche.adicionaIngrediente(Ingrediente.HAMBURGUER);
    double valor = Ingrediente.BACON.getPreco() + Ingrediente.HAMBURGUER.getPreco()
        + Ingrediente.QUEIJO.getPreco() + Ingrediente.HAMBURGUER.getPreco();
    double valorDoLancheComPromocao = lanche.aplicarPromocoes(lanche.getPreco());
    assertEquals(valorDoLancheComPromocao, valor);
  }

  @Test
  public void xburguer_testandoPreco() {
    Lanche lanche = new Lanche("X-Burguer", Lanches.X_BURGUER.getIngredientes());
    double valor = Ingrediente.HAMBURGUER.getPreco() + Ingrediente.QUEIJO.getPreco();
    assertEquals(lanche.getPreco(), valor);
  }

  @Test
  public void xburguer_testandoLight() {
    Lanche lanche = new Lanche("X-Burguer", Lanches.X_BURGUER.getIngredientes());
    lanche.adicionaIngrediente(Ingrediente.ALFACE);
    double valor = (Ingrediente.ALFACE.getPreco() + Ingrediente.HAMBURGUER.getPreco()
        + Ingrediente.QUEIJO.getPreco()) * 0.90;
    double valorDoLancheComPromocao = lanche.aplicarPromocoes(lanche.getPreco());
    assertEquals(valorDoLancheComPromocao, valor);
  }

}
