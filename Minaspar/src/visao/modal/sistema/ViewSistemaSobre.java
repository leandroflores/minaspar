package visao.modal.sistema;

import controlador.visao.modal.sistema.ControllerViewSistemaSobre;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import visao.estruturais.menu.ViewMenu;
import visao.modal.ViewModal;

/**
 * <p>Classe de Visao <b>ViewSistemaSobre</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Informacoes</b> do SGBov.</p>
 * @author Leandro
 * @since  18/12/2020
 * @see    controlador.visao.modal.sistema.ControllerViewSistemaSobre
 * @see    visao.estruturais.menu.ViewMenu
 * @see    visao.modal.ViewModal
 */
public final class ViewSistemaSobre extends ViewModal {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewSistemaSobre(ViewMenu view) {
        super(view);
        title      = "Sobre";
        controller = new ControllerViewSistemaSobre(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        updateTitle();
        setSize(new Dimension(550, 300));
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
        getContentPane().add(createLabelImage("sistema/sobre"));
        getContentPane().add(getVerticalSpace(35));
    }
    
    @Override
    public void addBody() {
        getContentPane().add(createLabelTitle("SGBov - Sistema de Gerenciamento de Bovinos", 20));
        getContentPane().add(getVerticalSpace(10));
        getContentPane().add(createLabel("D-Work Sistemas Inteligentes", 15));
        getContentPane().add(getVerticalSpace(10));
        getContentPane().add(createLabel("Versao 1.0", 10));
        getContentPane().add(getVerticalSpace(25));
    }
    
    @Override
    public void addFooter() {
        getContentPane().add(createButton("ok", "   Ok   ", "sim"));
    }

    /**
     * Metodo responsavel por retornar o Button Ok.
     * @return Button Ok.
     */
    public JButton getButtonOk() {
        return getButton("ok");
    }
}