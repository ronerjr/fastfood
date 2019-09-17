package com.roner.fastfood;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public enum Lanches {
  @JsonProperty("x-bacon")
  X_BACON(Ingrediente.BACON, Ingrediente.HAMBURGUER, Ingrediente.QUEIJO),
  @JsonProperty("x-burguer")
  X_BURGUER(Ingrediente.HAMBURGUER, Ingrediente.QUEIJO),
  @JsonProperty("x-egg")
  X_EGG(Ingrediente.OVO, Ingrediente.HAMBURGUER, Ingrediente.QUEIJO),
  @JsonProperty("x-egg-bacon")
  X_EGG_BACON(Ingrediente.OVO, Ingrediente.BACON, Ingrediente.HAMBURGUER, Ingrediente.QUEIJO);

  private List<Ingrediente> ingredientes;

  Lanches(Ingrediente... ingredientes) {
    this.ingredientes = new ArrayList<>();
    for(Ingrediente ingrediente : ingredientes) {
      this.ingredientes.add(ingrediente);
    }
  }

  public List<Ingrediente> getIngredientes() {
    return ingredientes;
  }
}
