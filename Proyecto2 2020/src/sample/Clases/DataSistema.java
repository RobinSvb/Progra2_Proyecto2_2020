package sample.Clases;

import java.util.ArrayList;


public class DataSistema {
    private ArrayList<Cliente> LGC = new ArrayList<Cliente>();
    private ArrayList<Producto> LGP = new ArrayList<Producto>();
    private ArrayList<Orden> LGO = new ArrayList<Orden>();
    public void addDataSistema(Empresa empresa){
        LGC.add(empresa);
    }
    public void addDataSistema(Individual individual){
        LGC.add(individual);
    }
    public void addDataProducto(Producto producto){
        LGP.add(producto);
    }
    public void addDataOrden(Orden orden){
        LGO.add(orden);
    }
    public void addDataItem(ItemOrden item,int idOrden){
        this.LGO.get(idOrden).addProducto(item);
    }
    public int obtenerIDNuevo(){
            return this.LGC.size()+1;
    }
    public Cliente obtenerCliente(int x){
        return this.LGC.get(x-1);
    }
    public Producto obtenerProdcto(int x){
        return this.LGP.get(x-1);
    }
    public int obtenerIDNuevoOrden(){
        return this.LGO.size()+1;
    }
    public DataSistema(){
        //Ingreso Productos Default
        LGP.add(new Producto(this.LGP.size()+1+2000,"Silvin", "Kiyamoto", 155.0,"ACTIVO"));
        LGP.add(new Producto(this.LGP.size()+1+2000,"Retrovisor", "Masesa", 100.0,"ACTIVO"));
        LGP.add(new Producto(this.LGP.size()+1+2000,"Ventana", "Flippy", 500.0,"ACTIVO"));
        LGP.add(new Producto(this.LGP.size()+1+2000,"Tapa Radiador", "Toyota", 10.5,"ACTIVO"));
        LGP.add(new Producto(this.LGP.size()+1+2000,"Rines de Magnesio", "YOKOHIMA", 300.25,"ACTIVO"));
        LGP.add(new Producto(this.LGP.size()+1+2000,"LLantas", "Micheline", 400.1,"ACTIVO"));
        LGP.add(new Producto(this.LGP.size()+1+2000,"Cubre-Volante", "Chinito Feliz", 55.0,"ACTIVO"));
        LGP.add(new Producto(this.LGP.size()+1+2000,"Terminales de Bateria", "Truper", 5.0,"ACTIVO"));
        //CLIENTES (4 CADA TIPO)
        LGC.add(new Empresa(this.LGC.size()+1,"103637516","Robin Inc","Pedro Cuevas","ACTIVO",0.05));
        LGC.add(new Empresa(this.LGC.size()+1,"158963255","Lenovo S.A.","Jaime Jimenez","ACTIVO",0.09));
        LGC.add(new Empresa(this.LGC.size()+1,"895622154","Industrias Patrona","Gustavo Barcenas","ACTIVO",0.1));
        LGC.add(new Empresa(this.LGC.size()+1,"123584102","Ferreteria La Bendicion","Juan Lechuga","ACTIVO",0.02));
        LGC.add(new Individual(this.LGC.size()+1, "694561-0", "Pablo Muñoz","ACTIVO", "2589758960101"));
        LGC.add(new Individual(this.LGC.size()+1, "87451126", "Maria Beltram","ACTIVO", "6852313213651"));
        LGC.add(new Individual(this.LGC.size()+1, "8955421-0", "Jose Jimenez","ACTIVO", "2589758960101"));
        LGC.add(new Individual(this.LGC.size()+1, "89365555", "Marcos Solis","ACTIVO", "464515313513"));
    }
    public String toString(int y){
        String x="";
        x="|Cliente| "+LGC.get(y).toString();
        return x;
    }
    public void setCliente( String nombre,String nit,int id) {
        this.LGC.get(id).setNit(nit);
        this.LGC.get(id).setNombre(nombre);
    }
    public String getStateClientes(int y) {
        return LGC.get(y).getEstado();
    }
    public void setNewState( String estado,int id) {
        this.LGC.get(id).setEstado(estado);
    }
    public void setProducto( String nombre,String marca,Double precio,int id) {
        this.LGP.get(id).setNombre(nombre);
        this.LGP.get(id).setMarca(marca);
        this.LGP.get(id).setPrecio(precio);
    }
    public String getStateProducto(int y) {
        return LGP.get(y).getEstado();
    }
    public void setNewStateProducto( String estado,int id) {
        this.LGP.get(id).setEstado(estado);
    }
    public String toStringProducto(int y){
        String x="";
        x="[Producto] "+LGP.get(y).toString();
        return x;
    }
    public int obtenerIDProducto(){
        return this.LGP.size()+1;
    }
    public String toStringOrden(int y){
        String x="";
        x=LGO.get(y).toString();
        return x;
    }
}
