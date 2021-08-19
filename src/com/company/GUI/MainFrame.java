package com.company.GUI;

import java.awt.Image;;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainFrame extends JFrame {
    private JPanel MainFrame;
    private JButton homeButton;
    private JButton impostazioniButton;
    private JTextField BENVENUTOINWETRAVELTextField;
    private JPanel Frame;
    private JButton Città;


    public MainFrame() {
        super("WeTravel");
        setContentPane(MainFrame);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1500,800);


        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SwingUtilities.invokeLater(MainFrame::new);
            }
        });
        Città.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SwingUtilities.invokeLater(CitiesFrame::new);
            }
        });
        impostazioniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SwingUtilities.invokeLater(SettingsFrame::new);
            }
        });
    }
}
