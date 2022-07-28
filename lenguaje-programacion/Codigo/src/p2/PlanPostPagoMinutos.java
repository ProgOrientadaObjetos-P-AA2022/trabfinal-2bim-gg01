package p2;

/**
 *
 * @author Daniel
 */
public class PlanPostPagoMinutos extends PlanCelular {

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
    
    //Constructor para creación
    public PlanPostPagoMinutos(String n, String c, String ciu, String mar,
            String mod, String num, double mN, double cN, double mI, double cI){
        super(n, c, ciu, mar, mod, num);
        minNacional = mN;
        costoNacional = cN;
        minInter = mI;
        costoInter = cI;
    }
    
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
        String reporte = String.format("Plan Post Pago Megas\n"
                + "  Nombres: %s\n"
                + "  Cedula: %s\n"
                + "  Ciudad: %s\n"
                + "  Marca: %s\n"
                + "  Modelo: %s\n"
                + "  Numero: %s\n"
                + "  Cantidad Minutos Nacionales: %.2f\n"
                + "  Costo Minutos Nacionales: %.3f\n"
                + "  Cantidad Minutos Internacionales: %.3f\n"
                + "  Costo Minutos Internacionales: %.2f\n"
                + " Valor Mensual: %.2f\n",
                obtenerNombres(),
                obtenerCedula(),
                obtenerCiudad(),
                obtenerMarcaCelular(),
                obtenerModeloCelular(),
                obtenerNumeroCelular(),
                obtenerMinNacional(),
                obtenerCostoNacional(),
                obtenerMinInter(),
                obtenerCostoInter(),
                obtenerCostoMensual());

        return reporte;
    }
}
