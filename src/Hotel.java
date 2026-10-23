import java.util.ArrayList;

public class Hotel {

    //  Atributos
    private String nombre;
    private String direccion;
    private ArrayList<Habitacion> habitaciones;    //  COMPOSICIÓN: las habitaciones no existen sin el hotel
    private ArrayList<Huesped> huespedes;    //  AGREGACIÓN: los huéspedes existen por su cuenta
    private ArrayList<Reserva> reservas;    //  AGREGACIÓN: las reservas se crean afuera y el hotel las guarda

    //  Constructor
    public Hotel(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.habitaciones = new ArrayList<>();
        this.huespedes = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    //  Getters
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }

    //  Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //  Buscar habitacion por número
    public Habitacion buscarHabitacion(int numero) {
        for (Habitacion habitacion : habitaciones ) {
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null;
    }

    //  Agregar habitación estandar
    public void agregarHabitacionEstandar(int numero, int capacidad, double tarifaBase, boolean incluyeDesayuno) {
        if (buscarHabitacion(numero) != null) {
            System.out.println("La habitación " + numero + " ya está registrada.");
        } else {
            habitaciones.add(new HabitacionEstandar(numero, capacidad, tarifaBase, incluyeDesayuno));
            System.out.println("Se agregó la habitación estándar " + numero + ".");
        }
    }

    //  Agregar habitación suite
    public void agregarHabitacionSuite(int numero, int capacidad, double tarifaBase, boolean tieneJacuzzi, double metrosCuadrados) {
        if (buscarHabitacion(numero) != null) {
            System.out.println("Ya existe una habitación con el número " + numero + ".");
        } else {
            habitaciones.add(new HabitacionSuite(numero, capacidad, tarifaBase, tieneJacuzzi, metrosCuadrados));
            System.out.println("Se agregó la suite " + numero + ".");
        }
    }

    //  Agregar habitación deluxe
    public void agregarHabitacionDeluxe(int numero, int capacidad, double tarifaBase, boolean vistaAlMar, boolean incluyeMiniBar) {
        if (buscarHabitacion(numero) != null) {
            System.out.println("Ya existe una habitación con el número " + numero + ".");
        } else {
            habitaciones.add(new HabitacionDeluxe(numero, capacidad, tarifaBase, vistaAlMar, incluyeMiniBar));
            System.out.println("Se agregó la habitación deluxe " + numero + ".");
        }
    }

    //  Buscar huesped por cédula
    public Huesped buscarHuesped(String cedula) {
        for (Huesped huesped : huespedes) {
            if (huesped.getCedula().equals(cedula)) {
                return huesped;
            }
        }
        return null;
    }

    //  Agregar huesped
    public void registrarHuesped(Huesped huesped) {
        if (buscarHuesped(huesped.getCedula()) != null) {
            System.out.println("El huésped " + huesped.getNombre() + " " + huesped.getApellidos() + " ya está registrado.");
        } else {
            huespedes.add(huesped);
            System.out.println("Se ha registrado al huésped " + huesped.getNombre() + " " + huesped.getApellidos() + ".");
        }
    }
    //  Agregar reserva
    public void agregarReserva(Reserva reserva) {
        if (reserva.getHabitacion() == null) {
            System.out.println("No se puede agregar la reserva " + reserva.getNumeroReserva() + ": la habitación no existe.");
        } else if (reserva.getHuesped() == null) {  //  ESTE ELSE IF ES OPCIONAL, YA VEREMOS
            System.out.println("No se puede agregar la reserva " + reserva.getNumeroReserva() + ": el huésped no existe.");
        } else {
            reservas.add(reserva);
            System.out.println("Se ha agregado la reserva " + reserva.getNumeroReserva() + ".");
        }
    }

    //  Muestra habitaciones disponibles
    public void mostrarHabitacionesDisponibles() {
        System.out.println("=== Habitaciones disponibles en " + nombre + " ===");
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getDisponible()) {
                System.out.println(habitacion);
                System.out.println("Precio por noche: $" + habitacion.calcularPrecioNoche());
                System.out.println("-----------------------------");
            }
        }
    }

    //  Contar habitaciones disponibles
    public int contarHabitacionesDisponibles() {
        int contador = 0;
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getDisponible()) {
                contador++;
            }
        }
        return contador;
    }

    //  toString
    public String toString() {
        return "Hotel: " + nombre + 
        "\nDirección: " + direccion + 
        "\nHabitaciones: " + habitaciones.size() + 
        "\nDisponibles: " + contarHabitacionesDisponibles() +
        "\nHuéspedes registrados: " + huespedes.size() +
        "\nReservas totales: " + reservas.size();
    }
    
}
