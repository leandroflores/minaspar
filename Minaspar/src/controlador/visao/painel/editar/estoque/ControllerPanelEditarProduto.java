package controlador.visao.painel.editar.estoque;

import controlador.visao.painel.editar.ControllerPanelEditar;
import visao.painel.editar.estoque.PanelEditarProduto;

/**
 * <p>Classe de Controle <b>ControllerPanelEditarProduto</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelEditarProduto.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.painel.editar.ControllerPanelEditar
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.painel.editar.estoque.PanelEditarProduto
 */
public final class ControllerPanelEditarProduto extends ControllerPanelEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Editar Produto.
     */
    public ControllerPanelEditarProduto(PanelEditarProduto panel) {
        super(panel);
    }
    
    @Override
    public PanelEditarProduto getPanel() {
        return (PanelEditarProduto) panel;
    }
}