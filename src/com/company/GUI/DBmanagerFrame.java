package com.company.GUI;

import com.company.Database;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DBmanagerFrame extends JFrame implements ActionListener {
    String a;
    private final JPanel p1;
    private final JPanel p2;
    private final JPanel p3;
    private final JComboBox Città;
    private final JComboBox Attrazioni;
    private final JTextArea Descript;
    private final JTextField NomeAttr;
    private final JToolBar Barra;
    private final JButton Invio;
    private final JButton Indietro;
    private final JButton ModificaAttr;
    private final JButton AggiungiAttr;
    private final JButton ModificaCit;
    private final JButton AggiungiCit;

    // aggiungo possibilità di cancellare tabelle e colonne
    // stampo dentro text area cosa c'è già nel DB

    public DBmanagerFrame(String s){
        super("" +s);
        p1 = new JPanel(new GridLayout(5,2));
        p2 = new JPanel(new GridLayout(1,1));
        p3 = new JPanel(new BorderLayout(1,1));

        Barra = new JToolBar();
        Indietro = new JButton("LOGIN");
        Indietro.addActionListener(this);
        ModificaAttr = new JButton("MODIFICA ATTRAZIONE");
        ModificaAttr.addActionListener(this);
        AggiungiAttr = new JButton("AGGIUNGI ATTRAZIONE");
        AggiungiAttr.addActionListener(this);
        ModificaCit = new JButton("MODIFICA CITTA'");
        ModificaCit.addActionListener(this);
        AggiungiCit = new JButton("AGGIUNGI CITTA'");
        AggiungiCit.addActionListener(this);
        Barra.add(Indietro);
        Barra.add(ModificaAttr);
        Barra.add(AggiungiAttr);
        Barra.add(ModificaCit);
        Barra.add(AggiungiCit);

        Invio = new JButton("INVIO");
        Invio.addActionListener(this);
        NomeAttr = new JTextField();
        Descript = new JTextArea();

        String [] Cit = {"Modena"};
        String [] Attract = {"Duomo" , "Ghirlandina", "Palazzo Ducale"};
        Città = new JComboBox(Cit);
        Attrazioni = new JComboBox(Attract);

        if (s == "Modifica Attrazione"){
            a = "Modifica Attrazione";
            ModificaAttr.setVisible(false);
            p1.add(Città);
            p1.add(Attrazioni);
            p1.add(new JLabel("Descrizione(max 2000 caratteri)"));
            p1.add(Descript);

            p2.add(Invio);

            p3.add(Barra,BorderLayout.NORTH);
            p3.add(p1, BorderLayout.CENTER);
            p3.add(p2, BorderLayout.SOUTH);
        }
        if (s == "Aggiungi Attrazione"){
            a = "Aggiungi Attrazione";
            AggiungiAttr.setVisible(false);
            p1.add(Città);
            p1.add(new JLabel("Inserire nome attrazione"));
            p1.add(NomeAttr);
            p1.add(new JLabel("Descrizione(max 2000 caratteri)"));
            p1.add(Descript);

            p2.add(Invio);

            p3.add(Barra,BorderLayout.NORTH);
            p3.add(p1, BorderLayout.CENTER);
            p3.add(p2, BorderLayout.SOUTH);
        }
        if (s == "Modifica Città"){
            a = "Modifica Città";
            ModificaCit.setVisible(false);
            p1.add(Città);
            p1.add(new JLabel("Descrizione(max 2000 caratteri)"));
            p1.add(Descript);

            p2.add(Invio);

            p3.add(Barra,BorderLayout.NORTH);
            p3.add(p1, BorderLayout.CENTER);
            p3.add(p2, BorderLayout.SOUTH);
        }
        if (s == "Aggiungi Città"){
            a = "Aggiungi Città";
            AggiungiCit.setVisible(false);
            p1.add(new JLabel("Inserire nome città"));
            p1.add(NomeAttr);
            p1.add(new JLabel("Descrizione(max 2000 caratteri)"));
            p1.add(Descript);

            p2.add(Invio);

            p3.add(Barra,BorderLayout.NORTH);
            p3.add(p1, BorderLayout.CENTER);
            p3.add(p2, BorderLayout.SOUTH);
        }

        setContentPane(p3);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000, 800);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == Invio){
            if(a == "Modifica Attrazione"){
                String b = (String) Attrazioni.getSelectedItem();
                String c = (String) Città.getSelectedItem();
                Database DB = new Database("Città", "" +c, "" +b);
                DB.UpdateDB(DB, Descript.getText());
            }
            if(a == "Aggiungi Attrazione"){
                String c = (String) Città.getSelectedItem();
                Database DB = new Database("Città", "" +c, "");
                DB.AddColumnDB(DB,NomeAttr.getText());
                DB = new Database("Città", "" +c, "" +NomeAttr.getText());
                DB.WriteColumnDB(DB,Descript.getText());
            }
            if(a == "Modifica Città"){
                String c = (String) Città.getSelectedItem();
                Database DB = new Database("Città", "" +c, "GenDescript");
                DB.UpdateDB(DB, Descript.getText());
            }
            if(a == "Aggiungi Città"){
                Database DB = new Database("Città", "", "");
                DB.AddtableDB(DB, NomeAttr.getText());
                DB = new Database("Città", "" +NomeAttr.getText(),"GenDescript");
                DB.WriteColumnDB(DB, Descript.getText());
            }
        }
        if (e.getSource() == Indietro){
            setVisible(false);
            SwingUtilities.invokeLater(LOGIN::new);
        }
        if (e.getSource() == ModificaAttr){
            setVisible(false);
            new DBmanagerFrame("Modifica Attrazione");
        }
        if (e.getSource() == AggiungiAttr){
            setVisible(false);
            new DBmanagerFrame("Aggiungi Attrazione");
        }
        if (e.getSource() == ModificaCit){
            setVisible(false);
            new DBmanagerFrame("Modifica Città");
        }
        if (e.getSource() == AggiungiCit){
            setVisible(false);
            new DBmanagerFrame("Aggiungi Città");
        }
    }
}
