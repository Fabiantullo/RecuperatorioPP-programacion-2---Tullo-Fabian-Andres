package recuperatoriopp.tullo.fabian.Entidades;

import java.util.Random;

public abstract class Producto {

    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio;

    static {
        generadorAleatorio = new Random();
    }

    public Producto(String nombre, double precio, Fabricante fabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
        this.calorias = 0;
        this.tiempoPreparacion = 0;
    }

    public Producto(String nombre, double precio, String nombreFabricante,
            String ciudadFabricante, int antiguedadFabricante) {
        this(nombre, precio, new Fabricante(nombreFabricante, ciudadFabricante, antiguedadFabricante));
    }

    public int getCalorias() {
        if (this.calorias == 0) {
            this.calorias = generadorAleatorio.nextInt(200, 801);
        }
        return this.calorias;
    }

    public int getTiempoPreparacion() {
        if (this.tiempoPreparacion == 0) {
            this.tiempoPreparacion = generadorAleatorio.nextInt(5, 21);
        }
        return this.tiempoPreparacion;
    }

    private static String mostrar(Producto p) {
        if (p == null) return "Producto nulo";
        
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(p.nombre).append("\n");
        sb.append("Precio Base: ").append(p.precio).append("\n");
        sb.append("Calorias: ").append(p.getCalorias()).append("\n");
        sb.append("Tiempo Preparacion: ").append(p.getTiempoPreparacion()).append(" minutos\n");
        sb.append("Fabricante: [").append(p.fabricante.toString()).append("]");
        return sb.toString();
    }

    private static boolean sonIguales(Producto p1, Producto p2) {
        if (p1 == null || p2 == null) {
            return false;
        }
        return p1.nombre.equalsIgnoreCase(p2.nombre)
                && Fabricante.sonIguales(p1.fabricante, p2.fabricante);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Producto)) {
            return false;
        }
        Producto otro = (Producto) obj;
        return Producto.sonIguales(this, otro);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mostrar(this));
        return sb.toString();
    }
}
