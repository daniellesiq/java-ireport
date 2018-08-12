
package DAO;

import java.util.ArrayList;

public interface DAO <T> {
    public void Incluir(T obj);
    public void Excluir(int codigo);
    public void Alterar(T obj);
    public ArrayList<T> Consultar();
    public T Consultar(int codigo);  
}
