import java.time.LocalDate;

public class Factura {
    
    //  Atributos
    //  Encapsulamiento: atributos privados
    private String numeroFactura;
    private LocalDate fechaEmision;
    private double subtotal;
    private double impuesto;
    private double total;

    //  Constructor
    public Factura(String numeroFactura, double subtotal) {
    this.numeroFactura = numeroFactura;
    this.fechaEmision = LocalDate.now();
    this.subtotal = subtotal;
    this.impuesto = subtotal * 0.13;
    this.total = this.subtotal + this.impuesto;
    }

    //  Getters (sin setters: una factura emitida no se modifica)
    public String getNumeroFactura() {
        return numeroFactura;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getTotal() {
        return total;
    }

    //  toString
    public String toString() {
        return "Factura: " + numeroFactura + 
        "\nFecha de emisión: " + fechaEmision + 
        "\nSubtotal: " + subtotal + 
        "\nIVA (13%): " + impuesto + 
        "\nTotal: " + total;
    }

    
}
