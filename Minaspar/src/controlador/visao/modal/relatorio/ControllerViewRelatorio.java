package controlador.visao.modal.relatorio;

import controlador.visao.modal.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.controlador.ControllerEntidade;
import visao.modal.relatorio.ViewRelatorio;
import visao.painel.filtro.PanelFiltro;

/**
 * <p>Classe de Controle <b>ControllerViewConsulta</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewConsulta do Sistema.</p>
 * @author Leandro
 * @since  15/01/2021
 * @see    controlador.visao.modal.ControllerViewModal
 * @see    visao.modal.relatorio.ViewRelatorio
 */
public abstract class ControllerViewRelatorio extends ControllerViewModal {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Relatorio.
     */
    public ControllerViewRelatorio(ViewRelatorio view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (getView().getButtonAtualizar().equals(event.getSource()))
            update();
        else if (getView().getButtonImprimir().equals(event.getSource()))
            imprimir();
        else if (getView().getButtonVoltar().equals(event.getSource()))
            getView().dispose();
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        switch (event.getKeyCode()) {
            case F5:
            case ENTER:
                update();
                break;
            case F1:
                imprimir();
                break;
            case F2:
                getView().dispose();
                break;
            default:
                break;
        }
    }
    
    /**
     * Metodo responsavel por atualizar a View Relatorio.
     */
    public abstract void update();
    
    /**
     * Metodo abstrato responsavel por realizar a Pesquisa.
     */
    public abstract void pesquisar();
    
    /**
     * Metodo abstrato responsavel por Imprimir o Relatorio.
     */
    public abstract void imprimir();
    
    /**
     * Metodo abstract responsavel por retornar o Controller da Entidade.
     * @return Controller da Entidade.
     */
    public abstract ControllerEntidade getController();
    
    /**
     * Metodo responsavel por retornar o Panel Filtro da View Relatorio.
     * @return Panel Filtro da View Relatorio.
     */
    public PanelFiltro getFiltro() {
        return getView().getFiltro();
    }
    
    @Override
    public ViewRelatorio getView() {
        return (ViewRelatorio) this.view;
    }
}