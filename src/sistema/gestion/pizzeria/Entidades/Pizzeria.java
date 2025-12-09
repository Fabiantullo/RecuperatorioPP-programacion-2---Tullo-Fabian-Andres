package sistema.gestion.pizzeria.Entidades;

import java.util.ArrayList;
import java.util.Iterator;

public class Pizzeria implements Iterable<Producto> {

    private String nombre;
    private int capacidad;
    private ArrayList<Producto> productos;

    public Pizzeria(String nombre) {
        this(nombre, 3);
    }

    public Pizzeria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }

    private boolean sonIguales(Producto p) {
        return this.productos.contains(p);
    }

    public void agregar(Producto p) {
        if (p == null) {
            System.out.println("Producto nulo");
            return;
        }
        if (this.productos.size() >= this.capacidad) {
            System.out.println("No hay mas lugar en la pizzeria");
            return;
        }
        if (this.sonIguales(p)) {
            System.out.println("El producto ya esta en la pizzeria");
            return;
        }
        this.productos.add(p);
        System.out.println("Producto agregado");
    }

    private double getPrecioProductos(TipoProducto tipo) {
        double total = 0;
        for (Producto prod : this.productos) {
            if (prod instanceof IVendible) {
                IVendible vendible = (IVendible) prod;
                if (tipo == TipoProducto.TODOS) {
                    total += vendible.getPrecioTotal();
                } else if (tipo == TipoProducto.PIZZAS && prod instanceof Pizza) {
                    total += vendible.getPrecioTotal();
                } else if (tipo == TipoProducto.POSTRES && prod instanceof Postre) {
                    total += vendible.getPrecioTotal();
                }
            }
        }
        return total;
    }

    private double getPrecioDePizzas() {
        return this.getPrecioProductos(TipoProducto.PIZZAS);
    }

    private double getPrecioDePostres() {
        return this.getPrecioProductos(TipoProducto.POSTRES);
    }

    private double getPrecioTotal() {
        return this.getPrecioProductos(TipoProducto.TODOS);
    }

    @Override
    public Iterator<Producto> iterator() {
        return this.productos.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizzeria: ").append(this.nombre);
        sb.append(", Capacidad: ").append(this.capacidad).append("\n");
        sb.append("Cantidad actual: ").append(this.productos.size()).append("\n");
        
        sb.append("\n--- Precios Totales ---\n");
        sb.append("Total Pizzas: $").append(this.getPrecioDePizzas()).append("\n");
        sb.append("Total Postres: $").append(this.getPrecioDePostres()).append("\n");
        sb.append("Total General: $").append(this.getPrecioTotal()).append("\n");
        
        sb.append("\n--- Detalle de Productos ---\n");
        for (Producto prod : this.productos) {
            sb.append(prod.toString());
            sb.append("\n------------------\n");
        }
        return sb.toString();
    }
}