package visao.modal.novo.estoque;

import controlador.visao.modal.novo.estoque.ControllerViewNovoProduto;
import java.awt.Dimension;
import visao.modal.ViewModal;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.estoque.PanelNovoProduto;

/**
 * <p>Classe de Visao <b>ViewNovoProduto</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Novo Produto</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.modal.novo.estoque.ControllerViewNovoProduto
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.modal.novo.ViewNovo
 */
public final class ViewNovoProduto extends ViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewNovoProduto(ViewModal view) {
        super(view);
        title      = "Cadastro de Produto";
        controller = new ControllerViewNovoProduto(this);
        setProperties();
        addComponents();
        clear();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(550, 400));
    }
    
    @Override
    protected PanelNovoProduto createPanelNovo() {
        return new PanelNovoProduto(this);
    }
    
    @Override
    public PanelNovoProduto getPanelNovo() {
        return (PanelNovoProduto) super.getPanelNovo();
    }
}