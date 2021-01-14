package visao.painel.consulta.filtro.estoque;

import controlador.visao.painel.consulta.filtro.ControllerPanelFiltro;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import visao.modal.consulta.estoque.ViewConsultaProduto;
import visao.painel.consulta.filtro.PanelFiltro;

/**
 * <p>Classe de Visao <b>PanelFiltroItem</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Filtro do Item</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.painel.consulta.filtro.ControllerPanelFiltro
 * @see    modelo.entidade.estoque.Item
 * @see    visao.painel.consulta.filtro.PanelFiltro
 */
public final class PanelFiltroItem extends PanelFiltro {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Item.
     */
    public PanelFiltroItem(ViewConsultaProduto view) {
        super(view);
        controller = new ControllerPanelFiltro(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    protected void addComponents() {
        add(createLabel("Produto/Cód. Barras: ", 200));
        add(createTextField("produto", "", 20));
        add(createButtonAtualizar());
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Produto.
     * @return Text Field Produto.
     */
    public JTextField getTextFieldProduto() {
        return getTextField("produto");
    }
}