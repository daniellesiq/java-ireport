
package BUS;

import DAO.FornecedorDAO;
import TO.Fornecedor;
import java.util.ArrayList;

public class FornecedorBUS {
    public void Incluir(Fornecedor obj){
       FornecedorDAO fDAO = new FornecedorDAO();
       fDAO.Incluir(obj);
    }
    
    public ArrayList<Fornecedor> Consultar(){
        FornecedorDAO fDAO = new FornecedorDAO();
        return fDAO.Consultar();
    }
    
    public void Excluir(int codigo){
        FornecedorDAO fDAO = new FornecedorDAO();
        fDAO.Excluir(codigo);
    }
        
    public void Alterar(Fornecedor obj){
        FornecedorDAO fDAO = new FornecedorDAO();
        fDAO.Alterar(obj);
    }
    
    public Fornecedor Consultar(int codigo){
        FornecedorDAO fDAO = new FornecedorDAO();
        fDAO.Consultar(codigo);
        return null;
    }
}
