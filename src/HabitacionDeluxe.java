public class HabitacionDeluxe extends Habitacion {

    // Atributos
    // Encapsulamiento: atributos propios privados
    private boolean vistaAlMar;
    private boolean incluyeMiniBar;
    private final static double PRECIO_VISTAMAR = 30;
    private final static double PRECIO_MINIBAR = 25;

    //  Constructor
    public HabitacionDeluxe(int numero, int capacidad, double tarifaBase, boolean vistaAlMar,
            boolean incluyeMiniBar) {
        super(numero, capacidad, tarifaBase);
        this.vistaAlMar = vistaAlMar;
        this.incluyeMiniBar = incluyeMiniBar;
    }

    //  Getters
    public boolean getVistaAlMar() {
        return vistaAlMar;
    }

    public boolean getIncluyeMiniBar() {
        return incluyeMiniBar;
    }

    //  Setters
    public void setVistaAlMar(boolean vistaAlMar) {
        this.vistaAlMar = vistaAlMar;
    }

    public void setIncluyeMiniBar(boolean incluyeMiniBar) {
        this.incluyeMiniBar = incluyeMiniBar;
    }

    //  Métodos
    //  Sobreescritura: suma un cargo si incluye vista al mar y mini bar
    //  Polimorfismo: reutiliza la versión de Habitacion con super
    public double calcularPrecioNoche() {
    double precio = super.calcularPrecioNoche();
    if (vistaAlMar) {
        precio += PRECIO_VISTAMAR;
    }
    if (incluyeMiniBar) {
        precio += PRECIO_MINIBAR;
    }
    return precio;
    }

    //  toString()
    public String toString() {
        String mar, minibar;
        if (vistaAlMar) {
            mar = "Si";
        } else {
            mar = "No";
        }
        if (incluyeMiniBar) {
            minibar = "Si";
        }  else {
            minibar = "No";
        }
        return super.toString() +
        "\nTipo: Deluxe" +
        "\nVista al mar: " + mar +
        "\nMinibar: " + minibar;
    }

}
