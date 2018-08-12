
package TO;

public class Produto {
    
    private int codigo;
    private String nome;
    private String tipo_prod;
    private String descricao;
    private String tipo_uso;
    private String tipo_pele;
    private String cor;
    private String consistencia;

   
     @Override
    public String toString(){//exibe o nome
        return this.getNome();
    } 

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tipo_prod
     */
    public String getTipo_prod() {
        return tipo_prod;
    }

    /**
     * @param tipo_prod the tipo_prod to set
     */
    public void setTipo_prod(String tipo_prod) {
        this.tipo_prod = tipo_prod;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the tipo_uso
     */
    public String getTipo_uso() {
        return tipo_uso;
    }

    /**
     * @param tipo_uso the tipo_uso to set
     */
    public void setTipo_uso(String tipo_uso) {
        this.tipo_uso = tipo_uso;
    }

    /**
     * @return the tipo_pele
     */
    public String getTipo_pele() {
        return tipo_pele;
    }

    /**
     * @param tipo_pele the tipo_pele to set
     */
    public void setTipo_pele(String tipo_pele) {
        this.tipo_pele = tipo_pele;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the consistencia
     */
    public String getConsistencia() {
        return consistencia;
    }

    /**
     * @param consistencia the consistencia to set
     */
    public void setConsistencia(String consistencia) {
        this.consistencia = consistencia;
    }
}
