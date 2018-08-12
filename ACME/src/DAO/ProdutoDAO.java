
package DAO;
import TO.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO implements DAO<Produto>{
    BancoDados bd = new BancoDados();//Instância do banco de dados
       
    @Override
    public void Incluir(Produto obj) {    
      
        try {
             bd.conectar();
              String inclu = "INSERT INTO produto (nome, tipo_prod, descricao, tipo_uso, tipo_pele, cor, consistencia) "
              + "VALUES (?,?,?,?,?,?,?)";
               PreparedStatement p = bd.connection.prepareStatement(inclu);
            
               p.setString(1, obj.getNome());
               p.setString(2, obj.getTipo_prod());
               p.setString(3, obj.getDescricao());
               p.setString(4, obj.getTipo_uso());
               p.setString(5, obj.getTipo_pele());
               p.setString(6, obj.getCor());
               p.setString(7, obj.getConsistencia());
               p.execute();
               p.close();
               bd.desconectar();
               
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Excluir(int codigo) {
        try{
            bd.conectar();
            String exclu = "DELETE FROM produto where cod_produto=?";
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
    public void Alterar(Produto obj) {
        try{
             bd.conectar();
            String alt = "UPDATE produto SET nome=?, tipo_prod=?, descricao=?, tipo_uso=?, tipo_pele=?, cor=?, consistencia=? where cod_produto=?";
            
            PreparedStatement p = bd.connection.prepareStatement(alt);
            p.setString(1, obj.getNome());
            p.setString(2, obj.getTipo_prod());
            p.setString(3, obj.getDescricao());
            p.setString(4, obj.getTipo_uso());
            p.setString(5, obj.getTipo_pele());
            p.setString(6, obj.getCor());
            p.setString(7, obj.getConsistencia());
            p.setInt(8, obj.getCodigo());
            
            p.executeUpdate();
            p.close();
            bd.desconectar();
            
        }catch(SQLException ex){
            Logger.getLogger(ProdutoDAO.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Produto> Consultar() {
        ArrayList<Produto> lista = new ArrayList<>();
        bd.conectar();
        Statement comando;
        
        try{
            comando = (Statement) bd.connection.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM produto");
            while (rs.next()) {
                Produto obj = new Produto();
                
                obj.setCodigo(rs.getInt("cod_produto"));
                obj.setNome(rs.getString("nome"));
                obj.setTipo_prod(rs.getString("tipo_prod"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setTipo_uso(rs.getString("tipo_uso"));
                obj.setTipo_pele(rs.getString("tipo_pele"));
                obj.setCor(rs.getString("cor"));
                obj.setConsistencia(rs.getString("consistencia"));
                lista.add(obj);
            }
                return lista;                
                
        }catch(SQLException ex){
            Logger.getLogger(ProdutoDAO.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Produto Consultar(int codigo) {
        Produto obj = null;
        bd.conectar();
        Statement comando;
        
        try{
            
            String consul = "Select * from produto where cod_produto = ?";
              PreparedStatement p = bd.connection.prepareStatement(consul);
              p.setInt(1, codigo);
              ResultSet rs = p.executeQuery();
              
              if (rs.next()) {
                  obj = new Produto();
                  obj.setCodigo(rs.getInt("cod_produto"));
                obj.setNome(rs.getString("nome"));
                obj.setTipo_prod(rs.getString("tipo_prod"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setTipo_uso(rs.getString("tipo_uso"));
                obj.setTipo_pele(rs.getString("tipo_pele"));
                obj.setCor(rs.getString("cor"));
                obj.setConsistencia(rs.getString("consistencia"));
                return obj;                  
              }
            
        }catch(SQLException ex){
            Logger.getLogger(ProdutoDAO.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
}
