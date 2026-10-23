import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        //  Crear hotel y habitaciones
        Hotel hotel = new Hotel("Flamingo Resort", "123 Calle Principal, Guanacaste, Flamingo");
        // Habitaciones estándar
        System.out.println("===Agregar habitaciones al hotel===");
        hotel.agregarHabitacionEstandar(101, 2, 100.0, false);
        hotel.agregarHabitacionEstandar(102, 3, 125.0, true);
        // Habitacion suite
        hotel.agregarHabitacionSuite(201, 5, 200.0, false, 70.0);
        hotel.agregarHabitacionSuite(202, 4, 180.0, true, 60.0);    //  habitacion disponible
        // Habitaciones deluxe
        hotel.agregarHabitacionDeluxe(301, 6, 300.0, true, false);
        hotel.agregarHabitacionDeluxe(302, 8, 330.0, true, true);
        System.out.println();

        hotel.mostrarHabitacionesDisponibles(); // Mostrar habitaciones disponibles

        //  Registrar huespedes
        System.out.println("\n===Registrar huéspedes===");
        Huesped huesped1 = new Huesped("Juan", "Pérez Vargas", "8-0872-3402", "87651234");
        Huesped huesped2 = new Huesped("María", "González López", "8-1234-5678", "76456321");
        Huesped huesped3 = new Huesped("Carlos", "Rodríguez Martínez", "3-9646-5932", "69345678");
        Huesped huesped4 = new Huesped("Ana", "Ramírez Torres", "9-0011-8001", "87254321");
        Huesped huesped5 = new Huesped("Luis", "Fernández Morales", "3-2345-6089", "73456029");
        Huesped huesped6 = new Huesped("Sofía", "Hernández Castro", "2-3456-3890", "84567890");

        hotel.registrarHuesped(huesped1);
        hotel.registrarHuesped(huesped2);
        hotel.registrarHuesped(huesped3); 
        hotel.registrarHuesped(huesped4); 
        hotel.registrarHuesped(huesped5);   
        hotel.registrarHuesped(huesped6); 
        hotel.registrarHuesped(huesped1); // Intento de registrar un huésped ya registrado
        System.out.println();

        //  Agregar servicios adicionales
        ServicioAdicional spaAdicional = new ServicioAdicional("Spa", 40.0);
        ServicioAdicional gymAdicional = new ServicioAdicional("Gym", 35.0);
        ServicioAdicional lavanderiaAdicional = new ServicioAdicional("Lavanderia", 20.0);

        System.out.println("===Crear reservas===");
        //  Crear reservacion para Juan (huesped1) - disponible
        Reserva reserva1 = new Reserva("R001", LocalDate.of(2026, 12, 27), 3, 
                                        hotel.buscarHabitacion(101), huesped1);
        hotel.agregarReserva(reserva1);
        reserva1.generarFactura(); // todavía pendiente
        reserva1.confirmarReserva(); // confirmar la reserva
        reserva1.agregarServicio(spaAdicional); // agregar servicio adicional
        reserva1.generarFactura(); // generar factura después de confirmar la reserva y agregar servicio
        System.out.println(reserva1); // Mostrar detalles de la reserva
        huesped1.pagarFactura(reserva1.getFactura()); // Pagar la factura generada
        System.out.println("-----------------------------");

        //  Crear reservacion para Maria (huesped2) - disponible
        Reserva reserva2 = new Reserva("R002", LocalDate.of(2026, 12, 28), 4, 
                                        hotel.buscarHabitacion(102), huesped2);
        hotel.agregarReserva(reserva2);
        reserva2.confirmarReserva(); 
        reserva2.agregarServicio(gymAdicional);
        reserva2.agregarServicio(spaAdicional); 
        reserva2.generarFactura(); 
        System.out.println(reserva2); // Mostrar detalles de la reserva
        huesped2.pagarFactura(reserva2.getFactura()); // Pagar la factura generada
        System.out.println("-----------------------------");

        //  Crear reservacion para Carlos (huesped3) - disponible
        Reserva reserva3 = new Reserva("R003", LocalDate.of(2026, 12, 29), 2, 
                                        hotel.buscarHabitacion(201), huesped3);
        hotel.agregarReserva(reserva3);
        reserva3.confirmarReserva();
        reserva3.generarFactura();
        System.out.println(reserva3); // Mostrar detalles de la reserva
        huesped3.pagarFactura(reserva3.getFactura()); // Pagar la factura generada
        System.out.println("-----------------------------");

        //  Crear reservacion para Ana (huesped4) - disponible
        Reserva reserva4 = new Reserva("R004", LocalDate.of(2026, 12, 30), 5, 
                                        hotel.buscarHabitacion(302), huesped4);
        hotel.agregarReserva(reserva4);
        reserva4.confirmarReserva();
        reserva4.agregarServicio(lavanderiaAdicional);
        reserva4.agregarServicio(spaAdicional);
        reserva4.generarFactura();
        System.out.println(reserva4); // Mostrar detalles de la reserva
        huesped4.pagarFactura(reserva4.getFactura()); // Pagar la factura generada
        System.out.println("-----------------------------");

        //  Crear reservacion para Luis (huesped5) - ocupado
        Reserva reserva5 = new Reserva("R005", LocalDate.of(2026, 12, 31), 3, 
                                        hotel.buscarHabitacion(101), huesped5);
        hotel.agregarReserva(reserva5);
        reserva5.confirmarReserva(); // Intento de confirmar la reserva (habitación ocupada)
        System.out.println("-----------------------------");

        //  Crear reservacion para Sofia (huesped6) - disponible
        Reserva reserva6 = new Reserva("R006", LocalDate.of(2026, 12, 1), 4, 
                                        hotel.buscarHabitacion(301), huesped6);
        hotel.agregarReserva(reserva6);
        reserva6.confirmarReserva();
        reserva6.generarFactura();
        System.out.println(reserva6); // Mostrar detalles de la reserva
        huesped6.pagarFactura(reserva6.getFactura()); // Pagar la factura generada
        System.out.println("-----------------------------");

        //  Se intenta reservar una habitación que no existe
        Reserva reserva7 = new Reserva("R007", LocalDate.of(2026, 12, 2), 2, 
                                        hotel.buscarHabitacion(999), huesped1);
        hotel.agregarReserva(reserva7); // Intento de agregar reserva con habitación inexistente
        System.out.println("-----------------------------");

        //  Cancelar una reserva
        reserva2.cancelarReserva(); // Cancelar la reserva de Maria (huesped2)
        System.out.println(reserva2.getEstado()); // Verificar el estado de la reserva cancelada
        System.out.println("-----------------------------");

        //  Mostrar habitaciones disponibles después de las reservas
        System.out.println();
        hotel.mostrarHabitacionesDisponibles();

        //  Mostrar estado final de hotel
        System.out.println("\n===Estado final del hotel===\n" +hotel);

    }

}
