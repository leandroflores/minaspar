package visao.modal.consulta;

import controlador.visao.interfaces.Updatable;
import controlador.visao.modal.consulta.ControllerViewConsulta;
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
import visao.painel.consulta.filtro.PanelFiltro;

/**
 * <p>Classe de Visao <b>ViewConsulta</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Consulta</b> do SGBov.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    controlador.visao.interfaces.Updatable
 * @see    controlador.visao.modal.consulta.ControllerViewConsulta
 * @see    visao.modal.ViewModal
 */
public abstract class ViewConsulta extends ViewModal implements Updatable {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View do Sistema.
     */
    public ViewConsulta(View view) {
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
     * Metodo responsavel por criar o Filtro da View Consulta.
     * @return Filtro da View Consulta.
     */
    protected abstract PanelFiltro createFiltro(); 
    
    @Override
    public void addBody() {
        addTable();
        setTableHeader();
        addTableFooter();
    }
    
    /**
     * Metodo responsavel por adicionar a Tabela da View Consulta.
     */
    protected void addTable() {
        createTable("consulta");
        getContentPane().add(getScrollPane("consulta"));
    }
    
    /**
     * Metodo responsavel por definir o Cabecalho da Tabela da View Consulta.
     */
    protected void setTableHeader() {
        addColumns("consulta", getColumns());
        setColumnsSize("consulta", getSizes());
    }
    
    /**
     * Metodo responsavel por retornar as Colunas da Tabela da View Consulta.
     * @return Colunas da Tabela da View Consulta.
     */
    protected abstract String[] getColumns();
    
    /**
     * Metodo responsavel por retornar o Tamanho das Colunas da Tabela da View Consulta.
     * @return Tamanho das Colunas da Tabela da View Consulta.
     */
    protected abstract Integer[] getSizes();
    
    /**
     * Metodo responsavel por adicionar o Rodape da Tabela na View Consulta.
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
               total.add(createRightTextFieldNoEditable("total", "0.00", 8));
        return total;
    }
    
    /**
     * Metodo responsavel por atualizar o Total de Registros encontrados.
     * @param total Total de Registros.
     */     
    public void setTotal(Float total) {
        String text = total > 0 ? new DecimalFormat("#,##0.00").format(total) : "0.00";
        getTextField("total").setText(text);
    }
    
    @Override
    public void addFooter() {
        JPanel footer = new JPanel();
               footer.setLayout(new FlowLayout(FlowLayout.CENTER));
               footer.add(createButton("novo",    "  Novo   ", "inserir"));
               footer.add(createButton("editar",  " Editar  ", "editar"));
               footer.add(createButton("excluir", " Excluir ", "excluir"));
               footer.add(createButton("voltar",  " Voltar  ", "voltar"));
        getContentPane().add(footer);
    }
    
    /**
     * Metodo responsavel por retornar o Filtro da View Consulta.
     * @return Filtro da View Consulta.
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
     * Metodo responsavel por retornar a Tabela de Consulta.
     * @return Tabela de Consulta.
     */
    public JTable getTable() {
        return getTable("consulta");
    }

    /**
     * Metodo responsavel por retornar o Modelo da Tabela de Consulta.
     * @return Modelo da Tabela de Consulta.
     */
    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) getTableModel("consulta");
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
     * Metodo responsavel por retornar o Scroll Pane da Tabela de Consulta.
     * @return Scroll Pane da Tabela de Consulta.
     */
    public JScrollPane getScrollPane() {
        return getScrollPane("consulta");
    }
    
     /**
     * Metodo responsavel por retornar o Button Novo.
     * @return Button Novo.
     */
    public JButton getButtonNovo() {
        return getButton("novo");
    }
    
    /**
     * Metodo responsavel por retornar o Button Editar.
     * @return Button Editar.
     */
    public JButton getButtonEditar() {
        return getButton("editar");
    }
    
    /**
     * Metodo responsavel por retornar o Button Excluir.
     * @return Button Excluir.
     */
    public JButton getButtonExcluir() {
        return getButton("excluir");
    }
    
    /**
     * Metodo responsavel por retornar o Button Voltar.
     * @return Button Voltar.
     */
    public JButton getButtonVoltar() {
        return getButton("voltar");
    }
    
    /**
     * Metodo responsavel por retornar o Controller da View Consulta.
     * @return Controller da View Consulta.
     */
    public ControllerViewConsulta getController() {
        return (ControllerViewConsulta) controller;
    }
}