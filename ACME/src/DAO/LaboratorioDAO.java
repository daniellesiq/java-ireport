
package DAO;

import TO.Laboratorio;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LaboratorioDAO implements DAO<Laboratorio>{
    BancoDados bd = new BancoDados();
    
    @Override
    public void Incluir(Laboratorio obj) {
        try{
            bd.conectar();
            String inclu = "INSERT INTO laboratorio (tipo_acesso,responsavel,localizacao) VALUES (?,?,?)";
            PreparedStatement p = bd.connection.prepareStatement(inclu);
            
            p.setString(1, obj.getTipo_acesso());
            p.setString(2, obj.getResponsavel());
            p.setString(3, obj.getLocalizacao());
            
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
            String exclu = "DELETE FROM laboratorio where cod_laboratorio=?";
            
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
    public void Alterar(Laboratorio obj) {
        try{
            bd.conectar();
            String alt = "UPDATE laboratorio SET tipo_acesso=?, responsavel=?, localizacao=? where cod_laboratorio=?";
            
            PreparedStatement p = bd.connection.prepareStatement(alt);
            p.setString(1, obj.getTipo_acesso());
            p.setString(2, obj.getResponsavel());
            p.setString(3, obj.getLocalizacao());           ;
            p.setInt(4, obj.getCodigo());
            p.executeUpdate();
            p.close();
            bd.desconectar();
            
        }catch(SQLException ex){
             Logger.getLogger(ProdutoDAO.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Laboratorio> Consultar() {
         ArrayList<Laboratorio> lista = new ArrayList<>();
        bd.conectar();
        Statement comando;
        
        try{
            comando = (Statement) bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM laboratorio");
            while (rs.next()) {
                Laboratorio obj = new Laboratorio();
                
                obj.setCodigo(rs.getInt("cod_laboratorio"));
                obj.setTipo_acesso(rs.getString("tipo_acesso"));
                obj.setResponsavel(rs.getString("responsavel"));
                obj.setLocalizacao(rs.getString("localizacao"));
                 
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
    public Laboratorio Consultar(int codigo) {
        Laboratorio obj = null;
        bd.conectar();
        Statement comando;
        
        try{
              String consul = "Select * from laboratorio where cod_laboratorio = ?";
              PreparedStatement p = bd.connection.prepareStatement(consul);
              p.setInt(1, codigo);
              ResultSet rs = p.executeQuery();
              
              if (rs.next()) {
                  obj = new Laboratorio();
                  obj.setCodigo(rs.getInt("cod_laboratorio"));
                  obj.setTipo_acesso(rs.getString("tipo_acessp"));
                  obj.setResponsavel(rs.getString("responsavel"));
                  obj.setLocalizacao(rs.getString("localizacao"));
                   
                 return obj;
              }
              
        }catch(SQLException ex){
            Logger.getLogger(ProdutoDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return obj;
    }
 }   

