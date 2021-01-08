package visao.modal.mensagem;

import controlador.visao.modal.mensagem.ControllerViewErro;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import visao.View;
import visao.modal.ViewModal;

/**
 * <p>Classe de Visao <b>ViewErro</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Erro</b> do Sistema.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    controlador.visao.modal.mensagem.ControllerViewErro
 * @see    visao.View
 * @see    visao.modal.ViewModal
 */
public final class ViewErro extends ViewModal {
    private final String mensagem;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View do Sistema.
     * @param message Mensagem a ser exibida.
     */
    public ViewErro(View view, String message) {
        super(view);
        mensagem   = message;
        title      = "Erro";
        controller = new ControllerViewErro(this);
        setProperties();
        addComponents();
    }
    
    /**
     * Metodo construtor alternativo da Classe.
     * @param view View Modal do Sistema.
     * @param message Mensagem a ser exibida.
     */
    public ViewErro(ViewModal view, String message) {
        super(view);
        mensagem   = message;
        title      = "Erro";
        controller = new ControllerViewErro(this);
        setProperties();
        addComponents();
    }

    @Override
    public void setProperties() {
        updateTitle();
        setSize(mensagem.length() + 500, 160);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }
    
    @Override
    public void addComponents() {
        addHeader();
        addBody();
        addFooter();
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getVerticalSpace(20));
        getContentPane().add(createLabelImage("icones/erro"));
    }
    
    @Override
    public void addBody() {
        getContentPane().add(getVerticalSpace(10));
        getContentPane().add(createLabel(mensagem));
        getContentPane().add(getVerticalSpace(10));
    }
    
    @Override
    public void addFooter() {
        getContentPane().add(createButton("ok", "   Ok   ", "sim"));
    }

    /**
     * Metodo responsavel por retornar o Botao Ok.
     * @return Botao Ok.
     */
    public JButton getButtonOk() {
        return getButton("ok");
    }
}