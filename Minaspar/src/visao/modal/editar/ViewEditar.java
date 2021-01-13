package visao.modal.editar;

import controlador.visao.interfaces.Updatable;
import controlador.visao.modal.editar.ControllerViewEditar;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import visao.modal.ViewModal;
import visao.painel.editar.PanelEditar;

/**
 * <p>Classe de Visao <b>ViewEditar</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Edicao</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.modal.editar.ControllerViewEditar
 * @see    visao.modal.ViewModal
 */
public abstract class ViewEditar extends ViewModal {
    protected final ViewModal view;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view_ View Modal.
     */
    public ViewEditar(ViewModal view_) {
        super(view_);
        view = view_;
    }
    
    @Override
    public void addComponents() {
        addHeader();
        addBody();
        addFooter();
    }
    
    @Override
    public void setProperties() {
        updateTitle();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getVerticalSpace(20));
    }
    
    @Override
    public void addBody() {
        addPanel("editar", createPanel());
        getContentPane().add(getPanelEditar());
        getContentPane().add(getVerticalSpace(20));
    }
    
    /**
     * Metodo responsavel por criar o Panel da View Editar.
     * @return Panel da View Editar.
     */
    protected abstract PanelEditar createPanel(); 
    
    @Override
    public void addFooter() {
        JPanel footer = new JPanel();
               footer.setLayout(new FlowLayout(FlowLayout.CENTER));
               footer.add(createButton("salvar",   "  Salvar  ", "salvar"));
               footer.add(createButton("cancelar", " Cancelar ", "cancelar"));
        getContentPane().add(footer);
    }
    
    /**
     * Metodo responsavel por apresentar os Valores da View Editar.
     */
    public void setValues() {
        getPanelEditar().setValues();
    }
    
    /**
     * Metodo responsavel por retornar o Panel Editar.
     * @return Panel Editar.
     */
    public PanelEditar getPanelEditar() {
        return (PanelEditar) getPanel("editar");
    }
    
    /**
     * Metodo responsavel por retornar o Button Salvar.
     * @return Button Salvar.
     */
    public JButton getButtonSalvar() {
        return getButton("salvar");
    }
    
    /**
     * Metodo responsavel por retornar o Button Cancelar.
     * @return Button Cancelar.
     */
    public JButton getButtonCancelar() {
        return getButton("cancelar");
    }
    
    /**
     * Metodo responsavel por retornar o Controller da View Editar.
     * @return Controller da View Editar.
     */
    public ControllerViewEditar getController() {
        return (ControllerViewEditar) controller;
    }
    
    /**
     * Metodo responsavel por retornar a View.
     * @return View.
     */
    public Updatable getView() {
        return (Updatable) view;
    }
}