package controlador.visao.modal.novo.estoque;

import controlador.visao.modal.novo.ControllerViewNovo;
import modelo.dao.estoque.DaoProduto;
import modelo.entidade.estoque.Produto;
import visao.modal.novo.estoque.ViewNovoProduto;
import visao.painel.base.estoque.PanelBaseProduto;
import visao.painel.novo.estoque.PanelNovoProduto;

/**
 * <p>Classe de Controle <b>ControllerViewNovoProduto</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewNovoProduto.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.modal.novo.ControllerViewNovo
 * @see    modelo.dao.estoque.DaoProduto
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.modal.novo.estoque.ViewNovoProduto
 */
public class ControllerViewNovoProduto extends ControllerViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo Produto.
     */
    public ControllerViewNovoProduto(ViewNovoProduto view) {
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
    public void inserir() {
        Produto produto = new Produto();
                produto.setCodigoBarras(getString(getPanelBase().getTextFieldCodigoBarras()));
                produto.setDescricao(getString(getPanelBase().getTextFieldDescricao()).toUpperCase());
                produto.setValorUnitario(getFloat(getPanelBase().getTextFieldValorUnitario()));
        new DaoProduto().insert(produto);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public PanelBaseProduto getPanelBase() {
        return getPanelNovo().getPanelBaseProduto();
    }
    
    @Override
    public PanelNovoProduto getPanelNovo() {
        return getView().getPanelNovo();
    }
    
    @Override
    public ViewNovoProduto getView() {
        return (ViewNovoProduto) view;
    }
}