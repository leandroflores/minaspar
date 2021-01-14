package visao.painel.pesquisa;

import visao.modal.pesquisa.ViewPesquisa;
import visao.painel.Panel;

/**
 * <p>Classe de Visao <b>PanelPesquisa</b>.</p> 
 * <p>Classe responsavel por definir um Modelo Abstrato para o <b>Painel de Pesquisa</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.painel.pesquisa.ControllerPanelPesquisa
 * @see    visao.modal.pesquisa.ViewPesquisa
 * @see    visao.painel.Panel
 */
public abstract class PanelPesquisa extends Panel {
    protected ViewPesquisa owner;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Pesquisa.
     */
    public PanelPesquisa(ViewPesquisa view) {
        owner = view;
    }
    
    /**
     * Metodo abstrato responsavel por definir as Propriedades do Panel Filtro.
     */
    protected abstract void setProperties();
    
    /**
     * Metodo responsavel por retornar o Owner da View Filtro.
     * @return Owner da View Filtro.
     */
    public ViewPesquisa getOwner() {
        return (ViewPesquisa) owner;
    }
}