package com.company.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel MainFrame;
    private JButton homeButton;
    private JButton impostazioniButton;
    private JTextField WETRAVELTextField;
    private JPanel Frame;
    private JButton Città;
    private JTextArea Newsletter;


    public MainFrame() {
        super("WeTravel");

        if(SettingsFrame.colore == "notte"){
            getContentPane().setBackground(Color.black);
            MainFrame.setBackground(Color.black);
            Frame.setBackground(Color.black);
            Newsletter.setBackground(Color.black);
            WETRAVELTextField.setBackground(Color.black);
        }
        if(SettingsFrame.colore == "giorno"){
            getContentPane().setBackground(Color.white);
        }

        setContentPane(MainFrame);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1500, 800);


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
                SwingUtilities.invokeLater(ModenaFrame::new);
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