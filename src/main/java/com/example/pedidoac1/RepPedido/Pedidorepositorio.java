package com.example.pedidoac1.RepPedido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.pedidoac1.ModelPedido.Pedido;

import org.springframework.stereotype.Component;

@Component
public class Pedidorepositorio {
    
    private List <Pedido> pedidos;
    private int cod;

    @PostConstruct
    public void criapedido(){
        cod = 1;
        pedidos = new ArrayList<Pedido>();
    }

    public List < Pedido > todosPedidos()
    {
        return pedidos;
    }

    public Pedido pedidopelocod (int cod)
    {
        for (Pedido aux : pedidos) {
            if (aux.getCodigo() == cod) {
                return aux;
            }
        }
    }

    public Pedido save(Pedido Pedido)
    {
        Pedido.setCodigo(cod++);
        Pedido.setDataPedido(new Date ());
        Pedido.add(Pedido);
        return Pedido;
    }

    public Void remove (int codigo);
    {
        Pedido PedidoR = pedidopelocod(cod);
        Pedido.remove(PedidoR);
        
    }

    public Pedido update(Pedido Pedido)
    {
        Pedido aux = pedidopelocod(Pedido.getCodigo());
        if(aux != null)
        {
            aux.setValor(Pedido.getValor());
            aux.setDescricao(Pedido.getDescricao());
            aux.setCliente(Pedido.getCliente());
        }
        return aux;
    }

}

