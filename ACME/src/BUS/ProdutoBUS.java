
package BUS;

import DAO.ProdutoDAO;
import TO.Produto;
import java.util.ArrayList;


public class ProdutoBUS {
    public void Incluir(Produto obj){
        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.Incluir(obj);
    }

    public ArrayList<Produto> Consultar(){
        ProdutoDAO pDAO = new ProdutoDAO();
        return pDAO.Consultar();
    }
    
    public void Excluir(int codigo){
        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.Excluir(codigo);
    }
    
    public void Alterar(Produto obj){
        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.Alterar(obj);
    }
    
    public Produto Consultar(int codigo){
        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.Consultar(codigo);
        return null;
    }
   
}
