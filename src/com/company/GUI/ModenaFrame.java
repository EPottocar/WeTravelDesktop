package com.company.GUI;

import javax.swing.*;

import com.company.Database;


public class ModenaFrame extends JFrame{
    Database DB = new Database("Modena", "Città", "GenDescript");
    String Text;
    private JPanel Modena;
    private JLabel Image;
    private JButton Indietro;
    private JButton impostazioniButton;
    private JTextArea GenDescript;
    private JButton Attrazioni;

    public ModenaFrame() {
        super("MODENA");
        Text = DB.GetFromDB(DB);
        GenDescript.setText(Text);
        setContentPane(Modena);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1600, 1000);

        Indietro.addActionListener(e -> {
            setVisible(false);
            SwingUtilities.invokeLater(CitiesFrame::new);
        });
        Attrazioni.addActionListener(e -> {
            setVisible(false);
        });
    }

}
