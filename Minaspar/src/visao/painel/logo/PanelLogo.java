package visao.painel.logo;

import funct.FunctView;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import visao.painel.Panel;

/**
 * <p>Classe de Visao <b>PanelLogo</b>.</p>
 * <p>Classe responsavel por definir o <b>Painel de Logo</b> do SGBov.</p>
 * @author Leandro
 * @since  16/12/2020
 * @see    visao.painel.Panel
 */
public final class PanelLogo extends Panel {
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public PanelLogo() {
        addComponents();
    }
    
    @Override
    protected void addComponents() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(new JLabel(new FunctView().createImage("logo")));
        setPreferredSize(new Dimension(600, 300));
    }
}