package com.cambio.training;


import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * PatientTable model is used to present patient data
 */
public class PatientTableModel extends AbstractTableModel
{
  private List<Patient> patientList;

  private final String[] columnNames = new String[] {
    "Name", "Age", "Address", "Emp. Status"
  };
  private final Class[] columnClass = new Class[] {
    String.class,String.class, String.class, String.class
  };

  public PatientTableModel(List<Patient> patientList)
  {
    this.patientList = patientList;
  }

  public List<Patient> getPatientList()
  {
    return this.patientList;
  }

  public void setPatientList(List<Patient> patientList)
  {
    this.patientList = patientList;
  }

  @Override
  public String getColumnName(int column)
  {
    return columnNames[column];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex)
  {
    return columnClass[columnIndex];
  }

  @Override
  public int getColumnCount()
  {
    return columnNames.length;
  }

  @Override
  public int getRowCount()
  {
    return patientList.size();
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    Patient row = patientList.get(rowIndex);
    if(0 == columnIndex) {
      return row.getName();
    }
    else if(1 == columnIndex) {
      return row.getAge();
    }
    else if(2 == columnIndex) {
      return row.getAddress();
    }
    else if(3 == columnIndex) {
      return row.getEmpStatus();
    }
    return null;
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex)
  {
    return true;
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex)
  {
    Patient row = patientList.get(rowIndex);
    if(0 == columnIndex) {
      row.setName((String) aValue);
    }
    else if(1 == columnIndex) {
      row.setName((String) aValue);
    }
    else if(2 == columnIndex) {
      row.setAddress((String) aValue);
    }
    else if(3 == columnIndex) {
      row.setEmpStatus((String) aValue);
    }
  }

  public void removeRow(int row) {
    // remove a row from your internal data structure
    patientList.remove(row);
  }
}
