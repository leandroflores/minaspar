package visao.modal.excluir;

import controlador.visao.interfaces.Updatable;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import visao.modal.ViewModal;

/**
 * <p>Classe de Visao <b>ViewExcluir</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Exclusao</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.modal.excluir.ControllerViewExcluir
 * @see    visao.modal.ViewModal
 */
public abstract class ViewExcluir extends ViewModal {
    private final ViewModal owner;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Modal.
     */
    public ViewExcluir(ViewModal view) {
        super(view);
        owner = view;
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
        getContentPane().add(getVerticalSpace(25));
        getContentPane().add(createLabelImage("icones/erro"));
        getContentPane().add(getVerticalSpace(15));
    }
    
    /**
     * Metodo responsavel por adicionar a Mensagem da View Excluir.
     * @param message Mensagem a ser exibida.
     */
    protected void addMessage(String message) {
        getContentPane().add(createLabel("Confirma exclusão: " +  message + "?"));
    }
    
    @Override
    public void addFooter() {
        JPanel footer = new JPanel();
               footer.setLayout(new FlowLayout(FlowLayout.CENTER));
               footer.add(createButton("sim", "  Sim  ", "sim"));
               footer.add(createLabel("  "));
               footer.add(createButton("nao", "  Não  ", "excluir"));
        getContentPane().add(getVerticalSpace(10));
        getContentPane().add(footer);
    }
    
    /**
     * Metodo responsavel por retornar o Button Sim.
     * @return Button Sim.
     */
    public JButton getButtonSim() {
        return getButton("sim");
    }

    /**
     * Metodo responsavel por retornar o Button Nao.
     * @return Button Nao.
     */
    public JButton getButtonNao() {
        return getButton("nao");
    }
    
    /**
     * Metodo responsavel por retornar o View.
     * @return View.
     */
    public Updatable getView() {
        return (Updatable) owner;
    }
}