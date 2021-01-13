package controlador.visao;

import controlador.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.View;

/**
 * <p>Classe de Controle <b>ControllerView</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> das Views do Sistema.</p>
 * @author Leandro
 * @since  10/01/2021
 * @see    controlador.Controller
 * @see    visao.View
 */
public abstract class ControllerView extends Controller {
    protected final View view;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ControllerView(View view) {
        this.view = view;
    }
    
    @Override
    public abstract void actionPerformed(ActionEvent event);

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == ESC)
            view.dispose();
    }
    
    /**
     * Metodo responsavel por retornar a View.
     * @return View.
     */
    public View getView() {
        return view;
    }
}