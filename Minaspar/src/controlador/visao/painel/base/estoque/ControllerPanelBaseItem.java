package controlador.visao.painel.base.estoque;

import controlador.visao.painel.base.ControllerPanelBase;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeEvent;
import modelo.dao.estoque.DaoProduto;
import modelo.entidade.estoque.Produto;
import visao.painel.base.estoque.PanelBaseItem;

/**
 * <p>Classe de Controle <b>ControllerPanelBaseItem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelBaseItem.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.painel.base.ControllerPanelBase
 * @see    modelo.entidade.estoque.Item
 * @see    visao.painel.base.estoque.PanelBaseItem
 */
public final class ControllerPanelBaseItem extends ControllerPanelBase {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Base Item.
     */
    public ControllerPanelBaseItem(PanelBaseItem panel) {
        super(panel);
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        if (getPanel().getTextFieldCodigoBarras().equals(event.getSource())) {
            if (event.getKeyCode() == ENTER)
                findProduto();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent event) {
        if (getPanel().getTextFieldValorUnitario().equals(event.getSource()))
            updateValorTotal();
    }
    
    @Override
    public void stateChanged(ChangeEvent event) {
        updateValorTotal();
    }
    
    /**
     * Metodo responsavel por atualizar o Valor Total.
     */
    private void updateValorTotal() {
        if (getPanel().getProduto() != null) {
            try {
                setFloat(getPanel().getTextFieldValorTotal(), getValorTotal());
            }catch (Exception exception) {
                setFloat(getPanel().getTextFieldValorTotal(), 0.00f);
            }
        }
    }
    
    /**
     * Metodo responsavel por retornar o Valor Total do Item.
     * @return Valor Total do Item.
     */
    private Float getValorTotal() {
        Integer quantidade = (Integer) getPanel().getSpinnerQuantidade().getValue();
        Float   valor      = getDecimal(getPanel().getTextFieldValorUnitario());
        return  quantidade * valor;
    }
    
    /**
     * Metodo responsavel por encontrar o Produto pelo Codigo de Barras.
     */
    private void findProduto() {
        String  codigo  = getPanel().getTextFieldCodigoBarras().getText();
        Produto produto = new DaoProduto().find(codigo);
        if (produto != null)
            getPanel().setProduto(produto);
    }
    
    @Override
    public PanelBaseItem getPanel() {
        return (PanelBaseItem) panel;
    }
}