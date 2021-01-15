package controlador.visao.modal.editar.estoque;

import controlador.visao.modal.editar.ControllerViewEditar;
import modelo.dao.estoque.DaoItem;
import modelo.entidade.estoque.Item;
import visao.modal.editar.estoque.ViewEditarItem;
import visao.painel.base.estoque.PanelBaseItem;
import visao.painel.editar.estoque.PanelEditarItem;

/**
 * <p>Classe de Controle <b>ControllerViewEditarItem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewEditarItem.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.editar.ControllerViewEditar
 * @see    modelo.dao.estoque.DaoItem
 * @see    modelo.entidade.estoque.Item
 * @see    visao.modal.editar.estoque.ViewEditarItem
 */
public class ControllerViewEditarItem extends ControllerViewEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar Item.
     */
    public ControllerViewEditarItem(ViewEditarItem view) {
        super(view);
    }
    
    /**
     * Metodo responsavel por verificar se o Ano e valido.
     * @return Ano e valido.
     */
    public boolean checkAno() {
        return checkAno(getPanelBase().getTextFieldAno(), "Ano Inválido!");
    }
    
    /**
     * Metodo responsavel por validar o Valor Unitario.
     * @return Valor Unitario e valido.
     */
    public boolean checkValorUnitario() {
        return checkValor(getPanelBase().getTextFieldValorUnitario(), "Valor Unitário Inválido!");
    }
    
    @Override
    public boolean check() {
        return checkAno()
            && checkValorUnitario();
    }
    
    /**
     * Metodo responsavel por retornar o Valor Total do Item.
     * @return Valor Total do Item.
     */
    private Float getValorTotal() {
        Integer quantidade = (Integer) getPanelBase().getSpinnerQuantidade().getValue();
        Float   valor      = getFloat(getPanelBase().getTextFieldValorUnitario());
        return  quantidade * valor;
    }
    
    @Override
    public void salvar() {
        Item item = getView().getItem();
             item.setAno(getInteger(getPanelBase().getTextFieldAno()));
             item.setValorUnitario(getFloat(getPanelBase().getTextFieldValorUnitario()));
             item.setQuantidade((Integer) getPanelBase().getSpinnerQuantidade().getValue());
             item.setValorTotal(getValorTotal());
        new DaoItem().update(item);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public PanelBaseItem getPanelBase() {
        return getPanelEditar().getPanelBaseItem();
    }
    
    @Override
    public PanelEditarItem getPanelEditar() {
        return getView().getPanelEditar();
    }
    
    @Override
    public ViewEditarItem getView() {
        return (ViewEditarItem) view;
    }
}