package visao.painel.novo.estoque;

import controlador.visao.painel.novo.estoque.ControllerPanelNovoItem;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import modelo.entidade.estoque.Item;
import visao.modal.novo.ViewNovo;
import visao.painel.base.estoque.PanelBaseItem;
import visao.painel.novo.PanelNovo;

/**
 * <p>Classe de Visao <b>PanelNovoItem</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewNovoItem</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.painel.novo.estoque.ControllerPanelNovoItem
 * @see    modelo.entidade.estoque.Item
 * @see    visao.painel.novo.PanelNovo
 */
public final class PanelNovoItem extends PanelNovo {
    private Item item;
    protected JTabbedPane tabbedPane;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo.
     */
    public PanelNovoItem(ViewNovo view) {
        super(view);
        item       = new Item();
        controller = new ControllerPanelNovoItem(this);
        setProperties();
        addComponents();
    }

    @Override
    protected void setProperties() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(750, 300));
    }
    
    @Override
    protected void addComponents() {
        addPanels();
        add(tabbedPane);
    }
    
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
    
    @Override
    public void clear() {
        item = new Item();
        getPanelBaseItem().setValues();
        getPanelBaseItem().getTextFieldCodigoBarras().requestFocus();
    }
    
    /**
     * Metodo responsavel por retornar o Panel Base Item.
     * @return Panel Base Item.
     */
    public PanelBaseItem getPanelBaseItem() {
        return (PanelBaseItem) getPanel("base_item");
    }
}