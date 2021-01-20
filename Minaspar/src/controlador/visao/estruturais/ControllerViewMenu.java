package controlador.visao.estruturais;

import controlador.visao.ControllerView;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.estruturais.menu.ViewMenu;
import visao.modal.consulta.balanco.ViewConsultaBalanco;
import visao.modal.consulta.estoque.ViewConsultaItem;
import visao.modal.consulta.estoque.ViewConsultaProduto;
import visao.modal.relatorio.balanco.ViewRelatorioBalanco;
import visao.modal.relatorio.produto.ViewRelatorioProduto;
import visao.modal.sistema.ViewSistemaSair;
import visao.modal.sistema.ViewSistemaSobre;

/**
 * <p>Classe de Controle <b>ControllerViewMenu</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewMenu.</p>
 * @author Leandro
 * @since  12/01/2021
 * @see    controlador.visao.ControllerView
 * @see    visao.estruturais.menu.ViewMenu
 */
public class ControllerViewMenu extends ControllerView {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ControllerViewMenu(ViewMenu view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (getView().getMenuItemProduto().equals(event.getSource()))
            new ViewConsultaProduto(getView()).setVisible(true);
        else if (getView().getMenuItemEstoque().equals(event.getSource()))
            new ViewConsultaItem(getView()).setVisible(true);
        else if (getView().getMenuItemBalanco().equals(event.getSource()))
            new ViewConsultaBalanco(getView()).setVisible(true);
        else if (getView().getMenuItemRelatorio().equals(event.getSource()))
            new ViewRelatorioBalanco(getView()).setVisible(true);
        else if (getView().getMenuItemRelatorioProduto().equals(event.getSource()))
            new ViewRelatorioProduto(getView()).setVisible(true);
        else if (getView().getMenuItemSobre().equals(event.getSource()))
            new ViewSistemaSobre(getView()).setVisible(true);
        else if (getView().getMenuItemSair().equals(event.getSource()))
            new ViewSistemaSair(getView()).setVisible(true);
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        if (ESC == event.getKeyCode())
            new ViewSistemaSair(getView()).setVisible(true);
    }
    
    @Override
    public ViewMenu getView() {
        return (ViewMenu) view;
    }
}