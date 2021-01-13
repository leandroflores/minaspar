package visao.painel.base.estoque;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import modelo.controlador.estoque.ControllerProduto;
import modelo.entidade.estoque.Produto;
import visao.painel.Panel;
import visao.painel.base.PanelBase;

/**
 * <p>Classe de Visao <b>PanelBaseProduto</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel Base do Produto</b> do Sistema.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.painel.base.
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.painel.base.PanelBase
 */
public final class PanelBaseProduto extends PanelBase {
    private final Produto produto;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Owner.
     * @param produto_ Produto.
     */
    public PanelBaseProduto(Panel panel, Produto produto_) {
        super(panel);
        produto    = produto_;
        //controller = new ControllerPanelBaseInseminacao(this);
        setProperties();
        addComponents();
        setValues();
    }
    
    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(400, 525));
        setMaximumSize(new Dimension(400, 525));
        setLayout(new GridLayout(4, 2));
    }
    
    @Override
    protected void addComponents() {
        add(createRightLabel("Cód. de Barras*: "));
        add(createTextField("codigo_barras", "", 10));
        
        add(createRightLabel("Descrição*: "));
        add(createTextField("descricao", "", 10));
        
        add(createRightLabel("Tipo*: "));
        add(createComboBox("tipo", new ControllerProduto().getTipos(), 10));
        
        add(createRightLabel("Valor Unitário*: "));
        add(createDecimalTextField("valor_unitario", 0.00f, 10));
    }
    
    @Override
    public void setValues() {
        getTextFieldCodigoBarras().setText(produto.getCodigoBarras());
        getTextFieldDescricao().setText(produto.getDescricao());
        getComboBoxTipo().setSelectedItem(produto.getTipo());
        getTextFieldValorUnitario().setText(produto.getValorUnitarioFormatado());
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Codigo de Barras.
     * @return Text Field Codigo de Barras.
     */
    public JTextField getTextFieldCodigoBarras() {
        return getTextField("codigo_barras");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Descricao.
     * @return Text Field Descricao.
     */
    public JTextField getTextFieldDescricao() {
        return getTextField("descricao");
    }
    
    /**
     * Metodo responsavel por retornar o Combo Box Tipo.
     * @return Combo Box Tipo.
     */
    public JComboBox getComboBoxTipo() {
        return getComboBox("tipo");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Valor Unitario.
     * @return Text Field Valor Unitario.
     */
    public JTextField getTextFieldValorUnitario() {
        return getTextField("valor_unitario");
    }
}