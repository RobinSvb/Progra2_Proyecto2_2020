package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Clases.*;

import javax.swing.*;
import java.io.IOException;
import java.util.Date;

public class Main extends Application {
    public Stage primaryStage = new Stage();
    DataSistema Data = new DataSistema();//DataSistem Inicializada para almacenamiento
    @Override
    public void start(Stage primaryStage1) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Sistema de Ventas 7690-19-11292");
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

    }

    public void start() throws IOException {

        primaryStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
        primaryStage.setTitle("Sistema de Ventas 7690-19-11292");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    public void RegistrarClientes(String nit, String nombre, String dpi){
        Data.addDataSistema(new Individual(Data.obtenerIDNuevo(),nit,nombre,"ACTIVO",dpi));
    }
    public void RegistrarClientes(String nit, String nombre, String representante, Double descuento){
        Data.addDataSistema(new Empresa(Data.obtenerIDNuevo(),nit,nombre,representante,"ACTIVO",descuento));
    }
    public void ModificarClientes(int x){
        JOptionPane.showMessageDialog(null, "Usted Selecciono Modificar "+Data.toString(x-1));
        String nit =JOptionPane.showInputDialog ( "Introduzca el NIT del CLiente ACTUALIZADO");
        String nombre =JOptionPane.showInputDialog ( "Introduzca el Nombre del CLiente ACTUALIZADO");
        Data.setCliente(nombre,nit,x-1);
    }
    public void ChageStateClientes(int x){
        String newState="";
        JOptionPane.showMessageDialog(null, "Usted Selecciono Cambiat el estado "+Data.toString(x-1));
        if(Data.getStateClientes(x-1).equals("ACTIVO")){
            newState="INACTIVO";
        }else if(Data.getStateClientes(x-1).equals("INACTIVO")){
            newState="ACTIVO";
        }
        JOptionPane.showMessageDialog(null, "EL ESTADO CAMBIARA DE "+Data.getStateClientes(x-1)+">>A>>"+newState);

        Data.setNewState(newState,x-1);
        JOptionPane.showMessageDialog(null, "ACTUALIZADO \n"+Data.toString(x-1));

    }
    //PRODUCTOS
    public void RegistrarProductos(String nombre, String marca, Double precio){
        Data.addDataProducto(new Producto(Data.obtenerIDProducto()+2000,nombre,marca,precio,"ACTIVO"));
    }
    public void ModificarProductos(int x){
        JOptionPane.showMessageDialog(null, "Usted Selecciono Modificar "+Data.toStringProducto(x-1));
        String nombre = JOptionPane.showInputDialog("Introduzca el nombre del producto ACTUALIZADO");
        String marca = JOptionPane.showInputDialog("Introduzca la marca del producto ACTUALIZADO");
        Double precio=Double.parseDouble(JOptionPane.showInputDialog("Introduzca la precio del producto ACTUALIZADO"));

        Data.setProducto(nombre,marca,precio,x-1);
    }
    public void ChageStateProducto(int x){
        String newState="";
        JOptionPane.showMessageDialog(null, "Usted Selecciono Cambiat el estado "+Data.toStringProducto(x-1));
        if(Data.getStateProducto(x-1).equals("ACTIVO")){
            newState="INACTIVO";
        }else if(Data.getStateProducto(x-1).equals("INACTIVO")){
            newState="ACTIVO";
        }
        JOptionPane.showMessageDialog(null, "EL ESTADO CAMBIARA DE "+Data.getStateProducto(x-1)+">>A>>"+newState);

        Data.setNewStateProducto(newState,x-1);
        JOptionPane.showMessageDialog(null, "ACTUALIZADO \n"+Data.toStringProducto(x-1));

    }
    public static Date obtenerFecha(){
        java.util.Date utilDate = new java.util.Date(); //fecha actual
        long lnMilisegundos = utilDate.getTime();//Tiempo Actual
        java.sql.Timestamp fecha = new java.sql.Timestamp(lnMilisegundos);
        return fecha;
    }
    public boolean buscarIDCliente(int id){
        boolean x=false;
        if ((id)<Data.obtenerIDNuevo()){
            x=true;
        }
        return x;
    }
    public boolean buscarIDProducto(int id){
        boolean x=false;
        if ((id)<Data.obtenerIDProducto()){
            x=true;
        }
        return x;
    }
    public void RegistrarOrden(Orden orden){
        Data.addDataOrden(orden);
    }

    public int idOrden(){
        return Data.obtenerIDNuevoOrden();
    }
    public Cliente cliente(int x){
        return Data.obtenerCliente(x);
    }
    public Producto producto(int x){
        return Data.obtenerProdcto(x-2000);
    }
    public String ReportClientes(){
        String Clientes="";
        for(int i=0; i<Data.obtenerIDNuevo()-1;i++){
            Clientes=Clientes+Data.toString(i)+"\n";
        }
        return Clientes;
    }
    public String ReportProductos(){
        String Productos="";
        for(int i=0; i<Data.obtenerIDProducto()-1;i++){
            Productos=Productos+Data.toStringProducto(i)+"\n";
        }
        return Productos;
    }
    public String ReportOrdenes(){
        String Ordenes="";

        for(int i=0; i<Data.obtenerIDNuevoOrden()-1;i++){
            Ordenes=Ordenes+Data.toStringOrden(i)+"\n";
        }
        return Ordenes;
    }
}
