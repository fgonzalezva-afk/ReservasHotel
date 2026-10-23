public class ServicioAdicional {
    
    //  Atributos
    private String nombre;
    private double costo;

    //  Constructor
    public ServicioAdicional(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    //  Getters
    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    //  toString()
    public String toString() {
        return "Servicio adicional: " + nombre +
        "\nCosto: " + costo;
    }

}
