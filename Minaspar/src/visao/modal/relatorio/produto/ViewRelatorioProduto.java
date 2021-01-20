package visao.modal.relatorio.produto;

import controlador.visao.modal.relatorio.produto.ControllerViewRelatorioProduto;
import java.awt.Dimension;
import modelo.entidade.estoque.Produto;
import visao.estruturais.menu.ViewMenu;
import visao.interfaces.Searchable;
import visao.modal.relatorio.ViewRelatorio;
import visao.painel.filtro.relatorio.produto.PanelFiltroRelatorioProduto;

/**
 * <p>Classe de Visao <b>ViewRelatorioProduto</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Relatorio do Produto</b> do Sistema.</p>
 * @author Leandro
 * @since  19/01/2021
 * @see    controlador.visao.modal.relatorio.produto.ControllerViewRelatorioProduto
 * @see    modelo.entidade.estoque.Item
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.interfaces.Searchable
 * @see    visao.modal.relatorio.ViewRelatorio
 */
public final class ViewRelatorioProduto extends ViewRelatorio implements Searchable {
    private Produto produto;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewRelatorioProduto(ViewMenu view) {
        super(view);
        produto    = null;
        title      = "Relatório do Produto";
        controller = new ControllerViewRelatorioProduto(this);
        setProperties();
        addComponents();
        update();
    }

    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(1000, 530));
    }
    
    @Override
    protected PanelFiltroRelatorioProduto createFiltro() {
        return new PanelFiltroRelatorioProduto(this);
    }
    
    @Override
    protected void setTableHeader() {
        super.setTableHeader();
        getScrollPane().setPreferredSize(new Dimension(900, 275));
        getTable().getColumnModel().getColumn(1).setCellRenderer(createRightRenderer());
        getTable().getColumnModel().getColumn(2).setCellRenderer(createRightRenderer());
        getTable().getColumnModel().getColumn(4).setCellRenderer(createRightRenderer());
        getTable().getColumnModel().getColumn(5).setCellRenderer(createRightRenderer());
        getTable().getColumnModel().getColumn(6).setCellRenderer(createRightRenderer());
    }
    
    @Override
    protected String[] getColumns() {
        return new String[] {"Id", "Ano", "Cód. Barras", "Descrição", "Valor Unitário", "Quantidade", "Valor Total"};
    }
    
    @Override
    protected Integer[] getSizes() {
        return new Integer[] {50, 50, 100, 250, 100, 100, 100};
    }
    
    @Override
    protected void addTableFooter() {
        getContentPane().add(getSpace(10, 1000));
        getContentPane().add(super.getTableCount());
        getContentPane().add(super.getTableTotal());
        getContentPane().add(getSpace(10, 1000));
    }

    @Override
    public PanelFiltroRelatorioProduto getFiltro() {
        return (PanelFiltroRelatorioProduto) super.getFiltro();
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Produto) 
            produto = (Produto) value;
        else if (value == null) 
            produto = null;
        getFiltro().setProduto(produto);
    }
    
    /**
     * Metodo responsavel por retornar o Produto.
     * @return Produto.
     */
    public Produto getProduto() {
        return produto;
    }
}