package controlador.visao.painel.editar.estoque;

import controlador.visao.painel.editar.ControllerPanelEditar;
import visao.painel.editar.estoque.PanelEditarItem;

/**
 * <p>Classe de Controle <b>ControllerPanelEditarItem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelEditarItem.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.painel.editar.ControllerPanelEditar
 * @see    modelo.entidade.estoque.Item
 * @see    visao.painel.editar.estoque.PanelEditarItem
 */
public final class ControllerPanelEditarItem extends ControllerPanelEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Editar Item.
     */
    public ControllerPanelEditarItem(PanelEditarItem panel) {
        super(panel);
    }
    
    @Override
    public PanelEditarItem getPanel() {
        return (PanelEditarItem) panel;
    }
}