package sistema.gestion.pizzeria.Entidades;

public class Fabricante {

    private String nombre;
    private String ciudad;
    private int antiguedad;

    public Fabricante(String nombre, String ciudad, int antiguedad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.antiguedad = antiguedad;
    }

    public static boolean sonIguales(Fabricante f1, Fabricante f2) {
        if (f1 == null || f2 == null) {
            return false;
        }
        return f1.nombre.equals(f2.nombre) && f1.ciudad.equals(f2.ciudad) && f1.antiguedad == f2.antiguedad;
    }

    private String getInfoFabricante() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(this.nombre);
        sb.append(", Ciudad: ").append(this.ciudad);
        sb.append(", Antiguedad: ").append(this.antiguedad);
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.getInfoFabricante();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Fabricante otro = (Fabricante) obj;
        return Fabricante.sonIguales(this, otro);
    }
}