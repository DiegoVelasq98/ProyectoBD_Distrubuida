package modelo;

public class Cliente {
    private int id;
    private String nombre;
    private String dpi;
    private String direccion;
    private String telefono;

    public Cliente() {}

    public Cliente(String nombre, String dpi, String direccion, String telefono) {
        this.nombre = nombre;
        this.dpi = dpi;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Cliente(int id, String nombre, String dpi, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.dpi = dpi;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDpi() { return dpi; }
    public void setDpi(String dpi) { this.dpi = dpi; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
