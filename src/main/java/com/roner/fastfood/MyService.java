package com.roner.fastfood;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyService {
  private Map<Long, Pedido> pedidos;

  public MyService() {
    pedidos = new HashMap<>();
  }

  public Pedido adicionaItem(Long mesa, Lanche lanche) {
    if(!pedidos.containsKey(mesa)) {
      pedidos.put(mesa, new Pedido());
    }
    Pedido pedido = pedidos.get(mesa);
    pedido.adicionaLanche(lanche);
    pedidos.put(mesa, pedido);
    return pedidos.get(mesa);
  }

  public void encerraPedido(Long mesa) {
    pedidos.put(mesa, new Pedido());
  }

  public Pedido getPedido(Long mesa) {
    return pedidos.get(mesa);
  }

  public List<Ingrediente> getLanche(String nome) {
    nome = nome.replace("-", "_").toUpperCase();
    return Lanches.valueOf(nome).getIngredientes();
  }
}
