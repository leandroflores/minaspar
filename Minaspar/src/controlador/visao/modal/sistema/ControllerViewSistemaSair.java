package controlador.visao.modal.sistema;

import controlador.visao.modal.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.modal.sistema.ViewSistemaSair;

/**
 * <p>Classe de Controle <b>ControllerViewSistemaSair</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewSistemaSair.</p>
 * @author  Leandro
 * @since   18/12/2020
 * @see     controlador.visao.modal.ControllerViewModal
 * @see     visao.modal.sistema.ViewSistemaSair
 */
public class ControllerViewSistemaSair extends ControllerViewModal {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Sair.
     */
    public ControllerViewSistemaSair(ViewSistemaSair view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (getView().getButtonSim().equals(event.getSource()))
            System.exit(0);
        else if (getView().getButtonNao().equals(event.getSource()))
            getView().dispose();
        
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        if (ENTER == event.getKeyCode()) {
            if (getView().getFocusOwner().equals(getView().getButtonSim()))
                System.exit(0);
            else if (getView().getFocusOwner().equals(getView().getButtonNao()))
                getView().dispose();
        }
    }
    
    @Override
    public ViewSistemaSair getView() {
        return (ViewSistemaSair) view;
    }
}