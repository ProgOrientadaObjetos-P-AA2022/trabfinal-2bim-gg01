package p3;

import java.sql.Statement;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import p2.PlanCelular;
import p2.PlanPostPagoMegas;


public class Enlace {
    /** 
     * Connect to a sample database 
     * @return 
    */
    private Connection conn;
       
    public void establecerConexion() {  

        try {  
            // db parameters  
            String url = "jdbc:sqlite:bd/base.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
            // System.out.println(conn.isClosed());
            //System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
        
    } 
    
    public Connection obtenerConexion(){
        return conn;
    }
    
    public void insertarPlanPostPagoMegas(PlanPostPagoMegas plan) {  
  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PlanPostPagoMegas "
                    + "(nombres, cedula, ciudad, marca, modelo, "
                    + "numero, minNacional, costoNacional,"
                    + "minInter, costoInter, costoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', "
                    + "'%s', '%.2f', '%.2f', "
                    + "'%.2f', '%.2f', '%.2f')", 
                    plan.obtenerNombres(),
                    plan.obtenerCedula(),
                    plan.obtenerCiudad(),
                    plan.obtenerMarcaCelular(),
                    plan.obtenerModeloCelular(),
                    plan.obtenerNumeroCelular(),
                    plan.obtenerMinNacional(),
                    plan.obtenerCostoNacional(),
                    plan.obtenerMinInter(),
                    plan.obtenerCostoInter(),
                    plan.obtenerCostoMensual());
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarPagoMegas");
             System.out.println(e.getMessage());  
             
        }  
    }
    
    public ArrayList<PlanCelular> obtenerDataPlanes() {  
        ArrayList<PlanCelular> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMegas;";
            
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                PlanPostPagoMegas plan = new PlanPostPagoMegas(
                rs.getString("nombres"),
                rs.getString("cedula"),
                rs.getString("ciudad"),
                rs.getString("marca"),
                rs.getString("modelo"),
                rs.getString("numero"),
                rs.getDouble("minNacional"),
                rs.getDouble("costoNacional"),
                rs.getDouble("minInter"),
                rs.getDouble("costoInter"),
                rs.getDouble("costoMensual"));
                lista.add(plan);
            }
            
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarTrabajador");
             System.out.println(e.getMessage());  
             
        }  
        return lista;
    }
    
     
} 