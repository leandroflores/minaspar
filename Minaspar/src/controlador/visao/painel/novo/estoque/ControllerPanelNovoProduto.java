package controlador.visao.painel.novo.estoque;

import controlador.visao.painel.novo.ControllerPanelNovo;
import visao.painel.novo.estoque.PanelNovoProduto;

/**
 * <p>Classe de Controle <b>ControllerPanelNovoProduto</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelNovoProduto.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.painel.novo.ControllerPanelNovo
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.painel.novo.estoque.PanelNovoProduto
 */
public final class ControllerPanelNovoProduto extends ControllerPanelNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Novo Produto.
     */
    public ControllerPanelNovoProduto(PanelNovoProduto panel) {
        super(panel);
    }
    
    @Override
    public PanelNovoProduto getPanel() {
        return (PanelNovoProduto) panel;
    }
}