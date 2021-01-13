package controlador.visao.painel.novo;

import controlador.visao.painel.ControllerPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.painel.novo.PanelNovo;

/**
 * <p>Classe de Controle <b>ControllerPanelNovo</b>.</p>
 * <p>Classe responsavel por controlar os <b>Eventos</b> do <b>Panel Novo</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.painel.ControllerPanel
 * @see    visao.painel.novo.PanelNovo
 */
public abstract class ControllerPanelNovo extends ControllerPanel {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Novo.
     */
    public ControllerPanelNovo(PanelNovo panel) {
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
    public PanelNovo getPanel() {
        return (PanelNovo) panel;
    }
}