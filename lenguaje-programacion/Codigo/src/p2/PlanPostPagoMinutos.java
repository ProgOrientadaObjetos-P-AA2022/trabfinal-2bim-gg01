package p2;

/**
 *
 * @author Daniel
 */
public class PlanPostPagoMinutos extends PlanCelular {

    private double minNacional;
    private double costoNacional;
    private double minInter;
    private double costoInter;
    
    //Constructor para creación
    public PlanPostPagoMinutos(String n, String c, String ciu, String mar,
            String mod, String num, double mN, double cN, double mI, double cI){
        super(n, c, ciu, mar, mod, num);
        minNacional = mN;
        costoNacional = cN;
        minInter = mI;
        costoInter = cI;
    }
    /*
    //Constructor para Lectura
    public PlanPostPagoMinutos(String n, String c, String ciu, String mar,
            String mod, String num, double mN, double cN, double mI, double cI,
            double vM) { 
        super(n, c, ciu, mar, mod, num);
        minNacional = mN;
        costoNacional = cN;
        minInter = mI;
        costoInter = cI;
        costoMensual = vM;
    }
*/
    public void establecerMinNacional(double m) {
        minNacional = m;
    }

    public void establecerCostoNacional(double m) {
        costoNacional = m;
    }

    public void establecerMinInter(double m) {
        minInter = m;
    }

    public void establecerCostoInter(double m) {
        costoInter = m;
    }

    @Override
    public void calcularPagoMensual() {
        costoMensual = (minNacional * costoNacional) + (minInter * costoInter);
    }

    public double obtenerMinNacional() {
        return minNacional;
    }

    public double obtenerCostoNacional() {
        return costoNacional;
    }

    public double obtenerMinInter() {
        return minInter;
    }

    public double obtenerCostoInter() {
        return costoInter;
    }

    @Override
    public String toString() {
        String reporte = String.format("\n-------PLAN POST PAGO MINUTOS-------\n"
                + super.toString()+ "\nFactura\n"
                + "\tCantidad Minutos Nacionales: %.2f\n"
                + "\tCosto Minutos Nacionales: %.3f\n"
                + "\tCantidad Minutos Internacionales: %.3f\n"
                + "\tCosto Minutos Internacionales: %.2f\n"
                + "\tValor Mensual: %.2f\n",
                obtenerMinNacional(),
                obtenerCostoNacional(),
                obtenerMinInter(),
                obtenerCostoInter(),
                obtenerCostoMensual());

        return reporte;
    }
}
