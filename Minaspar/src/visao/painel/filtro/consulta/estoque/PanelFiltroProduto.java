package visao.painel.filtro.consulta.estoque;

import controlador.visao.painel.filtro.ControllerPanelFiltro;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import visao.modal.consulta.estoque.ViewConsultaProduto;
import visao.painel.filtro.PanelFiltro;

/**
 * <p>Classe de Visao <b>PanelFiltroProduto</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Filtro do Produto</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.painel.filtro.ControllerPanelFiltro
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.painel.filtro.PanelFiltro
 */
public final class PanelFiltroProduto extends PanelFiltro {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Produto.
     */
    public PanelFiltroProduto(ViewConsultaProduto view) {
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