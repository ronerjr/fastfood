package com.roner.fastfood;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
  private List<Lanche> lanches;
  private double valorTotal;

  public Pedido() {
    valorTotal = 0.0;
  }

  public List<Lanche> getLanches() {
    return lanches;
  }

  public boolean adicionaLanche(Lanche lanche) {
    if (lanches == null) {
      lanches = new ArrayList<>();
    }
    return lanches.add(lanche);
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void atualizaValorTotal(Lanche lanche) {
    valorTotal += lanche.aplicarPromocoes(lanche.getPreco());
  }

  public void limpaPedido() {
    lanches.clear();
    valorTotal = 0.0;
  }
}
