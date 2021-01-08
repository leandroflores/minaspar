package controlador.visao.modal.mensagem;

import controlador.visao.modal.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.modal.mensagem.ViewErro;

/**
 * <p>Classe de Controle <b>ControllerViewErro</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewErro.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    controlador.visao.modal.ControllerViewModal
 * @see    visao.modal.mensagem.ViewErro
 */
public class ControllerViewErro extends ControllerViewModal {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Erro.
     */
    public ControllerViewErro(ViewErro view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (getView().getButtonOk().equals(event.getSource()))
            getView().dispose();
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        if (ENTER == event.getKeyCode())
            getView().dispose();
    }
    
    @Override
    public ViewErro getView() {
        return (ViewErro) view;
    }
}