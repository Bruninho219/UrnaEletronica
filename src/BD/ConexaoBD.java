package BD;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoBD
{
    public static Connection conecta() throws ClassNotFoundException
    {
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/Urna?useTimezone=true&serverTimezone=UTC","root","naotemsenha");
            //Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Urna","postgres","brs28041996");
            return con;
        }
        catch (SQLException error)
        {
            JOptionPane.showMessageDialog(null, error);
            return null;
        }
    }
}


