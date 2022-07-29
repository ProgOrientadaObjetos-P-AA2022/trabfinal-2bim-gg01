package p2;

/**
 *
 * @author Daniel
 */
public class PlanPostPagoMegas extends PlanCelular {

    /*
    megas expresado en gigas
costo por cada giga
tarifa base
     */
    private double megasGb;
    private double costoGb;
    private double tarifaBase;

    //Constructor para creación
    public PlanPostPagoMegas(String n, String c, String ciu, String mar,
            String mod, String num, double mG, double cG, double t) {
        super(n, c, ciu, mar, mod, num);
        megasGb = mG;
        costoGb = cG;
        tarifaBase = t;
    }

    /*
    //Constructor para Lectura
    public PlanPostPagoMegas(String n, String c, String ciu, String mar,
            String mod, String num, double mG, double cG, double t, 
            double vM){
        super(n, c, ciu, mar, mod, num);
        megasGb = mG;
        costoGb = cG;
        tarifaBase = t;
        costoMensual = vM;
    }
     */
    public void establecerMegasGb(double n) {
        megasGb = n;
    }

    public void establecerCostoGb(double n) {
        costoGb = n;
    }

    public void establecerTarifaBase(double n) {
        tarifaBase = n;
    }

    public double obtenerMegasGb() {
        return megasGb;
    }

    public double obtenerCostoGb() {
        return costoGb;
    }

    public double obtenerTarifaBase() {
        return tarifaBase;
    }

    @Override
    public void calcularPagoMensual() {
        costoMensual = (megasGb * costoGb) + tarifaBase;
    }

    @Override
    public double obtenerCostoMensual() {
        return costoMensual;
    }

    @Override
    public String toString() {
        String cadena = String.format("\n-------PLAN POST PAGO MEGAS-------\n"
                + super.toString() + "\nFactura\n"
                + "\tNumero de Megas (GB): %.2f\n"
                + "\tCosto del GB: %.2f\n"
                + "\tTarifa base: %.2f\n"
                + "\tPago mensual: %.2f\n",
                obtenerMegasGb(), 
                obtenerCostoGb(),
                obtenerTarifaBase(),
                obtenerCostoMensual());
        return cadena;
    }
}
