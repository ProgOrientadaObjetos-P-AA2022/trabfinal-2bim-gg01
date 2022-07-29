/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2;

/**
 *
 * @author Daniel
 */
public class PlanPostPagoMinutosMegas extends PlanCelular {

    private double minutos;
    private double costoMinuto;
    private double megasGb;
    private double costoGb;

    public PlanPostPagoMinutosMegas(String n, String c, String ciu, String mar, 
            String mod,String num, double min, double cmin, double mG, double cG) {
        super(n, c, ciu, mar, mod, num);
        minutos = min;
        costoMinuto = cmin;
        megasGb = mG;
        costoGb = cG;
    }

    public void establecerMinutos(double n) {
        minutos = n;
    }

    public void establecerCostoMinuto(double n) {
        costoMinuto = n;
    }

    public void establecerMegasGb(double n) {
        megasGb = n;
    }

    public void establecerCostoGB(double n) {
        costoGb = n;
    }

    public double obtenerMinutos() {
        return minutos;
    }

    public double obtenerCostoMinuto() {
        return costoMinuto;
    }

    public double obtenerMegasGb() {
        return megasGb;
    }

    public double obtenerCostoGb() {
        return costoGb;
    }

    @Override
    public void calcularPagoMensual() {
        costoMensual = (minutos * costoMinuto) + (megasGb * costoGb);
    }


    @Override
    public String toString() {
        String cadena = String.format("\nPlan PostPago MinutosMegas\n"
                + super.toString() + "\nFactura\n"
                + "\tMinutos: %.2f\n"
                + "\tCosto minuto : %.2f\n"
                + "\tNumero de Megas (GB): %.2f\n"
                + "\tCosto del GB: %.2f\n"
                + "\tPago mensual: %.2f\n",
                obtenerMinutos(),
                obtenerCostoMinuto(),
                obtenerMegasGb(),
                obtenerCostoGb(),
                obtenerCostoMensual());
        return cadena;
    }
}
