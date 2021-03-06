package controlador.visao.modal.relatorio.balanco;

import arquivo.relatorio.Relatorio;
import arquivo.relatorio.balanco.RelatorioBalanco;
import arquivo.relatorio.balanco.RelatorioBalancoAno;
import controlador.visao.modal.relatorio.ControllerViewRelatorio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.controlador.estoque.ControllerItem;
import modelo.dao.estoque.DaoItem;
import modelo.entidade.estoque.Item;
import net.sf.jasperreports.engine.JRException;
import visao.modal.mensagem.ViewErro;
import visao.modal.relatorio.balanco.ViewRelatorioBalanco;
import visao.painel.filtro.relatorio.PanelFiltroRelatorio;

/**
 * <p>Classe de Controle <b>ControllerViewRelatorioBalanco</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewRelatorioBalanco.</p>
 * @author Leandro
 * @since  15/01/2021
 * @see    controlador.visao.modal.relatorio.ControllerViewRelatorio
 * @see    modelo.dao.estoque.DaoItem
 * @see    modelo.entidade.estoque.Item
 * @see    visao.modal.relatorio.balanco.ViewRelatorioBalanco
 */
public class ControllerViewRelatorioBalanco extends ControllerViewRelatorio {
    private final DaoItem dao;
    private List<Item> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Relatorio Balanco.
     */
    public ControllerViewRelatorioBalanco(ViewRelatorioBalanco view) {
        super(view);
        dao  = new DaoItem();
        list = new ArrayList<>();
    }
    
    @Override
    public void update() {
        pesquisar();
        getView().addRows("relatorio", getController().getMatriz(list));
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
    public void imprimir() {
        try {
            Relatorio relatorio = createRelatorio();
                      relatorio.create();
            getView().dispose();
        }catch (JRException | SQLException exception) {
            System.out.println(exception);
            new ViewErro(getView(), "Erro ao criar o Relatório!").setVisible(true);
        }
    }

    /**
     * Metodo responsavel por Criar o Relatorio do Balanco.
     * @return Relatorio do Balanco.
     */
    private Relatorio createRelatorio() {
        if (checkAno(getString(getView().getFiltro().getTextFieldAno())))
            return new RelatorioBalancoAno(getInteger(getView().getFiltro().getTextFieldAno()));
        return new RelatorioBalanco();
    }
    
    @Override
    public ControllerItem getController() {
        return new ControllerItem();
    }
    
    @Override
    public PanelFiltroRelatorio getFiltro() {
        return (PanelFiltroRelatorio) super.getFiltro();
    }
    
    @Override
    public ViewRelatorioBalanco getView() {
        return (ViewRelatorioBalanco) view;
    }
}