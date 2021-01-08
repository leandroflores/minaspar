package controlador.visao.modal.mensagem;

import java.awt.event.ActionEvent;
import controlador.visao.modal.ControllerViewModal;
import java.awt.event.KeyEvent;
import visao.modal.mensagem.ViewMensagem;

/**
 * <p>Classe de Controle <b>ControllerViewMensagem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewMensagem.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    controlador.visao.modal.ControllerViewModal
 * @see    visao.modal.mensagem.ViewMensagem
 */
public class ControllerViewMensagem extends ControllerViewModal {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Mensagem.
     */
    public ControllerViewMensagem(ViewMensagem view) {
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
    public ViewMensagem getView() {
        return (ViewMensagem) view;
    }
}