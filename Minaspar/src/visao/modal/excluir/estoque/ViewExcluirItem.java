package visao.modal.excluir.estoque;

import controlador.visao.modal.excluir.estoque.ControllerViewExcluirItem;
import java.awt.Dimension;
import modelo.entidade.estoque.Item;
import visao.modal.consulta.estoque.ViewConsultaItem;
import visao.modal.excluir.ViewExcluir;

/**
 * <p>Classe de Visao <b>ViewExluirItem</b>.</p>
 * <p>Classe responsavel por definir uma <b>Interface de Exclusao do Item de Estoque</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.excluir.estoque.ControllerViewExcluirItem
 * @see    modelo.entidade.estoque.Item
 * @see    visao.modal.excluir.ViewExcluir
 */
public final class ViewExcluirItem extends ViewExcluir {
    private final Item item;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Item.
     * @param item_ Item.
     */
    public ViewExcluirItem(ViewConsultaItem view, Item item_) {
        super(view);
        item       = item_;
        title      = "Excluir Item de Estoque";
        controller = new ControllerViewExcluirItem(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(700, 175));
    }
    
    @Override
    public void addBody() {
        super.addMessage(item.toString());
    }
    
    /**
     * Metodo responsavel por retornar o Item.
     * @return Item.
     */
    public Item getItem() {
        return item;
    }
}