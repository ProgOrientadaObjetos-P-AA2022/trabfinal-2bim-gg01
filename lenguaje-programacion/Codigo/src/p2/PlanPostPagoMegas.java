package p2;

/**
 *
 * @author Daniel
 */
public class PlanPostPagoMegas extends PlanCelular {

    /*
    minutos nacionales
    costo minuto nacional
    minutos internacionales
    costo minuto internacional
     */
    private double minNacional;
    private double costoNacional;
    private double minInter;
    private double costoInter;

    public PlanPostPagoMegas(String n, String c, String ciu, String mar,
            String mod, String num, double mN, double cN, double mI, double cI) {
        super(n, c, ciu, mar, mod, num);
        minNacional = mN;
        costoNacional = cN;
        minInter = mI;
        costoInter = cI;
        calcularPagoMensual();
    }

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
}
