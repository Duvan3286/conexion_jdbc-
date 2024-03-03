/*

 */
package proyectosoftcoinpconexionjdbc;

/**
 *
 * @author admin
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProyectoSoftcoinpConexionJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String usuario = "root";
        String password = "";
        String url= "jdbc:mysql://localhost:3306/proyecto_softcoinp";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoSoftcoinpConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO TIPO_PERSONA(DESCRIPCION) VALUES ('CONTRATISTA')");
            rs = statement.executeQuery("SELECT * FROM TIPO_PERSONA");
            rs.next();
            do{
                System.out.println(rs.getInt("id")+":"+rs.getString("DESCRIPCION"));
            }while(rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoSoftcoinpConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
