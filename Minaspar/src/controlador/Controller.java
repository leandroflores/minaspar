package controlador;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * <p>Classe de Controle <b>Controller</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> das Views do Sistema.</p>
 * @author Leandro
 * @since  10/01/2021
 * @see    java.awt.event.ActionListener
 * @see    java.awt.event.KeyListener
 * @see    javax.swing.event.DocumentListener
 * @see    javax.swing.event.DocumentListener
 */
public abstract class Controller implements ActionListener, KeyListener, ChangeListener, DocumentListener {
    protected static final int ENTER = KeyEvent.VK_ENTER;
    protected static final int ESC   = KeyEvent.VK_ESCAPE;
    protected static final int F1    = KeyEvent.VK_F1;
    protected static final int F2    = KeyEvent.VK_F2;
    protected static final int F3    = KeyEvent.VK_F3;
    protected static final int F4    = KeyEvent.VK_F4;
    protected static final int F5    = KeyEvent.VK_F5;
    protected static final int F6    = KeyEvent.VK_F6;
    protected static final int F7    = KeyEvent.VK_F7;
    protected static final int F8    = KeyEvent.VK_F8;
    protected static final int F9    = KeyEvent.VK_F9;
    protected static final int F10   = KeyEvent.VK_F10;
    protected static final int F11   = KeyEvent.VK_F11;
    protected static final int F12   = KeyEvent.VK_F12;
    protected static final int DOWN  = KeyEvent.VK_DOWN;
    protected static final int LEFT  = KeyEvent.VK_LEFT;
    protected static final int RIGHT = KeyEvent.VK_RIGHT;
    protected static final int UP    = KeyEvent.VK_UP;

    @Override
    public void keyTyped(KeyEvent event) {}

    @Override
    public void keyReleased(KeyEvent event) {}
    
    @Override
    public void stateChanged(ChangeEvent event) {}
    
    @Override
    public void insertUpdate(DocumentEvent event) {}

    @Override
    public void removeUpdate(DocumentEvent event) {}

    @Override
    public void changedUpdate(DocumentEvent event) {}
    
    /**
     * Metodo responsavel por checar a Expressao de Campo Obrigatorio.
     * @param  string String com os valores.
     * @return String valida.
     */
    protected boolean check(String string) {
        return string.trim().equals("") == false;
    }
    
    /**
     * Metodo responsavel por checar a Expressao Regular do Ano.
     * @param  string String com os valores.
     * @return String valida.
     */
    protected boolean checkAno(String string) {
        return string.matches("\\d\\d\\d\\d");
    }
    
    /**
     * Metodo responsavel por checar a Expressao Regular de CPF.
     * @param  string String com os valores.
     * @return String valida.
     */
    protected boolean checkCpf(String string) {
        return string.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
    }
    
    /**
     * Metodo responsavel por checar a Expressao Regular de Data.
     * @param  string String com os valores.
     * @return String valida.
     */
    protected boolean checkData(String string) {
        return string.matches("\\d{2}\\/\\d{2}\\/\\d{4}");
    }
    
    /**
     * Metodo responsavel por checar a Expressao Regular de Numeros.
     * @param  string String com os valores.
     * @return String valida.
     */
    protected boolean checkNumeros(String string) {
        return string.matches("\\d+");
    }
    
    /**
     * Metodo responsavel por checar a Expressao Regular de Valores Decimais.
     * @param  string String com os valores.
     * @return String valida.
     */
    protected boolean checkValor(String string) {
        return string.matches("^-?\\d*\\.\\d{2}$");
    }
}