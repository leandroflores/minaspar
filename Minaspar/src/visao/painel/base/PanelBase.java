package visao.painel.base;

import visao.painel.Panel;

/**
 * <p>Classe de Visao <b>PanelBase</b>.</p> 
 * <p>Classe responsavel por definir um Modelo Abstrato para o <b>Painel Base</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.painel.base.ControllerPanelBase
 * @see    visao.painel.Panel
 */
public abstract class PanelBase extends Panel {
    protected Panel owner;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel.
     */
    public PanelBase(Panel panel) {
        owner = panel;
    }
    
    /**
     * Metodo abstrato responsavel por definir as Propriedades do Panel Base.
     */
    protected abstract void setProperties();
    
    /**
     * Metodo abstrato responsavel por preencher os Valores do Panel Base.
     */
    public abstract void setValues();
    
    /**
     * Metodo responsavel por retornar o Panel Owner.
     * @return Panel Owner.
     */
    public Panel getOwner() {
        return owner;
    }
}