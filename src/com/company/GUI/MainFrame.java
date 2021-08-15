package com.company.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JPanel MainFrame;
    private JButton homeButton;
    private JButton utenteButton;
    private JButton cittàButton1;
    private JTextField benvenutoInWeTravelTextField;

    public MainFrame(){

        setContentPane(MainFrame);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000,600);


    }

}
