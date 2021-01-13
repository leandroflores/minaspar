package visao.painel;

import controlador.Controller;
import funct.FunctDate;
import funct.FunctView;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import visao.estilo.ViewStyle;

/**
 * <p>Classe de Visao <b>Panel</b>.</p> 
 * <p>Classe responsavel por definir um Modelo Abstrato para os <b>Paineis Graficos</b> do SGBov.</p>
 * @author Leandro
 * @since  14/12/2020
 * @see    controlador.Controller
 * @see    javax.swing.JPanel
 */
public abstract class Panel extends JPanel {
    protected Controller controller;
    
    private HashMap buttons;
    private HashMap checks;
    private HashMap combos;
    private HashMap choosers;
    private HashMap lists;
    private HashMap panels;
    private HashMap scrolls;
    private HashMap tables;
    private HashMap colums;
    private HashMap models;
    private HashMap passwords;
    private HashMap radios;
    private HashMap spinners;
    private HashMap textAreas;
    private HashMap textFields;
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public Panel() {
        init();
    }
    
    /**
     * Metodo responsavel por iniciar as Listas de Componentes.
     */
    private void init() {
        buttons    = new HashMap<>();
        checks     = new HashMap<>();
        combos     = new HashMap<>();
        choosers   = new HashMap<>();
        lists      = new HashMap<>();
        panels     = new HashMap<>();
        scrolls    = new HashMap<>();
        tables     = new HashMap<>();
        colums     = new HashMap<>();
        models     = new HashMap<>();
        passwords  = new HashMap<>();
        radios     = new HashMap<>();
        spinners   = new HashMap<>();
        textAreas  = new HashMap<>();
        textFields = new HashMap<>();
    }
    
    /**
     * Metodo responsavel por adicionar os Componentes do Painel.
     */
    protected abstract void addComponents();
    
    /**
     * Metodo responsavel por retornar a Cor Padrao.
     * @return Cor Padrao.
     */
    protected Color getDefaultColor() {
        return getBackground();
    }
    
    /**
     * Metodo responsavel por retornar a Cor de Foco.
     * @return Cor de Foco.
     */
    protected Color getFocusColor() {
        return ColorUIResource.LIGHT_GRAY;
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
        return label;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Right Label.
     * @param  title Titulo do Right Label.
     * @return Novo Right Label.
     */
    protected JLabel createRightLabel(String title) {
        JLabel label = createLabel(title);
               label.setHorizontalAlignment(SwingConstants.RIGHT);
        return label;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Title Label.
     * @param  title Titulo do Label.
     * @return Novo Title Label.
     */
    protected JLabel createTitleLabel(String title) {
        JLabel label = createLabel(title);
               label.setFont(new Font(ViewStyle.ESTILO, ViewStyle.NEGRITO, 30));
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
               label.setHorizontalAlignment(SwingConstants.RIGHT);
               label.setPreferredSize(new Dimension(size, ViewStyle.ALTURA));
        return label;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Label Centralizado.
     * @param  title Titulo do Label.
     * @param  size Tamanho do Label.
     * @return Novo Label Centralizado.
     */
    protected JLabel createCenterLabel(String title, int size) {
        JLabel label = createLabel(title, size);
               label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Image Label.
     * @param  path Caminho da Imagem.
     * @return Novo Image Label.
     */
    protected JLabel createLabelImage(String path) {
        return new JLabel(new FunctView().createImage(path));
    }
    
    /**
     * Metodo responsavel por retornar um Novo Button.
     * @param  id Identificador do Button.
     * @param  title Titulo do Button.
     * @return Novo Button.
     */
    protected JButton createButton(String id, String title) {
        JButton button = new JButton();
                button.setText(title);
                button.setToolTipText(title);
                button.setPreferredSize(new Dimension(75, 30));
                button.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
                button.addActionListener(controller);
                button.addKeyListener(controller);
                buttons.put(id, button);
        return  button;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Button.
     * @param  id Identificador do Button.
     * @param  title Titulo do Button.
     * @param  path Caminho da Imagem do Button.
     * @return Novo Button.
     */
    protected JButton createButton(String id, String title, String path) {
        JButton button = createButton(id, title);
                button.setIcon(new FunctView().createImage("icones/" + path));
        return  button;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Button.
     * @param  id Identificador do Button.
     * @param  title Titulo do Button.
     * @param  focus Titulo do Foco do Button.
     * @param  path Caminho da Imagem do Button.
     * @return Novo Button.
     */
    protected JButton createButton(String id, String title, String focus, String path) {
        JButton button = createButton(id, title, path);
                button.setToolTipText(focus);
        return  button;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Button.
     * @param  id Identificador do Button.
     * @param  title Titulo do Button.
     * @param  focus Titulo do Foco do Button.
     * @param  path Caminho da Imagem do Button.
     * @param  dimension Dimensao do Button.
     * @return Novo Button.
     */
    protected JButton createButton(String id, String title, String focus, String path, Dimension dimension) {
        JButton button = createButton(id, title, focus, path);
                button.setPreferredSize(dimension);
        return  button;
    }
    
    /**
     * Metodo responsavel por retornar o Button pelo Identificador.
     * @param  id Identificador do Button.
     * @return Button pelo Identificador.
     */
    protected JButton getButton(String id) {
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
     * Metodo responsavel por retornar um Novo File Chooser.
     * @param  id Identificador do File Chooser.
     * @return Novo File Chooser.
     */
    protected JFileChooser createFileChooser(String id) {
        JFileChooser fileChooser = new JFileChooser();
                     fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                     choosers.put(id, fileChooser);
        return       fileChooser;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Directory Chooser.
     * @param  id Identificador do Directory Chooser.
     * @return Novo Directory Chooser.
     */
    protected JFileChooser createDirectoryChooser(String id) {
        JFileChooser fileChooser = new JFileChooser();
                     fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                     choosers.put(id, fileChooser);
        return       fileChooser;
    }
    
    /**
     * Metodo responsavel por retornar o File Chooser pelo Identificador.
     * @param  id Identificador do File Chooser.
     * @return File Chooser pelo Identificador.
     */
    protected JFileChooser getFileChooser(String id) {
        return (JFileChooser) choosers.get(id);
    }
    
    /**
     * Metodo responsavel por retornar uma Nova List.
     * @param  id Identificador da List.
     * @return Nova List.
     */
    protected JList createList(String id) {
        JList  list = new JList();
               list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
               list.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
               list.addKeyListener(controller);
               createScrollPane(id, list);
               lists.put(id, list);
        return list;
    }
    
    /**
     * Metodo responsavel por retornar a List pelo Identificador.
     * @param  id Identificador da List.
     * @return List pelo Identificador.
     */
    protected JList getList(String id) {
        return (JList) lists.get(id);
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
     * Metodo responsavel por retornar um Novo Scroll Pane.
     * @param  id Identificador do Scroll Pane.
     * @return Novo Scroll Pane.
     */
    protected JScrollPane createScrollPane(String id) {
        JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                    scrolls.put(id, scrollPane);
        return      scrollPane;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Scroll Pane de um Panel.
     * @param  id Identificador do Scroll Pane.
     * @param  panel Panel do Scroll Pane.
     * @return Novo Scroll Pane de um Panel.
     */
    protected JScrollPane createScrollPane(String id, JPanel panel) {
        JScrollPane scrollPane = createScrollPane(id);
                    scrollPane.setPreferredSize(new Dimension(390, 120));
                    scrollPane.setViewportView(panel);
        return      scrollPane;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Scroll Pane de uma List.
     * @param  id Identificador do Scroll Pane.
     * @param  list List do Scroll Pane.
     * @return Novo Scroll Pane de uma List.
     */
    private JScrollPane createScrollPane(String id, JList list) {
        JScrollPane scrollPane = createScrollPane(id);
                    scrollPane.setViewportView(list);
                    scrollPane.setPreferredSize(new Dimension(390, 120));
        return      scrollPane;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Scroll Pane de uma Text Area.
     * @param  id Identificador do Scroll Pane.
     * @param  textArea Text Area do Scroll Pane.
     * @return Novo Scroll Pane de uma Text Area.
     */
    private JScrollPane createScrollPane(String id, JTextArea textArea) {
        JScrollPane scrollPane = createScrollPane(id);
                    scrollPane.setViewportView(textArea);
                    scrollPane.setPreferredSize(new Dimension(200, 100));
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
    protected JScrollPane getScrollPane(String id) {
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
                    return true;
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
    protected void setColumnsSize(String id, int[] size) {
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
     * Metodo responsavel por retornar um Novo Password Field.
     * @param  id Identificador do Password Field.
     * @param  value Valor do Password Field.
     * @param  size Tamanho do Password Field.
     * @return Novo Password Field.
     */
    protected JPasswordField createPasswordField(String id, String value, int size) {
        JPasswordField passwordField = new JPasswordField(size);
                       passwordField.setText(value);
                       passwordField.setPreferredSize(new Dimension(ViewStyle.LARGURA, ViewStyle.ALTURA));
                       passwordField.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
                       passwordField.addActionListener(controller);
                       passwordField.addKeyListener(controller);
                       passwords.put(id, passwordField);
                return passwordField;
    }
    
    /**
     * Metodo responsavel por retornar o Password Field pelo Identificador.
     * @param  id Identificador do Password Field.
     * @return Password Field pelo Identificador.
     */
    protected JPasswordField getPasswordField(String id) {
        return (JPasswordField) passwords.get(id);
    }
    
    /**
     * Metodo responsavel por retornar um Novo Radio Button.
     * @param  id Identificador do Radio Button.
     * @param  title Titulo do Radio Button.
     * @return Novo Radio Button.
     */
    public JRadioButton createRadioButton(String id, String title) {
        JRadioButton radio = new JRadioButton(title);
                     radio.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
                     radio.addActionListener(controller);
                     radio.addKeyListener(controller);
                     radios.put(id, radio);
        return       radio;
    }
    
    /**
     * Metodo responsavel por retornar o Radio Button pelo Identificador.
     * @param  id Identificador do Radio Button.
     * @return Radio Button pelo Identificador.
     */
    protected JRadioButton getRadioButton(String id) {
        return (JRadioButton) radios.get(id);
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
                 ((DefaultEditor) spinner.getEditor()).getTextField().addKeyListener(controller);
                 ((DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
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
                 ((DefaultEditor) spinner.getEditor()).getTextField().setEditable(true);
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
     * Metodo responsavel por retornar uma Nova Text Area.
     * @param  id Identificador da Text Area.
     * @return Nova Text Area.
     */
    protected JTextArea createTextArea(String id) {
        JTextArea textArea = new JTextArea(5, 10);
                  textArea.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
                  textArea.addKeyListener(controller);
                  textAreas.put(id, textArea);
                  createScrollPane(id, textArea);
        return    textArea;
    }
    
    /**
     * Metodo responsavel por retornar uma Nova Text Area.
     * @param  id Identificador da Text Area.
     * @param  text Texto da Text Area.
     * @return Nova Text Area.
     */
    protected JTextArea createTextArea(String id, String text) {
        JTextArea textArea = createTextArea(id);
                  textArea.setText(text);
        return    textArea;
    }
    
    /**
     * Metodo responsavel por retornar a Text Area pelo Identificador.
     * @param  id Identificador da Text Area.
     * @return Text Area pelo Identificador.
     */
    protected JTextArea getTextArea(String id) {
        return (JTextArea) textAreas.get(id);
    }
    
    /**
     * Metodo responsavel por retornar um Novo Text Field.
     * @param  id Identificador do Text Field.
     * @param  value Valor do Text Field.
     * @param  size Tamanho do Text Field.
     * @return Novo Text Field.
     */
    protected JTextField createTextField(String id, String value, int size) {
        JTextField textField = new JTextField(size);
                   textField.setText(value);
                   textField.setPreferredSize(new Dimension(ViewStyle.LARGURA, ViewStyle.ALTURA));
                   textField.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
                   textField.addActionListener(controller);
                   textField.addKeyListener(controller);
                   textFields.put(id, textField);
        return     textField;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Text Field Nao Editavel.
     * @param  id Identificador do Text Field.
     * @param  value Valor do Text Field.
     * @param  size Tamanho do Text Field.
     * @return Novo Text Field Nao Editavel.
     */
    protected JTextField createTextFieldNoEditable(String id, String value, int size) {
        JTextField textField = createTextField(id, value, size);
                   textField.setEditable(false);
        return     textField;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Price Text Field.
     * @param  id Identificador do Price Text Field.
     * @param  value Valor do Price Text Field.
     * @param  size Tamanho do Price Text Field.
     * @return Novo Price Text Field.
     */
    protected JTextField createPriceTextField(String id, Float value, int size) {
        JTextField textField = createTextField(id, "", size);
                   textField.setHorizontalAlignment(SwingConstants.RIGHT);
                   textField.setText(new DecimalFormat("R$ #,##0.00").format(value));
        return     textField;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Decimal Text Field.
     * @param  id Identificador do Decimal Text Field.
     * @param  value Valor do Decimal Text Field.
     * @param  size Tamanho do Decimal Text Field.
     * @return Novo Decimal Text Field.
     */
    protected JTextField createDecimalTextField(String id, Float value, int size) {
        JTextField textField = createTextField(id, "", size);
                   textField.setHorizontalAlignment(SwingConstants.RIGHT);
                   textField.setText(new DecimalFormat("R$ #,##0.00").format(value));
        return     textField;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Year Text Field.
     * @param  id Identificador do Year Text Field.
     * @return Novo Year Text Field.
     */
    protected JTextField createYearTextField(String id) {
        JTextField textField = createTextField(id, new FunctDate().getYear(new Date()), 5);
                   textField.setHorizontalAlignment(SwingConstants.RIGHT);
        return     textField;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Year Text Field.
     * @param  id Identificador do Year Text Field.
     * @param  value Valor do Year Text Field.
     * @return Novo Year Text Field.
     */
    protected JTextField createYearTextField(String id, Integer value) {
        JTextField textField = createYearTextField(id);
                   textField.setText(Integer.toString(value));
                   textField.setHorizontalAlignment(SwingConstants.RIGHT);
        return     textField;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Date Text Field.
     * @param  id Identificador do Date Text Field.
     * @param  value Valor do Date Text Field.
     * @return Novo Date Text Field.
     */
    protected JTextField createDateTextField(String id, Date value) {
        JTextField textField = createTextField(id, new FunctDate().getFormattedDate(value), 8);
                   textField.setHorizontalAlignment(SwingConstants.RIGHT);
        return     textField;
    }
    
    /**
     * Metodo responsavel por retornar o Text Field pelo Identificador.
     * @param  id Identificador do Text Field.
     * @return Text Field pelo Identificador.
     */
    protected JTextField getTextField(String id) {
        return (JTextField) textFields.get(id);
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
     * Metodo responsavel por retornar um Novo Constraints.
     * @param  width Largura do Constraints.
     * @param  height Altura do Constraints.
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
     * Metodo responsavel por retornar o Novo Start Constraint.
     * @return Novo Start Constraint.
     */
    protected GridBagConstraints createStartConstraint() {
        return setStartConstraint(new GridBagConstraints());
    }
    
    /**
     * Metodo responsavel por definir o Start Constraint.
     * @param  constraint Grid Bag Constraint.
     * @return Start Constraint.
     */
    protected GridBagConstraints setStartConstraint(GridBagConstraints constraint) {
               constraint.anchor  = GridBagConstraints.PAGE_START;
               constraint.fill    = GridBagConstraints.HORIZONTAL;
               constraint.gridx   = 0;
               constraint.gridy   = 0;
               constraint.weightx = 1.0;
               constraint.weighty = 0.25;
        return constraint;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Body Constraint.
     * @return Novo Body Constraint.
     */
    protected GridBagConstraints createBodyConstraint() {
        return setBodyConstraint(new GridBagConstraints());
    }
    
    /**
     * Metodo responsavel por definir o Body Constraint.
     * @param  constraint Grid Bag Constraint.
     * @return Body Constraint.
     */
    protected GridBagConstraints setBodyConstraint(GridBagConstraints constraint) {
               constraint.anchor     = GridBagConstraints.FIRST_LINE_START;
               constraint.fill       = GridBagConstraints.BOTH;
               constraint.gridx      = 0;
               constraint.gridy      = 1;
               constraint.weightx    = 1.0;
               constraint.weighty    = 11.75;
               constraint.gridheight = GridBagConstraints.RELATIVE;
               constraint.gridwidth  = GridBagConstraints.RELATIVE;
        return constraint;       
    }
    
    /**
     * Metodo responsavel por retornar o Controller do Panel.
     * @return Controller do Panel.
     */
    public Controller getController() {
        return controller;
    }
}