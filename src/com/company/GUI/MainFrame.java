package com.company.GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainFrame extends JFrame {
    private JPanel MainFrame;
    private JButton homeButton;
    private JButton impostazioniButton;
    private JTextField BENVENUTOINWETRAVELTextField;
    private JPanel Frame;
    private JButton Città;
    private JButton utenteButton1;


    public MainFrame() {
        super("WeTravel");
        setContentPane(MainFrame);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000,600);


    }
}
