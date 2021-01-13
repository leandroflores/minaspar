package visao.modal.excluir.estoque;

import controlador.visao.modal.excluir.estoque.ControllerViewExcluirProduto;
import java.awt.Dimension;
import modelo.entidade.estoque.Produto;
import visao.modal.consulta.estoque.ViewConsultaProduto;
import visao.modal.excluir.ViewExcluir;

/**
 * <p>Classe de Visao <b>ViewExluirProduto</b>.</p>
 * <p>Classe responsavel por definir uma <b>Interface de Exclusao do Produto</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.modal.excluir.estoque.ControllerViewExcluirProduto
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.modal.excluir.ViewExcluir
 */
public final class ViewExcluirProduto extends ViewExcluir {
    private final Produto produto;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Produto.
     * @param produto_ Produto.
     */
    public ViewExcluirProduto(ViewConsultaProduto view, Produto produto_) {
        super(view);
        produto     = produto_;
        title       = "Excluir Produto";
        controller  = new ControllerViewExcluirProduto(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(650, 165));
    }
    
    @Override
    public void addBody() {
        super.addMessage(produto.toString());
    }
    
    /**
     * Metodo responsavel por retornar o Produto.
     * @return Produto.
     */
    public Produto getProduto() {
        return produto;
    }
}