package visao.modal.pesquisa.estoque;

import controlador.visao.modal.pesquisa.estoque.ControllerViewPesquisaProduto;
import java.awt.Dimension;
import visao.modal.ViewModal;
import visao.modal.pesquisa.ViewPesquisa;
import visao.painel.pesquisa.estoque.PanelPesquisaProduto;

/**
 * <p>Classe de Visao <b>ViewPesquisaProduto</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Pesquisa de Produto</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.pesquisa.estoque.ControllerViewPesquisaProduto
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.modal.pesquisa.ViewPesquisa
 */
public final class ViewPesquisaProduto extends ViewPesquisa {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewPesquisaProduto(ViewModal view) {
        super(view);
        title      = "Pesquisa de Produtos";
        controller = new ControllerViewPesquisaProduto(this);
        setProperties();
        addComponents();
        update();
    }

    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(750, 425));
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getSpace(20, 750));
        addPanel("panel_pesquisa", new PanelPesquisaProduto(this));
        getContentPane().add(getPanelPesquisa());
        getContentPane().add(getSpace(10, 750));
    }
    
    @Override
    protected void setTableHeader() {
        super.setTableHeader();
        getScrollPane().setPreferredSize(new Dimension(700, 275));
        getScrollPane().setMaximumSize(new Dimension(700, 275));
    }
    
    @Override
    protected String[] getColumns() {
        return new String[] {"Id", "Tipo", "Cód. Barras", "Descrição", "Valor Unitário"};
    }
    
    @Override
    protected Integer[] getSizes() {
        return new Integer[] {50, 100, 150, 150, 100};
    }
    
    @Override
    public PanelPesquisaProduto getPanelPesquisa() {
        return (PanelPesquisaProduto) getPanel("panel_pesquisa");
    }
}