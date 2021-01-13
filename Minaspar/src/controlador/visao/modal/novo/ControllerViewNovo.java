package controlador.visao.modal.novo;

import controlador.visao.modal.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.PanelNovo;

/**
 * <p>Classe de Controle <b>ControllerViewNovo</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewNovo do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.modal.ControllerViewModal
 * @see    visao.modal.novo.ViewNovo
 */
public abstract class ControllerViewNovo extends ControllerViewModal {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo.
     */
    public ControllerViewNovo(ViewNovo view) {
        super(view);
    }

    /**
     * Metodo abstrato responsavel por checar os Dados para o Cadastro.
     * @return Dados corretos para o Cadastro.
     */
    public abstract boolean check();
    
    /**
     * Metodo abstrato responsavel por Inserir o Objeto.
     */
    public abstract void inserir();
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if (getView().getButtonInserir().equals(event.getSource()) && check())
            inserir();
        else if (getView().getButtonLimpar().equals(event.getSource()))
            getView().clear();
        else if (getView().getButtonVoltar().equals(event.getSource()))
            getView().dispose();
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        switch (event.getKeyCode()) {
            case F1:
                if (check())
                    inserir();
                break;
            case F2:
                getView().clear();
                break;
            case F3:
                getView().dispose();
                break;
            default:
                break;
        }
    }
    
    /**
     * Metodo responsavel por retornar o Panel Novo.
     * @return Panel Novo.
     */
    public abstract PanelNovo getPanelNovo();
    
    @Override
    public ViewNovo getView() {
        return (ViewNovo) view;
    }
}