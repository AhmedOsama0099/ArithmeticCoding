package com.arithmeticcoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class GUI extends JFrame{

    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JButton compressButton;
    private JTextField value;
    private JLabel range;
    private JTextField symbolInput;
    private JTextField lowRangeInput;
    private JTextField highRangeInput;
    private JList deCompressList;
    private JTextField deCompressedSeq;
    private JButton ADDButton;
    private JButton STARTButton;
    private JTextField valueInput;
    private JTextField numSymbolsInput;
    Vector<String>data=new Vector<>();
    Map<Character,LowUpperBoundry>table=new HashMap<>();
    //private JPanel panel1;

    public GUI() {
        setTitle("Arithmetic Coding");
        setSize(800,600);

        add(panel1);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        compressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value.setText(ArithmeticCoding.compressForGui(textField1.getText()));
                range.setText(ArithmeticCoding.getRangeForGui());

            }
        });

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                data.add(symbolInput.getText()+" , "+lowRangeInput.getText()+" , "+highRangeInput.getText());
                deCompressList.setListData(data);
                table.put(symbolInput.getText().charAt(0),new LowUpperBoundry(Double.valueOf(lowRangeInput.getText()),Double.valueOf(highRangeInput.getText())));
            }
        });
        STARTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                data.clear();
                deCompressedSeq.setText(ArithmeticCoding.deCompress(Double.valueOf(valueInput.getText()),Integer.parseInt(numSymbolsInput.getText()),table));
                table.clear();
            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui=new GUI();
                gui.setVisible(true);
            }
        });
    }


}
