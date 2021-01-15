package visao.painel.editar.estoque;

import controlador.visao.painel.editar.estoque.ControllerPanelEditarItem;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import modelo.entidade.estoque.Item;
import visao.modal.editar.ViewEditar;
import visao.painel.base.estoque.PanelBaseItem;
import visao.painel.editar.PanelEditar;

/**
 * <p>Classe de Visao <b>PanelEditarItem</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewEditarItem</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.painel.editar.estoque.ControllerPanelEditarItem
 * @see    modelo.entidade.estoque.Item
 * @see    visao.painel.editar.PanelEditar
 */
public final class PanelEditarItem extends PanelEditar {
    private final Item item;
    protected JTabbedPane tabbedPane;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar.
     * @param item_ Item.
     */
    public PanelEditarItem(ViewEditar view, Item item_) {
        super(view);
        item       = item_;
        controller = new ControllerPanelEditarItem(this);
        setProperties();
        addComponents();
        updatePanelBase();
        getController().setReady();
    }

    @Override
    protected void setProperties() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(670, 300));
    }
    
    @Override
    protected void addComponents() {
        addPanels();
        add(tabbedPane);
    }
    
    @Override
    protected void addPanels() {
        addPanelBaseItem();
    }
    
    /**
     * Metodo responsavel por adicionar o Panel Base Item.
     */
    public void addPanelBaseItem() {
        addPanel("base_item", new PanelBaseItem(this, item));
        createScrollPane("base_item",  getPanelBaseItem());
        getScrollPane("base_item").setViewportView(getPanelBaseItem());
        tabbedPane.add("Item", getScrollPane("base_item"));
    }
    
    /**
     * Metodo responsavel por atualizar o Panel Base Item.
     */
    private void updatePanelBase() {
        getPanelBaseItem().getButtonPesquisaProduto().setVisible(false);
        getPanelBaseItem().getTextFieldCodigoBarras().setEditable(false);
        getPanelBaseItem().getTextFieldDescricao().setEditable(false);
    }
    
    /**
     * Metodo responsavel por retornar o Panel Base Item.
     * @return Panel Base Item.
     */
    public PanelBaseItem getPanelBaseItem() {
        return (PanelBaseItem) getPanel("base_item");
    }
}