package visao.painel.novo.estoque;

import controlador.visao.painel.novo.estoque.ControllerPanelNovoProduto;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import modelo.entidade.estoque.Produto;
import visao.modal.novo.ViewNovo;
import visao.painel.base.estoque.PanelBaseProduto;
import visao.painel.novo.PanelNovo;

/**
 * <p>Classe de Visao <b>PanelNovoProduto</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewNovoProduto</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.painel.novo.estoque.ControllerPanelNovoProduto
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.painel.novo.PanelNovo
 */
public final class PanelNovoProduto extends PanelNovo {
    private Produto produto;
    protected JTabbedPane tabbedPane;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo.
     */
    public PanelNovoProduto(ViewNovo view) {
        super(view);
        produto    = new Produto();
        controller = new ControllerPanelNovoProduto(this);
        setProperties();
        addComponents();
    }

    @Override
    protected void setProperties() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(475, 230));
    }
    
    @Override
    protected void addComponents() {
        addPanels();
        add(tabbedPane);
    }
    
    protected void addPanels() {
        addPanelBaseProduto();
    }
    
    /**
     * Metodo responsavel por adicionar o Panel Base Produto.
     */
    public void addPanelBaseProduto() {
        addPanel("base_produto", new PanelBaseProduto(this, produto));
        createScrollPane("base_produto",  getPanelBaseProduto());
        getScrollPane("base_produto").setViewportView(getPanelBaseProduto());
        tabbedPane.add("Produto", getScrollPane("base_produto"));
    }
    
    @Override
    public void clear() {
        produto = new Produto();
        getPanelBaseProduto().setValues();
    }
    
    /**
     * Metodo responsavel por retornar o Panel Base Produto.
     * @return Panel Base Produto.
     */
    public PanelBaseProduto getPanelBaseProduto() {
        return (PanelBaseProduto) getPanel("base_produto");
    }
}