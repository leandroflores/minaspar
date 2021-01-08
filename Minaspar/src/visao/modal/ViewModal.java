package visao.modal;

import controlador.Controller;
import funct.FunctDate;
import funct.FunctView;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.util.Date;
import java.util.HashMap;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import visao.View;
import visao.estilo.ViewStyle;
import visao.painel.Panel;
import visao.interfaces.Viewable;

/**
 * <p>Classe de Visao <b>ViewModal</b>.</p>
 * <p>Classe responsavel por definir um Modelo Abstrato para as <b>Interfaces Modais</b> do SGBov.</p>
 * @author Leandro
 * @since  15/12/2020
 * @see    controlador.Controller
 * @see    javax.swing.JDialog
 * @see    visao.interfaces.Viewable
 */
public abstract class ViewModal extends JDialog implements Viewable {
    protected String title;
    protected Controller controller;
    
    private HashMap buttons;
    private HashMap checks;
    private HashMap combos;
    private HashMap panels;
    private HashMap scrolls;
    private HashMap tables;
    private HashMap colums;
    private HashMap models;
    private HashMap spinners;
    private HashMap fields;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Parent.
     */
    public ViewModal(View view) {
        super(view, true);
        init();
        setDefaultProperties();
    }
    
    /**
     * Metodo construtor alternativo da Classe.
     * @param view View Parent.
     */
    public ViewModal(ViewModal view) {
        super(view, true);
        init();
        setDefaultProperties();
    }
    
    /**
     * Metodo responsavel por iniciar as Listas de Componentes.
     */
    private void init() {
        buttons  = new HashMap<>();
        checks   = new HashMap<>();
        combos   = new HashMap<>();
        panels   = new HashMap<>();
        scrolls  = new HashMap<>();
        tables   = new HashMap<>();
        colums   = new HashMap<>();
        models   = new HashMap<>();
        spinners = new HashMap<>();
        fields   = new HashMap<>();   
    }
    
    /**
     * Metodo responsavel por definir as Propriedades Padrao para a View Modal.
     */
    private void setDefaultProperties() {
        setSize(220, 120);
        setLocation(350, 400);
        setIconImage(new FunctView().createImage("icone").getImage());
        setResizable(false);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    /**
     * Metodo responsavel por atualizar o Titulo da View.
     */
    protected void updateTitle() {
        setTitle(ViewStyle.SISTEMA + title);
    }
    
    /**
     * Metodo responsavel por retornar um Componente de Espaco.
     * @param  vertical Espaco Vertical.
     * @param  horizontal Espaco Horizontal.
     * @return Componente de Espaco.
     */
    protected Component getSpace(Integer vertical, Integer horizontal) {
        return Box.createRigidArea(new Dimension(horizontal, vertical));
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
     * Metodo responsavel por retornar um Novo Label.
     * @param  title Titulo do Label.
     * @return Novo Label.
     */
    protected JLabel createLabel(String title) {
        JLabel label = new JLabel(title);
               label.setFont(new Font(ViewStyle.ESTILO, ViewStyle.NEGRITO, ViewStyle.TAMANHO));
               label.addKeyListener(controller);
               label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Label.
     * @param  title Titulo do Label.
     * @param  size Tamanho do Label.
     * @return Novo Label.
     */
    protected JLabel createLabel(String title, int size) {
        JLabel label = createLabel(title);
               label.setPreferredSize(new Dimension(size, ViewStyle.ALTURA));
               label.setHorizontalAlignment(SwingConstants.RIGHT);
        return label;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Image Label.
     * @param  path Caminho da Imagem do Label.
     * @return Novo Image Label.
     */
    protected JLabel createLabelImage(String path) {
        JLabel label = new JLabel(new FunctView().createImage(path));
               label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Title Label.
     * @param  title Titulo do Label.
     * @param  size Tamanho da Fonte do Label.
     * @return Novo Title Label.
     */
    protected JLabel createLabelTitle(String title, Integer size) {
        JLabel label = createLabel(title);
               label.setFont(new Font(ViewStyle.ESTILO, ViewStyle.NEGRITO, size));
        return label;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Button.
     * @param  id Identificador do Button.
     * @param  title Titulo do Button.
     * @param  path Caminho da Imagem do Button.
     * @return Novo Button.
     */
    protected JButton createButton(String id, String title, String path) {
        JButton button = new JButton(new FunctView().createImage("icones/" + path));
                button.setText(title);
                button.setToolTipText(title);
                button.setFont(new Font(ViewStyle.ESTILO, ViewStyle.CENTRO, ViewStyle.TAMANHO));
                button.addActionListener(controller);
                button.addKeyListener(controller);
                button.setAlignmentX(Component.CENTER_ALIGNMENT);
                buttons.put(id, button);
        return  button;
    }
    
    /**
     * Metodo responsavel por retornar o Button pelo Identificador.
     * @param  id Identificador do Button.
     * @return Button pelo Identificador.
     */
    public JButton getButton(String id) {
        return (JButton) buttons.get(id);
    }
    
    /**
     * Metodo responsavel por retornar um Novo Check Box.
     * @param  id Identificador do Check Box.
     * @param  title Titulo do Check Box.
     * @param  selected Tag Selected do Check Box.
     * @return Novo Check Box.
     */
    protected JCheckBox createCheckBox(String id, String title, boolean selected) {
        JCheckBox checkBox = new JCheckBox(title);
                  checkBox.setSelected(selected);
                  checkBox.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
                  checkBox.addActionListener(controller);
                  checkBox.addKeyListener(controller);
                  checks.put(id, checkBox);
        return    checkBox;
    }
    
    /**
     * Metodo responsavel por retornar o Check Box pelo Identificador.
     * @param  id Identificador do Check Box.
     * @return Check Box pelo Identificador.
     */
    protected JCheckBox getCheckBox(String id) {
        return (JCheckBox) checks.get(id);
    }
    
    /**
     * Metodo responsavel por retornar um Novo Combo Box.
     * @param  id Identificador do Combo Box.
     * @param  values Valores do Combo Box.
     * @param  size Tamanho do Combo Box.
     * @return Novo Combo Box.
     */
    protected JComboBox createComboBox(String id, Object[] values, int size) {
        JComboBox comboBox = new JComboBox(values);
                  comboBox.setAlignmentX(CENTER_ALIGNMENT);
                  comboBox.setAlignmentY(CENTER_ALIGNMENT);
                  comboBox.setFont(new Font(ViewStyle.ESTILO, ViewStyle.NEGRITO, ViewStyle.TAMANHO));
                  comboBox.setPreferredSize(new Dimension(size, ViewStyle.ALTURA));
                  comboBox.addActionListener(controller);
                  comboBox.addKeyListener(controller);
                  combos.put(id, comboBox);
        return    comboBox;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Combo Box.
     * @param  id Identificador do Combo Box.
     * @param  values Valores do Combo Box.
     * @param  size Tamanho do Combo Box.
     * @param  object Objeto Selecionado do Combo Box.
     * @return Novo Combo Box.
     */
    protected JComboBox createComboBox(String id, Object[] values, int size, Object object) {
        JComboBox comboBox = createComboBox(id, values, size);
                  comboBox.setSelectedItem(object);
        return    comboBox;
    }
    
    /**
     * Metodo responsavel por retornar o Combo Box pelo Identificador.
     * @param  id Identificador do Combo Box.
     * @return Combo Box pelo Identificador.
     */
    protected JComboBox getComboBox(String id) {
        return (JComboBox) combos.get(id);
    }
    
    /**
     * Metodo responsavel por retornar o Novo Scroll Pane.
     * @param  id Identificador do Scroll Pane.
     * @return Novo Scroll Pane.
     */
    public JScrollPane createScrollPane(String id) {
        JScrollPane scrollPane = new JScrollPane();
                    scrolls.put(id, scrollPane);
        return      scrollPane;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Scroll Pane de um Panel.
     * @param  id Identificador do Scroll Pane.
     * @param  panel Panel do Scroll Pane.
     * @return Novo Scroll Pane de um Panel.
     */
    public JScrollPane createScrollPane(String id, JPanel panel) {
        JScrollPane scrollPane = new JScrollPane(panel);
                    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                    scrollPane.setPreferredSize(new Dimension(390, 120));
                    scrolls.put(id, scrollPane);
        return      scrollPane;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Scroll Pane de uma Table.
     * @param  id Identificador do Scroll Pane.
     * @param  table Table do Scroll Pane.
     * @return Novo Scroll Pane de uma Table.
     */
    private JScrollPane createScrollPane(String id, JTable table) {
        JScrollPane scrollPane = createScrollPane(id);
                    scrollPane.setViewportView(table);
                    scrollPane.setPreferredSize(new Dimension(380, 150));
        return      scrollPane;
    }
    
    /**
     * Metodo responsavel por retornar o Scroll Pane pelo Identificador.
     * @param  id Identificador do Scroll Pane.
     * @return Scroll Pane pelo Identificador.
     */
    public JScrollPane getScrollPane(String id) {
        return (JScrollPane) scrolls.get(id);
    }
    
    /**
     * Metodo responsavel por retornar uma Nova Table.
     * @param  id Identificador da Table.
     * @return Nova Table.
     */
    protected JTable createTable(String id) {
        JTable table = new JTable(createTableModel());
               table.addKeyListener(controller);
               createScrollPane(id, table);
               models.put(id, table.getModel());
               colums.put(id, table.getColumnModel());
               tables.put(id, table);
        return table;
    }
    
    /**
     * Metodo responsavel por retornar uma Nova Table Model.
     * @return Nova Table Model.
     */
    private DefaultTableModel createTableModel() {
        return 
            new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int col) {   
                    return false;
                }};
    }
    
    /**
     * Metodo responsavel por adicionar as Colunas da Table.
     * @param id Identificador da Table.
     * @param values Valores da Column.
     */
    protected void addColumns(String id, String[] values) {
        for (String value : values)
            ((DefaultTableModel) models.get(id)).addColumn(value);
    }
    
    /**
     * Metodo responsavel por definir o Tamanho das Colunas da Table.
     * @param id Identificador da Table. 
     * @param size Array dos Tamanhos da Table.
     */
    protected void setColumnsSize(String id, Integer[] size) {
        for (int i = 0; i < size.length; i++)
            getTable(id).getColumnModel().getColumn(i).setPreferredWidth(size[i]);
    }
    
    /**
     * Metodo responsavel por limpar a Table
     * @param id Identificador da Table.
     */
    protected void clearTable(String id) {
        while (getTableModel(id).getRowCount() > 0)
            getTableModel(id).removeRow(0);
        getTable(id).removeAll();
    }
    
    /**
     * Metodo responsavel por adicionar os Valores da Table.
     * @param id Identificador da Table. 
     * @param values Valores da Table.
     */
    public void addRows(String id, Object[][] values) {
        clearTable(id);
        for (Object[] value : values) {
            getTableModel(id).addRow(value);
            getTable(id).setEditingRow(JTable.AUTO_RESIZE_NEXT_COLUMN);
            getTable(id).setEditingRow(0);
        }
    }
    
    /**
     * Metodo responsavel por retornar a Table pelo Identificador.
     * @param  id Identificador da Table.
     * @return Table pelo Identificador.
     */
    protected JTable getTable(String id) {
        return (JTable) tables.get(id);
    }
    
    /**
     * Metodo responsavel por retornar o Table Model pelo Identificador.
     * @param  id Identificador do Table Model.
     * @return Table Model pelo Identificador.
     */
    protected DefaultTableModel getTableModel(String id) {
        return (DefaultTableModel) models.get(id);
    }
    
    /**
     * Metodo responsavel por retornar o Table Column pelo Identificador.
     * @param  id Identificador do Table Column.
     * @return Table Column pelo Identificador.
     */
    protected TableColumnModel getTableColumn(String id) {
        return (TableColumnModel) colums.get(id);
    }
    
    /**
     * Metodo responsavel por retornar um Novo Spinner.
     * @param  id Identificador do Spinner.
     * @return Novo Spinner.
     */
    public JSpinner createSpinner(String id) {
        JSpinner spinner = new JSpinner();
                 spinner.setAlignmentY(SwingConstants.RIGHT);
                 spinner.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
                 spinner.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 0));
                 spinner.setPreferredSize(new Dimension(75, 30));
                 spinner.addKeyListener(controller);
                 ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().addKeyListener(controller);
                 ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
                 spinners.put(id, spinner);
        return   spinner;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Spinner Editavel.
     * @param  id Identificador do Spinner.
     * @return Novo Spinner Editavel.
     */
    public JSpinner createSpinnerEditable(String id) {
        JSpinner spinner = createSpinner(id);
                 spinner.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
                 ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setEditable(true);
        return   spinner;
    }
    
    /**
     * Metodo responsavel por retornar o Spinner pelo Identificador.
     * @param  id Identificador do Spinner.
     * @return Spinner pelo Identificador.
     */
    protected JSpinner getSpinner(String id) {
        return (JSpinner) spinners.get(id);
    }
    
    /**
     * Metodo responsavel por retornar um Novo Text Field.
     * @param  id Identificador do Text Field.
     * @param  title Titulo do Text Field.
     * @param  size Tamanho do Text Field.
     * @return Novo Text Field.
     */
    protected JTextField createTextField(String id, String title, int size) {
        JTextField textField = new JTextField(size);
                   textField.setText(title);
                   textField.setPreferredSize(new Dimension(ViewStyle.LARGURA, ViewStyle.ALTURA));
                   textField.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
                   textField.addActionListener(controller);
                   textField.addKeyListener(controller);
                   fields.put(id, textField);
        return     textField;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Text Field Nao Editavel.
     * @param  id Identificador do Text Field.
     * @param  title Titulo do Text Field.
     * @param  size Tamanho do Text Field.
     * @return Novo Text Field Nao Editavel.
     */
    protected JTextField createTextFieldNoEditable(String id, String title, int size) {
        JTextField textField = createTextField(id, title, size);
                   textField.setEditable(false);
        return     textField;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Right Text Field Nao Editavel.
     * @param  id Identificador do Right Text Field.
     * @param  title Titulo do Right Text Field.
     * @param  size Tamanho do Right Text Field.
     * @return Novo Right Text Field Nao Editavel.
     */
    protected JTextField createRightTextFieldNoEditable(String id, String title, int size) {
        JTextField textField = createTextFieldNoEditable(id, title, size);
                   textField.setHorizontalAlignment(SwingConstants.RIGHT);
        return     textField;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Date Text Field.
     * @param  id Identificador do Date Text Field.
     * @param  value Valor do Date Text Field.
     * @return Novo Date Text Field.
     */
    protected JTextField createTextFieldDate(String id, Date value) {
        return createTextField(id, new FunctDate().getFormattedDate(value), 8);
    }
    
    /**
     * Metodo responsavel por retornar o Text Field pelo Identificador.
     * @param  id Identificador do Text Field.
     * @return Text Field pelo Identificador.
     */
    public JTextField getTextField(String id) {
        return (JTextField) fields.get(id);
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
     * Metodo responsavel por retornar um Novo Constraints.
     * @param  width Largura do Constraints.
     * @param  height Tamanho do Constraints.
     * @param  x Posicao X do Grid.
     * @param  y Posicao Y do Grid.
     * @return Novo Constraints.
     */
    protected GridBagConstraints createConstraints(int width, int height, int x, int y) {
        GridBagConstraints constraints = new GridBagConstraints();
                           constraints.gridheight = height;
                           constraints.gridwidth  = width;
                           constraints.gridx      = x;
                           constraints.gridy      = y;
                           constraints.fill       = GridBagConstraints.HORIZONTAL;
        return constraints;
    }
    
    /**
     * Metodo responsavel por definir o Tamanho da View Modal.
     * @param y Eixo Y.
     * @param x Eixo X.
     */
    @Override
    public void setSize(int y, int x) {
        super.setSize(y, x);
        setLocationRelativeTo(getParent());
    }
}