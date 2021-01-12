package visao.painel.menu.titulo;

import java.awt.FlowLayout;
import visao.painel.Panel;

/**
 * <p>Classe de Visao <b>PanelTitulo</b>.</p>
 * <p>Classe responsavel por definir o <b>Painel de Titulo</b> do SGBov.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    visao.painel.Panel
 */
public final class PanelTitulo extends Panel {
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public PanelTitulo() {
        addComponents();
    }
    
    @Override
    protected void addComponents() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(createTitleLabel("Minaspar - Controle de Estoque"));
    }
}