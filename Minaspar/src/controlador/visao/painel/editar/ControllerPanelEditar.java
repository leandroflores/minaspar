package controlador.visao.painel.editar;

import controlador.visao.painel.ControllerPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.painel.editar.PanelEditar;

/**
 * <p>Classe de Controle <b>ControllerPanelEditar</b>.</p>
 * <p>Classe responsavel por controlar os <b>Eventos</b> do <b>Painel Editar</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.painel.ControllerPanel
 * @see    visao.painel.editar.PanelEditar
 */
public abstract class ControllerPanelEditar extends ControllerPanel {
    protected boolean ready;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Editar.
     */
    public ControllerPanelEditar(PanelEditar panel) {
        super(panel);
        ready = false;
    }
    
    /**
     * Metodo responsavel por definir o Controlador Ativo.
     */
    public void setReady() {
        ready = true;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if (ready)
            getPanel().getOwner().getController().actionPerformed(event);
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        if (ready)
            getPanel().getOwner().getController().keyPressed(event);
    }
    
    @Override
    public PanelEditar getPanel() {
        return (PanelEditar) panel;
    }
}