package controlador.visao.painel.pesquisa.estoque;

import controlador.visao.painel.pesquisa.ControllerPanelPesquisa;
import java.awt.event.ActionEvent;
import visao.painel.pesquisa.estoque.PanelPesquisaProduto;

/**
 * <p>Classe de Controle <b>ControllerPanelPesquisaProduto</b>.</p>
 * <p>Classe responsavel por controlar os <b>Eventos</b> do <b>PanelPesquisaProduto</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.painel.pesquisa.ControllerPanelPesquisa
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.painel.pesquisa.estoque.PanelPesquisaProduto
 */
public class ControllerPanelPesquisaProduto extends ControllerPanelPesquisa {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Pesquisa Produto.
     */
    public ControllerPanelPesquisaProduto(PanelPesquisaProduto panel) {
        super(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getPanel().getButtonAtualizar().equals(event.getSource()))
            getPanel().getOwner().update();
    }
    
    @Override
    public PanelPesquisaProduto getPanel() {
        return (PanelPesquisaProduto) panel;
    }
}