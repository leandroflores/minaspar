package visao.painel.filtro;

import javax.swing.JButton;
import visao.modal.ViewModal;
import visao.painel.Panel;

/**
 * <p>Classe de Visao <b>PanelFiltro</b>.</p> 
 * <p>Classe responsavel por definir um Modelo Abstrato para o <b>Painel Filtro</b> do Sistema.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    controlador.visao.painel.filtro.ControllerPanelFiltro
 * @see    visao.modal.consulta.ViewConsulta
 * @see    visao.painel.Panel
 */
public abstract class PanelFiltro extends Panel {
    protected ViewModal owner;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Modal.
     */
    public PanelFiltro(ViewModal view) {
        owner = view;
    }
    
    /**
     * Metodo abstrato responsavel por definir as Propriedades do Panel Filtro.
     */
    protected abstract void setProperties();
   
    /**
     * Metodo responsavel por retornar o Novo Button Atualizar.
     * @return Button Atualizar.
     */
    protected JButton createButtonAtualizar() {
        return createButton("atualizar", "", "atualizar");
    }
    
    /**
     * Metodo responsavel por retornar o Button Atualizar.
     * @return Button Atualizar.
     */
    public JButton getButtonAtualizar() {
        return getButton("atualizar");
    }
    
    /**
     * Metodo responsavel por retornar o Owner da View Filtro.
     * @return Owner da View Filtro.
     */
    public ViewModal getOwner() {
        return (ViewModal) owner;
    }
}