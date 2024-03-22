package view.user;

import javax.swing.*;
import java.awt.*;

public class CreateMeetingJDialog extends JDialog {
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton finishButton;
    public CreateMeetingJDialog(Window owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - jiajun Liu
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        finishButton = new JButton();

        //======== this ========
        setTitle("\u4f1a\u8bae\u521b\u5efa\u6210\u529f/create successful");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x666666));
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
                    javax.swing.border.EmptyBorder(0,0,0,0), " ",javax
                    .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
                    .awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt
                    .Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.
                PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".
                equals(e.getPropertyName()))throw new RuntimeException();}});
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u4f1a\u8bae\u5ba4\uff1a");
            label1.setForeground(Color.lightGray);
            panel1.add(label1);
            label1.setBounds(75, 60, 105, 35);

            //---- label2 ----
            label2.setText("text");
            label2.setForeground(Color.lightGray);
            panel1.add(label2);
            label2.setBounds(220, 60, 105, 35);

            //---- label3 ----
            label3.setText("===\u521b\u5efa\u7684\u4f1a\u8bae\u5c06\u5728\u6b64\u4f1a\u8bae\u5ba4\u4e2d\u5f00\u59cb===");
            label3.setForeground(Color.lightGray);
            panel1.add(label3);
            label3.setBounds(70, 110, 250, 60);

            //---- finishButton ----
            finishButton.setText("\u5b8c\u6210/finish");
            finishButton.setBackground(Color.black);
            finishButton.setForeground(Color.lightGray);
            panel1.add(finishButton);
            finishButton.setBounds(130, 195, 105, 40);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 380, 260);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
    }

}