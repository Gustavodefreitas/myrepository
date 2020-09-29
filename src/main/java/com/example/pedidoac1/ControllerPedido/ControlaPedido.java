package com.example.pedidoac1.ControllerPedido;

import java.net.URI;
import java.util.List;

import com.example.pedidoac1.ModelPedido.Pedido;
import com.example.pedidoac1.RepPedido.Pedidorepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class ControlaPedido 
{

    @Autowired
    private Pedidorepositorio repositorio;

    @GetMapping()
    public List <Pedido> todosPedidos()
    {
        return repositorio.todosPedidos();
    }

    @GetMapping("/{codigo}")
    
    public ResponseEntity < Pedido > getCliente(@PathVariable int codigo){
        Pedido pedido = repositorio.pedidopelocod(codigo);
        if(pedido != null){
            return ResponseEntity.ok(pedido);
        }
        else{
            return ResponseEntity.notFound().build();
       }
    }

    @PostMapping()
    public ResponseEntity <Pedido> save(@RequestBody Pedido pedido){
        Pedido criarpedido = repositorio.save(pedido);
        URI uri = URI.create("http://localhost:8080/pedidos/" + criarpedido.getCodigo());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{codigo}")

    public ResponseEntity < Pedido > update(@RequestBody Pedido pedido , @PathVariable int codigo){
        
        if(repositorio.pedidopelocod(codigo)!= null){
            pedido.setCodigo(codigo);
            pedido = repositorio.update(pedido);
            return ResponseEntity.ok(pedido);
        
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping

    public ResponseEntity <Void> delete(@PathVariable int codigo){

        Pedido pedido=repositorio.pedidopelocod(codigo);
        if(pedido != null) {
            repositorio.remove(codigo);
            return ResponseEntity.noContent().build();
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
    
}
