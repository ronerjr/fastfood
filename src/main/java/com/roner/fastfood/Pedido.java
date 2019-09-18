package com.roner.fastfood;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pedido {
  private List<Lanche> lanches;
  private double valorTotal;

  public Pedido() {
    valorTotal = 0.0;
  }

  public List<Lanche> getLanches() {
    return lanches;
  }

  public void adicionaLanche(Lanche lanche) {
    if (lanches == null) {
      lanches = new ArrayList<>();
    }
    lanches.add(lanche);
    atualizaValorTotal();
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void atualizaValorTotal() {
    for(Lanche lanche : lanches) {
      valorTotal += lanche.aplicarPromocoes();
    }
  }

  public void limpaPedido() {
    lanches.clear();
    valorTotal = 0.0;
  }
}
