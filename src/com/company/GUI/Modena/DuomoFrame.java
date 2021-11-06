package com.company.GUI.Modena;

import com.company.Database;
import com.company.GUI.CitiesFrame;
import com.company.GUI.SettingsFrame;

import javax.swing.*;

public class DuomoFrame extends JFrame{
    Database DB = new Database("Città", "Modena", "Duomo");
    String Text;
    private JPanel panel1;
    private JLabel ImageFacciata;
    private JTextArea Descript;
    private JButton Impostazioni;
    private JButton Indietro;
    private JLabel ImageInterno;

    public DuomoFrame(){
        super("DUOMO-MODENA");
        Text = DB.GetFromDB(DB);
        Descript.setText(Text);
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1450, 1100);

        Indietro.addActionListener(e -> {
            setVisible(false);
            SwingUtilities.invokeLater(ModenaFrame::new);
        });

        Impostazioni.addActionListener(e -> {
            setVisible(false);
            SwingUtilities.invokeLater(SettingsFrame::new);
        });
    }

}
