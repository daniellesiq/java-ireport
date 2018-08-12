
package BUS;

import DAO.Componentes_quimicosDAO;
import TO.Componentes_quimicos;
import java.util.ArrayList;

public class Componentes_quimicosBUS {
     public void Incluir(Componentes_quimicos obj){
       Componentes_quimicosDAO cDAO = new Componentes_quimicosDAO();
       cDAO.Incluir(obj);
    }
    
    public ArrayList<Componentes_quimicos> Consultar(){
        Componentes_quimicosDAO cDAO = new Componentes_quimicosDAO();
        return cDAO.Consultar();
    }
    
    public void Excluir(int codigo){
       Componentes_quimicosDAO cDAO = new Componentes_quimicosDAO();
        cDAO.Excluir(codigo);
    }
        
    public void Alterar(Componentes_quimicos obj){
        Componentes_quimicosDAO cDAO = new Componentes_quimicosDAO();
        cDAO.Alterar(obj);
    }
    
    public Componentes_quimicos Consultar(int codigo){
        Componentes_quimicosDAO cDAO = new Componentes_quimicosDAO();
        cDAO.Consultar(codigo);
        return null;
    }
}
