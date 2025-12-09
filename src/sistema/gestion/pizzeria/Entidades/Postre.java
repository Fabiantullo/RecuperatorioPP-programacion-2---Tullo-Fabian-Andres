package recuperatoriopp.tullo.fabian.Entidades;

public class Postre extends Producto implements IVendible {

    private TipoPostre tipoPostre;

    public Postre(String nombre, double precio, Fabricante fabricante, TipoPostre tipoPostre) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;
    }

    @Override
    public double getPrecioTotal() {
        double incremento = 0;
        switch (this.tipoPostre) {
            case TIRAMISU:
                incremento = 0.20;
                break;
            case HELADO:
                incremento = 0.15;
                break;
            case FLAN:
                incremento = 0.10;
                break;
        }
        return this.precio + (this.precio * incremento);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append("Tipo: ").append(this.tipoPostre).append("\n");
        sb.append("Precio Total: $").append(this.getPrecioTotal());
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Postre)) {
            return false;
        }
        Postre otro = (Postre) obj;
        return this.tipoPostre == otro.tipoPostre;
    }
}