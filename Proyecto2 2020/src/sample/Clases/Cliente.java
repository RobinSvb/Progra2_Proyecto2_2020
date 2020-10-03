package sample.Clases;

public class Cliente {
    private int idCliente;
    private String nit;
    private String nombre;
    private String estado;
    public Cliente(int id,String nit, String nombre, String estado){
        this.nit=nit;
        this.nombre=nombre;
        this.idCliente=id;
        this.estado=estado;

    }
    public String getNit() {
        return nit;
    }
    public String getNombre() {
        return nombre;
    }
    public int getId() {
        return idCliente;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) { this.estado=estado; }
    public void setNit(String nit) {
        this.nit=nit;
    }
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }
    public Double getDescuento() {
        return 0.0;
    }


}
