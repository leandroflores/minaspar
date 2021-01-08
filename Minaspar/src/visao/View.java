package visao;

import visao.estilo.ViewStyle;
import controlador.Controller;
import funct.FunctView;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.util.HashMap;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import visao.interfaces.Viewable;
import visao.painel.Panel;

/**
 * <p>Classe de Visao <b>View</b>.</p> 
 * <p>Classe responsavel por definir um Modelo Abstrato para as <b>Interfaces Graficas</b> do SGBov.</p>
 * @author Leandro
 * @since  12/12/2018
 * @see    javax.swing.JFrame
 * @see    visao.interfaces.Viewable
 */
public abstract class View extends JFrame implements Viewable {
    protected Controller controller;
    
    protected HashMap buttons;
    protected HashMap panels;
    protected HashMap menus;
    protected HashMap items;
    
    /**
     * Metodo contrutor padrao da Classe.
     */
    public View() {
        init();
    }
    
    /**
     * Metodo responsavel por iniciar as Listas de Componentes.
     */
    private void init() {
        buttons = new HashMap<>();
        menus   = new HashMap<>();
        items   = new HashMap<>();
    }
    
    /**
     * Metodo responsavel por atualizar o Titulo da View.
     * @param title Titulo da View.
     */
    protected void updateTitle(String title) {
        setTitle(ViewStyle.SISTEMA + title);
    }
    
    /**
     * Metodo responsavel por definir as Propriedades Padrao para a View.
     */
    protected void setDefaultProperties() {
        setSize(new Dimension(getEixoX(), getEixoY()));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(5, 5);
        setIconImage(new FunctView().createImage("icone").getImage());
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /**
     * Metodo responsavel por retornar um Espaco Vertical.
     * @param  space Valor de Espaco.
     * @return Espaco Vertical.
     */
    protected Component getVerticalSpace(Integer space) {
        return Box.createRigidArea(new Dimension(0, space));
    }
    
    /**
     * Metodo responsavel por retornar um Espaco Horizontal.
     * @param  space Valor de Espaco.
     * @return Espaco Horizontal.
     */
    protected Component getHorizontalSpace(Integer space) {
        return Box.createRigidArea(new Dimension(space, 0));
    }
    
    /**
     * Metodo responsavel por retornar um Tamanho de Altura Padrao para a View.
     * @return Altura da View.
     */
    private int getEixoY() {
        return (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 50;
    }
    
    /**
     * Metodo responsavel por retornar um Tamanho de Largura Padrao para a View.
     * @return Largura da View.
     */
    private int getEixoX() {
        return (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()- 10;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Label.
     * @param  message Mensagem do Label.
     * @return Novo Label.
     */
    protected JLabel createLabel(String message) {
        JLabel label = new JLabel(message);
               label.setFont(new Font(ViewStyle.ESTILO, ViewStyle.NEGRITO, ViewStyle.TAMANHO));
               label.addKeyListener(controller);
        return label;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Label.
     * @param  title Titulo do Label.
     * @param  size Tamanho do Label.
     * @return Novo Label.
     */
    protected JLabel createLabel(String title, int size) {
        JLabel label = new JLabel(title, SwingConstants.RIGHT);
               label.setFont(new Font(ViewStyle.ESTILO, ViewStyle.NEGRITO, ViewStyle.TAMANHO));
               label.setPreferredSize(new Dimension(size, ViewStyle.ALTURA));
               label.addKeyListener(controller);
        return label;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Image Label.
     * @param  urlImage URL da Imagem.
     * @return Novo Image Label.
     */
    protected JLabel createLabelImage(String urlImage) {
        return new JLabel(new FunctView().createImage(urlImage));
    }
    
    /**
     * Metodo responsavel por retornar um Novo Button.
     * @param  id Identificador do Button.
     * @param  title Titulo do Button.
     * @param  urlImage Imagem do Button.
     * @return Novo Button.
     */
    protected JButton createButton(String id, String title, String urlImage) {
        JButton button = new JButton(new FunctView().createImage("buttons/" + urlImage));
                button.setText(title);
                button.setPreferredSize(new Dimension(130, 30));
                button.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
                button.addActionListener(controller);
                button.addKeyListener(controller);
                buttons.put(id, button);
        return  button;
    }
    
    /**
     * Metodo responsavel por retornar um Button pelo Identificador.
     * @param  id Identificador do Button.
     * @return Button pelo Identificador.
     */
    protected JButton getButton(String id) {
        return (JButton) buttons.get(id);
    }
    
    /**
     * Metodo responsavel por adicionar um Panel.
     * @param id Identificador do Panel.
     * @param panel Panel.
     */
    protected void addPanel(String id, Panel panel) {
        panels.put(id, panel);
    }
    
    /**
     * Metodo responsavel por retornar um Panel pelo Identificador.
     * @param  id Identificador do Panel.
     * @return Panel pelo Identificador.
     */
    protected Panel getPanel(String id) {
        return (Panel) panels.get(id);
    }
    
    /**
     * Metodo responsavel por remover um Panel.
     * @param id Identificador do Panel.
     */
    protected void removePanel(String id) {
        panels.remove(id);
    }
    
    /**
     * Metodo responsavel por retornar um Novo Menu.
     * @param  id Identificador do Menu.
     * @param  title Titulo do Menu.
     * @return Novo Menu.
     */
    protected JMenu createMenu(String id, String title) {
        JMenu  menu = new JMenu(title);
               menu.setFont(new Font(ViewStyle.ESTILO, ViewStyle.NEGRITO, ViewStyle.TAMANHO));
               menu.addActionListener(this.controller);
               menus.put(id, menu);
        return menu;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Menu.
     * @param  id Identificador do Menu.
     * @param  title Titulo do Menu.
     * @param  urlImage Imagem do Menu.
     * @return Novo JMenu.
     */
    protected JMenu createMenu(String id, String title, String urlImage) {
        JMenu  menu = new JMenu(title);
               menu.setIcon(new FunctView().createImage("icones/" + urlImage));
               menu.setFont(new Font(ViewStyle.ESTILO, ViewStyle.NEGRITO, ViewStyle.TAMANHO));
               menu.addActionListener(controller);
               menus.put(id, menu);
        return menu;
    }
    
    /**
     * Metodo responsavel por retornar um Menu pelo Identificador.
     * @param  id Identificador do Menu.
     * @return Menu pelo Identificador.
     */
    protected JMenu getMenu(String id) {
        return (JMenu) menus.get(id);
    }
    
    /**
     * Metodo responsavel por retornar um Novo Item.
     * @param  id Identificador do Item.
     * @param  title Titulo do Item.
     * @param  urlImage Imagem do Item.
     * @return Novo Item.
     */
    protected JMenuItem createMenuItem(String id, String title, String urlImage) {
        JMenuItem menuItem = new JMenuItem(title, new FunctView().createImage("menu/" + urlImage));
                  menuItem.setFont(new Font(ViewStyle.ESTILO, ViewStyle.NEGRITO, ViewStyle.TAMANHO));
                  menuItem.addActionListener(controller);
                  menuItem.addKeyListener(controller);
                  items.put(id, menuItem);
        return    menuItem;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Item.
     * @param  id Identificador do Item.
     * @param  title Titulo do Item.
     * @param  path Caminho da Imagem do Item.
     * @param  keychar Key Char do Item.
     * @return Novo Item.
     */
    protected JMenuItem createMenuItem(String id, String title, String path, int keychar) {
        JMenuItem menuItem = this.createMenuItem(id, title, path);
                  menuItem.setAccelerator(KeyStroke.getKeyStroke(keychar, InputEvent.CTRL_MASK));
                  menuItem.setMnemonic(keychar);
        return    menuItem;
    }
    
    /**
     * Metodo responsavel por retornar um Item pelo Identificador.
     * @param  id Identificador do Item.
     * @return Item pelo Identificador.
     */
    protected JMenuItem getMenuItem(String id) {
        return (JMenuItem) items.get(id);
    }
}