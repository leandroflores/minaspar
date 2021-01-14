package visao.modal.novo.estoque;

import controlador.visao.modal.novo.estoque.ControllerViewNovoItem;
import java.awt.Dimension;
import modelo.entidade.estoque.Produto;
import visao.interfaces.Searchable;
import visao.modal.ViewModal;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.estoque.PanelNovoItem;

/**
 * <p>Classe de Visao <b>ViewNovoItem</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Novo Item de Estoque</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.novo.estoque.ControllerViewNovoItem
 * @see    modelo.entidade.estoque.Item
 * @see    visao.interfaces.Searchable
 * @see    visao.modal.novo.ViewNovo
 */
public final class ViewNovoItem extends ViewNovo implements Searchable {
    private Produto produto;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewNovoItem(ViewModal view) {
        super(view);
        produto    = null;
        title      = "Cadastro de Item de Estoque";
        controller = new ControllerViewNovoItem(this);
        setProperties();
        addComponents();
        clear();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(740, 460));
    }
    
    /**
     * Metodo responsavel por retornar o Produto.
     * @return Produto.
     */
    public Produto getProduto() {
        return produto;
    }
    
    @Override
    public void setValue(Object value) {
        if (value instanceof Produto) {
            produto = (Produto) value;
            getPanelNovo().getPanelBaseItem().setProduto(produto);
        }
    }
    
    @Override
    protected PanelNovoItem createPanelNovo() {
        return new PanelNovoItem(this);
    }
    
    @Override
    public PanelNovoItem getPanelNovo() {
        return (PanelNovoItem) super.getPanelNovo();
    }
}