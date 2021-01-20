package visao.painel.filtro.consulta.balanco;

import controlador.visao.painel.filtro.ControllerPanelFiltro;
import funct.FunctDate;
import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.JTextField;
import visao.modal.consulta.balanco.ViewConsultaBalanco;
import visao.painel.filtro.PanelFiltro;

/**
 * <p>Classe de Visao <b>PanelFiltroBalanco</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Filtro do Balanco</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.painel.filtro.ControllerPanelFiltro
 * @see    modelo.entidade.estoque.Item
 * @see    visao.painel.filtro.PanelFiltro
 */
public final class PanelFiltroBalanco extends PanelFiltro {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Balanco.
     */
    public PanelFiltroBalanco(ViewConsultaBalanco view) {
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
        add(createLabel("Ano*: ", 100));
        add(createYearTextField("ano"));
        getTextFieldAno().setText(getAno());
        add(createLabel("Produto/Cód. Barras: ", 200));
        add(createTextField("produto", "", 20));
        add(createButtonAtualizar());
    }
    
    /**
     * Metodo responsavel por retornar o Valor do Ano.
     * @return Valor do Ano.
     */
    private String getAno() {
        return Integer.toString(new FunctDate().getYearValue(new Date()) - 1);
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Ano.
     * @return Text Field Ano.
     */
    public JTextField getTextFieldAno() {
        return getTextField("ano");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Produto.
     * @return Text Field Produto.
     */
    public JTextField getTextFieldProduto() {
        return getTextField("produto");
    }
}