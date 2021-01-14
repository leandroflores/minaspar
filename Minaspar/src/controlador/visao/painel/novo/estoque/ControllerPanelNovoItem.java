package controlador.visao.painel.novo.estoque;

import controlador.visao.painel.novo.ControllerPanelNovo;
import visao.painel.novo.estoque.PanelNovoItem;

/**
 * <p>Classe de Controle <b>ControllerPanelNovoItem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelNovoItem.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.painel.novo.ControllerPanelNovo
 * @see    modelo.entidade.estoque.Item
 * @see    visao.painel.novo.estoque.PanelNovoItem
 */
public final class ControllerPanelNovoItem extends ControllerPanelNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Novo Item.
     */
    public ControllerPanelNovoItem(PanelNovoItem panel) {
        super(panel);
    }
    
    @Override
    public PanelNovoItem getPanel() {
        return (PanelNovoItem) panel;
    }
}