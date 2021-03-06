package com.cambio.training;

import javax.swing.*;
import java.awt.*;

/**
 * FormUtility class consist of methods that are used to
 * place components in parent container according needs  in
 * different positions using GridBagLayout
 */
public class FormUtility {
  /**
   * Grid bag constraints for fields and labels
   */
  private GridBagConstraints lastConstraints = null;
  private GridBagConstraints middleConstraints = null;
  private GridBagConstraints labelConstraints = null;
  private GridBagConstraints oneFieldMiddleCostrainsts = null;

  public FormUtility() {
    // Set up the constraints for the "last" field in each
    // row first, then copy and modify those constraints.

    // weightx is 1.0 for fields, 0.0 for labels
    // gridwidth is REMAINDER for fields, 1 for labels
    lastConstraints = new GridBagConstraints();

    // Stretch components horizontally (but not vertically)
    lastConstraints.fill = GridBagConstraints.HORIZONTAL;

    // Components that are too short or narrow for their space
    // Should be pinned to the northwest (upper left) corner
    lastConstraints.anchor = GridBagConstraints.NORTHWEST;

    // Give the "last" component as much space as possible
    lastConstraints.weightx = 1.0;

    // Give the "last" component the remainder of the row
    lastConstraints.gridwidth = GridBagConstraints.REMAINDER;

    // Add a little padding
    lastConstraints.insets = new Insets(2, 5, 2, 5);

    // Now for the "middle" field components
    middleConstraints = (GridBagConstraints) lastConstraints.clone();

    // These still get as much space as possible, but do
    // not close out a row
    middleConstraints.gridwidth = GridBagConstraints.RELATIVE;

    // And finally the "label" constrains, typically to be
    // used for the first component on each row
    labelConstraints =
      (GridBagConstraints) lastConstraints.clone();

    // Give these as little space as necessary
    labelConstraints.weightx = 0.0;
    labelConstraints.gridwidth = 1;
  }

  /**
   * Adds a field component. Any component may be used. The
   * component will be stretched to take the remainder of
   * the current row.
   */
  public void addLastField(Component c, Container parent)
  {
    GridBagLayout gbl = (GridBagLayout) parent.getLayout();
    gbl.setConstraints(c, lastConstraints);
    parent.add(c);
  }

  /**
   * Adds an arbitrary label component, starting a new row
   * if appropriate. The width of the component will be set
   * to the minimum width of the widest component on the
   * form.
   */
  public void addLabel(Component c, Container parent)
  {
    GridBagLayout gbl = (GridBagLayout) parent.getLayout();
    gbl.setConstraints(c, labelConstraints);
    parent.add(c);
  }

  /**
   * Adds a JLabel with the given string to the label column
   */
  public JLabel addLabel(String s, Container parent)
  {
    JLabel c = new JLabel(s);
    addLabel(c, parent);
    return c;
  }

  /**
   * Adds a "middle" field component. Any component may be
   * used. The component will be stretched to take all of
   * the space between the label and the "last" field. All
   * "middle" fields in the layout will be the same width.
   */
  public void addMiddleField(Component c, Container parent)
  {
    GridBagLayout gbl = (GridBagLayout) parent.getLayout();
    gbl.setConstraints(c, middleConstraints);
    parent.add(c);
  }

  /**
   * addCoverSpace method  cover the remaining  right corner space with empty JPanel
   * @param parent takes parent Container as argument
   */
  public void addCoverSpace(Container parent)
  {
    GridBagLayout gbl = (GridBagLayout) parent.getLayout();
    Component c = new JPanel();
    gbl.setConstraints(c,lastConstraints);
    parent.add(c);
  }
}
