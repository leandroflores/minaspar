package visao.modal.consulta.estoque;

import controlador.visao.modal.consulta.estoque.ControllerViewConsultaItem;
import java.awt.Dimension;
import visao.estruturais.menu.ViewMenu;
import visao.modal.consulta.ViewConsulta;
import visao.painel.filtro.consulta.estoque.PanelFiltroItem;

/**
 * <p>Classe de Visao <b>ViewConsultaItem</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Consulta de Item</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.consulta.estoque.ControllerViewConsultaItem
 * @see    modelo.entidade.estoque.Item
 * @see    visao.modal.consulta.ViewConsulta
 */
public final class ViewConsultaItem extends ViewConsulta {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewConsultaItem(ViewMenu view) {
        super(view);
        title      = "Consulta de Itens de Estoque";
        controller = new ControllerViewConsultaItem(this);
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
    protected PanelFiltroItem createFiltro() {
        return new PanelFiltroItem(this);
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
        getContentPane().add(getSpace(10, 1000));
    }

    @Override
    public PanelFiltroItem getFiltro() {
        return (PanelFiltroItem) super.getFiltro();
    }
}