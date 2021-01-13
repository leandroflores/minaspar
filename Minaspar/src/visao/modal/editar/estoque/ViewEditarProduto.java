package visao.modal.editar.estoque;

import controlador.visao.modal.editar.estoque.ControllerViewEditarProduto;
import java.awt.Dimension;
import modelo.entidade.estoque.Produto;
import visao.modal.consulta.estoque.ViewConsultaProduto;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.estoque.PanelEditarProduto;

/**
 * <p>Classe de Visao <b>ViewEditarProduto</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Edicao do Produto</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.modal.editar.estoque.ControllerViewEditarProduto
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.editar.ViewEditar
 */
public final class ViewEditarProduto extends ViewEditar {
    private final Produto produto;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Produto.
     * @param produto_ Produto.
     */
    public ViewEditarProduto(ViewConsultaProduto view, Produto produto_) {
        super(view);
        produto    = produto_;
        title      = "Editar Produto";
        controller = new ControllerViewEditarProduto(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(550, 330));
    }
    
    /**
     * Metodo responsavel por retornar o Produto.
     * @return Produto.
     */
    public Produto getProduto() {
        return produto;
    }
    
    @Override
    protected PanelEditarProduto createPanel() {
        return new PanelEditarProduto(this, produto);
    }
    
    @Override
    public PanelEditarProduto getPanelEditar() {
        return (PanelEditarProduto) super.getPanelEditar();
    }
}