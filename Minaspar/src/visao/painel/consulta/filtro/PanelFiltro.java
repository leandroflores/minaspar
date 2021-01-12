package visao.painel.consulta.filtro;

//import controlador.visao.painel.editar.ControllerPanelEditar;
import javax.swing.JButton;
import visao.modal.consulta.ViewConsulta;
import visao.painel.Panel;

/**
 * <p>Classe de Visao <b>PanelFiltro</b>.</p> 
 * <p>Classe responsavel por definir um Modelo Abstrato para o <b>Painel Filtro</b> do SGBov.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    controlador.visao.painel.consulta.filtro.ControllerPanelFiltro
 * @see    visao.modal.consulta.ViewConsulta
 * @see    visao.painel.Panel
 */
public abstract class PanelFiltro extends Panel {
    protected ViewConsulta owner;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta.
     */
    public PanelFiltro(ViewConsulta view) {
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
     * Metodo responsavel por retornar o Controlador do Panel Editar.
     * @return Controlador do Panel Editar.
     */
    //public ControllerPanelEditar getController() {
    //    return (ControllerPanelEditar) controller;
    //}
    
    /**
     * Metodo responsavel por retornar o Owner da View Filtro.
     * @return Owner da View Filtro.
     */
    public ViewConsulta getOwner() {
        return (ViewConsulta) owner;
    }
}