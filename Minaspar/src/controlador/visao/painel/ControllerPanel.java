package controlador.visao.painel;

import controlador.Controller;
import funct.FunctDate;
import funct.FunctString;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.JTextComponent;
import visao.painel.Panel;

/**
 * <p>Classe de Controle <b>ControllerPanel</b>.</p>
 * <p>Classe responsavel por controlar os <b>Eventos</b> dos <b>Paineis</b> do SGBov.</p>
 * @author Leandro
 * @since  16/12/2020
 * @see    controlador.Controller
 * @see    visao.painel.Panel
 */
public abstract class ControllerPanel extends Controller {
    protected final Panel panel;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Painel.
     */
    public ControllerPanel(Panel panel) {
        this.panel = panel;
    }
    
    /**
     * Metodo responsavel por retornar a Cor Padrao.
     * @return Cor Padrao.
     */
    protected Color getDefaultColor() {
        return panel.getBackground();
    }
    
    /**
     * Metodo responsavel por retornar a Cor de Foco.
     * @return Cor de Foco.
     */
    protected Color getFocusColor() {
        return ColorUIResource.LIGHT_GRAY;
    }
   
    /**
     * Metodo responsavel por retornar o Valor Inteiro.
     * @param  string String.
     * @return Valor Inteiro.
     */
    protected Integer getInteger(String string) {
        try {
            return Integer.parseInt(string);
        }catch (NumberFormatException exception) {
            return 0;
        }
    }
    
    /**
     * Metodo responsavel por retornar o Valor Decimal
     * @param  string String.
     * @return Valor Decimal.
     */
    protected Float getDecimalValue(String string) {
        try {
            return Float.parseFloat(string);
        }catch (NumberFormatException exception) {
            return 0.0f;
        }
    }
    
    /**
     * Metodo responsavel por retornar a String de um Componente de Texto.
     * @param  component Componente de Texto.
     * @return String de um Componente de Texto.
     */
    protected String getString(JTextComponent component) {
        return new FunctString().removeCharEspeciais(component.getText().trim());
    }
    
    /**
     * Metodo responsavel por retornar a Data de um Componente de Texto.
     * @param  component Componente de Texto.
     * @return Data de um Componente de Texto.
     */
    protected Date getDate(JTextField component) {
        return new FunctDate().createDate(component.getText().trim());
    }
    
    /**
     * Metodo responsavel por retornar o Valor Inteiro de um Componente de Texto.
     * @param  component Componente de Texto.
     * @return Valor Inteiro de um Componente de Texto.
     */
    protected Integer getInteger(JTextComponent component) {
        return getInteger(component.getText().trim());
    }
    
    /**
     * Metodo responsavel por retornar o Valor Decimal de um Componente de Texto.
     * @param  component Componente de Texto.
     * @return Valor Decimal de um Componente de Texto.
     */
    protected Float getDecimal(JTextComponent component) {
        return getDecimalValue(component.getText().replaceAll("R\\$", "").replaceAll("\\.", "").replaceAll(",", ".").trim());
    }
    
    /**
     * Metodo responsavel por setar o Float do Text Field.
     * @param textField JTextField.
     * @param valor Valor.
     */
    protected void setFloat(JTextField textField, Float valor) {
        textField.setText(new DecimalFormat("R$ #,##0.00").format(valor));
    }
    
    /**
     * Metodo responsavel por retornar o Valor do Combo Box.
     * @param  comboBox Combo Box.
     * @return Valor do Combo Box.
     */
    protected String getValue(JComboBox comboBox) {
        return comboBox.getSelectedItem().toString();
    }
    
    /**
     * Metodo responsavel por retornar o Painel.
     * @return Painel.
     */
    public Panel getPanel() {
        return panel;
    }
}