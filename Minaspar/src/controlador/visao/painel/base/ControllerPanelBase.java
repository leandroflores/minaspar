package controlador.visao.painel.base;

import controlador.visao.painel.ControllerPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.painel.base.PanelBase;

/**
 * <p>Classe de Controle <b>ControllerPanelBase</b>.</p>
 * <p>Classe responsavel por controlar os <b>Eventos</b> dos <b>Paineis Base</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.painel.ControllerPanel
 * @see    visao.painel.base.PanelBase
 */
public abstract class ControllerPanelBase extends ControllerPanel {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Base.
     */
    public ControllerPanelBase(PanelBase panel) {
        super(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        getPanel().getOwner().getController().actionPerformed(event);
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        getPanel().getOwner().getController().keyPressed(event);
    }
    
    @Override
    public PanelBase getPanel() {
        return (PanelBase) panel;
    }
}