public class HabitacionSuite extends Habitacion {

    // Atributos
    private boolean tieneJacuzzi;
    private double metrosCuadrados;
    private final double PRECIO_JACUZZI = 20;

    // Constructor
    public HabitacionSuite(int numero, int capacidad, double tarifaBase, boolean tieneJacuzzi, double metrosCuadrados) {
        super(numero, capacidad, tarifaBase);
        this.tieneJacuzzi = tieneJacuzzi;
        this.metrosCuadrados = metrosCuadrados;
    }

    //  Getters
    public boolean getTieneJacuzzi() {
        return tieneJacuzzi;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    //  Setters
    public void setTieneJacuzzi(boolean tieneJacuzzi) {
        this.tieneJacuzzi = tieneJacuzzi;
    }

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    //  Métodos
    //  Sobreescritura: suma un cargo si incluye Jacuzzi
    //  POLIMORFISMO: redefine el método heredado y reutiliza la versión de Habitacion con super
    public double calcularPrecioNoche() {
        double precio = super.calcularPrecioNoche();
        if (tieneJacuzzi) {
            precio += PRECIO_JACUZZI;
        }
        return precio;
    }
    //  toString()
    public String toString() {
        String jacuzzi;
        if (tieneJacuzzi) {
            jacuzzi = "Si";
        } else {
            jacuzzi = "No";
        }
        return super.toString() +
                "\nTipo: Suite" +
                "\nTiene jacuzzi: " + jacuzzi +
                "\nMetros cuadrados: " + metrosCuadrados;
    }
    
}
