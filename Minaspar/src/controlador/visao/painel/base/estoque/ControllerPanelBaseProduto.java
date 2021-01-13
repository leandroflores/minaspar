package controlador.visao.painel.base.estoque;

import controlador.visao.painel.base.ControllerPanelBase;
import visao.painel.base.estoque.PanelBaseProduto;

/**
 * <p>Classe de Controle <b>ControllerPanelBaseProduto</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelBaseProduto.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.painel.base.ControllerPanelBase
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.painel.base.estoque.PanelBaseProduto
 */
public final class ControllerPanelBaseProduto extends ControllerPanelBase {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Base Produto.
     */
    public ControllerPanelBaseProduto(PanelBaseProduto panel) {
        super(panel);
    }
    
    @Override
    public PanelBaseProduto getPanel() {
        return (PanelBaseProduto) panel;
    }
}