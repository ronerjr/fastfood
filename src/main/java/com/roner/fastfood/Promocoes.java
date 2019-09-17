package com.roner.fastfood;

import java.util.List;

public enum Promocoes implements Promocao {
  LIGHT(true, "Light") {
    @Override
    public double aplicarRegra(List<Ingrediente> ingredientes, double valor) {
      if (ingredientes.contains(Ingrediente.ALFACE) && !ingredientes.contains(Ingrediente.BACON)) {
        valor = valor * 0.90;
      }
      return valor;
    }
  },
  MUITA_CARNE(true, "Muita carne") {
    @Override
    public double aplicarRegra(List<Ingrediente> ingredientes, double valor) {
      long contadorDeCarne = ingredientes.stream()
          .filter(ingrediente -> ingrediente.equals(Ingrediente.HAMBURGUER))
          .count();
      if (contadorDeCarne % 3 == 0) {
        valor -= Ingrediente.HAMBURGUER.getPreco() * contadorDeCarne;
        contadorDeCarne = (contadorDeCarne / 3) * 2;
        valor += Ingrediente.HAMBURGUER.getPreco() * contadorDeCarne;
      }
      return valor;
    }
  },
  MUITO_QUEIJO(true, "Muito queijo") {
    @Override
    public double aplicarRegra(List<Ingrediente> ingredientes, double valor) {
      long contadorDeQueijo = ingredientes.stream()
          .filter(ingrediente -> ingrediente.equals(Ingrediente.QUEIJO))
          .count();
      if (contadorDeQueijo % 3 == 0) {
        valor -= Ingrediente.QUEIJO.getPreco() * contadorDeQueijo;
        contadorDeQueijo = (contadorDeQueijo / 3) * 2;
        valor += Ingrediente.QUEIJO.getPreco() * contadorDeQueijo;
      }
      return valor;
    }
  };

  private boolean ativa;
  private String nome;

  Promocoes(boolean ativa, String nome) {
    this.ativa = ativa;
    this.nome = nome;
  }

  public boolean isAtiva() {
    return ativa;
  }

  public String getNome() {
    return nome;
  }
}
