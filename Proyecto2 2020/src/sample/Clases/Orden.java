package sample.Clases;

import java.util.ArrayList;
import java.util.Date;

import static java.lang.System.out;

public class Orden {
    private int id;
    private Cliente cliente;
    private Double total;
    private Date fechahora;
    private ArrayList<ItemOrden> Productos = new ArrayList<ItemOrden>();
    public Orden(){
    }
    public Orden(int id,Cliente cliente, Date fechahora){
        this.cliente=cliente;
        this.id=id;
        this.fechahora=fechahora;
    }
    public void addProducto(ItemOrden producto){
        Productos.add(producto);
    }
    public Double gettotal() {
        this.total=0.0;
        for(int i=0;i<Productos.size();i++){
            this.total=this.total+Productos.get(i).getSubtotal();
        }
        return this.total*(1-cliente.getDescuento());
    }
    public int obtenerIDNuevoItem(){
        return this.Productos.size()+1;
    }
    public String toString(){//EDITAR ESTO
        String x="";
        x="|ORDEN #"+id+"|\n";
        x=x+"|Cliente "+cliente.toString()+"|\n";
        for(int i=0;i<Productos.size();i++){
            x=x+"   "+Productos.get(i).toString()+"\n";

        }
        x=x+"TOTAL DE LA ORDEN Q."+gettotal();
        return x;
    }
}
