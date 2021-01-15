package visao.modal.editar.estoque;

import controlador.visao.modal.editar.estoque.ControllerViewEditarItem;
import java.awt.Dimension;
import modelo.entidade.estoque.Item;
import visao.modal.consulta.balanco.ViewConsultaBalanco;
import visao.modal.consulta.estoque.ViewConsultaItem;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.estoque.PanelEditarItem;

/**
 * <p>Classe de Visao <b>ViewEditarItem</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Edicao do Item de Estoque</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.editar.estoque.ControllerViewEditarItem
 * @see    modelo.entidade.estoque.Item
 * @see    visao.editar.ViewEditar
 */
public final class ViewEditarItem extends ViewEditar {
    private final Item item;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Item.
     * @param item_ Item.
     */
    public ViewEditarItem(ViewConsultaItem view, Item item_) {
        super(view);
        item       = item_;
        title      = "Editar Item de Estoque";
        controller = new ControllerViewEditarItem(this);
        setProperties();
        addComponents();
    }
    
    /**
     * Metodo construtor alternativo da Classe.
     * @param view View Consulta Balanco.
     * @param item_ Item.
     */
    public ViewEditarItem(ViewConsultaBalanco view, Item item_) {
        super(view);
        item       = item_;
        title      = "Editar Item de Estoque";
        controller = new ControllerViewEditarItem(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(740, 425));
    }
    
    /**
     * Metodo responsavel por retornar o Item.
     * @return Item.
     */
    public Item getItem() {
        return item;
    }
    
    @Override
    protected PanelEditarItem createPanel() {
        return new PanelEditarItem(this, item);
    }
    
    @Override
    public PanelEditarItem getPanelEditar() {
        return (PanelEditarItem) super.getPanelEditar();
    }
}