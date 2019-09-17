package com.roner.fastfood;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Ingrediente {
  @JsonProperty("Alface")
  ALFACE("Alface",0.40),
  @JsonProperty("Bacon")
  BACON("Bacon",2.00),
  @JsonProperty("Hamburguer")
  HAMBURGUER("Hamburguer de carne", 3.00),
  @JsonProperty("Ovo")
  OVO("Ovo", 0.80),
  @JsonProperty("Queijo")
  QUEIJO("Queijo", 1.50);

  private String descricao;
  private double preco;

  Ingrediente(String descricao, double preco) {
    this.descricao = descricao;
    this.preco = preco;
  }

  public String getDescricao() {
    return descricao;
  }

  public double getPreco() {
    return preco;
  }
}
