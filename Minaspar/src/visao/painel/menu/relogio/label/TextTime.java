package visao.painel.menu.relogio.label;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * <p>Classe de Visao <b>TextTime</b>.</p>
 * <p>Classe responsavel por definir o <b>Text Label da Hora</b> do SGBov.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    javax.swing.JTextField
 */
public class TextTime extends JTextField {
    private final Timer timer;
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public TextTime() {
        timer = new Timer(1000, e -> setText(getTime()));
        timer.setDelay(0);
        timer.start();
        setDefaultProperties();
    }
    
    /**
     * Metodo responsavel por definir as Propriedades Padrao do Text Time.
     */
    private void setDefaultProperties() {
        setEditable(false);
        setColumns(8);
    }
    
    /**
     * Metodo responsavel por retornar a Hora atualizada.
     * @return Hora atualizada.
     */
    private String getTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
