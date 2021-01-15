package controlador.visao.modal.consulta.balanco;

import controlador.visao.modal.consulta.ControllerViewConsulta;
import java.util.ArrayList;
import java.util.List;
import modelo.controlador.estoque.ControllerItem;
import modelo.dao.estoque.DaoItem;
import modelo.entidade.estoque.Item;
import visao.modal.consulta.balanco.ViewConsultaBalanco;
import visao.modal.editar.estoque.ViewEditarItem;
import visao.modal.excluir.estoque.ViewExcluirItem;
import visao.modal.mensagem.ViewErro;
import visao.modal.novo.estoque.ViewNovoItem;
import visao.painel.consulta.filtro.balanco.PanelFiltroBalanco;

/**
 * <p>Classe de Controle <b>ControllerViewConsultaBalanco</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewConsultaBalanco.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    controlador.visao.modal.consulta.ControllerViewConsulta
 * @see    modelo.dao.estoque.DaoItem
 * @see    modelo.entidade.estoque.Item
 * @see    visao.modal.consulta.balanco.ViewConsultaBalanco
 */
public class ControllerViewConsultaBalanco extends ControllerViewConsulta {
    private final DaoItem dao;
    private List<Item> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Balanco.
     */
    public ControllerViewConsultaBalanco(ViewConsultaBalanco view) {
        super(view);
        dao  = new DaoItem();
        list = new ArrayList<>();
    }
    
    @Override
    public void update() {
        pesquisar();
        getView().addRows("consulta", getController().getMatriz(list));
        getView().setCount(list.size());
        getView().setTotal(getController().getTotal(list));
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
        if (indice >= 0 && indice < tamanho)
            new ViewEditarItem(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione um Item!").setVisible(true);
    }

    @Override
    public void excluir() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            new ViewExcluirItem(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione um Item!").setVisible(true);
    }
    
    @Override
    public ControllerItem getController() {
        return new ControllerItem();
    }
    
    @Override
    public PanelFiltroBalanco getFiltro() {
        return (PanelFiltroBalanco) super.getFiltro();
    }
    
    @Override
    public ViewConsultaBalanco getView() {
        return (ViewConsultaBalanco) view;
    }
}