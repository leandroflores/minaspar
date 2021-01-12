package visao.modal.sistema;

import controlador.visao.modal.sistema.ControllerViewSistemaSair;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import visao.View;
import visao.modal.ViewModal;

/**
 * <p>Classe de Visao <b>ViewSistemaSair</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Saida</b> do Sistema.</p>
 * @author  Leandro
 * @since   18/12/2020
 * @see     controlador.visao.modal.sistema.ControllerViewSistemaSair
 * @see     visao.estruturais.menu.ViewMenu
 * @see     visao.modal.ViewModal
 */
public final class ViewSistemaSair extends ViewModal {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View do Sistema.
     */
    public ViewSistemaSair(View view) {
        super(view);
        title      = "Sair";
        controller = new ControllerViewSistemaSair(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        updateTitle();
        setSize(new Dimension(650, 225));
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
        getContentPane().add(createLabelImage("sistema/sair"));
    }
    
    @Override
    public void addBody() {
        getContentPane().add(getVerticalSpace(25));
        getContentPane().add(createLabel("Deseja realmente Sair do Sistema?"));
        getContentPane().add(getVerticalSpace(25));
    }
    
    @Override
    public void addFooter() {
        JPanel footer = new JPanel();
               footer.setLayout(new FlowLayout(FlowLayout.CENTER));
               footer.add(createButton("sim", "  Sim  ", "sim"));
               footer.add(createLabel("  "));
               footer.add(createButton("nao", "  Não  ", "excluir"));
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
}