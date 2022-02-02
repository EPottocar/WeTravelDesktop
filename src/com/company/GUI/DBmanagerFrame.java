package com.company.GUI;

import com.company.Database;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

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
    private final JButton CancAttr;
    private final JButton CancCit;
    private final JButton Suggerimenti;
    private final JButton View;

    public DBmanagerFrame(String s){
        super("" +s);
        p1 = new JPanel(new GridLayout(4,2));
        p2 = new JPanel(new GridLayout(2,1));
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
        CancAttr = new JButton("CANCELLA ATTRAZIONE");
        CancAttr.addActionListener(this);
        CancCit = new JButton("CANCELLA CITTA'");
        CancCit.addActionListener(this);
        Suggerimenti = new JButton("SUGGERIMENTI");
        Suggerimenti.addActionListener(this);
        Barra.add(Indietro);
        Barra.add(ModificaAttr);
        Barra.add(AggiungiAttr);
        Barra.add(ModificaCit);
        Barra.add(AggiungiCit);
        Barra.add(CancAttr);
        Barra.add(CancCit);
        Barra.add(Suggerimenti);
        View = new JButton("VIEW");
        View.addActionListener(this);

        Invio = new JButton("INVIO");
        Invio.addActionListener(this);
        NomeAttr = new JTextField();
        Descript = new JTextArea();

        Database DBmain = new Database("Città","Modena","");

        String [] Cit = {"Modena"};
        String [] Attract = DBmain.GetDBColumns(DBmain);
        Città = new JComboBox(Cit);
        Attrazioni = new JComboBox(Attract);

        if (Objects.equals(s, "Modifica Attrazione")){
            a = "Modifica Attrazione";
            ModificaAttr.setVisible(false);
            p1.add(Città);
            p1.add(Attrazioni);
            p1.add(new JLabel("Descrizione(max 2000 caratteri)"));
            p1.add(Descript);

            p2.add(View);
            p2.add(Invio);

            p3.add(Barra,BorderLayout.NORTH);
            p3.add(p1, BorderLayout.CENTER);
            p3.add(p2, BorderLayout.SOUTH);;
        }
        if (Objects.equals(s, "Aggiungi Attrazione")){
            a = "Aggiungi Attrazione";
            AggiungiAttr.setVisible(false);
            p1.add(Città);
            NomeAttr.setText("Inserire nome attrazione");
            p1.add(NomeAttr);
            p1.add(new JLabel("Descrizione(max 2000 caratteri)"));
            p1.add(Descript);

            p2.add(Invio);

            p3.add(Barra,BorderLayout.NORTH);
            p3.add(p1, BorderLayout.CENTER);
            p3.add(p2, BorderLayout.SOUTH);
        }
        if (Objects.equals(s, "Modifica Città")){
            a = "Modifica Città";
            ModificaCit.setVisible(false);
            p1.add(Città);
            p1.add(new JLabel("Descrizione(max 2000 caratteri)"));
            p1.add(Descript);

            p2.add(View);
            p2.add(Invio);

            p3.add(Barra,BorderLayout.NORTH);
            p3.add(p1, BorderLayout.CENTER);
            p3.add(p2, BorderLayout.SOUTH);
        }
        if (Objects.equals(s, "Aggiungi Città")){
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
        if (Objects.equals(s, "Cancella Attrazione")){
            a = "Cancella Attrazione";
            CancAttr.setVisible(false);
            p1.add(Città);
            p1.add(Attrazioni);

            p2.add(Invio);

            p3.add(Barra,BorderLayout.NORTH);
            p3.add(p1, BorderLayout.CENTER);
            p3.add(p2, BorderLayout.SOUTH);
        }
        if (Objects.equals(s, "Cancella Città")){
            a = "Cancella Città";
            CancCit.setVisible(false);
            p1.add(Città);

            p2.add(Invio);

            p3.add(Barra,BorderLayout.NORTH);
            p3.add(p1, BorderLayout.CENTER);
            p3.add(p2, BorderLayout.SOUTH);
        }
        if (Objects.equals(s, "Suggerimenti")){
            a = "Suggerimenti";
            Suggerimenti.setVisible(false);
            p1.add(Barra);
            p1.add(Città);
            p1.add(Attrazioni);

            p2.add(Descript);

            p3.add(p1,BorderLayout.NORTH);
            p3.add(p2, BorderLayout.CENTER);
            p3.add(View, BorderLayout.SOUTH);
        }

        setContentPane(p3);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1200, 1000);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == Invio){
            if(Objects.equals(a, "Modifica Attrazione")){
                String b = (String) Attrazioni.getSelectedItem();
                String c = (String) Città.getSelectedItem();
                Database DB = new Database("Città", "" +c, "" +b);
                DB.UpdateDB(DB, Descript.getText());
            }
            if(Objects.equals(a, "Aggiungi Attrazione")){
                String c = (String) Città.getSelectedItem();
                Database DB = new Database("Città", "" +c, "");
                DB.AddColumnDB(DB,NomeAttr.getText());
                DB.setDBcolumn("" +NomeAttr.getText());
                DB.UpdateDB(DB,Descript.getText());
                Database DB1 = new Database("Commenti", "" +c, "");
                DB1.AddColumnDB(DB1,NomeAttr.getText());
                DB1.AddColumnDB(DB1,"Sugg" +NomeAttr.getText());
            }
            if(Objects.equals(a, "Modifica Città")){
                String c = (String) Città.getSelectedItem();
                Database DB = new Database("Città", "" +c, "GenDescript");
                DB.UpdateDB(DB, Descript.getText());
            }
            if(Objects.equals(a, "Aggiungi Città")){
                Database DB = new Database("Città", "", "");
                DB.AddTableDB(DB, NomeAttr.getText());
                DB = new Database("Città", "" +NomeAttr.getText(),"GenDescript");
                DB.UpdateDB(DB, Descript.getText());
                Database DB1 = new Database("Commenti", "", "");
                DB1.AddTableDB(DB1, NomeAttr.getText());
            }
            if(Objects.equals(a, "Cancella Attrazione")){
                String b = (String) Attrazioni.getSelectedItem();
                String c = (String) Città.getSelectedItem();
                Database DB = new Database("Città", "" +c, "" +b);
                DB.CancColumnDB(DB);
                Database DB1 = new Database("Commenti", "" +c, "" +b);
                DB1.CancColumnDB(DB1);
                Database DB2 = new Database("Commenti", "" +c, "Sugg" +b);
                DB1.CancColumnDB(DB2);
            }
            if(Objects.equals(a, "Cancella Città")){
                String c = (String) Città.getSelectedItem();
                Database DB = new Database("Città", "" +c, "");
                DB.CancTableDB(DB);
                Database DB1 = new Database("Commenti", "" +c, "");
                DB1.CancTableDB(DB1);
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
        if (e.getSource() == CancAttr){
            setVisible(false);
            new DBmanagerFrame("Cancella Attrazione");
        }
        if (e.getSource() == CancCit){
            setVisible(false);
            new DBmanagerFrame("Cancella Città");
        }
        if (e.getSource() == Suggerimenti){
            setVisible(false);
            new DBmanagerFrame("Suggerimenti");
        }
        if (e.getSource() == View){
            if (Objects.equals(a, "Modifica Città")){
                String c = (String) Città.getSelectedItem();
                Database DB2 = new Database("Città", "" +c, "GenDescript");
                Descript.setText(DB2.GetFromDB(DB2));
            }
            else if (Objects.equals(a, "Suggerimenti")){
                Database DB2 = new Database("Commenti", "" +Città.getSelectedItem(),
                        "Sugg" +Attrazioni.getSelectedItem());
                ArrayList<String> List = new ArrayList<String>();
                List.addAll(DB2.GetCommentFromDB(DB2));
                for(String a : List){
                    if (a == null){
                        continue;
                    }
                    Descript.append(a + "\n\n");
                }
            }
            else {
                String b = (String) Attrazioni.getSelectedItem();
                String c = (String) Città.getSelectedItem();
                Database DB2 = new Database("Città", "" + c, "" + b);
                Descript.setText(DB2.GetFromDB(DB2));
            }
        }
    }
}