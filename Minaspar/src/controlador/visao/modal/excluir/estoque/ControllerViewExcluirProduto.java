package controlador.visao.modal.excluir.estoque;

import controlador.visao.modal.excluir.ControllerViewExcluir;
import modelo.dao.estoque.DaoProduto;
import modelo.entidade.estoque.Produto;
import visao.modal.excluir.estoque.ViewExcluirProduto;
import visao.modal.mensagem.ViewMensagem;

/**
 * <p>Classe de Controle <b>ControllerViewExcluirProduto</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewExcluirProduto.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.modal.excluir.ControllerViewExcluir
 * @see    modelo.dao.estoque.DaoItem
 * @see    modelo.dao.estoque.DaoProduto
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.modal.excluir.es
 */
public class ControllerViewExcluirProduto extends ControllerViewExcluir {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Excluir Produto.
     */
    public ControllerViewExcluirProduto(ViewExcluirProduto view) {
        super(view);
    }
    
    @Override
    public void excluir() {
        Produto produto = getView().getProduto();
                produto.setAtivo(false);
        new DaoProduto().update(produto);
        new ViewMensagem(getView(), "Produto removido com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public ViewExcluirProduto getView() {
        return (ViewExcluirProduto) view;
    }
}