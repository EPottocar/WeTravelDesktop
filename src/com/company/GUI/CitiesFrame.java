package com.company.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CitiesFrame extends JFrame{
    private JPanel CitiesFrame;
    private JButton Città1;
    private JButton Città2;
    private JMenuItem Indietro;
    private JMenu Menu;
    private JMenuBar Barra;

    public CitiesFrame() {
        super("WeTravel");
        Indietro = new JMenuItem("Indietro");
        JMenu Menu = new JMenu("Menu");
        Menu.add(Indietro);
        Barra = new JMenuBar();
        Barra.add(Menu);
        setJMenuBar(Barra);
        setContentPane(CitiesFrame);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1500, 800);


        Città1.addActionListener(e -> {
            setVisible(false);
            SwingUtilities.invokeLater(ModenaFrame::new);
        });
        Città2.addActionListener(e -> {
            setVisible(false);
        });
        Indietro.addActionListener(e -> {
            setVisible(false);
            SwingUtilities.invokeLater(MainFrame::new);
        });
    }
}