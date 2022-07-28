package p3;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import p2.*;
import p2.PlanPostPagoMinutos;

public class Enlace {

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

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarPostPagoMinutos(PlanPostPagoMinutos plan) {

        try {
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
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPagoMegas");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanPostPagoMinutos> obtenerDataPostPagoMinutos() {
        ArrayList<PlanPostPagoMinutos> listamin = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutos;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutos plan = new PlanPostPagoMinutos(
                        rs.getString("nombres"),
                        rs.getString("cedula"),
                        rs.getString("ciudad"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("numero"),
                        rs.getDouble("minNacional"),
                        rs.getDouble("costoNacional"),
                        rs.getDouble("minInter"),
                        rs.getDouble("costoInter"));
                plan.calcularPagoMensual();
                listamin.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutos");
            System.out.println(e.getMessage());

        }
        return listamin;
    }
    
        public void insertarPostPagoMegas(PlanPostPagoMegas plan) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PlanPostPagoMegas "
                    + "(nombres, cedula, ciudad, marca, modelo, "
                    + "numero, megasGb, costoGb, tarifaBase,costoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', "
                    + "'%s', '%.2f', '%.2f','%.2f', '%.2f')",
                    plan.obtenerNombres(),
                    plan.obtenerCedula(),
                    plan.obtenerCiudad(),
                    plan.obtenerMarcaCelular(),
                    plan.obtenerModeloCelular(),
                    plan.obtenerNumeroCelular(),
                    plan.obtenerMegasGb(),
                    plan.obtenerCostoGb(),
                    plan.obtenerTarifaBase(),
                    plan.obtenerCostoMensual());
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMegas");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanPostPagoMegas> obtenerDataPostPagoMegas() {
        ArrayList<PlanPostPagoMegas> listameg = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMegas;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMegas plan = new PlanPostPagoMegas(
                        rs.getString("nombres"),
                        rs.getString("cedula"),
                        rs.getString("ciudad"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("numero"),
                        rs.getDouble("megasGb"),
                        rs.getDouble("costoGb"),
                        rs.getDouble("tarifabase"));
                plan.calcularPagoMensual();
                listameg.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMegas");
            System.out.println(e.getMessage());

        }
        return listameg;
    }

}
