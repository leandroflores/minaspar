package visao.painel.base.estoque;

import controlador.visao.painel.base.estoque.ControllerPanelBaseItem;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import modelo.entidade.estoque.Item;
import modelo.entidade.estoque.Produto;
import visao.painel.Panel;
import visao.painel.base.PanelBase;

/**
 * <p>Classe de Visao <b>PanelBaseItem</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel Base do Item de Estoque</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.painel.base.estoque.ControllerPanelBaseItem
 * @see    modelo.entidade.estoque.Item
 * @see    visao.painel.base.PanelBase
 */
public final class PanelBaseItem extends PanelBase {
    private final Item item;
    private Produto produto;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Owner.
     * @param item_ Item.
     */
    public PanelBaseItem(Panel panel, Item item_) {
        super(panel);
        item       = item_;
        produto    = item_.getProduto();
        controller = new ControllerPanelBaseItem(this);
        setProperties();
        addComponents();
        setValues();
    }
    
    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(150, 200));
        setMaximumSize(new Dimension(150, 200));
        setLayout(new GridBagLayout());
    }
    
    @Override
    protected void addComponents() {
        add(createRightLabel("Ano*: "), createConstraints(1, 1, 0, 0));
        add(createYearTextField("ano"), createConstraints(1, 1, 1, 0));
        add(createRightLabel("Cód. Barras*: "), createConstraints(1, 1, 2, 0));
        add(createTextField("codigo_barras", "", 10), createConstraints(3, 1, 3, 0));
        add(createRightLabel(" "), createConstraints(1, 1, 6, 0));
        
        add(createRightLabel("Produto*: "), createConstraints(1, 1, 0, 1));
        add(createTextFieldNoEditable("produto", "", 15), createConstraints(5, 1, 1, 1));
        add(createButton("pesquisa", "", "pesquisa"), createConstraints(1, 1, 6, 1));
        getButtonPesquisaProduto().setMinimumSize(new Dimension(75, 30));
        getButtonPesquisaProduto().setMaximumSize(new Dimension(75, 30));
        
        add(createRightLabel("Descrição*: "), createConstraints(1, 1, 0, 2));
        add(createTextField("descricao", "", 15), createConstraints(5, 1, 1, 2));
        add(createRightLabel(" "), createConstraints(1, 1, 6, 2));
        
        add(createRightLabel("Quantidade*: "), createConstraints(1, 1, 0, 3));
        add(createSpinnerEditable("quantidade"), createConstraints(1, 1, 1, 3));
        getSpinnerQuantidade().addChangeListener(controller);
        add(createRightLabel("Valor Unitário*: ", 140), createConstraints(1, 1, 2, 3));
        add(createDecimalTextField("valor_unitario", 0.00f, 7), createConstraints(1, 1, 3, 3));
        add(createRightLabel("Valor Total*: ", 110), createConstraints(1, 1, 4, 3));
        add(createDecimalTextField("valor_total", 0.00f, 8), createConstraints(1, 1, 5, 3));
        getTextFieldValorTotal().setEditable(false);
        add(createRightLabel(" "), createConstraints(1, 1, 6, 3));
    }
    
    @Override
    public void setValues() {
        getTextFieldAno().setText(Integer.toString(item.getAno()));
        getSpinnerQuantidade().setValue(item.getQuantidade());
        getTextFieldValorTotal().setText(item.getValorTotalFormatado());
        setDadosProduto();
    }
    
    /**
     * Metodo responsavel por retornar o Produto.
     * @return Produto.
     */
    public Produto getProduto() {
        return produto;
    }
    
    /**
     * Metodo responsavel por definir o Produto.
     * @param produto_ Produto.
     */
    public void setProduto(Produto produto_) {
        produto = produto_;
        setDadosProduto();
    }
    
    /**
     * Metodo responsavel por preencher os Dados do Produto.
     */
    private void setDadosProduto() {
        getTextFieldCodigoBarras().setText(produto != null ? produto.getCodigoBarras(): "");
        getTextFieldProduto().setText(produto != null ? produto.toString(): "");
        getTextFieldDescricao().setText(produto != null ? produto.getDescricao(): "");
        getTextFieldValorUnitario().setText(produto != null ? produto.getValorUnitarioFormatado(): "");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Ano.
     * @return Text Field Ano.
     */
    public JTextField getTextFieldAno() {
        return getTextField("ano");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Codigo de Barras.
     * @return Text Field Codigo de Barras.
     */
    public JTextField getTextFieldCodigoBarras() {
        return getTextField("codigo_barras");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Produto.
     * @return Text Field Produto.
     */
    public JTextField getTextFieldProduto() {
        return getTextField("produto");
    }
    
    /**
     * Metodo responsavel por retornar o Button Pesquisa Produto.
     * @return Button Pesquisa Produto.
     */
    public JButton getButtonPesquisaProduto() {
        return getButton("pesquisa");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Descricao.
     * @return Text Field Descricao.
     */
    public JTextField getTextFieldDescricao() {
        return getTextField("descricao");
    }
    
    /**
     * Metodo responsavel por retornar o Spinner Quantidade.
     * @return Spinner Quantidade.
     */
    public JSpinner getSpinnerQuantidade() {
        return getSpinner("quantidade");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Valor Unitario.
     * @return Text Field Valor Unitario.
     */
    public JTextField getTextFieldValorUnitario() {
        return getTextField("valor_unitario");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Valor Total.
     * @return Text Field Valor Total.
     */
    public JTextField getTextFieldValorTotal() {
        return getTextField("valor_total");
    }
}