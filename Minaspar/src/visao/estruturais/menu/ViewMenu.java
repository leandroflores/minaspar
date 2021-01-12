package visao.estruturais.menu;

import controlador.visao.estruturais.ControllerViewMenu;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import visao.View;
import visao.painel.logo.PanelLogo;
import visao.painel.menu.relogio.PanelRelogio;
import visao.painel.menu.titulo.PanelTitulo;

/**
 * <p>Classe de Visao <b>ViewMenu</b>.</p> 
 * <p>Classe responsavel por definir a <b>View do Menu Principal</b> do Sistema.</p>
 * @author Leandro
 * @since  12/01/2021
 * @see    controlador.visao.estruturais.ControllerViewMenu
 * @see    visao.View
 */
public final class ViewMenu extends View {
    private JMenuBar menu;
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public ViewMenu() {
        controller = new ControllerViewMenu(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setDefaultProperties();
        updateTitle("Menu Principal");
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }
    
    @Override
    public void addComponents() {
        addHeader();
        addBody();
        addFooter();
    }
    
    @Override
    public void addHeader() {
        addMenu();
    }
    
    /**
     * Metodo responsavel por adicionar o Menu de Barras.
     */
    private void addMenu() {
        menu = new JMenuBar();
            createMenuEstoque();
            createMenuProcessar();
            createMenuRelatorios();
            createMenuSistema();
        setJMenuBar(menu);
    }
    
    /**
     * Metodo responsavel por criar o Menu Estoque da View Menu.
     */
    private void createMenuEstoque() {
        createMenu("estoque", "Estoque");
        
        createMenuItem("estoque_produto", "Consultar Produtos", "estoque/produto");
        createMenuItem("estoque_balanco", "Balanço",            "estoque/balanco");
        
        getMenu("estoque").add(getMenuItem("estoque_produto"));
        getMenu("estoque").addSeparator();
        getMenu("estoque").add(getMenuItem("estoque_balanco"));
        menu.add(getMenu("estoque"));
    }
    
    /**
     * Metodo responsavel por criar o Menu Processar da View Menu.
     */
    private void createMenuProcessar() {
        createMenu("processar", "Processar");
        
        createMenuItem("processar_balanco", "Balanço", "processar/balanco");
        
        getMenu("processar").add(getMenuItem("processar_balanco"));
        menu.add(getMenu("processar"));
    }
    
    /**
     * Metodo responsavel por criar o Menu Relatorios da View Menu.
     */
    private void createMenuRelatorios() {
        createMenu("relatorios", "Relatórios");
        menu.add(getMenu("relatorios"));
    }
    
    /**
     * Metodo responsavel por criar o Menu Sistema da View Menu.
     */
    private void createMenuSistema() {
        createMenu("sistema", "Sistema");
        
        createMenuItem("sistema_sobre", "Sobre", "sistema/sobre");
        createMenuItem("sistema_sair",  "Sair",  "sistema/sair");
        
        getMenu("sistema").add(getMenuItem("sistema_sobre"));
        getMenu("sistema").addSeparator();
        getMenu("sistema").add(getMenuItem("sistema_sair"));
        menu.add(getMenu("sistema"));
    }
    
    @Override
    public void addBody() {
        getContentPane().add(getVerticalSpace(50));
        getContentPane().add(new PanelTitulo());
        getContentPane().add(getVerticalSpace(75));
        getContentPane().add(new PanelLogo());
        getContentPane().add(getVerticalSpace(75));
    }
    
    @Override
    public void addFooter() {
        getContentPane().add(new PanelRelogio());
    }
    
    /**
     * Metodo responsavel por retornar o Menu Item Rebanho.
     * @return Menu Item Rebanho.
     */
    public JMenuItem getMenuItemRebanho() {
        return getMenuItem("rebanho_consulta");
    }
    
    /**
     * Metodo responsavel por retornar o Menu Item Pesagem.
     * @return Menu Item Pesagem.
     */
    public JMenuItem getMenuItemPesagem() {
        return getMenuItem("rebanho_pesagem");
    }
    
    /**
     * Metodo responsavel por retornar o Menu Item Inseminacao.
     * @return Menu Item Inseminacao.
     */
    public JMenuItem getMenuItemInseminacao() {
        return getMenuItem("rebanho_inseminacao");
    }
    
    /**
     * Metodo responsavel por retornar o Menu Item Funcionario.
     * @return Menu Item Funcionario.
     */
    public JMenuItem getMenuItemFuncionario() {
        return getMenuItem("admin_funcionario");
    }
    
    /**
     * Metodo responsavel por retornar o Menu Item Movimentacoes.
     * @return Menu Item Movimentacoes.
     */
    public JMenuItem getMenuItemMovimentacoes() {
        return getMenuItem("financeiro_movimentacoes");
    }
    
    /**
     * Metodo responsavel por retornar o Menu Item Despesas.
     * @return Menu Item Despesas.
     */
    public JMenuItem getMenuItemDespesas() {
        return getMenuItem("financeiro_despesas");
    }
    
    /**
     * Metodo responsavel por retornar o Menu Item Receitas.
     * @return Menu Item Receitas.
     */
    public JMenuItem getMenuItemReceitas() {
        return getMenuItem("financeiro_receitas");
    }
    
    /**
     * Metodo responsavel por retornar o Menu Item Sobre.
     * @return Menu Item Sobre.
     */
    public JMenuItem getMenuItemSobre() {
        return getMenuItem("sistema_sobre");
    }
    
    /**
     * Metodo responsavel por retornar o Menu Item Sair.
     * @return Menu Item Sair.
     */
    public JMenuItem getMenuItemSair() {
        return getMenuItem("sistema_sair");
    }
    
    /**
     * Metodo principal da aplicacao.
     * @param args 
     */
    public static void main(String[] args) {
        //System.out.println(new DaoBovino());
        //System.out.println(new DaoBovino().select());
        new ViewMenu().setVisible(true);
    }
}