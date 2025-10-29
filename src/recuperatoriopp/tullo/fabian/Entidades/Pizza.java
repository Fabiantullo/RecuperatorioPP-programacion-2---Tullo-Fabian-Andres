package recuperatoriopp.tullo.fabian.Entidades;

public class Pizza extends Producto implements IVendible {

    private TipoPizza sabor;
    private TamanoPizza tamano;

    public Pizza(String nombre, double precio, Fabricante fabricante, TipoPizza sabor, TamanoPizza tamano) {
        super(nombre, precio, fabricante);
        this.sabor = sabor;
        this.tamano = tamano;
    }

    @Override
    public double getPrecioTotal() {
        double incremento = 1;
        switch (this.tamano) {
            case CHICA:
                incremento = 1.05;
                break;
            case MEDIANA:
                incremento = 1.10;
                break;
            case GRANDE:
                incremento = 1.20;
                break;
        }
        return (this.precio * incremento);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append("Sabor: ").append(this.sabor).append("\n");
        sb.append("Tamano: ").append(this.tamano).append("\n");
        sb.append("Precio Total: $").append(this.getPrecioTotal());
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Pizza)) {
            return false;
        }
        Pizza otra = (Pizza) obj;
        return this.sabor == otra.sabor && this.tamano == otra.tamano;
    }
}
