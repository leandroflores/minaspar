package visao.modal.pesquisa;

import controlador.visao.interfaces.Updatable;
import controlador.visao.modal.pesquisa.ControllerViewPesquisa;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import visao.interfaces.Searchable;
import visao.modal.ViewModal;
import visao.painel.pesquisa.PanelPesquisa;

/**
 * <p>Classe de Visao <b>ViewPesquisa</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Pesquisa</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.pesquisa.ControllerViewPesquisa
 * @see    visao.interfaces.InterfaceView
 * @see    visao.modal.ViewModal
 */
public abstract class ViewPesquisa extends ViewModal implements Updatable {
    private final ViewModal view;

    /**
     * Metodo construtor padrao da Classe.
     * @param view_ View Modal.
     */
    public ViewPesquisa(ViewModal view_) {
        super(view_);
        view = view_;
    }
    
    @Override
    public void setProperties() {
        updateTitle();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
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
    public void addBody() {
        addTable();
        setTableHeader();
    }
    
    /**
     * Metodo responsavel por adicionar a Tabela da View Pesquisa.
     */
    protected void addTable() {
        createTable("pesquisa");
        getContentPane().add(getScrollPane("pesquisa"));
    }
    
    /**
     * Metodo responsavel por definir o Cabecalho da Tabela da View Pesquisa.
     */
    protected void setTableHeader() {
        addColumns("pesquisa", getColumns());
        setColumnsSize("pesquisa", getSizes());
    }
    
    /**
     * Metodo responsavel por retornar as Colunas da Tabela da View Pesquisa.
     * @return Colunas da Tabela da View Pesquisa.
     */
    protected abstract String[] getColumns();
    
    /**
     * Metodo responsavel por retornar o Tamanho das Colunas da Tabela da View Pesquisa.
     * @return Tamanho das Colunas da Tabela da View Pesquisa.
     */
    protected abstract Integer[] getSizes();
    
    @Override
    public void addFooter() {
        JPanel footer = new JPanel();
               footer.setLayout(new FlowLayout(FlowLayout.CENTER));
               footer.add(createButton("selecionar", " Selecionar ", "selecionar"));
               footer.add(createButton("cancelar",   "  Cancelar  ", "cancelar"));
        getContentPane().add(footer);
    }

    /**
     * Metodo responsavel por retornar o Panel Pesquisa.
     * @return Panel Pesquisa.
     */
    public abstract PanelPesquisa getPanelPesquisa();
    
    /**
     * Metodo responsavel por retornar a Tabela de Pesquisa.
     * @return Tabela de Pesquisa.
     */
    public JTable getTable() {
        return getTable("pesquisa");
    }

    /**
     * Metodo responsavel por retornar o Modelo da Tabela de Pesquisa.
     * @return Modelo da Tabela de Pesquisa.
     */
    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) getTableModel("pesquisa");
    }

    /**
     * Metodo responsavel por retornar o Scroll Pane da Tabela de Pesquisa.
     * @return Scroll Pane da Tabela de Pesquisa.
     */
    public JScrollPane getScrollPane() {
        return getScrollPane("pesquisa");
    }
    
    /**
     * Metodo responsavel por retornar o Button Selecionar.
     * @return Button Selecionar.
     */
    public JButton getButtonSelecionar() {
        return getButton("selecionar");
    }
    
    /**
     * Metodo responsavel por retornar o Button Cancelar.
     * @return Button Cancelar.
     */
    public JButton getButtonCancelar() {
        return getButton("cancelar");
    }
    
    /**
     * Metodo responsavel por retornar o Controller da View Pesquisa.
     * @return Controller da View Pesquisa.
     */
    public ControllerViewPesquisa getController() {
        return (ControllerViewPesquisa) controller;
    }
    
    /**
     * Metodo responsavel por retornar a View Parent.
     * @return View Parent.
     */
    public Searchable getView() {
        return (Searchable) view;
    }
}