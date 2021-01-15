package modelo.entidade.estoque;

import funct.FunctDate;
import java.text.DecimalFormat;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import modelo.entidade.Entidade;

/**
 * <p>Classe de Modelo <b>Item</b>.</p>
 * <p>Classe responsavel por representar os objetos da tabela <b>minaspar.item_produto</b>.</p>
 * @author Leandro
 * @since  12/01/2021
 * @see    modelo.entidade.Entidade
 * @see    modelo.entidade.estoque.Produto
 */
@Entity
@Table (schema = "minaspar_final", name = "item_produto")
public class Item extends Entidade {
    @JoinColumn (name = "id_produto")
    @ManyToOne
    private Produto produto;
    @Column (name = "ano_referencia")
    private Integer ano;
    @Column (name = "quantidade")
    private Integer quantidade;
    @Column (name = "valor_unitario")
    private Float   valorUnitario;
    @Column (name = "valor_total")
    private Float   valorTotal;
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public Item() {
        produto       = null;
        ano           = 2020;
        quantidade    = 0;
        valorUnitario = 0.0f;
        valorTotal    = 0.0f;
    }
    
    /**
     * Metodo construtor alternativo da Classe.
     * @param ano Ano de Referencia.
     */
    public Item(Integer ano) {
        this();
        this.ano = ano;
    }
    
    /**
     * Metodo responsavel por retornar o Produto do Item.
     * @return Produto do Item.
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Metodo responsavel por definir o Produto do Item.
     * @param produto Produto do Item.
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Metodo responsavel por retornar o Ano de Referencia do Item.
     * @return 
     */
    public Integer getAno() {
        return ano;
    }

    /**
     * Metodo responsavel por definir o Ano de Referencia do Item.
     * @param ano Ano de Referencia do Item.
     */
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    /**
     * Metodo responsavel por retornar a Quantidade do Item.
     * @return Quantidade do Item.
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * Metodo responsavel por definir a Quantidade do Item.
     * @param quantidade Quantidade do Item.
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    /**
     * Metodo responsavel por retornar o Valor Unitario do Item.
     * @return Valor Unitario do Item.
     */
    public Float getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Metodo responsavel por retornar o Valor Unitario Formatado do Item.
     * @return Valor Unitario Formatado do Item.
     */
    public String getValorUnitarioFormatado() {
        return new DecimalFormat("R$ #,##0.00").format(valorUnitario);
    }
    
    /**
     * Metodo responsavel por definir o Valor Unitario do Item.
     * @param valorUnitario Valor Unitario do Item.
     */
    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * Metodo responsavel por retornar o Valor Total do Item.
     * @return Valor Total do Item.
     */
    public Float getValorTotal() {
        return valorTotal;
    }

    /**
     * Metodo responsavel por retornar o Valor Total Formatado do Item.
     * @return Valor Unitario Total do Item.
     */
    public String getValorTotalFormatado() {
        return new DecimalFormat("R$ #,##0.00").format(valorTotal);
    }
    
    /**
     * Metodo responsavel por definir o Valor Total do Item.
     * @param valorTotal Valor Total do Item.
     */
    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    /**
     * Metodo responsavel por retornar o Token de Exportacao do Item.
     * @return Token de Exportacao do Item.
     */
    public String getToken() {
        return ano + "|" + 
               produto.getCodigoBarras() + "|" + 
               quantidade + "|" + 
               valorUnitario + "|" +
               valorTotal + "|" +
               new FunctDate().getFormattedDate(dataCadastro);
    }

    @Override
    public String[] getDadosPesquisa() {
        return getDados();
    }
    
    @Override
    public String[] getDados() {
        String[] item    = new String[7];
                 item[0] = Long.toString(id);
                 item[1] = Integer.toString(ano);
                 item[2] = produto.getCodigoBarras();
                 item[3] = produto.getDescricao();
                 item[4] = getValorUnitarioFormatado();
                 item[5] = Integer.toString(quantidade);
                 item[6] = getValorTotalFormatado();
        return   item;
    }

    @Override
    public int hashCode() {
        int    hash  = 0;
               hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object objeto) {
        if (objeto instanceof Item == false)
            return false;
        return Objects.equals(id, ((Item) objeto).getId());
    }

    @Override
    public String toString() {
        return id + " - " + produto + " (" + ano + ")";
    }
}