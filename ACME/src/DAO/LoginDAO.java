
package DAO;

import TO.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO implements DAO<Login>{
    BancoDados bd = new BancoDados();
    
    @Override
    public void Incluir(Login obj) {
        try{
            bd.conectar();
            String inclu = "INSERT INTO login (usuario,senha) VALUES (?,?)";
            PreparedStatement p = bd.connection.prepareStatement(inclu);
            
            p.setString(1, obj.getUsuario());
            p.setString(2, obj.getSenha());            
            
            p.execute();
            p.close();
           bd.desconectar();
            
        }catch(SQLException ex){
            Logger.getLogger(ProdutoDAO.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Excluir(int codigo) {
        try{
            bd.conectar();
            String exclu = "DELETE FROM login where codigo=?";
            
            PreparedStatement p = bd.connection.prepareStatement(exclu);
            p.setInt(1, codigo);
            p.execute();
            p.close();
            bd.desconectar();                    
                    
        }catch(SQLException ex){
            Logger.getLogger(ProdutoDAO.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Alterar(Login obj) {
        try{
            bd.conectar();
            String alt = "UPDATE login SET usuario=?, senha=? where codigo=?";
            
            PreparedStatement p = bd.connection.prepareStatement(alt);
            p.setString(1, obj.getUsuario());
            p.setString(2, obj.getSenha());                     
            p.setInt(3, obj.getCodigo());
            p.executeUpdate();
            p.close();
            bd.desconectar();
            
        }catch(SQLException ex){
             Logger.getLogger(ProdutoDAO.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Login> Consultar() {
        ArrayList<Login> lista = new ArrayList<>();
        bd.conectar();
        Statement comando;

        try {
            comando = (Statement) bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM login");
            while (rs.next()) {
                Login obj = new Login();

                obj.setCodigo(rs.getInt("codigo"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setSenha(rs.getString("senha"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Login Consultar(int codigo) {
        Login obj = null;
        bd.conectar();
        
        try {            
            String strSql
                    = "SELECT * FROM login WHERE codigo = ?";
            PreparedStatement l = bd.connection.prepareStatement(strSql);
            l.setInt(1, obj.getCodigo());
            ResultSet rs = l.executeQuery();
            
            if(rs.next()){
                obj = new Login();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setSenha(rs.getString("senha"));
                return obj;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
             return obj;
    }
    
}
