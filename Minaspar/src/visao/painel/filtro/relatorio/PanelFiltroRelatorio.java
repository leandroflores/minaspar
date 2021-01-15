package visao.painel.filtro.relatorio;

import controlador.visao.painel.filtro.ControllerPanelFiltro;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import visao.modal.relatorio.balanco.ViewRelatorioBalanco;
import visao.painel.filtro.PanelFiltro;

/**
 * <p>Classe de Visao <b>PanelFiltroRelatorio</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Filtro de Relatorio</b> do Sistema.</p>
 * @author Leandro
 * @since  15/01/2021
 * @see    controlador.visao.painel.filtro.ControllerPanelFiltro
 * @see    modelo.entidade.estoque.Item
 * @see    visao.painel.filtro.PanelFiltro
 */
public final class PanelFiltroRelatorio extends PanelFiltro {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Relatorio Balanco.
     */
    public PanelFiltroRelatorio(ViewRelatorioBalanco view) {
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
        add(createLabel("Ano*: ", 50));
        add(createYearTextField("ano"));
        getTextFieldAno().setText("2020");
        add(createLabel("Tipo: ", 50));
        add(createComboBox("tipo", getTipos(), 150));
        add(createLabel("Produto/Cód. Barras: ", 175));
        add(createTextField("produto", "", 20));
        add(createButtonAtualizar());
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Tipos do Produto.
     * @return Lista de Tipos do Produto.
     */
    public String[] getTipos() {
        return new String[]{"", "MEDICAMENTO", "PERFUMARIA", "OUTROS"};
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Ano.
     * @return Text Field Ano.
     */
    public JTextField getTextFieldAno() {
        return getTextField("ano");
    }
    
    /**
     * Metodo responsavel por retornar o Combo Box Tipo.
     * @return Combo Box Tipo.
     */
    public JComboBox getComboBoxTipo() {
        return getComboBox("tipo");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Produto.
     * @return Text Field Produto.
     */
    public JTextField getTextFieldProduto() {
        return getTextField("produto");
    }
}