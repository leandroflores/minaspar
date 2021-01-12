package visao.painel.menu.relogio;

import java.awt.FlowLayout;
import visao.painel.Panel;
import visao.painel.menu.relogio.label.TextDate;
import visao.painel.menu.relogio.label.TextTime;

/**
 * <p>Classe de Visao <b>PanelRelogio</b>.</p>
 * <p>Classe responsavel por definir o <b>Painel de Relogio</b> do SGBov.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    visao.painel.Panel
 * @see    visao.painel.menu.relogio.label.TextDate
 * @see    visao.painel.menu.relogio.label.TextTime
 */
public final class PanelRelogio extends Panel {
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public PanelRelogio() {
        addComponents();
    }
    
    @Override
    protected void addComponents() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(createLabel("Data: "));
        add(new TextDate());
        add(createLabel(" - "));
        add(createLabel("Hora: "));
        add(new TextTime());
    }
}