package gerais;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.tomcat.jdbc.pool.DataSource;


/**
 *
 * @author pfsta
 */
public class FabricaConexao {
     private static Connection con;
    
    public static Connection criaConexao(){       
        try{
            if(con !=null && !con.isClosed()){
                return con;
            }
            
            Context contexto = new InitialContext();
            
            if(contexto == null){
                System.err.println("erro de configuração no netbeans");
            }else{
                Context envContext = (Context) contexto.lookup("java:comp/env/");
               DataSource ds = (DataSource) envContext.lookup("jdbc/lu_paloma_rebeka");
                
                if(ds != null){
                    con = ds.getConnection();
                    
                }
            }
            
        }catch(NamingException ex){
            System.err.println("Não existe o dataSource requisitado");
        }catch(SQLException ex){
            System.err.println("Erro ao estabelecer conexão com o banco de dados");
        }
        
        return con;
        
    }
}
