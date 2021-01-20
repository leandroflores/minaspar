package controlador.visao.modal.relatorio.produto;

import arquivo.relatorio.Relatorio;
import arquivo.relatorio.produto.RelatorioProduto;
import controlador.visao.modal.relatorio.ControllerViewRelatorio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.controlador.estoque.ControllerItem;
import modelo.dao.estoque.DaoItem;
import modelo.dao.estoque.DaoProduto;
import modelo.entidade.estoque.Item;
import modelo.entidade.estoque.Produto;
import net.sf.jasperreports.engine.JRException;
import visao.modal.mensagem.ViewErro;
import visao.modal.pesquisa.estoque.ViewPesquisaProduto;
import visao.modal.relatorio.produto.ViewRelatorioProduto;
import visao.painel.filtro.relatorio.produto.PanelFiltroRelatorioProduto;

/**
 * <p>Classe de Controle <b>ControllerViewRelatorioProduto</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewRelatorioProduto.</p>
 * @author Leandro
 * @since  19/01/2021
 * @see    controlador.visao.modal.relatorio.ControllerViewRelatorio
 * @see    modelo.dao.estoque.DaoItem
 * @see    modelo.dao.estoque.DaoProduto
 * @see    modelo.entidade.estoque.Item
 * @see    modelo.entidade.estoque.Produto
 * @see    visao.modal.relatorio.produto.ViewRelatorioProduto
 */
public class ControllerViewRelatorioProduto extends ControllerViewRelatorio {
    private final DaoItem dao;
    private List<Item> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Relatorio Produto.
     */
    public ControllerViewRelatorioProduto(ViewRelatorioProduto view) {
        super(view);
        dao  = new DaoItem();
        list = new ArrayList<>();
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getFiltro().getButtonPesquisa().equals(event.getSource()))
            new ViewPesquisaProduto(getView()).setVisible(true);
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        if (getFiltro().getTextFieldCodigoBarras().equals(event.getSource())) {
            if (event.getKeyCode() == ENTER)
                update();
        }
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
        String  codigo  = getStringSimples(getFiltro().getTextFieldCodigoBarras());
        Produto produto = new DaoProduto().find(codigo);
                list    = produto != null ? dao.find(produto) : new ArrayList<>();
                getView().setValue(produto);
    }
    
    /**
     * Metodo responsavel por checar os Dados para o Relatorio.
     * @return Dados checados para o Relatorio.
     */
    protected boolean check() {
        if (getView().getProduto() == null) {
            new ViewErro(getView(), "Selecione um Produto!").setVisible(true);
            getFiltro().getTextFieldCodigoBarras().requestFocus();
            return false;
        }
        return true;
    }
    
    @Override
    public void imprimir() {
        if (check()) {
            try {
                Relatorio relatorio = new RelatorioProduto(getView().getProduto().getId());
                          relatorio.create();
                getView().dispose();
            }catch (JRException | SQLException exception) {
                new ViewErro(getView(), "Erro ao criar o Relatório!").setVisible(true);
            }
        }
    }

    @Override
    public ControllerItem getController() {
        return new ControllerItem();
    }
    
    @Override
    public PanelFiltroRelatorioProduto getFiltro() {
        return (PanelFiltroRelatorioProduto) super.getFiltro();
    }
    
    @Override
    public ViewRelatorioProduto getView() {
        return (ViewRelatorioProduto) view;
    }
}