package visao.modal.relatorio.balanco;

import controlador.visao.modal.relatorio.balanco.ControllerViewRelatorioBalanco;
import java.awt.Dimension;
import visao.estruturais.menu.ViewMenu;
import visao.modal.relatorio.ViewRelatorio;
import visao.painel.filtro.relatorio.PanelFiltroRelatorio;

/**
 * <p>Classe de Visao <b>ViewRelatorioBalanco</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Relatorio do Balanco</b> do Sistema.</p>
 * @author Leandro
 * @since  15/01/2021
 * @see    controlador.visao.modal.relatorio.balanco.ControllerViewRelatorioBalanco
 * @see    modelo.entidade.estoque.Item
 * @see    visao.modal.relatorio.ViewRelatorio
 */
public final class ViewRelatorioBalanco extends ViewRelatorio {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewRelatorioBalanco(ViewMenu view) {
        super(view);
        title      = "Relatório do Balanço";
        controller = new ControllerViewRelatorioBalanco(this);
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
    protected PanelFiltroRelatorio createFiltro() {
        return new PanelFiltroRelatorio(this);
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
    public PanelFiltroRelatorio getFiltro() {
        return (PanelFiltroRelatorio) super.getFiltro();
    }
}