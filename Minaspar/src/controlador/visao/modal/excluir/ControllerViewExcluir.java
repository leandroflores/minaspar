package controlador.visao.modal.excluir;

import controlador.visao.modal.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.modal.excluir.ViewExcluir;

/**
 * <p>Classe de Controle <b>ControllerViewExcluir</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewExcluir do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.modal.ControllerViewModal
 * @see    visao.modal.excluir.ViewExcluir
 */
public abstract class ControllerViewExcluir extends ControllerViewModal {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Excluir.
     */
    public ControllerViewExcluir(ViewExcluir view) {
        super(view);
    }

    /**
     * Metodo abstrato responsavel por realizar a Exclusao.
     */
    public abstract void excluir();
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if (getView().getButtonSim().equals(event.getSource()))
            excluir();
        else if (getView().getButtonNao().equals(event.getSource()))
            getView().dispose();
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        if (F1 == event.getKeyCode())
            excluir();
        else if (F2 == event.getKeyCode())
            getView().dispose();
    }
    
    @Override
    public ViewExcluir getView() {
        return (ViewExcluir) view;
    }
}