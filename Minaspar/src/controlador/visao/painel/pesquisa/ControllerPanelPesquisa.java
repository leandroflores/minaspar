package controlador.visao.painel.pesquisa;

import controlador.visao.painel.ControllerPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.painel.pesquisa.PanelPesquisa;

/**
 * <p>Classe de Controle <b>ControllerPanelPesquisa</b>.</p>
 * <p>Classe responsavel por controlar os <b>Eventos</b> do <b>PanelPesquisa</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.painel.ControllerPanel
 * @see    visao.painel.pesquisa.PanelPesquisa
 */
public abstract class ControllerPanelPesquisa extends ControllerPanel {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Pesquisa.
     */
    public ControllerPanelPesquisa(PanelPesquisa panel) {
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
    public PanelPesquisa getPanel() {
        return (PanelPesquisa) panel;
    }
}