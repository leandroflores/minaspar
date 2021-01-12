package controlador.visao.modal.sistema;

import controlador.visao.modal.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.modal.sistema.ViewSistemaSobre;

/**
 * <p>Classe de Controle <b>ControllerViewSistemaSobre</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewSistemaSobre.</p>
 * @author Leandro
 * @since  18/12/2020
 * @see    controlador.visao.modal.ControllerViewModal
 * @see    visao.modal.sistema.ViewSistemaSobre
 */
public class ControllerViewSistemaSobre extends ControllerViewModal {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Sobre.
     */
    public ControllerViewSistemaSobre(ViewSistemaSobre view) {
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
    public ViewSistemaSobre getView() {
        return (ViewSistemaSobre) view;
    }
}