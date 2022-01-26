package com.company.GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SettingsFrame extends JFrame {
    public static String colore;
    private JPanel SettingsFrame;
    private JButton Giorno;
    private JButton Notte;
    private JButton logout;
    private JMenuItem Indietro;
    private JMenu Menu;
    private JMenuBar Barra;

    public SettingsFrame() {
        super("Settings");
        SettingsFrame = new JPanel();
        Indietro = new JMenuItem("Indietro");
        JMenu Menu = new JMenu("Menu");
        Menu.add(Indietro);
        Giorno = new JButton("Giorno");
        Notte = new JButton("Notte");
        logout = new JButton("Logout");
        JMenuBar Barra = new JMenuBar();
        Barra.add(Menu);
        setJMenuBar(Barra);
        setContentPane(SettingsFrame);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SettingsFrame.add(Giorno);
        SettingsFrame.add(Notte);
        SettingsFrame.add(logout);
        Notte.setVisible(true);
        Giorno.setVisible(true);
        logout.setVisible(true);
        setVisible(true);
        setSize(1500, 800);

        Giorno.addActionListener(e -> {
            getContentPane().setBackground(Color.white);
            getJMenuBar().setBackground(Color.white);
            colore = "giorno";
        });
        Notte.addActionListener(e -> {
            getContentPane().setBackground(Color.black);
            getJMenuBar().setBackground(Color.black);
            colore = "notte";
        });
        Indietro.addActionListener(e -> {
            setVisible(false);
            SwingUtilities.invokeLater(MainFrame::new);
        });
        logout.addActionListener(e -> {
            setVisible(false);
            SwingUtilities.invokeLater(LOGIN::new);
        });
    };
}