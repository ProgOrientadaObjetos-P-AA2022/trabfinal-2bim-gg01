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
            String mod, String num, double mG, double cG, double t){
        super(n, c, ciu, mar, mod, num);
        megasGb = mG;
        costoGb = cG;
        tarifaBase = t;
    }
    
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
    
    @Override
    public void calcularPagoMensual() {
        costoMensual = (megasGb * costoGb) + tarifaBase;
    }

}
