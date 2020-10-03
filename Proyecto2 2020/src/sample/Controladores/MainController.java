package sample.Controladores;
import javafx.event.ActionEvent;

import javafx.scene.control.*;


import sample.Clases.ItemOrden;
import sample.Clases.Orden;
import sample.Main;

import javax.swing.*;
import java.io.IOException;
import java.util.Date;

public class MainController{
    public MenuItem cmdRegistrarCliente;
    public MenuItem cmdModificarrCliente;
    public MenuItem cmdEliminarCliente;
    public Main menu = new Main();
    public void RegistrarCliente(ActionEvent actionEvent){
        String tipo =JOptionPane.showInputDialog ( "Introduzca un Tipo de cliente:\n 1-Individual \n 2-Empresa");
        String nit =JOptionPane.showInputDialog ( "Introduzca el NIT del CLiente");
        String nombre =JOptionPane.showInputDialog ( "Introduzca el Nombre del CLiente");
        if(tipo.equals("1")){
            String dpi =JOptionPane.showInputDialog ( "Introduzca el DPI del CLiente");
            menu.RegistrarClientes(nit,nombre,dpi);
            JOptionPane.showMessageDialog(null, "INGRESO EXITOSO");
        }else if(tipo.equals("2")){
            String representante =JOptionPane.showInputDialog ( "Introduzca el Nombre  del representate de la empresa");
            Double descuento = Double.parseDouble(JOptionPane.showInputDialog ( "Ingrese el porcentaje de descuento Ej 0.1 para que sea 10%"));
            menu.RegistrarClientes(nit,nombre,representante,descuento);
            JOptionPane.showMessageDialog(null, "INGRESO EXITOSO");
        }else{
            JOptionPane.showMessageDialog(null, "DATOS NO VALIDOS");
        }
    }
    public void ModificarCliente(ActionEvent actionEvent){
        int id =Integer.parseInt(JOptionPane.showInputDialog ( "Introduzca el ID del CLiente a modificar"));
        menu.ModificarClientes(id);

    }
    public void EliminarCliente(ActionEvent actionEvent){
        int id =Integer.parseInt(JOptionPane.showInputDialog ( "Introduzca el ID del CLiente que desea modificar"));
        menu.ChageStateClientes(id);
    }
    public void RegistrarProducto(ActionEvent actionEvent) {
        String nombre = JOptionPane.showInputDialog("Introduzca el nombre del producto");
        String marca = JOptionPane.showInputDialog("Introduzca la marca del producto");
        Double precio=Double.parseDouble(JOptionPane.showInputDialog("Introduzca la precio del producto"));
        menu.RegistrarProductos(nombre,marca,precio);
        JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
    }
    public void ModificarProducto(ActionEvent actionEvent){
        int id =Integer.parseInt(JOptionPane.showInputDialog ( "Introduzca el ID del producto a modificar"));
        menu.ModificarProductos(id-2000);
    }
    public void EliminarProducto(ActionEvent actionEvent){
        int id =Integer.parseInt(JOptionPane.showInputDialog ( "Introduzca el ID del PRODUCTO que desea modificarle el estado"));
        menu.ChageStateProducto(id-2000);
    }
    public void RegistrarOrden(ActionEvent actionEvent){
    boolean control=false;


        int idCliente =Integer.parseInt(JOptionPane.showInputDialog ( "Introduzca el ID del Cliente"));
        Date fecha;
        if (menu.buscarIDCliente(idCliente)==true){
            fecha=menu.obtenerFecha();
            Orden orden=new Orden(menu.idOrden(),menu.cliente(idCliente),fecha);
            while (control==false) {
                int D = Integer.parseInt(JOptionPane.showInputDialog("Desea Agregar Productos al carrito \n 1-SI \n 2-no"));
                if (D == 1) {
                    int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto"));
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea"));
                    orden.addProducto(new ItemOrden(orden.obtenerIDNuevoItem(), menu.producto(idProducto), cantidad));
                }
                if (D == 2) {
                    menu.RegistrarOrden(orden);
                    control=true;
                    JOptionPane.showMessageDialog(null, "El total es de=Q."+orden.gettotal());
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "CLIENTE NO EXISTE");
        }
    }
    public void ReporteClientes(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "CLIENTES REGISTRADOS\n"+menu.ReportClientes());
    }
    public void ReporteProductos(ActionEvent actionEvent) {
            JOptionPane.showMessageDialog(null, "PRODUCTOS REGISTRADOS\n"+menu.ReportProductos());
    }
    public void ReporteOrdenes(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "ORDENES REGISTRADAS\n"+menu.ReportOrdenes());
    }
    }
