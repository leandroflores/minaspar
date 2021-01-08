package controlador.visao.modal;

import controlador.Controller;
import funct.FunctDate;
import funct.FunctString;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import visao.modal.ViewModal;
import visao.modal.mensagem.ViewErro;

/**
 * <p>Classe de Controle <b>ControllerViewModal</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> das Views Modais do SGBov.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    controlador.Controller
 * @see    visao.ViewModal
 */
public abstract class ControllerViewModal extends Controller {
    protected final ViewModal view;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Modal.
     */
    public ControllerViewModal(ViewModal view) {
        this.view = view;
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        if (ESC == event.getKeyCode())
            view.dispose();
    }
    
    /**
     * Metodo responsavel por retornar se o Text Field esta preenchido.
     * @param  component Text Component.
     * @param  message Mensagem de Erro.
     * @return Text Field preenchido.
     */
    protected boolean check(JTextComponent component, String message) {
        String texto = component.getText().trim();
        if (!check(texto)) {
            new ViewErro(view, message).setVisible(true);
            component.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * Metodo responsavel por retornar se o Text Field esta preenchido com CPF.
     * @param  textField Text Field.
     * @param  mensagem Mensagem de Erro.
     * @return Text Field preenchido com CPF.
     */
    protected boolean checkCPF(JTextField textField, String mensagem) {
        String texto = textField.getText().trim();
        if (!checkCpf(texto)) {
            new ViewErro(view, mensagem).setVisible(true);
            textField.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * Metodo responsavel por retornar se o Text Field esta preenchido com Numeros.
     * @param  textField Text Field.
     * @param  mensagem Mensagem de Erro.
     * @return Text Field preenchido com Numeros.
     */
    protected boolean checkNumero(JTextField textField, String mensagem) {
        String texto = textField.getText().trim();
        if (!checkNumeros(texto)) {
            new ViewErro(view, mensagem).setVisible(true);
            textField.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * Metodo responsavel por retornar se o Text Field esta preenchido com Valor.
     * @param  textField Text Field.
     * @param  mensagem Mensagem de Erro.
     * @return Text Field preenchido com Valor.
     */
    protected boolean checkValor(JTextField textField, String mensagem) {
        String texto = textField.getText().replace("R$", "").replaceAll("\\.", "").replace(",", ".").trim();
        if (!checkValor(texto)) {
            new ViewErro(view, mensagem).setVisible(true);
            textField.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * Metodo responsavel por retornar se o Text Field esta preenchido com uma Data.
     * @param  textField Text Field.
     * @param  mensagem Mensagem de Erro.
     * @return Text Field preenchido com uma Data.
     */
    protected boolean checkData(JTextField textField, String mensagem) {
        String texto = textField.getText().trim();
        if (!checkData(texto)) {
            new ViewErro(view, mensagem).setVisible(true);
            textField.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * Metodo responsavel por retornar se o Text Field esta preenchido com o Ano.
     * @param  textField Text Field.
     * @param  mensagem Mensagem de Erro.
     * @return Text Field preenchido com o Ano.
     */
    protected boolean checkAno(JTextField textField, String mensagem) {
        String texto = textField.getText().trim();
        if (!checkAno(texto)) {
            new ViewErro(view, mensagem).setVisible(true);
            textField.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * Metodo responsavel por retornar se o Combo Box foi selecionado.
     * @param  comboBox Combo Box.
     * @param  mensagem Mensagem de Erro.
     * @return Combo Box selecionado.
     */
    protected boolean check(JComboBox comboBox, String mensagem) {
        if (comboBox.getSelectedIndex() == 0) {
            new ViewErro(view, mensagem).setVisible(true);
            comboBox.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * Metodo responsavel por retornar a String do Text Field.
     * @param  textField Text Field.
     * @return String do Text Field.
     */
    protected String getString(JTextField textField) {
        return new FunctString().removeCharEspeciais(textField.getText().trim());
    }
    
    /**
     * Metodo responsavel por retornar a String do Combo Box.
     * @param  comboBox Combo Box.
     * @return String do Combo Box.
     */
    protected String getString(JComboBox comboBox) {
        return new FunctString().removeCharEspeciais(comboBox.getSelectedItem().toString().trim());
    }
    
    /**
     * Metodo responsavel por retornar a String do Text Field.
     * @param  textField Text Field.
     * @return String do Text Field.
     */
    protected String getStringSimples(JTextField textField) {
        return textField.getText().trim();
    }
    
    /**
     * Metodo responsavel por retornar a String selecionada do Combo Box.
     * @param  comboBox Combo Box.
     * @return String selecionada do Combo Box.
     */
    protected String getValor(JComboBox comboBox) {
        return comboBox.getSelectedItem().toString();
    }
    
    /**
     * Metodo responsavel por retornar o Inteiro do Text Field.
     * @param  textField Text Field.
     * @return Integer do Text Field.
     */
    protected Integer getInteger(JTextField textField) {
        return Integer.parseInt(textField.getText().trim());
    }
    
    /**
     * Metodo responsavel por retornar o Inteiro do Spinner.
     * @param  spinner Spinner.
     * @return Integer do Spinner.
     */
    protected Integer getInteger(JSpinner spinner) {
        return Integer.parseInt(spinner.getValue().toString().trim());
    }
    
    /**
     * Metodo responsavel por retornar o Float do Text Field.
     * @param  textField Text Field.
     * @return Float do Text Field.
     */
    protected Float getFloat(JTextField textField) {
        String valor = textField.getText().replace("R$", "").replaceAll("\\.", "").replace(",", ".").trim();
        return Float.parseFloat(valor);
    }
    
    /**
     * Metodo responsavel por setar o Float do Text Field.
     * @param textField Text Field.
     * @param valor Valor.
     */
    protected void setFloat(JTextField textField, Float valor) {
        textField.setText(new DecimalFormat("R$ #,##0.00").format(valor));
    }
    
    /**
     * Metodo responsavel por retornar a Data do Text Field.
     * @param  textField Text Field.
     * @return Data do Text Field.
     */
    protected Date getData(JTextField textField) {
        return new FunctDate().createDate(textField.getText().trim());
    }
    
    /**
     * Metodo responsavel por retornar a View Modal.
     * @return View Modal.
     */
    public ViewModal getView() {
        return view;
    }
}