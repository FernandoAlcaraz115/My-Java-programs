package ejemplosaccesodatos;
// Fig. 4.6: ConexionBD.java
// Muestra el contenido de la tabla student de la BD University.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    // nombre del controlador de JDBC y URL de la base de datos
    static final String URL_BASEDATOS = "jdbc:postgresql://localhost:5432/university";

    // inicia la aplicación
    public static void main(String args[]) {
        Connection conexion = null; // maneja la conexión
        Statement instruccion = null; // instrucción de consulta
        ResultSet conjuntoResultados = null; // maneja los resultados

        // se conecta a la base de datos university y realiza una consulta
        try {
            // establece la conexión a la base de datos
            conexion = DriverManager.getConnection(URL_BASEDATOS, "university", "fer11102003");

            // crea objeto Statement para consultar la base de datos
            instruccion = conexion.createStatement();
            // consulta la base de datos
            conjuntoResultados = instruccion.executeQuery(
                "SELECT stuid, lastname, firstname, major, credits FROM student");

            // procesa los resultados de la consulta
            ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
            int numeroDeColumnas = metaDatos.getColumnCount();
            System.out.println("Tabla Student de la base de datos University:\n");
            for (int i = 1; i <= numeroDeColumnas; i++) {
                System.out.printf("%-8s\t", metaDatos.getColumnName(i));
            }
            System.out.println();

            while (conjuntoResultados.next()) {
                for (int i = 1; i <= numeroDeColumnas; i++) {
                    System.out.printf("%-8s\t", conjuntoResultados.getObject(i));
                }
                System.out.println();
            } // fin de while
        } // fin de try
        catch (SQLException excepcionSql) {
        }
        // fin de catch
         // fin de catch
        finally { // asegura que conjuntoResultados, instruccion y conexion estén cerrados
            try {
                conjuntoResultados.close();
                instruccion.close();
                conexion.close();
            } // fin de try
            catch (SQLException excepcion) {
            } // fin de catch
        } // fin de finally
    } // fin de main
} // fin de la clase ConexionBD
