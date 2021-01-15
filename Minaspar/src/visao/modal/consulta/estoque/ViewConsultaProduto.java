package visao.modal.consulta.estoque;

import controlador.visao.modal.consulta.estoque.ControllerViewConsultaProduto;
import java.awt.Dimension;
import visao.estruturais.menu.ViewMenu;
import visao.modal.consulta.ViewConsulta;
import visao.painel.filtro.consulta.estoque.PanelFiltroProduto;

/**
 * <p>Classe de Visao <b>ViewConsultaProduto</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Consulta de Produto</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.modal.consulta.estoque.ControllerViewConsultaProduto
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.modal.consulta.ViewConsulta
 */
public final class ViewConsultaProduto extends ViewConsulta {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewConsultaProduto(ViewMenu view) {
        super(view);
        title      = "Consulta de Produtos";
        controller = new ControllerViewConsultaProduto(this);
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
    protected PanelFiltroProduto createFiltro() {
        return new PanelFiltroProduto(this);
    }
    
    @Override
    protected void setTableHeader() {
        super.setTableHeader();
        getScrollPane().setPreferredSize(new Dimension(900, 275));
        getTable().getColumnModel().getColumn(1).setCellRenderer(createRightRenderer());
        getTable().getColumnModel().getColumn(4).setCellRenderer(createRightRenderer());
    }
    
    @Override
    protected String[] getColumns() {
        return new String[] {"Id", "Cód. Barras", "Descrição", "Tipo", "Valor Unitário"};
    }
    
    @Override
    protected Integer[] getSizes() {
        return new Integer[] {50, 100, 250, 100, 125};
    }
    
    @Override
    protected void addTableFooter() {
        getContentPane().add(getSpace(10, 1000));
        getContentPane().add(super.getTableCount());
        getContentPane().add(getSpace(10, 1000));
    }

    @Override
    public PanelFiltroProduto getFiltro() {
        return (PanelFiltroProduto) super.getFiltro();
    }
}