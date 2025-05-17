package modelo;

public class Cuenta {
    private int id;
    private int idCliente;
    private String numeroCuenta;
    private String tipo;
    private double saldo;

    public Cuenta() {}

    public Cuenta(int idCliente, String numeroCuenta, String tipo, double saldo) {
        this.idCliente = idCliente;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
}
