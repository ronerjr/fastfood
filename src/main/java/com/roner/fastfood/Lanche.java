package com.roner.fastfood;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lanche {
  private String nome;
  private List<Ingrediente> ingredientes;
  private Set<String> promocoesAplicadas;

  public Lanche(String nome, List<Ingrediente> ingredientes) {
    this.nome = nome;
    this.ingredientes = new ArrayList<>();
    this.ingredientes.addAll(ingredientes);
    promocoesAplicadas = new HashSet<>();
  }

  public double getPreco() {
    return
        ingredientes.stream().map(ingrediente -> ingrediente.getPreco()).reduce(0.0, Double::sum);
  }

  public double aplicarPromocoes() {
    double valor = getPreco();
    for (Promocoes promocao : Promocoes.values()) {
      if (promocao.isAtiva()) {
        double valorSemPromocao = new Double(valor);
        valor = promocao.aplicarRegra(ingredientes, valor);
        if (valorSemPromocao != valor) {
          promocoesAplicadas.add(promocao.getNome());
        }
      }
    }
    return valor;
  }

  public String getNome() {
    return nome;
  }

  public boolean adicionaIngrediente(Ingrediente ingrediente) {
    if (ingredientes == null) {
      ingredientes = new ArrayList<>();
    }
    return ingredientes.add(ingrediente);
  }

  public void removeIngrediente(Ingrediente ingrediente) {
    if (ingredientes != null && !ingredientes.isEmpty()) {
      ingredientes.remove(ingrediente);
    }
  }

  public List<Ingrediente> getIngredientes() {
    return ingredientes;
  }

  public Set<String> getPromocoesAplicadas() {
    return promocoesAplicadas;
  }
}
