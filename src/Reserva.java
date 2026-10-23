import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {
    
    //  Atributos
    private String numeroReserva; 
    private LocalDate fechaEntrada;
    private int cantNoches;
    private String estado;
    private Huesped huesped;    
    private Habitacion habitacion;  
    private ArrayList<ServicioAdicional> servicios;    
    private Factura factura;    

    //  Constructor
    public Reserva(String numeroReserva, LocalDate fechaEntrada, 
                    int cantNoches, Habitacion habitacion, Huesped huesped) {
        this.numeroReserva = numeroReserva;
        this.fechaEntrada = fechaEntrada;
        this.cantNoches = cantNoches;
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.estado = "PENDIENTE";
        this.servicios = new ArrayList<>();
        this.factura = null;    //  se crea luego
    }

    //  Getters
    public String getNumeroReserva() { return numeroReserva; }
    public LocalDate getFechaEntrada() { return fechaEntrada; }
    public int getCantNoches() { return cantNoches; }
    public String getEstado() { return estado; }
    public Huesped getHuesped() { return huesped; }
    public Habitacion getHabitacion() { return habitacion; }
    public ArrayList<ServicioAdicional> getServicios() { return servicios; }
    public Factura getFactura() { return factura; }

    //  Setter (solo el estado cambia durante la vida de la reserva)
    public void setEstado(String estado) {
        this.estado = estado;
    }
    //  Método para agregar un servicio adicional a la reserva
    public void agregarServicio(ServicioAdicional servicio) {
        if (estado.equals("CANCELADA")) {
            System.out.println("No se puede agregar " + servicio.getNombre() + ": la reserva " + numeroReserva + " está cancelada.");
        } else {
            servicios.add(servicio);
            System.out.println("Se agregó " + servicio.getNombre() + " a la reserva " + numeroReserva);
        }
    }

    //  Confirma la reserva si la habitación está disponible
    public void confirmarReserva() {
        if (habitacion.getDisponible()) {
            estado = "CONFIRMADA";
            habitacion.setDisponible(false);
            System.out.println("La reserva " + numeroReserva + " ha sido confirmada.");
        } else {
            System.out.println("No se puede confirmar la reserva " + numeroReserva + ": la habitación " + habitacion.getNumero() + " no está disponible.");
        }
    }

    //  Cancela la reserva 
    public void cancelarReserva() {
        if (estado.equals("CANCELADA")) {
            System.out.println("La reserva " + numeroReserva + " ya ha sido cancelada.");
        } else {
            estado = "CANCELADA";
            habitacion.setDisponible(true);
            System.out.println("La reserva " + numeroReserva + " ha sido cancelada exitosamente.");
        }
    }

    //  Subtotal
    public double calcularSubtotal() {
        double subtotal = habitacion.calcularPrecioNoche() * cantNoches;
        for (ServicioAdicional servicio : servicios) {
            subtotal += servicio.getCosto();
        }
        return subtotal;
    }

    //  Genera la factura de la reserva
    public void generarFactura() {
        if (estado.equals("CONFIRMADA")) {
            factura = new Factura("F-" + numeroReserva, calcularSubtotal());
            System.out.println("Se generó la factura: " + factura.getNumeroFactura() + ".");
        } else {
            System.out.println("No se puede facturar la reserva " + numeroReserva + ": su estado es " + estado + ".");
        }
    }

    //  toString
    public String toString() {
        return "Reserva: " + numeroReserva + 
        "\nEstado: " + estado + 
        "\nFecha de entrada: " + fechaEntrada + 
        "\nNoches: " + cantNoches + 
        "\nHuésped: " + huesped.getNombre() + " " + huesped.getApellidos() + 
        "\nHabitación: " + habitacion.getNumero() + 
        "\nServicios contratados: " + servicios.size();
    }
}
