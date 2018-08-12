
package DAO;

import TO.MateriasPrimas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MateriasPrimasDAO implements DAO<MateriasPrimas>{
    BancoDados bd = new BancoDados();
    
    @Override
    public void Incluir(MateriasPrimas obj) {
        try{
            bd.conectar();
            String inclu = "INSERT INTO materias_primas (descricao, cod_compquim, cod_fornecedor) VALUES (?,?,?)";
                    
            PreparedStatement p
                    = bd.connection.prepareStatement(inclu, Statement.RETURN_GENERATED_KEYS);
            p.setString(1, obj.getDescricao());
            p.setInt(2, obj.getCod_compquim());
            p.setInt(3, obj.getCod_fornecedor());
            p.execute();
            
            ResultSet rs = p.getGeneratedKeys();
            
            if (rs.next()) {
                obj.setCodigo(rs.getInt(1));
            }
            
            p.close();
            bd.desconectar();
            
        }catch(SQLException ex){
            Logger.getLogger(MateriasPrimasDAO.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Excluir(int codigo) {
       try{
           bd.conectar();
           String exclu = "DELETE FROM materias_primas where cod_materia=?";
           PreparedStatement p
                    = bd.connection.prepareStatement(exclu);
           
           p.setInt(1, codigo);
           p.execute();
           p.close();
           bd.desconectar();
           
       }catch(SQLException ex){
           Logger.getLogger(MateriasPrimasDAO.class.
                    getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    public void Alterar(MateriasPrimas obj) {
        try{
            bd.conectar();
            String alt = "UPDATE SET materia_primas (descricao=?, cod_compquim=?, cod_fornecedor=?) WHERE cod_materia=?";
            PreparedStatement p = bd.connection.prepareStatement(alt);
            
            p.setString(1, obj.getDescricao());
            p.setInt(2, obj.getCod_compquim());
            p.setInt(3, obj.getCod_fornecedor());
            p.setInt(4, obj.getCodigo());
            p.executeUpdate();
            p.close();
            bd.desconectar();
            
        }catch(SQLException ex){
            Logger.getLogger(MateriasPrimasDAO.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<MateriasPrimas> Consultar() {
        ArrayList<MateriasPrimas> lista = new ArrayList<>();
        bd.conectar();
        Statement comando;
        
        try{
            comando = bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM materias_primas");
            
              while (rs.next()) {
                  MateriasPrimas obj = new MateriasPrimas();
                  obj.setCodigo(rs.getInt("cod_materia"));
                  obj.setDescricao(rs.getString("descricao"));
                  obj.setCod_compquim(rs.getInt("cod_compquim"));
                  obj.setCod_fornecedor(rs.getInt("cod_fornecedor"));
                  lista.add(obj);
              }
            return lista;
        }catch(SQLException ex){
            Logger.getLogger(MateriasPrimasDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public MateriasPrimas Consultar(int codigo) {
        MateriasPrimas obj = null;
        bd.conectar();
        Statement comando;
        
        try{
            String strSQL = "Select * from materias_primas where cod_materia = ?";
            PreparedStatement p = bd.connection.prepareStatement(strSQL);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            
            if (rs.next()) {
                obj = new MateriasPrimas();
                obj.setCodigo(rs.getInt("cod_materia"));
                  obj.setDescricao(rs.getString("descricao"));
                  obj.setCod_compquim(rs.getInt("cod_compquim"));
                  obj.setCod_fornecedor(rs.getInt("cod_fornecedor"));
                  return obj;
            }            
        }catch(SQLException ex){
            Logger.getLogger(MateriasPrimasDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
         return obj;
    }
    
}
