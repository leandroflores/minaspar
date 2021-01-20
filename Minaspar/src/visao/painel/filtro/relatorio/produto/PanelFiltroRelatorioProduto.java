package visao.painel.filtro.relatorio.produto;

import controlador.visao.painel.filtro.ControllerPanelFiltro;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import modelo.entidade.estoque.Produto;
import visao.modal.relatorio.produto.ViewRelatorioProduto;
import visao.painel.filtro.PanelFiltro;

/**
 * <p>Classe de Visao <b>PanelFiltroRelatorioProduto</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Filtro de Relatorio do Produto</b> do Sistema.</p>
 * @author Leandro
 * @since  19/01/2021
 * @see    controlador.visao.painel.filtro.ControllerPanelFiltro
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.painel.filtro.PanelFiltro
 */
public final class PanelFiltroRelatorioProduto extends PanelFiltro {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Relatorio Produto.
     */
    public PanelFiltroRelatorioProduto(ViewRelatorioProduto view) {
        super(view);
        controller = new ControllerPanelFiltro(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    protected void addComponents() {
        add(createLabel("Cód. de Barras: ", 125));
        add(createTextField("codigo_barras", "", 10));
        add(createLabel("Produto: ", 90));
        add(createTextFieldNoEditable("produto", "", 20));
        add(createButton("pesquisa", "", "pesquisa"));
        add(createButtonAtualizar());
    }
    
    /**
     * Metodo responsavel por definir o Produto.
     * @param produto Produto.
     */
    public void setProduto(Produto produto) {
        getTextFieldCodigoBarras().setText(produto != null ? produto.getCodigoBarras() : getTextFieldCodigoBarras().getText());
        getTextFieldProduto().setText(produto != null ? produto.getDescricao() : "");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Codigo de Barras.
     * @return Text Field Codigo de Barras.
     */
    public JTextField getTextFieldCodigoBarras() {
        return getTextField("codigo_barras");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Produto.
     * @return Text Field Produto.
     */
    public JTextField getTextFieldProduto() {
        return getTextField("produto");
    }
    
    /**
     * Metodo responsavel por retornar o Button Pesquisa.
     * @return Button Pesquisa.
     */
    public JButton getButtonPesquisa() {
        return getButton("pesquisa");
    }
}