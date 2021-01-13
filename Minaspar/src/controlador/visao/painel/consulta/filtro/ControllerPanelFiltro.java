package controlador.visao.painel.consulta.filtro;

import controlador.visao.painel.ControllerPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.painel.consulta.filtro.PanelFiltro;

/**
 * <p>Classe de Controle <b>ControllerPanelFiltro</b>.</p>
 * <p>Classe responsavel por controlar os <b>Eventos</b> do <b>Painel Filtro</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.painel.ControllerPanel
 * @see    visao.painel.consulta.filtro.PanelFiltro
 */
public class ControllerPanelFiltro extends ControllerPanel {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Filtro.
     */
    public ControllerPanelFiltro(PanelFiltro panel) {
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
    public PanelFiltro getPanel() {
        return (PanelFiltro) panel;
    }
}