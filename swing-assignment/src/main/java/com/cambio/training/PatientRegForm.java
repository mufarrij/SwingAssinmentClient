package com.cambio.training;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

/**
 * PatientRegForm class consist of interface implementation and  logic related to Patient Registration Form
 * interface of the Patient Registration form implemented using GridBagLayout, it uses 3 main individual
 * components to create entire form.they are inputPanel, searchPanel  and tablePanel.
 */
public class PatientRegForm extends JFrame
{

  /**
   * Initializing  input fields used in Patient Registration Form
   */
  JTextField nameFieldInput = new JTextField("");
  JTextField nameFieldSearch= new JTextField("");
  JTextField phoneNumberField = new JTextField("");
  JTextArea addressTextArea = new JTextArea(3, 1);


  // Gender Field inputPanel
  JRadioButton genderMale = new JRadioButton("Male");
  JRadioButton genderFemale = new JRadioButton("Female");

  // Gender Field searchPanel
  JTextField birthYearField = new JTextField("");
  ButtonGroup genderGroupSearch = new ButtonGroup();
  JRadioButton genderMaleSearch = new JRadioButton("Male");
  JRadioButton genderFemaleSearch = new JRadioButton("Female");


  // Date Picker
  UtilDateModel model = new UtilDateModel();
  JDatePanelImpl datePanel = new JDatePanelImpl(model);
  JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);


  // Employee Status
  String empStatus[] = { "Full Time", "Part Time", "Retired", "Unemployed", "Student" };
  JComboBox empStatusComboBox = new JComboBox(empStatus);

  // Save and Clear Button
  JButton clear = new JButton("Clear");
  JButton save = new JButton("Save");


  //Patient Data Handling

  /**
   * Initializing data handler object
   */
  public static DataHandler dataHandler = new DataHandler();

  public static PatientTableModel tableModel = dataHandler.getPatientTableModel();
  //create the table
  public  static JTable table = new JTable(tableModel);

  /**
   * constructor method for PatientRegForm which initialize GUI for the form
   */
  public PatientRegForm()
  {
    initGUI();
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

  }

  /**
   * refresh method is used to refresh table model after any changes to the data
   */
  public static void refresh(){

    tableModel.fireTableDataChanged();
  }

  /**
   * initGUI method is used to render  Patient Registration form
   * it creates inputPanel , searchPanel and tablePanel and place
   * those components in appropriate locations on the form using
   * GriBagLayout
   */
  public  void initGUI()
  {

    setTitle("Patient Registration");

    JPanel panel = new JPanel(new GridBagLayout());
    this.getContentPane().add(panel);


    //creating InputPanel
    JPanel inputPanel = this.createInputPanel();
    inputPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 0;
    c.fill = GridBagConstraints.BOTH;
    c.anchor = GridBagConstraints.NORTH;
    c.weightx = 1;
    c.weighty = 1;
    c.insets = new Insets(4, 4, 4, 4);
    panel.add(inputPanel, c);

    //creating SearchPanel
    JPanel searchPanel = this.createSearchPanel();

    c.gridx = 0;
    c.gridy = 1;
    panel.add(searchPanel, c);

    //creating TablePanel
    JPanel tablePanel = this.createTablePanel();
    c.gridx = 0;
    c.gridy = 2;
    panel.add(tablePanel, c);

    this.pack();

    this.setVisible(true);
  }

  /**
   * createInputPanel method is used to create InputPanel Component of GUI
   * InputPanel is a Form which has textFields , DatePicker , ComboBoxes
   * to take input from users , InputPanel is created using GridBagLayout
   * inorder to place input fields appropriately
   * @return inputPanel which is a JPanel object
   */
  private JPanel createInputPanel()
  {

    // initializing inputPanel
    JPanel inputPanel = new JPanel();
    inputPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    FormUtility fu = new FormUtility();

    // initializing  labels used in the InputPanel
    JLabel nameLabel = new JLabel("Name *");
    JLabel phoneNumberLabel = new JLabel("Phone Number ");
    JLabel birthDayLable = new JLabel("Birthday *");
    JLabel genderLabel = new JLabel("Gender *");
    JLabel addressLabel = new JLabel("Address ");
    JLabel employmentStatusLabel = new JLabel("Employment Status ");

    // initializing gender button group
    ButtonGroup genderGroup = new ButtonGroup();
    genderGroup.add(genderMale);
    genderGroup.add(genderFemale);

    // initializing  radioPanel which uses GridBagLayout to render gender radio buttons
    JPanel radioPanel = new JPanel();
    radioPanel.setLayout(new GridBagLayout());
    fu.addLabel(genderFemale, radioPanel);
    fu.addLabel(genderMale, radioPanel);

    // initializing clear,save button panel which uses GridBagLayout

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridBagLayout());
    buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    fu.addMiddleField(save, buttonPanel);
    fu.addMiddleField(clear, buttonPanel);


    // placing the internal components of inputPanel using GridBagLayout
    inputPanel.setLayout(new GridBagLayout());
    inputPanel.setPreferredSize(new Dimension(600, 300));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.LINE_START;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.insets = new Insets(4, 4, 4, 4);

    int i = 0;

    gbc.gridx = 0;
    gbc.gridy = i;
    gbc.weightx = 0.0;
    gbc.gridwidth = 1;
    inputPanel.add(nameLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = i;
    gbc.weightx = 1;
    gbc.gridwidth = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    inputPanel.add(nameFieldInput, gbc);

    i++;

    gbc.gridx = 0;
    gbc.gridy = i;
    gbc.weightx = 0.0;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.NONE;
    inputPanel.add(phoneNumberLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = i;
    gbc.weightx = 1;
    gbc.gridwidth = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    inputPanel.add(phoneNumberField, gbc);

    i++;

    gbc.gridx = 0;
    gbc.gridy = i;
    gbc.weightx = 0.0;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.NONE;
    inputPanel.add(birthDayLable, gbc);

    gbc.gridx = 1;
    gbc.gridy = i;
    gbc.weightx = 1;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    inputPanel.add(datePicker, gbc);

    i++;

    gbc.gridx = 0;
    gbc.gridy = i;
    gbc.weightx = 0.0;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.NONE;
    inputPanel.add(genderLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = i;
    gbc.weightx = 1;
    gbc.gridwidth = 1;
    inputPanel.add(radioPanel, gbc);

    i++;

    gbc.gridx = 0;
    gbc.gridy = i;
    gbc.weightx = 0.0;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.NONE;
    inputPanel.add(addressLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = i;
    gbc.weightx = 1;
    gbc.gridwidth = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    inputPanel.add(addressTextArea, gbc);

    i++;
    gbc.gridx = 0;
    gbc.gridy = i;
    gbc.weightx = 0.0;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.NONE;
    inputPanel.add(employmentStatusLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = i;
    gbc.weightx = 1;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    inputPanel.add(empStatusComboBox, gbc);

    i++;
    gbc.gridx = 2;
    gbc.gridy = i;
    gbc.gridwidth = 1;
    gbc.weightx = 1;
    gbc.anchor = GridBagConstraints.LINE_END;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    inputPanel.add(buttonPanel, gbc);


    // following codes consist of Input handling logic for inputPanel

    // Disabling save button untill all required fields are filled ( Name, BirthDay , Gender )
    save.setEnabled(false);

    nameFieldInput.addKeyListener(new KeyAdapter()
    { @Override
    public void keyReleased(KeyEvent e)
    {
      super.keyReleased(e);
      if ( nameFieldInput.getText().length() > 0 && (Date) datePicker.getModel().getValue() != null && (genderMale.isSelected() || genderFemale.isSelected() ) )
        save.setEnabled(true);
      else
        save.setEnabled(false);
    }
    });

    // Allowing  only numbers for phone number field
    phoneNumberField.addKeyListener(new KeyAdapter()
    { @Override
    public void keyTyped(KeyEvent e)
    {
      char c = e.getKeyChar();
      if (Utility.phoneNumberFieldCheck(c))
      {
        e.consume();
      }
    }

      //Disabling save button until all required fields are filled ( Name, BirthDay , Gender )
      @Override
      public void keyReleased(KeyEvent e)
      {
        super.keyReleased(e);
        if ( nameFieldInput.getText().length() > 0 && (Date) datePicker.getModel().getValue() != null && (genderMale.isSelected() || genderFemale.isSelected() ) )
          save.setEnabled(true);
        else
          save.setEnabled(false);
      }
    });


    addressTextArea.addKeyListener(new KeyAdapter()
    {
      // Disabling save button until all required fields are filled ( Name, BirthDay , Gender )
      @Override public void keyReleased(KeyEvent e)
      {
        super.keyReleased(e);
        if ( nameFieldInput.getText().length() > 0 && (Date) datePicker.getModel().getValue() != null && (genderMale.isSelected() || genderFemale.isSelected() ) )
          save.setEnabled(true);
        else
          save.setEnabled(false);
      }
    });



    // Implementing validation message for birthday which is a future date
    datePicker.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        Date birthDate = (Date)datePicker.getModel().getValue();

        if(birthDate != null)
        {
          if (birthDate.compareTo(currentDate) > 0)
          {
            JOptionPane.showMessageDialog(null,
                                          "Oops!!! BirthDay Cant be a Future Date.",
                                          "Validation Error",
                                          JOptionPane.ERROR_MESSAGE);
            datePicker.getModel().setSelected(false);

          }
        }

        // disabling save button until  all required fields are filled ( Name, BirthDay , Gender )
        if ( nameFieldInput.getText().length() > 0 && (Date) datePicker.getModel().getValue() != null && (genderMale.isSelected() || genderFemale.isSelected() ) )
          save.setEnabled(true);
        else
          save.setEnabled(false);
      }

    });

    genderFemale.addActionListener(new ActionListener()
    {
      @Override public void actionPerformed(ActionEvent e)
      {
        // disabling save button until  all required fields are filled ( Name, BirthDay , Gender )
        if ( nameFieldInput.getText().length() > 0 && (Date) datePicker.getModel().getValue() != null && (genderMale.isSelected() || genderFemale.isSelected() ) )
          save.setEnabled(true);
        else
          save.setEnabled(false);
      }
    });

    genderMale.addActionListener(new ActionListener()
    {
      @Override public void actionPerformed(ActionEvent e)
      {
        // disabling save button until  all required fields are filled ( Name, BirthDay , Gender )
        if ( nameFieldInput.getText().length() > 0 && (Date) datePicker.getModel().getValue() != null && (genderMale.isSelected() || genderFemale.isSelected() ) )
          save.setEnabled(true);
        else
          save.setEnabled(false);
      }
    });



    // Implementing save button functionality of the Patient Registration Form
    save.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent actionEvent)
      {

        // getting user inputs from textFields of inputPanel
        String name = nameFieldInput.getText();
        String phoneNum = phoneNumberField.getText();
        String address = addressTextArea.getText();

        // getting birthday input from the datePicker
        Calendar cal = Calendar.getInstance();
        Date birth = (Date)datePicker.getModel().getValue();

        // calculating age based on birthday
        Date today = cal.getTime();
        Long diff =today.getTime() - birth.getTime();
        Long diffinMonths = diff / 1000 / 60 / 60 / 24 / 30 ;

        String age = "";

        // if age is less than 3 years setting age in years and months
        if(diffinMonths < 36 )
        {
          age = Utility.monthsToYearsAndMonths( diffinMonths.intValue() );
        }
        // if age is greater than 3 years setting age in years
        else if( diffinMonths > 36 )
        {
          age = Utility.monthsToYears( diffinMonths.intValue() );
        }

        // setting  gender of patient based on selected radio button
        String gender = "";

        if( genderMale.isSelected() )
        {
          gender = "Male";
        }
        else if( genderFemale.isSelected())
        {
          gender = "Female";
        }

        // setting  employment status of patient based on selected option from comboBox
        String empStatus ="";

        if( empStatusComboBox.getSelectedIndex() == 0 )
        {
          empStatus = "Full Time";
        }
        else if( empStatusComboBox.getSelectedIndex() == 1 )
        {
          empStatus = "Part Time";
        }
        else if( empStatusComboBox.getSelectedIndex() == 2 )
        {
          empStatus = "Retired";
        }
        else if( empStatusComboBox.getSelectedIndex() == 3 )
        {
          empStatus = "Unemployed";
        }
        else if( empStatusComboBox.getSelectedIndex() == 4 )
        {
          empStatus = "Student";
        }

        // inserting user entered new data to the data store using dataHandler
        Patient p = new Patient( name , phoneNum , birth , gender , age , address , empStatus );
        dataHandler.addPatient(p);
        PatientRegForm.refresh();
        save.setEnabled(false);

      }
    });


    // implementing clear button functionality of the Patient Registration Form
    clear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {

        nameFieldInput.setText("");
        phoneNumberField.setText("");
        addressTextArea.setText("");
        empStatusComboBox.setSelectedIndex(0);
        datePicker.getModel().setSelected(false);
        genderGroup.clearSelection();

        // Clear Search Panel

        nameFieldSearch.setText("");
        birthYearField.setText("");
        genderGroupSearch.clearSelection();

        // Change table model List to patientList

        tableModel.setPatientList(dataHandler.patientList);
        PatientRegForm.refresh();


      }
    });

    return inputPanel;
  }

  /**
   * createSearchPanel method is used to create searchPanel Component of GUI
   * searchPanel has textFields ,radio button ,search button to perform search based on user input
   * createSearchPanel method uses GridBagLayout to place components appropriately
   * @return searchPanel which is a JPanel object
   */
  private JPanel createSearchPanel()
  {

    // initialing searchPanel
    JPanel searchPanel = new JPanel();
    searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    searchPanel.setPreferredSize(new Dimension(600, 40));

    // initializing FormUtility object used
    FormUtility fu = new FormUtility();

    // initializing labels and textFields used in search panel
    JLabel nameLabel = new JLabel("Name");
    JLabel birthYearLabel = new JLabel("BirthYear");
    JButton search = new JButton("Search");


    // initializing Gender button group for search panel
    genderGroupSearch.add(genderMaleSearch);
    genderGroupSearch.add(genderFemaleSearch);

    // initializing radioPanel which uses GridBagLayout to render gender radio buttons
    JPanel radioPanel = new JPanel();
    radioPanel.setLayout(new GridBagLayout());
    fu.addMiddleField(genderFemaleSearch, radioPanel);
    fu.addMiddleField(genderMaleSearch, radioPanel);


    // placing the internal components of searchPanel using GridBagLayout
    searchPanel.setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.LINE_START;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.insets = new Insets(4, 4, 4, 4);

    int i = 0;

    gbc.gridx = 0;
    gbc.gridy = i;
    gbc.weightx = 0.0;
    gbc.gridwidth = 1;
    searchPanel.add(nameLabel, gbc);

    i++;
    gbc.gridx = i;
    gbc.weightx = 1;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    searchPanel.add(nameFieldSearch, gbc);

    i++;
    gbc.gridx = i;
    gbc.weightx = 0.0;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.NONE;
    searchPanel.add(birthYearLabel, gbc);

    i++;
    gbc.gridx = i;
    gbc.weightx = 1;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    searchPanel.add(birthYearField, gbc);

    i++;
    gbc.gridx = i;
    gbc.weightx = 1;
    gbc.gridwidth = 1;
    searchPanel.add(radioPanel, gbc);

    i++;
    gbc.gridx = i;
    gbc.weightx = 1;
    gbc.gridwidth = 1;
    searchPanel.add(search, gbc);


    //Implementing Filter functionality to the search button

    TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel( ));

    table.setRowSorter(rowSorter);

    search.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {

        // Sorting the table based on input

        // clear existing searchdata
        DataHandler.searchList.clear();

        String nameSearch = nameFieldSearch.getText();
        if( nameSearch.length() == 0)
          nameSearch = "" ;

        String birthYearSearch = birthYearField.getText();
        if( birthYearSearch.length() == 0)
          birthYearSearch = "";

        String genderSearch = "";

        if( genderMaleSearch.isSelected() )
        {
          genderSearch = "Male";
        }
        else if( genderFemaleSearch.isSelected())
        {
          genderSearch = "Female";
        }

        dataHandler.fillSearchData( nameSearch , birthYearSearch , genderSearch );
        tableModel.setPatientList( dataHandler.searchList );
        PatientRegForm.refresh();

      }
    });

    return searchPanel;
  }

  /**
   * createTablePanel method is used to create tablePanel Component of GUI
   * tablePanel consit of  JScrollPane component , close button
   * createTablePanel method uses GridBagLayout to place components appropriately
   * @return tablePanel which is a JPanel object
   */
  public JPanel createTablePanel()
  {
    // initialize form utility object which is used to create the panel
    FormUtility fu = new FormUtility();

    // adding right click delete functionality
    final RowPopUp rpop = new RowPopUp(table);

    // setting Emp.Status column of the table as editable
    String[] empStatus = { "Part Time", "Student", "Retired", "Unemployed" };
    JComboBox empStatusBox = new JComboBox(empStatus);
    table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(empStatusBox));

    // initializing scroll pane which is used to render table
    JScrollPane empTabelPane = new JScrollPane(table);

    // initializing tablePanel  and placing the internal components using GridBagLayout
    JPanel tablePanel = new JPanel();
    tablePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    tablePanel.setPreferredSize(new Dimension(600, 180));
    tablePanel.setLayout(new GridBagLayout());

    JButton close = new JButton("Close");
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridBagLayout());
    buttonPanel.setSize(new Dimension(150, 40));
    fu.addMiddleField(close, buttonPanel);


    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.LINE_START;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.insets = new Insets(5, 5, 5, 5);

    int i = 0;

    gbc.gridx = 0;
    gbc.gridy = i;
    gbc.gridwidth = 2;
    tablePanel.add(empTabelPane, gbc);

    i++;

    gbc.gridx = 1;
    gbc.gridy = i;
    gbc.gridwidth = GridBagConstraints.RELATIVE;
    gbc.weightx = 1;
    gbc.anchor = GridBagConstraints.NORTHEAST;
    gbc.fill = GridBagConstraints.NONE;
    tablePanel.add(buttonPanel, gbc);

    // Implementing functionality of the tablePane

    // adding functionality to close button
    close.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });



    // adding delete shortcut functionality to selected row
    InputMap im = table.getInputMap(JTable.WHEN_FOCUSED);
    ActionMap am = table.getActionMap();

    Action deleteAction = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {

        PatientTableModel model1 = (PatientTableModel) table.getModel();
        int row = table.getSelectedRow();
        model1.removeRow(row);
        PatientRegForm.refresh();
      }

    };

    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "Delete");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "Delete");
    am.put("Delete", deleteAction);


    // adding mouse action listening functionality for left click and right click of a row
    // adding functionality to fill input fields  with selected row data
    table.addMouseListener(new MouseAdapter()
    {
      @Override public void mouseClicked(MouseEvent e)
      {
        //Determine If Right Clicked
        if(SwingUtilities.isRightMouseButton(e))
        {
          rpop.show(e.getComponent(),e.getX(),e.getY());
        }
        else if(SwingUtilities.isLeftMouseButton(e))
        {

          int row = table.getSelectedRow();
          Patient p = tableModel.getPatientList().get(row);

          nameFieldInput.setText(p.getName());
          phoneNumberField.setText(p.getPhoneNumber());
          addressTextArea.setText(p.getAddress());
          if( p.getGender() == "Male" )
          {
            genderMale.setSelected(true);
          }
          else
          {
            genderFemale.setSelected(true);
          }
          String empStatus  = p.getEmpStatus();
          if(empStatus == "Full Time"){
            empStatusComboBox.setSelectedIndex(0);
          }
          else if (empStatus == "Part Time")
          {
            empStatusComboBox.setSelectedIndex(1);
          }
          else if (empStatus == "Retired")
          {
            empStatusComboBox.setSelectedIndex(2);
          }
          else if (empStatus == "Unemployed")
          {
            empStatusComboBox.setSelectedIndex(3);
          }
          else if (empStatus == "Student")
          {
            empStatusComboBox.setSelectedIndex(4);
          }

          Date birth = p.getBirthDay();
          String birthDate = birth.toString();

          datePicker.getJFormattedTextField().setText(birthDate);
        }

      }
    });


    // setting colour of a row to Red if age is less than 3 months

    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
      @Override
      public Component getTableCellRendererComponent(JTable table,
                                                     Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        Patient p = (Patient) tableModel.getPatientList().get(row);
        Date birthDay = p.getBirthDay();

        // checking if age is less than three months using Utility.isAgeLessThreeMonths method
        if (Utility.isAgeLessThreeMonths(birthDay)) {
          setBackground(Color.RED);
          setForeground(Color.WHITE);
        } else {
          setBackground(table.getBackground());
          setForeground(table.getForeground());
        }
        return this;
      }
    });


    return tablePanel;
  }

  /**
   * Main Mehtod for running Patient Registration Form
   * @param args
   */
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(()->{ new PatientRegForm().setVisible(true); });
  }

}
