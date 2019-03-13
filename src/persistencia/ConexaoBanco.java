package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Douglas
 * @since 07/07/2018 - 3:46
 * @version 1.0 - Beta Carrero
 */
public class ConexaoBanco {
 
    private static final String URL="jdbc:mysql://localhost:3306/geromel";
    private static final String USUARIO="root";
    private static final String SENHA="root";

    public static Connection getConexao() throws SQLException{
        
        Connection c = null;
        try {
            c = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException se) { 
            throw new SQLException("Erro ao conectar no Banco de Dados! "+se.getMessage());
        }
        
        return c;
    }
}