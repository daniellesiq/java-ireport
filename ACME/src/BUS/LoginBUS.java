
package BUS;

import DAO.LoginDAO;
import TO.Login;
import java.util.ArrayList;

public class LoginBUS {
    public void Incluir(Login obj){
       LoginDAO lDAO = new LoginDAO();
       lDAO.Incluir(obj);
    }
    
    public Login Consultar(int codigo){
        LoginDAO lDAO = new LoginDAO();
        lDAO.Consultar(codigo);
        return null;
    }
    
    public ArrayList<Login> Consultar(){
        LoginDAO lDAO = new LoginDAO ();
         return lDAO.Consultar();
    }
    
    public void Excluir(int codigo){
        LoginDAO lDAO = new LoginDAO();
        lDAO.Excluir(codigo);
    }
    
    public void Alterar(Login obj){
        LoginDAO lDAO = new LoginDAO();
        lDAO.Alterar(obj);
    }
}
