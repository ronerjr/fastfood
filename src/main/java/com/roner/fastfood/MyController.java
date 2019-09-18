package com.roner.fastfood;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  private final MyService myService;

  public MyController(MyService myService) {
    this.myService = myService;
  }

  @GetMapping("/lanches")
  public ResponseEntity listarLanches() {
    return ResponseEntity.ok(Lanches.values());
  }

  @GetMapping("/lanche/{nome}")
  public ResponseEntity buscarLanche(@PathVariable String nome) {
    try {
      return ResponseEntity.ok(myService.getLanche(nome));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/ingredientes")
  public ResponseEntity listarIngredientes() {
    return ResponseEntity.ok(Ingrediente.values());
  }

  @PostMapping("/pedido/{mesa}/item")
  public ResponseEntity adicionarItem(@RequestBody Lanche lanche, @PathVariable Long mesa) {
    try {
      myService.adicionaItem(mesa, lanche);
      return ResponseEntity.ok(lanche);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/pedido/{mesa}")
  public ResponseEntity fazerPedido(@PathVariable Long mesa) {
    return ResponseEntity.ok(myService.getPedido(mesa));
  }

  @GetMapping("/pedido/{mesa}/baixa")
  public ResponseEntity baixarPedido(@PathVariable Long mesa) {
    myService.encerraPedido(mesa);
    return ResponseEntity.ok().build();
  }
}
