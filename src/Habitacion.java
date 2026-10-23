//  Herencia
public class Habitacion {

    //  Atributos
    //  Encapsulamient: protected, visibles solo para esta clase y sus subclases
    protected int numero;
    protected int capacidad;
    protected double tarifaBase;
    protected boolean disponible;

    //  Constructor
    public Habitacion(int numero, int capacidad, double tarifaBase) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.tarifaBase = tarifaBase;
        this.disponible = true;
    }

    //  Getters
    public int getNumero() {
        return numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public boolean getDisponible() {
        return disponible;
    }

    //  Setters
    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //  Metodos
    public double calcularPrecioNoche() {
        return tarifaBase;
    }

    public String toString() {
        String estadoDisponible;
        if (disponible) {
            estadoDisponible = "Sí";
        } else {
            estadoDisponible = "No";
        }
        return "Habitación: " + numero +
                "\nCapacidad: " + capacidad + " personas" +
                "\nTarifa base: $" + tarifaBase +
                "\nDisponible: " + estadoDisponible;
    }
}