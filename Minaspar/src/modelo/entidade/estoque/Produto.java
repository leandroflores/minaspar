package modelo.entidade.estoque;

import java.text.DecimalFormat;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import modelo.entidade.Entidade;

/**
 * <p>Classe de Modelo <b>Produto</b>.</p>
 * <p>Classe responsavel por representar os objetos da tabela <b>minaspar.produto</b>.</p>
 * @author Leandro
 * @since  12/01/2021
 * @see    modelo.entidade.Entidade
 */
@Entity
@Table (schema = "minaspar", name = "produto")
public class Produto extends Entidade {
    @Column (name = "descricao")
    private String  descricao;
    @Column (name = "codigo_barras")
    private String  codigoBarras;
    @Column (name = "tipo")
    private String  tipo;
    @Column (name = "valor_unitario")
    private Float   valorUnitario;

    /**
     * Metodo construtor padrao da Classe.
     */
    public Produto() {
        tipo          = "MEDICAMENTO";
        valorUnitario = 0.0f;
    }

    /**
     * Metodo responsavel por retornar a Descricao do Produto.
     * @return Descricao do Produto.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Metodo responsavel por definir a Descricao do Produto.
     * @param descricao Descricao do Produto.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Metodo responsavel por retornar o Codigo de Barras do Produto.
     * @return Codigo de Barras do Produto.
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * Metodo responsavel por definir o Codigo de Barras do Produto.
     * @param codigoBarras Codigo de Barras do Produto.
     */
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    /**
     * Metodo responsavel por retornar o Tipo do Produto.
     * @return Tipo do Produto.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo responsavel por definir o Tipo do Produto.
     * @param tipo Tipo do Produto.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo responsavel por retornar o Valor Unitario Formatado do Produto.
     * @return Valor Unitario Formatado do Produto.
     */
    public String getValorUnitarioFormatado() {
        return new DecimalFormat("R$ #,##0.00").format(valorUnitario);
    }
    
    /**
     * Metodo responsavel por retornar o Valor Unitario do Produto.
     * @return Valor Unitario do Produto.
     */
    public Float getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Metodo responsavel por definir o Valor Unitario do Produto.
     * @param valorUnitario Valor Unitario do Produto.
     */
    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    @Override
    public String[] getDadosPesquisa() {
        return getDados();
    }
    
    @Override
    public String[] getDados() {
        String[] dados    = new String[5];
                 dados[0] = Long.toString(id);
                 dados[1] = codigoBarras;
                 dados[2] = descricao;
                 dados[3] = tipo;
                 dados[4] = getValorUnitarioFormatado();
        return   dados;
    }

    @Override
    public int hashCode() {
        int    hash  = 0;
               hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto instanceof Produto == false)
            return false;
        return Objects.equals(id, ((Produto) objeto).getId());
    }

    @Override
    public String toString() {
        return id + " - " + descricao + " (" + codigoBarras + ") - " + getValorUnitarioFormatado();
    }
}