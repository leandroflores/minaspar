package controlador.visao.modal.pesquisa.estoque;

import controlador.visao.modal.pesquisa.ControllerViewPesquisa;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import modelo.controlador.estoque.ControllerProduto;
import modelo.dao.estoque.DaoProduto;
import modelo.entidade.estoque.Produto;
import visao.modal.mensagem.ViewErro;
import visao.modal.pesquisa.estoque.ViewPesquisaProduto;

/**
 * <p>Classe de Controle <b>ControllerViewPesquisaProduto</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewPesquisaProduto.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.pesquisa.ControllerViewPesquisa
 * @see    modelo.controlador.estoque.ControllerProduto
 * @see    modelo.dao.estoque.DaoProduto
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.modal.pesquisa.estoque.ViewPesquisaProduto
 */
public class ControllerViewPesquisaProduto extends ControllerViewPesquisa {
    private final DaoProduto dao;
    private List<Produto> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Pesquisa Produto.
     */
    public ControllerViewPesquisaProduto(ViewPesquisaProduto view) {
        super(view);
        dao  = new DaoProduto();
        list = new ArrayList<>();
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getView().getPanelPesquisa().getButtonAtualizar().equals(event.getSource()))
            update();
    }

    @Override
    public void update() {
        pesquisar();
        getView().addRows("pesquisa", getController().getDadosPesquisa(list));
    }
    
    @Override
    public void pesquisar() {
        String tipo    = getString(getView().getPanelPesquisa().getComboBoxTipo());
        String produto = getString(getView().getPanelPesquisa().getTextFieldProduto());
                list   = dao.filter(produto, tipo);
    }
    
    @Override
    public void selecionar() {
        Integer indice  = getView().getTable().getSelectedRow();
        Integer tamanho = list.size();
        if (indice >= 0 && indice < tamanho) {
            getView().getView().setValue(list.get(indice));
            getView().dispose();
        }else {
            new ViewErro(getView(), "Selecione um Produto!").setVisible(true);
        }
    }

    @Override
    public ControllerProduto getController() {
        return new ControllerProduto();
    }
    
    @Override
    public ViewPesquisaProduto getView() {
        return (ViewPesquisaProduto) view;
    }
}