package visao.modal.relatorio;

import controlador.visao.interfaces.Updatable;
import controlador.visao.modal.relatorio.ControllerViewRelatorio;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import visao.View;
import visao.modal.ViewModal;
import visao.painel.filtro.PanelFiltro;

/**
 * <p>Classe de Visao <b>ViewRelatorio</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Relatorio</b> do Sistema.</p>
 * @author Leandro
 * @since  15/01/2021
 * @see    controlador.visao.interfaces.Updatable
 * @see    controlador.visao.modal.relatorio.ControllerViewRelatorio
 * @see    visao.modal.ViewModal
 */
public abstract class ViewRelatorio extends ViewModal implements Updatable {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View do Sistema.
     */
    public ViewRelatorio(View view) {
        super(view);
    }
    
    @Override
    public void setProperties() {
        updateTitle();
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }
    
    @Override
    public void addComponents() {
        addHeader();
        addBody();
        addFooter();
    }
    
    @Override
    public void update() {
        getController().update();
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getSpace(20, 1000));
        addPanel("filtro", createFiltro());
        getContentPane().add(getFiltro());
        getContentPane().add(getSpace(20, 1000));
    }
    
    /**
     * Metodo responsavel por criar o Filtro da View Relatorio.
     * @return Filtro da View Relatorio.
     */
    protected abstract PanelFiltro createFiltro(); 
    
    @Override
    public void addBody() {
        addTable();
        setTableHeader();
        addTableFooter();
    }
    
    /**
     * Metodo responsavel por adicionar a Tabela da View Relatorio.
     */
    protected void addTable() {
        createTable("relatorio");
        getContentPane().add(getScrollPane("relatorio"));
    }
    
    /**
     * Metodo responsavel por definir o Cabecalho da Tabela da View Relatorio.
     */
    protected void setTableHeader() {
        addColumns("relatorio", getColumns());
        setColumnsSize("relatorio", getSizes());
    }
    
    /**
     * Metodo responsavel por retornar as Colunas da Tabela da View Relatorio.
     * @return Colunas da Tabela da View Relatorio.
     */
    protected abstract String[] getColumns();
    
    /**
     * Metodo responsavel por retornar o Tamanho das Colunas da Tabela da View Relatorio.
     * @return Tamanho das Colunas da Tabela da View Relatorio.
     */
    protected abstract Integer[] getSizes();
    
    /**
     * Metodo responsavel por adicionar o Rodape da Tabela na View Relatorio.
     */
    protected abstract void addTableFooter();
    
    /**
     * Metodo responsavel por retornar o Contador da Tabela.
     * @return Contador da Tabela.
     */
    protected JPanel getTableCount() {
        JPanel count = new JPanel();
               count.setLayout(new FlowLayout(FlowLayout.CENTER));
               count.add(createLabel("Quantidade: "));
               count.add(createRightTextFieldNoEditable("count", "0", 5));
        return count;
    }
    
    /**
     * Metodo responsavel por atualizar a Quantidade de Registros encontrados.
     * @param count Quantidade de Registros.
     */     
    public void setCount(int count) {
        String text = count > 0 ? Integer.toString(count) : "0";
        getTextField("count").setText(text);
    }
    
    /**
     * Metodo responsavel por retornar o Total da Tabela.
     * @return Total da Tabela.
     */
    protected JPanel getTableTotal() {
        JPanel total = new JPanel();
               total.setLayout(new FlowLayout(FlowLayout.CENTER));
               total.add(createLabel("Total: "));
               total.add(createRightTextFieldNoEditable("total", "0.00", 10));
        return total;
    }
    
    /**
     * Metodo responsavel por atualizar o Total de Registros encontrados.
     * @param total Total de Registros.
     */     
    public void setTotal(Float total) {
        String text = total > 0 ? new DecimalFormat("R$ #,##0.00").format(total) : "0.00";
        getTextField("total").setText(text);
    }
    
    @Override
    public void addFooter() {
        JPanel footer = new JPanel();
               footer.setLayout(new FlowLayout(FlowLayout.CENTER));
               footer.add(createButton("imprimir", " Imprimir ", "imprimir"));
               footer.add(createButton("voltar",   "  Voltar  ", "voltar"));
        getContentPane().add(footer);
    }
    
    /**
     * Metodo responsavel por retornar o Filtro da View Relatorio.
     * @return Filtro da View Relatorio.
     */
    public PanelFiltro getFiltro() {
        return (PanelFiltro) getPanel("filtro");
    }
    
    /**
     * Metodo responsavel por retornar o Button Atualizar.
     * @return Button Atualizar.
     */
    public JButton getButtonAtualizar() {
        return getFiltro().getButtonAtualizar();
    }

    /**
     * Metodo responsavel por retornar a Tabela de Relatorio.
     * @return Tabela de Relatorio.
     */
    public JTable getTable() {
        return getTable("relatorio");
    }

    /**
     * Metodo responsavel por retornar o Modelo da Tabela de Relatorio.
     * @return Modelo da Tabela de Relatorio.
     */
    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) getTableModel("relatorio");
    }

    /**
     * Metodo responsavel por criar um Novo Right Renderer.
     * @return Novo Right Renderer.
     */
    public DefaultTableCellRenderer createRightRenderer() {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                                 renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        return renderer;
    }
    
    /**
     * Metodo responsavel por retornar o Scroll Pane da Tabela de Relatorio.
     * @return Scroll Pane da Tabela de Relatorio.
     */
    public JScrollPane getScrollPane() {
        return getScrollPane("relatorio");
    }
    
     /**
     * Metodo responsavel por retornar o Button Imprimir.
     * @return Button Imprimir.
     */
    public JButton getButtonImprimir() {
        return getButton("imprimir");
    }
    
    /**
     * Metodo responsavel por retornar o Button Voltar.
     * @return Button Voltar.
     */
    public JButton getButtonVoltar() {
        return getButton("voltar");
    }

    @Override
    public ControllerViewRelatorio getController() {
        return (ControllerViewRelatorio) controller;
    }
}