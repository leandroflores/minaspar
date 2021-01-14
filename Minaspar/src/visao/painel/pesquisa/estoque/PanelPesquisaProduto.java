package visao.painel.pesquisa.estoque;

import controlador.visao.painel.pesquisa.estoque.ControllerPanelPesquisaProduto;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import visao.modal.pesquisa.estoque.ViewPesquisaProduto;
import visao.painel.pesquisa.PanelPesquisa;

/**
 * <p>Classe de Visao <b>PanelPesquisaBovino</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Pesquisa de Produto</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.painel.pesquisa.estoque.ControllerPanelPesquisaProduto
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.painel.pesquisa.PanelPesquisa
 */
public final class PanelPesquisaProduto extends PanelPesquisa {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Pesquisa Produto.
     */
    public PanelPesquisaProduto(ViewPesquisaProduto view) {
        super(view);
        controller = new ControllerPanelPesquisaProduto(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    protected void addComponents() {
        add(createLabel("Tipo: ", 70));
        add(createComboBox("tipo", getTipos(), 30));
        getComboBoxTipo().setPreferredSize(new Dimension(150, 30));
        add(createLabel("Produto*: ", 100));
        add(createTextField("produto", "", 20));
        add(createButton("atualizar", "", "atualizar"));
    }
    
    /**
     * Metodo responsavel por retornar os Tipos dos Produtos.
     * @return Tipos dos Produtos.
     */
    private String[] getTipos() {
        return new String[]{"", "MEDICAMENTO", "PERFUMARIA", "OUTROS"};
    }
    
    /**
     * Metodo responsavel por retornar o Combo Box Tipo.
     * @return Check Box Tipo.
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
    
    /**
     * Metodo responsavel por retornar o Button Atualizar.
     * @return Button Atualizar.
     */
    public JButton getButtonAtualizar() {
        return getButton("atualizar");
    }
}