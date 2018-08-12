
package DAO;

import TO.Fornecedor;

import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FornecedorDAO implements DAO<Fornecedor>{
    BancoDados bd = new BancoDados();
    
    @Override
    public void Incluir(Fornecedor obj) {
        try{
            bd.conectar();
            String inclu = "INSERT INTO fornecedor (nome,razao_social,cnpj,endereco,telefone) VALUES (?,?,?,?,?)";
            PreparedStatement p = bd.connection.prepareStatement(inclu);
            
            p.setString(1, obj.getNome());
            p.setString(2, obj.getRazao_social());
            p.setString(3, obj.getCnpj());
            p.setString(4, obj.getEndereco());
            p.setString(5, obj.getTelefone());
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
            String exclu = "DELETE FROM fornecedor where cod_fornecedor=?";
            
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
    public void Alterar(Fornecedor obj) {
        try{
            bd.conectar();
            String alt = "UPDATE fornecedor SET nome=?, razao_social=?, cnpj=?, endereco=?, telefone=? where cod_fornecedor=?";
            
            PreparedStatement p = bd.connection.prepareStatement(alt);
            p.setString(1, obj.getNome());
            p.setString(2, obj.getRazao_social());
            p.setString(3, obj.getCnpj());
            p.setString(4, obj.getEndereco());
            p.setString(5, obj.getTelefone());
            p.setInt(6, obj.getCodigo());
            p.executeUpdate();
            p.close();
            bd.desconectar();
            
        }catch(SQLException ex){
             Logger.getLogger(ProdutoDAO.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Fornecedor> Consultar() {
        ArrayList<Fornecedor> lista = new ArrayList<>();
        bd.conectar();
        Statement comando;
        
        try{
            comando = (Statement) bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM fornecedor");
            while (rs.next()) {
                Fornecedor obj = new Fornecedor();
                
                obj.setCodigo(rs.getInt("cod_fornecedor"));
                obj.setNome(rs.getString("nome"));
                obj.setRazao_social(rs.getString("razao_social"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setTelefone(rs.getString("telefone"));  
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
    public Fornecedor Consultar(int codigo) {
        Fornecedor obj = null;
        bd.conectar();
        Statement comando;
        
        try{
              String consul = "Select * from fornecedor where cod_fornecedor = ?";
              PreparedStatement p = bd.connection.prepareStatement(consul);
              p.setInt(1, codigo);
              ResultSet rs = p.executeQuery();
              
              if (rs.next()) {
                  obj = new Fornecedor();
                  obj.setCodigo(rs.getInt("cod_fornecedor"));
                  obj.setNome(rs.getString("nome"));
                  obj.setRazao_social(rs.getString("razao_social"));
                    obj.setCnpj(rs.getString("cnpj"));
                 obj.setEndereco(rs.getString("endereco"));
                 obj.setTelefone(rs.getString("telefone")); 
                 return obj;
              }
              
        }catch(SQLException ex){
            Logger.getLogger(ProdutoDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
}
