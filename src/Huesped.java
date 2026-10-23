public class Huesped {

    //  Atributos
    private String nombre;
    private String apellidos;
    private String cedula;
    private String telefono;

    // Constructor sin teléfono
    public Huesped(String nombre, String apellidos, String cedula) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
    }

    // Constructor completo
    public Huesped(String nombre, String apellidos, String cedula, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    //  Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    //  Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //  Pagar factura
    public void pagarFactura(Factura factura) {
        if (factura == null) {
            System.out.println("No hay factura para pagar.");
        } else {
            System.out.println("El huésped " + nombre + " " + apellidos + " ha pagado la factura " + 
            factura.getNumeroFactura() + " por un total de $" + factura.getTotal() + ".");
        }

    }
    

    //  toString()
    public String toString() {
        return "Huesped: " + nombre + " " + apellidos +
        "\nCédula: " + cedula +
        "\nTeléfono: " + telefono;
    }


}
