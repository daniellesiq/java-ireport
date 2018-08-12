
package BUS;

import DAO.MateriasPrimasDAO;
import TO.Componentes_quimicos;
import TO.Fornecedor;
import TO.MateriasPrimas;
import java.util.ArrayList;

public class MateriasPrimasBUS {
    public void Incluir(MateriasPrimas obj){
        MateriasPrimasDAO mDAO = new MateriasPrimasDAO();
        mDAO.Incluir(obj);
    }
     public ArrayList<MateriasPrimas> Consultar(){
         MateriasPrimasDAO mDAO = new MateriasPrimasDAO();
         return mDAO.Consultar();
     }
     
     public void Excluir(int codigo){
          MateriasPrimasDAO mDAO = new MateriasPrimasDAO();
          mDAO.Excluir(codigo);
     }
     
     public void Alterar(MateriasPrimas obj){
         MateriasPrimasDAO mDAO = new MateriasPrimasDAO();
         mDAO.Alterar(obj);
     }
     
     public MateriasPrimas Consultar(int codigo){
         MateriasPrimasDAO mDAO = new MateriasPrimasDAO();
         mDAO.Consultar(codigo);
         return null;
     }
     
     public ArrayList<Componentes_quimicos> ConsultarComponentes() {
        Componentes_quimicosBUS cBus = new Componentes_quimicosBUS();
        return cBus.Consultar();
    }
     
     public ArrayList<Fornecedor> ConsultarFornecedor() {
        FornecedorBUS fBus = new FornecedorBUS();
        return fBus.Consultar();
    }
}
