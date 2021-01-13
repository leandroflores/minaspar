package visao.modal.novo;

import controlador.visao.interfaces.Updatable;
import controlador.visao.modal.novo.ControllerViewNovo;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import visao.modal.ViewModal;
import visao.painel.novo.PanelNovo;

/**
 * <p>Classe de Visao <b>ViewNovo</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Novo</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.modal.novo.ControllerViewNovo
 * @see    visao.modal.ViewModal
 */
public abstract class ViewNovo extends ViewModal {
    protected final ViewModal view;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view_ View Consulta.
     */
    public ViewNovo(ViewModal view_) {
        super(view_);
        view = view_;
    }
    
    @Override
    public void setProperties() {
        updateTitle();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }
    
    @Override
    public void addComponents() {
        addHeader();
        addBody();
        addFooter();
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getVerticalSpace(20));
        getContentPane().add(createLabel("Os campos com (*) sao obrigatorios!"));
    }
    
    @Override
    public void addBody() {
        getContentPane().add(getVerticalSpace(20));
        addPanel("novo", createPanelNovo());
        getContentPane().add(getPanelNovo());
        getContentPane().add(getVerticalSpace(20));
    }
    
    /**
     * Metodo responsavel por criar o Panel Novo da View Consulta.
     * @return Panel Novo da View Consulta.
     */
    protected abstract PanelNovo createPanelNovo(); 
    
    /**
     * Metodo responsavel por Limpar os Componentes da View Novo.
     */
    public void clear() {
        getPanelNovo().clear();
    }
    
    @Override
    public void addFooter() {
        JPanel footer = new JPanel();
               footer.setLayout(new FlowLayout(FlowLayout.CENTER));
               footer.add(createButton("inserir", " Inserir ", "sim"));
               footer.add(createButton("limpar",  " Limpar  ", "limpar"));
               footer.add(createButton("voltar",  " Voltar  ", "voltar"));
        getContentPane().add(footer);
    }
    
    /**
     * Metodo responsavel por retornar o Panel Novo.
     * @return Panel Novo.
     */
    public PanelNovo getPanelNovo() {
        return (PanelNovo) getPanel("novo");
    }
    
    /**
     * Metodo responsavel por retornar o Button Inserir.
     * @return Button Inserir.
     */
    public JButton getButtonInserir() {
        return getButton("inserir");
    }
    
    /**
     * Metodo responsavel por retornar o Button Limpar.
     * @return Button Limpar.
     */
    public JButton getButtonLimpar() {
        return getButton("limpar");
    }
    
    /**
     * Metodo responsavel por retornar o Button Voltar.
     * @return Button Voltar.
     */
    public JButton getButtonVoltar() {
        return getButton("voltar");
    }
    
    /**
     * Metodo responsavel por retornar o Controller da View Novo.
     * @return Controller da View Novo.
     */
    public ControllerViewNovo getController() {
        return (ControllerViewNovo) controller;
    }
    
    /**
     * Metodo responsavel por retornar a View.
     * @return View.
     */
    public Updatable getView() {
        return (Updatable) view;
    }
}