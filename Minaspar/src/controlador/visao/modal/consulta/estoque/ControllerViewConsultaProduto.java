package controlador.visao.modal.consulta.estoque;

import controlador.visao.modal.consulta.ControllerViewConsulta;
import java.util.ArrayList;
import java.util.List;
import modelo.controlador.estoque.ControllerProduto;
import modelo.dao.estoque.DaoProduto;
import modelo.entidade.estoque.Produto;
import visao.modal.consulta.estoque.ViewConsultaProduto;
import visao.modal.editar.estoque.ViewEditarProduto;
import visao.modal.excluir.estoque.ViewExcluirProduto;
import visao.modal.mensagem.ViewErro;
import visao.modal.novo.estoque.ViewNovoProduto;
import visao.painel.filtro.consulta.estoque.PanelFiltroProduto;

/**
 * <p>Classe de Controle <b>ControllerViewConsultaProduto</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewConsultaProduto.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    controlador.visao.modal.consulta.ControllerViewConsulta
 * @see    modelo.dao.estoque.DaoProduto
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.modal.consulta.estoque.ViewConsultaProduto
 */
public class ControllerViewConsultaProduto extends ControllerViewConsulta {
    private final DaoProduto dao;
    private List<Produto> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Produto.
     */
    public ControllerViewConsultaProduto(ViewConsultaProduto view) {
        super(view);
        dao  = new DaoProduto();
        list = new ArrayList<>();
    }
    
    @Override
    public void update() {
        pesquisar();
        getView().addRows("consulta", getController().getMatriz(list));
        getView().setCount(list.size());
    }
    
    @Override
    public void pesquisar() {
        String produto = getStringSimples(getFiltro().getTextFieldProduto());
               list = dao.filter(produto);
    }
    
    @Override
    public void novo() {
        new ViewNovoProduto(getView()).setVisible(true);
    }

    @Override
    public void editar() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            new ViewEditarProduto(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione um Produto!").setVisible(true);
    }

    @Override
    public void excluir() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            new ViewExcluirProduto(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione um Produto!").setVisible(true);
    }
    
    @Override
    public ControllerProduto getController() {
        return new ControllerProduto();
    }
    
    @Override
    public PanelFiltroProduto getFiltro() {
        return (PanelFiltroProduto) super.getFiltro();
    }
    
    @Override
    public ViewConsultaProduto getView() {
        return (ViewConsultaProduto) view;
    }
}