package sample;
import sample.Clases.*;

import java.util.Scanner;

import static java.lang.System.out;

public class MainTerminal {
    public static void main(String[] args){
         DataSistema Data = new DataSistema();//DataSistem Inicializada para almacenamiento

        Scanner lecturaCadena = new Scanner(System.in);
        Data.addDataSistema(new Empresa(Data.obtenerIDNuevo(),"103637516","Robin Inc","Pedro Cuevas","ACTIVO",0.05));
        Data.addDataSistema(new Individual(Data.obtenerIDNuevo(), "1039633-0", "Juan Medina", "ACTIVO","2589758960101"));
        Data.addDataSistema(new Empresa(Data.obtenerIDNuevo(),"3548664656","MUndial Corporation","Juan diaeguez","ACTIVO",0.07));
        Data.addDataSistema(new Individual(Data.obtenerIDNuevo(), "694561-0", "Pablo Muñoz","ACTIVO", "2589758960101"));
        for(int i=0;i<Data.obtenerIDNuevo()-1;i++){
            out.println(Data.toString(i));
        }
        Data.addDataProducto(new Producto(Data.obtenerIDProducto()+2000,"Silvin", "Kiyamoto", 155.0,"ACTIVO"));
        Data.addDataProducto(new Producto(Data.obtenerIDProducto()+2000,"Silvin", "Kiyamoto", 155.0,"ACTIVO"));
        Data.addDataProducto(new Producto(Data.obtenerIDProducto()+2000,"Silvin", "Kiyamoto", 155.0,"ACTIVO"));
        for(int i=0;i<Data.obtenerIDProducto()-1;i++){
            out.println(Data.toStringProducto(i));
        }
    }
}
