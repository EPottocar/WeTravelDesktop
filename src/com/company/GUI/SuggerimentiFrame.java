package com.company.GUI;

import com.company.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuggerimentiFrame extends JFrame implements ActionListener{
    private final JPanel p1;
    private final JPanel p2;
    private final JPanel ptot;
    private final JTextArea AreaSuggerimenti;
    private final JTextArea AreaScrittura;
    private final JButton Invio;
    String b;

    public SuggerimentiFrame(String s) {
        super("Suggerimenti " +s);

        p1 = new JPanel(new GridLayout(2,1));
        p2 = new JPanel(new GridLayout(2,1));
        ptot = new JPanel(new BorderLayout(1,1));
        AreaScrittura = new JTextArea();
        AreaSuggerimenti = new JTextArea();

        if(SettingsFrame.colore == "notte"){
            getContentPane().setBackground(Color.black);
            p1.setBackground(Color.black);
            p2.setBackground(Color.black);
            ptot.setBackground(Color.black);
            AreaSuggerimenti.setBackground(Color.black);
            AreaSuggerimenti.setForeground(Color.white);
        }
        if(SettingsFrame.colore == "giorno") {
            getContentPane().setBackground(Color.white);
            p1.setBackground(Color.white);
            p2.setBackground(Color.white);
            ptot.setBackground(Color.white);
            AreaSuggerimenti.setBackground(Color.white);
            AreaSuggerimenti.setForeground(Color.black);
        }

        b = s;
        Database DB = new Database("Commenti", "Modena", "Sugg" +s);
        Invio = new JButton("INVIO");
        Invio.addActionListener(this);
        if (DB.GetSuggerimentiFromDB(DB, LOGIN.Utente) != null){
            AreaSuggerimenti.setText("" +DB.GetSuggerimentiFromDB(DB, LOGIN.Utente));
        }
        else {
            AreaSuggerimenti.setText("");
        }
        AreaSuggerimenti.setEditable(false);

        p1.add(new JLabel("Suggerimenti inviati:"));
        p1.add(AreaSuggerimenti);

        p2.add(new JLabel("Nuovo suggerimento(max 2000 caratteri):"));
        p2.add(AreaScrittura);

        ptot.add(p1, BorderLayout.NORTH);
        ptot.add(p2, BorderLayout.CENTER);
        ptot.add(Invio, BorderLayout.SOUTH);

        setContentPane(ptot);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
        setSize(900, 800);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Invio){
            Database DB1 = new Database("Commenti", "Modena", "Utenti");
            Database DB2 = new Database("Commenti", "Modena", "Sugg" +b);
            if (!DB1.CheckUtenteDB(LOGIN.Utente, DB1)) {
                DB1.InsertUtenteDB(DB1, "" + LOGIN.Utente);
            }
            DB2.UpdateCommentDB(DB2, LOGIN.Utente + ": \n"  +AreaScrittura.getText());
            JOptionPane.showMessageDialog(this, "" +LOGIN.Utente + ", grazie per il tuo contributo! \n" +
                            "Il team di WeTravel valuter?? al pi?? presto il tuo suggerimento!", "Suggerimento inviato!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}