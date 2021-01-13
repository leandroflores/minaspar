package controlador.visao.modal.editar.estoque;

import controlador.visao.modal.editar.ControllerViewEditar;
import modelo.dao.estoque.DaoProduto;
import modelo.entidade.estoque.Produto;
import visao.modal.editar.estoque.ViewEditarProduto;
import visao.painel.base.estoque.PanelBaseProduto;
import visao.painel.editar.estoque.PanelEditarProduto;

/**
 * <p>Classe de Controle <b>ControllerViewEditarProduto</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewEditarProduto.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.modal.editar.ControllerViewEditar
 * @see    modelo.dao.estoque.DaoProduto
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.modal.editar.estoque.ViewEditarProduto
 */
public class ControllerViewEditarProduto extends ControllerViewEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar Produto.
     */
    public ControllerViewEditarProduto(ViewEditarProduto view) {
        super(view);
    }
    
    /**
     * Metodo responsavel por validar o Codigo de Barras do Produto.
     * @return Codigo de Barras do Produto e valido.
     */
    public boolean checkCodigoBarras() {
        return checkNumero(getPanelBase().getTextFieldCodigoBarras(), "Código de Barras Inválido!");
    }
    
    /**
     * Metodo responsavel por validar a Descricao do Produto.
     * @return Descricao do Produto e valida.
     */
    public boolean checkDescricao() {
        return check(getPanelBase().getTextFieldDescricao(), "Descrição Inválida!");
    }
    
    /**
     * Metodo responsavel por validar o Valor Unitario do Produto.
     * @return Valor Unitario do Produto e valido.
     */
    public boolean checkValorUnitario() {
        return checkValor(getPanelBase().getTextFieldValorUnitario(), "Valor Unitário Inválido!");
    }
    
    @Override
    public boolean check() {
        return checkCodigoBarras()
            && checkDescricao()
            && checkValorUnitario();
    }
    
    @Override
    public void salvar() {
        Produto produto = getView().getProduto();
                produto.setCodigoBarras(getString(getPanelBase().getTextFieldCodigoBarras()));
                produto.setDescricao(getString(getPanelBase().getTextFieldDescricao()).toUpperCase());
                produto.setTipo(getValor(getPanelBase().getComboBoxTipo()));
                produto.setValorUnitario(getFloat(getPanelBase().getTextFieldValorUnitario()));        
        new DaoProduto().update(produto);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public PanelBaseProduto getPanelBase() {
        return getPanelEditar().getPanelBaseProduto();
    }
    
    @Override
    public PanelEditarProduto getPanelEditar() {
        return getView().getPanelEditar();
    }
    
    @Override
    public ViewEditarProduto getView() {
        return (ViewEditarProduto) view;
    }
}