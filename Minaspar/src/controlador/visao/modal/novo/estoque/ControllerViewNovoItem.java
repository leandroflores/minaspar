package controlador.visao.modal.novo.estoque;

import controlador.visao.modal.novo.ControllerViewNovo;
import java.awt.event.ActionEvent;
import modelo.dao.estoque.DaoItem;
import modelo.dao.estoque.DaoProduto;
import modelo.entidade.estoque.Item;
import visao.modal.mensagem.ViewErro;
import visao.modal.novo.estoque.ViewNovoItem;
import visao.modal.pesquisa.estoque.ViewPesquisaProduto;
import visao.painel.base.estoque.PanelBaseItem;
import visao.painel.novo.estoque.PanelNovoItem;

/**
 * <p>Classe de Controle <b>ControllerViewNovoItem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewNovoItem.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.novo.ControllerViewNovo
 * @see    modelo.dao.estoque.DaoItem
 * @see    modelo.entidade.estoque.Item
 * @see    visao.modal.novo.estoque.ViewNovoItem
 */
public class ControllerViewNovoItem extends ControllerViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo Item.
     */
    public ControllerViewNovoItem(ViewNovoItem view) {
        super(view);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getPanelBase().getButtonPesquisaProduto().equals(event.getSource()))
            new ViewPesquisaProduto(getView()).setVisible(true);
    }
    
    /**
     * Metodo responsavel por verificar se o Ano e valido.
     * @return Ano e valido.
     */
    public boolean checkAno() {
        return checkAno(getPanelBase().getTextFieldAno(), "Ano Inválido!");
    }
    
    /**
     * Metodo responsavel por verificar se o Produto foi selecionado.
     * @return Produto foi selecionado.
     */
    public boolean checkProduto() {
        if (getPanelBase().getProduto() == null) {
            new ViewErro(getView(), "Selecione um Produto!").setVisible(true);
            return false;
        }
        return true;
    }
    
    /**
     * Metodo responsavel por validar a Descricao.
     * @return Descricao e valida.
     */
    public boolean checkDescricao() {
        return check(getPanelBase().getTextFieldDescricao(), "Descrição Inválida!");
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
            && checkProduto()
            && checkDescricao()
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
    
    /**
     * Metodo responsavel por atualizar os dados do Produto.
     */
    private void updateProduto() {
        getPanelBase().getProduto().setDescricao(getString(getPanelBase().getTextFieldDescricao()));
        getPanelBase().getProduto().setValorUnitario(getFloat(getPanelBase().getTextFieldValorUnitario()));
        new DaoProduto().update(getPanelBase().getProduto());
    }
    
    @Override
    public void inserir() {
        Item item = new Item();
             item.setProduto(getPanelBase().getProduto());
             item.setAno(getInteger(getPanelBase().getTextFieldAno()));
             item.setValorUnitario(getFloat(getPanelBase().getTextFieldValorUnitario()));
             item.setQuantidade((Integer) getPanelBase().getSpinnerQuantidade().getValue());
             item.setValorTotal(getValorTotal());
        updateProduto();
        new DaoItem().insert(item);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public PanelBaseItem getPanelBase() {
        return getPanelNovo().getPanelBaseItem();
    }
    
    @Override
    public PanelNovoItem getPanelNovo() {
        return getView().getPanelNovo();
    }
    
    @Override
    public ViewNovoItem getView() {
        return (ViewNovoItem) view;
    }
}