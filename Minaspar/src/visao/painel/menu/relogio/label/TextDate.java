package visao.painel.menu.relogio.label;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * <p>Classe de Visao <b>TextDate</b>.</p>
 * <p>Classe responsavel por definir o <b>Text Label da Data</b> do SGBov.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    javax.swing.JTextField
 */
public class TextDate extends JTextField {
    private final Timer timer;
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public TextDate() {
        timer = new Timer(1000, e -> setText(getDate()));
        timer.setDelay(0);
        timer.start();
        setDefaultProperties();
    }
    
    /**
     * Metodo responsavel por definir as Propriedades Padrao do Text Date.
     */
    private void setDefaultProperties() {
        setEditable(false);
        setColumns(8);
    }
    
    /**
     * Metodo responsavel por retornar a Data atualizada.
     * @return Data atualizada.
     */
    private String getDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
