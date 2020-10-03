package sample.Clases;

public class Individual extends Cliente{
    private String dpi;
    public Individual(int id,String nit, String nombre, String estado, String dpi) {
        super(id,nit,nombre,estado);
        this.dpi=dpi;
    }
    public String getDpi() {
        return dpi;
    }
    public void setDpi(String dpi) {
        this.dpi=dpi;
    }
    public String toString(){
        String x="";
        x="id="+super.getId()+" Nit="+super.getNit()+" Nombre="+super.getNombre()+" DPI="+dpi+" Estado="+super.getEstado();
        return x;
    }
    public String getNombreClase() {
        return "Individual";
    }
    public Double getDescuento() {
        return 0.0;
    }
}
