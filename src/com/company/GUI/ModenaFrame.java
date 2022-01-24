package com.company.GUI;

import javax.swing.*;

import com.company.Database;

import java.awt.*;

public class ModenaFrame extends JFrame{
    String s;
    Database DB = new Database("Città", "Modena", "GenDescript");
    String Text;
    private JPanel Modena;
    private JLabel Image;
    private JButton Indietro;
    private JButton impostazioniButton;
    private JTextArea GenDescript;
    private JButton Attrazioni;
    private JPanel rettangolo;

    public ModenaFrame() {
        super("MODENA");

        if(SettingsFrame.colore == "notte"){
            getContentPane().setBackground(Color.black);
            GenDescript.setBackground(Color.black);
            GenDescript.setForeground(Color.white);
            rettangolo.setBackground(Color.black);
            Modena.setBackground(Color.black);
        }
        if(SettingsFrame.colore == "giorno"){
            getContentPane().setBackground(Color.white);
            GenDescript.setBackground(Color.white);
            GenDescript.setForeground(Color.black);
            rettangolo.setBackground(Color.white);
        }

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
            Database DBmain = new Database("Città","Modena","");
            String[] opzioni = DBmain.GetDBColumns(DBmain);

            s = (String) JOptionPane.showInputDialog(this, "Scegli attrazione",
                    "Selezione", JOptionPane.PLAIN_MESSAGE, null, opzioni, "Seleziona"
            );;

                setVisible(false);
                new AttrazioniFrame(s);

        });
        impostazioniButton.addActionListener(e -> {
            setVisible(false);
            SwingUtilities.invokeLater(SettingsFrame::new);
        });
    }
}