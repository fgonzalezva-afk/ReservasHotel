public class HabitacionEstandar extends Habitacion {

    // Atributos
    private boolean incluyeDesayuno;
    private final double PRECIO_DESAYUNO = 10;

    // Constructor
    public HabitacionEstandar(int numero, int capacidad, double tarifaBase, boolean incluyeDesayuno) {
        super(numero, capacidad, tarifaBase);
        this.incluyeDesayuno = incluyeDesayuno;
    }

    //  Getter y Setter
    public boolean getIncluyeDesayuno() {
        return incluyeDesayuno;
    }

    public void setIncluyeDesayuno(boolean incluyeDesayuno) {
        this.incluyeDesayuno = incluyeDesayuno;
    }

    //  Metodos
    public double calcularPrecioNoche() {
        double precio = super.calcularPrecioNoche();
        if (incluyeDesayuno) {
            precio += PRECIO_DESAYUNO;
        }
        return precio;
    }
    //  toString()
    public String toString() {
        String desayuno;
        if (incluyeDesayuno) {
            desayuno = "Si";
        } else {
            desayuno = "No";
        }
        return super.toString() +
        "\nTipo: Estándar" +
        "\nIncluye desayuno: " + desayuno; 
    }

}
