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
    
    public PlanCelular(String n, String c, String ciu, String mar, String mod,
    String num){
        nombres = n;
        cedula = c;
        ciudad = ciu;
        marcaCelular = mar;
        modeloCelular = mod;
        numeroCelular = num;
    }
    
    public void establecerNombres(String n){
        nombres = n;
    }
    
    public void establecerCedula(String n){
        cedula = n;
    }
    
    public void establecerCiudad(String n){
        ciudad = n;
    }
    
    public void establecerMarcaCelular(String n){
        marcaCelular = n;
    }
    
    public void establecerModeloCelular(String n){
        modeloCelular = n;
    }
    
    public void establecerNumeroCelular(String n){
        numeroCelular = n;
    }
    
    public abstract void calcularPagoMensual();
    /*
    marca de celular
    modelo del celular
    numero celular
    pago mensual (para obtener el valor, se debe operar en cada subclase)
    */
    
}
