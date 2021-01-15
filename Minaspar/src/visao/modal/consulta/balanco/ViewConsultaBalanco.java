package visao.modal.consulta.balanco;

import controlador.visao.modal.consulta.balanco.ControllerViewConsultaBalanco;
import java.awt.Dimension;
import visao.estruturais.menu.ViewMenu;
import visao.modal.consulta.ViewConsulta;
import visao.painel.consulta.filtro.balanco.PanelFiltroBalanco;

/**
 * <p>Classe de Visao <b>ViewConsultaBalanco</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Consulta do Balanco</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.consulta.balanco.ControllerViewConsultaBalanco
 * @see    modelo.entidade.estoque.Item
 * @see    visao.modal.consulta.ViewConsulta
 */
public final class ViewConsultaBalanco extends ViewConsulta {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewConsultaBalanco(ViewMenu view) {
        super(view);
        title      = "Balanço do Estoque";
        controller = new ControllerViewConsultaBalanco(this);
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
    protected PanelFiltroBalanco createFiltro() {
        return new PanelFiltroBalanco(this);
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
    public PanelFiltroBalanco getFiltro() {
        return (PanelFiltroBalanco) super.getFiltro();
    }
}