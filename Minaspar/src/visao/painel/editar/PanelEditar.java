package visao.painel.editar;

import controlador.visao.painel.editar.ControllerPanelEditar;
import visao.modal.editar.ViewEditar;
import visao.painel.Panel;

/**
 * <p>Classe de Visao <b>PanelEditar</b>.</p> 
 * <p>Classe responsavel por definir um Modelo Abstrato para o <b>Painel Editar</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.painel.editar.ControllerPanelEditar
 * @see    visao.modal.editar.ViewEditar
 * @see    visao.painel.Panel
 */
public abstract class PanelEditar extends Panel {
    protected ViewEditar owner;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar.
     */
    public PanelEditar(ViewEditar view) {
        owner = view;
    }
    
    /**
     * Metodo abstrato responsavel por definir as Propriedades do Panel Editar.
     */
    protected abstract void setProperties();
    
    /**
     * Metodo abstrato responsavel por adicionar os Panels do Panel Editar.
     */
    protected abstract void addPanels();
    
    @Override
    public ControllerPanelEditar getController() {
        return (ControllerPanelEditar) controller;
    }
    
    /**
     * Metodo responsavel por retornar o Owner da View Editar.
     * @return Owner da View Editar.
     */
    public ViewEditar getOwner() {
        return (ViewEditar) owner;
    }
}