package com.company.GUI.Modena;

import javax.swing.*;

import com.company.Database;
import com.company.GUI.CitiesFrame;
import com.company.GUI.SettingsFrame;


public class ModenaFrame extends JFrame{
    Database DB = new Database("Città", "Modena", "GenDescript");
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
            String[] opzioni = {"Duomo", "Ghirlandina", "Palazzo Ducale"};

            String s = (String) JOptionPane.showInputDialog(this, "Scegli attrazione",
                    "Selezione", JOptionPane.PLAIN_MESSAGE, null, opzioni, "Seleziona"
            );;
            if (s == "Duomo") {
                setVisible(false);
                SwingUtilities.invokeLater(DuomoFrame::new);
            }


        });
        impostazioniButton.addActionListener(e -> {
            setVisible(false);
            SwingUtilities.invokeLater(SettingsFrame::new);
        });
    }

}
