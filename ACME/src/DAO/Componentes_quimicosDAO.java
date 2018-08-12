
package DAO;

import TO.Componentes_quimicos;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Componentes_quimicosDAO implements DAO<Componentes_quimicos>{
     BancoDados bd = new BancoDados();

    @Override
    public void Incluir(Componentes_quimicos obj) {
        try{
            bd.conectar();
            String inclu = "INSERT INTO componentes_quimicos (nome,tipo) VALUES (?,?)";
            PreparedStatement p = bd.connection.prepareStatement(inclu);
            
            p.setString(1, obj.getNome());
            p.setString(2, obj.getTipo());
           
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
            String exclu = "DELETE FROM componentes_quimicos where cod_compquim=?";
            
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
    public void Alterar(Componentes_quimicos obj) {
       try{
            bd.conectar();
            String alt = "UPDATE componentes_quimicos SET nome=?, tipo=? where cod_compquim=?";
            
            PreparedStatement p = bd.connection.prepareStatement(alt);
            p.setString(1, obj.getNome());
            p.setString(2, obj.getTipo());            
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
    public ArrayList<Componentes_quimicos> Consultar() {
        ArrayList<Componentes_quimicos> lista = new ArrayList<>();
        bd.conectar();
        Statement comando;
        
        try{
            comando = (Statement) bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM componentes_quimicos");
            while (rs.next()) {
                Componentes_quimicos obj = new Componentes_quimicos();
                
                obj.setCodigo(rs.getInt("cod_compquim"));
                obj.setNome(rs.getString("nome"));
                obj.setTipo(rs.getString("Tipo"));
                 
                lista.add(obj);
            }
            return lista;
        }catch(SQLException ex){
            Logger.getLogger(ProdutoDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Componentes_quimicos Consultar(int codigo) {
        Componentes_quimicos obj = null;
        bd.conectar();
        Statement comando;
        
        try{
              String consul = "Select * from componentes_quimicos where cod_compquim = ?";
              PreparedStatement p = bd.connection.prepareStatement(consul);
              p.setInt(1, codigo);
              ResultSet rs = p.executeQuery();
              
              if (rs.next()) {
                  obj = new Componentes_quimicos();
                  obj.setCodigo(rs.getInt("cod_compquim"));
                  obj.setNome(rs.getString("nome"));                 
                 obj.setTipo(rs.getString("Tipo")); 
                 return obj;
              }
              
        }catch(SQLException ex){
            Logger.getLogger(ProdutoDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return obj;
    }
 }

