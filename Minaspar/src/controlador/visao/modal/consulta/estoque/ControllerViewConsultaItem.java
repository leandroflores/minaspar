package controlador.visao.modal.consulta.estoque;

import controlador.visao.modal.consulta.ControllerViewConsulta;
import java.util.ArrayList;
import java.util.List;
import modelo.controlador.estoque.ControllerItem;
import modelo.dao.estoque.DaoItem;
import modelo.entidade.estoque.Item;
import visao.modal.consulta.estoque.ViewConsultaItem;
import visao.modal.novo.estoque.ViewNovoItem;
import visao.painel.consulta.filtro.estoque.PanelFiltroItem;

/**
 * <p>Classe de Controle <b>ControllerViewConsultaItem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewConsultaItem.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.consulta.ControllerViewConsulta
 * @see    modelo.dao.estoque.DaoItem
 * @see    modelo.entidade.estoque.Item
 * @see    visao.modal.consulta.estoque.ViewConsultaItem
 */
public class ControllerViewConsultaItem extends ControllerViewConsulta {
    private final DaoItem dao;
    private List<Item> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Item.
     */
    public ControllerViewConsultaItem(ViewConsultaItem view) {
        super(view);
        dao  = new DaoItem();
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
        Integer ano     = getInteger(getFiltro().getTextFieldAno());
        String  produto = getStringSimples(getFiltro().getTextFieldProduto());
                list    = dao.filter(ano, produto);
    }
    
    @Override
    public void novo() {
        new ViewNovoItem(getView()).setVisible(true);
    }

    @Override
    public void editar() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        //if (indice >= 0 && indice < tamanho)
        //    new ViewEditarProduto(getView(), list.get(indice)).setVisible(true);
        //else
        //    new ViewErro(getView(), "Selecione um Produto!").setVisible(true);
    }

    @Override
    public void excluir() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        //if (indice >= 0 && indice < tamanho)
        //    new ViewExcluirProduto(getView(), list.get(indice)).setVisible(true);
        //else
        //    new ViewErro(getView(), "Selecione um Produto!").setVisible(true);
    }
    
    @Override
    public ControllerItem getController() {
        return new ControllerItem();
    }
    
    @Override
    public PanelFiltroItem getFiltro() {
        return (PanelFiltroItem) super.getFiltro();
    }
    
    @Override
    public ViewConsultaItem getView() {
        return (ViewConsultaItem) view;
    }
}