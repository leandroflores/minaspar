package visao.painel.editar.estoque;

import controlador.visao.painel.editar.estoque.ControllerPanelEditarProduto;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import modelo.entidade.estoque.Produto;
import visao.modal.editar.ViewEditar;
import visao.painel.base.estoque.PanelBaseProduto;
import visao.painel.editar.PanelEditar;

/**
 * <p>Classe de Visao <b>PanelEditarProduto</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewEditarProduto</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.painel.editar.estoque.ControllerPanelEditarProduto
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.painel.editar.PanelEditar
 */
public final class PanelEditarProduto extends PanelEditar {
    private final Produto produto;
    protected JTabbedPane tabbedPane;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar.
     * @param produto_ Produto.
     */
    public PanelEditarProduto(ViewEditar view, Produto produto_) {
        super(view);
        produto    = produto_;
        controller = new ControllerPanelEditarProduto(this);
        setProperties();
        addComponents();
        getController().setReady();
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
    
    /**
     * Metodo responsavel por retornar o Panel Base Produto.
     * @return Panel Base Produto.
     */
    public PanelBaseProduto getPanelBaseProduto() {
        return (PanelBaseProduto) getPanel("base_produto");
    }
}