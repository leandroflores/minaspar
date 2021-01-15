package controlador.visao.modal.excluir.estoque;

import controlador.visao.modal.excluir.ControllerViewExcluir;
import modelo.dao.estoque.DaoItem;
import modelo.entidade.estoque.Item;
import visao.modal.excluir.estoque.ViewExcluirItem;

/**
 * <p>Classe de Controle <b>ControllerViewExcluirItem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewExcluirItem.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.excluir.ControllerViewExcluir
 * @see    modelo.dao.estoque.DaoItem
 * @see    modelo.entidade.estoque.Item
 * @see    visao.modal.excluir.estoque.ViewExcluirItem
 */
public class ControllerViewExcluirItem extends ControllerViewExcluir {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Excluir Item.
     */
    public ControllerViewExcluirItem(ViewExcluirItem view) {
        super(view);
    }
    
    @Override
    public void excluir() {
        Item item = getView().getItem();
        new DaoItem().delete(item.getId());
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public ViewExcluirItem getView() {
        return (ViewExcluirItem) view;
    }
}