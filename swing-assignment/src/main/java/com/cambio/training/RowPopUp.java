package com.cambio.training;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * RowPopUp class is intended  to implement Adding delete functionality to the right click menu for rows
 */
public class RowPopUp extends JPopupMenu {

  public RowPopUp(JTable table) {
    JMenuItem delete = new JMenuItem("Delete");
    JMenuItem edit = new JMenuItem("Edit");

    delete.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {

        PatientTableModel model = (PatientTableModel) table.getModel();
        int row = table.getSelectedRow();
        model.removeRow(row);
        PatientRegForm.refresh();
      }
    });

    edit.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(delete, "EDITED ROW");
      }
    });

    add(delete);
    add(edit);
  }

}



