
package BUS;

import DAO.LaboratorioDAO;
import TO.Laboratorio;
import java.util.ArrayList;

public class LaboratorioBUS {
     public void Incluir(Laboratorio obj){
       LaboratorioDAO lDAO = new LaboratorioDAO();
       lDAO.Incluir(obj);
    }
    
    public ArrayList<Laboratorio> Consultar(){
         LaboratorioDAO lDAO = new LaboratorioDAO();
        return lDAO.Consultar();
    }
    
    public void Excluir(int codigo){
        LaboratorioDAO lDAO = new LaboratorioDAO();
        lDAO.Excluir(codigo);
    }
        
    public void Alterar(Laboratorio obj){
        LaboratorioDAO lDAO = new LaboratorioDAO();
        lDAO.Alterar(obj);
    }
    
    public Laboratorio Consultar(int codigo){
        LaboratorioDAO lDAO = new LaboratorioDAO();
        lDAO.Consultar(codigo);
        return null;
    }
}
