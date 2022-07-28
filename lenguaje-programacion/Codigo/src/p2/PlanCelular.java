package p2;

/**
 *
 * @author Daniel
 */
public abstract class PlanCelular {

    protected String nombres;
    protected String cedula;
    protected String ciudad;
    protected String marcaCelular;
    protected String modeloCelular;
    protected String numeroCelular;
    protected double costoMensual;

    public PlanCelular(String n, String c, String ciu, String mar, String mod,
            String num) {
        nombres = n;
        cedula = c;
        ciudad = ciu;
        marcaCelular = mar;
        modeloCelular = mod;
        numeroCelular = num;
    }

    public void establecerNombres(String n) {
        nombres = n;
    }

    public void establecerCedula(String n) {
        cedula = n;
    }

    public void establecerCiudad(String n) {
        ciudad = n;
    }

    public void establecerMarcaCelular(String n) {
        marcaCelular = n;
    }

    public void establecerModeloCelular(String n) {
        modeloCelular = n;
    }

    public void establecerNumeroCelular(String n) {
        numeroCelular = n;
    }

    public abstract void calcularPagoMensual(); //Método Abstracto

    public String obtenerNombres() {
        return nombres;
    }

    public String obtenerCedula() {
        return cedula;
    }

    public String obtenerCiudad() {
        return ciudad;
    }

    public String obtenerMarcaCelular() {
        return marcaCelular;
    }

    public String obtenerModeloCelular() {
        return modeloCelular;
    }

    public String obtenerNumeroCelular() {
        return numeroCelular;
    }

    public double obtenerCostoMensual() {
        return costoMensual;
    }

    @Override
    public String toString() {
        String cadena = String.format("Datos del Propietario\n"
                + "\tNombres: %s\n"
                + "\tCedula: %s\n"
                + "\tCiudad: %s\n"
                + "Datos del Celular\n"
                + "\tMarca: %s\n"
                + "\tModelo: %s\n"
                + "\tNúmero: %s\n",
                obtenerNombres(), obtenerCedula(),
                obtenerCiudad(), obtenerMarcaCelular(),
                obtenerModeloCelular(), obtenerNumeroCelular());

        return cadena;
    }

}
