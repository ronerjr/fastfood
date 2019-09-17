package com.roner.fastfood;

import java.util.List;

public interface Promocao {
  double aplicarRegra(List<Ingrediente> ingredientes, double valor);
}
