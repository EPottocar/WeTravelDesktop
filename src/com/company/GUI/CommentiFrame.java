package com.company.GUI;

import com.company.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class CommentiFrame extends JFrame implements ActionListener {
    private final JScrollPane Panel;
    private final JPanel p1;
    private final JPanel p2;
    private final JPanel p3;
    private final JTextArea AreaCommenti;
    private final JTextArea AreaScrittura;
    private final JButton Invio;
    String b;

    public CommentiFrame(String s){
        super("Commenti " +s);
        p1 = new JPanel(new GridLayout(1,1));
        p2 = new JPanel(new GridLayout(2,1));
        p3 = new JPanel(new BorderLayout(1,1));
        Panel = new JScrollPane(p3);
        AreaCommenti = new JTextArea();

        if(Objects.equals(SettingsFrame.colore, "notte")){
            Panel.setBackground(Color.black);
            p1.setBackground(Color.black);
            p2.setBackground(Color.black);
            p3.setBackground(Color.black);
            AreaCommenti.setBackground(Color.black);
            AreaCommenti.setForeground(Color.white);
        }
        if(Objects.equals(SettingsFrame.colore, "giorno")) {
            Panel.setBackground(Color.white);
            p1.setBackground(Color.white);
            p2.setBackground(Color.white);
            p3.setBackground(Color.white);
            AreaCommenti.setBackground(Color.white);
            AreaCommenti.setForeground(Color.black);
        }

        b = s;
        Database DB = new Database("Commenti", "Modena", "" +s);
        AreaCommenti.setEditable(false);
        DB.SetActiveDB(DB);
        ArrayList<String> List = new ArrayList<String>();
        List.addAll(DB.GetCommentFromDB(DB));
        for(String a : List){
            if (a == null){
                continue;
            }
            AreaCommenti.append(a + "\n\n");
        }
        AreaScrittura = new JTextArea();
        Invio = new JButton("INVIO");
        Invio.addActionListener(this);

        p1.add(AreaCommenti);
        p2.add(AreaScrittura);
        p2.add(Invio);

        p3.add(p1, BorderLayout.CENTER);
        p3.add(p2, BorderLayout.SOUTH);

        setContentPane(Panel);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
        setSize(800, 700);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Invio){
            Database DB1 = new Database("Commenti", "Modena", "Utenti");
            Database DB2 = new Database("Commenti", "Modena", "" +b);
            if (DB1.CheckUtenteDB(LOGIN.Utente,DB1)){
                DB2.UpdateCommentDB(DB2, LOGIN.Utente + ": \n" +AreaScrittura.getText());
            }
            else{
                DB1.InsertUtenteDB(DB1, "" +LOGIN.Utente);
                DB2.UpdateCommentDB(DB2, LOGIN.Utente + ": \n" +AreaScrittura.getText());
            }
        }
    }
}