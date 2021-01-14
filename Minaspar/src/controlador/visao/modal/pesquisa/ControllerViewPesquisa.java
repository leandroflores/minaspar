package controlador.visao.modal.pesquisa;

import controlador.visao.modal.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.controlador.ControllerEntidade;
import visao.modal.pesquisa.ViewPesquisa;

/**
 * <p>Classe de Controle <b>ControllerViewPesquisa</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewPesquisa do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.ControllerViewModal
 * @see    visao.modal.pesquisa.ViewPesquisa
 */
public abstract class ControllerViewPesquisa extends ControllerViewModal {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Pesquisa.
     */
    public ControllerViewPesquisa(ViewPesquisa view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (getView().getButtonSelecionar().equals(event.getSource()))
            selecionar();
        else if (getView().getButtonCancelar().equals(event.getSource()))
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
                selecionar();
                break;
            case F2:
                getView().dispose();
                break;
            default:
                break;
        }
    }
    
    /**
     * Metodo abstrato responsavel por atualizar a View Pesquisa.
     */
    public abstract void update();
    
    /**
     * Metodo abstrato responsavel por pesquisar os Objetos da View Pesquisa.
     */
    public abstract void pesquisar();
    
    /**
     * Metodo abstrato responsavel por Selecionar o Objeto da View Pesquisa.
     */
    public abstract void selecionar();
    
    /**
     * Metodo abstract responsavel por retornar o Controller da Entidade.
     * @return Controller da Entidade.
     */
    public abstract ControllerEntidade getController();
    
    @Override
    public ViewPesquisa getView() {
        return (ViewPesquisa) this.view;
    }
}