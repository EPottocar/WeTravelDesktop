package com.company.GUI;

import com.company.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LOGIN extends JFrame implements ActionListener {
    public static String Utente;
    private final JTextField User;
    private final JPasswordField PASSWORD;
    private final JButton INVIOButton;
    String s;

    public LOGIN() {
        super("LOGIN-WeTravel");
        User = new JTextField("");
        JLabel userLabel = new JLabel("USER");

        PASSWORD = new JPasswordField();
        INVIOButton = new JButton("INVIO");
        INVIOButton.addActionListener(this);

        JPanel p1 = new JPanel(new GridLayout(10, 2));
        p1.add(userLabel);
        p1.add(User);
        p1.add(new JLabel("PASSWORD"));
        p1.add(PASSWORD);

        JPanel p2 = new JPanel();
        p2.add(INVIOButton);


        JPanel p3 = new JPanel(new BorderLayout(10, 10));

        p3.add(p1, BorderLayout.NORTH);
        p3.add(p2, BorderLayout.CENTER);

        setContentPane(p3);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == INVIOButton) {
            Utente = User.getText();
            if (User.getText().equals("Admin") && PASSWORD.getText().equals("EdoardoBaha")) {
                String[] opzioni = {"Modifica Attrazione", "Aggiungi Attrazione", "Modifica Città", "Aggiungi Città", "Cancella Attrazione", "Cancella Città"};

                s = (String) JOptionPane.showInputDialog(this, "Scegli azione",
                        "Selezione", JOptionPane.PLAIN_MESSAGE, null, opzioni, "Seleziona");
                setVisible(false);
                new DBmanagerFrame(s);
            }
            else{
                Database DB = new Database("Login", "Utenti", "Utenti");
                Database DB1 = new Database("Login", "Utenti","Password");
                if (DB.CheckUtenteDB(User.getText(),DB)){ // se l'utente utente è registrato
                    if (!DB1.CheckPasswordDB(PASSWORD.getText(), DB1)){
                        JOptionPane.showMessageDialog(this, "Password errata!", "Login Error!",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{ // se la password è corretta
                        setVisible(false);
                        new MainFrame();
                        JOptionPane.showMessageDialog(this, "" +Utente + " benvenuto in Wetravel!", "Login Succesful!",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{ // se l'utente non è registrato
                    DB.InsertUtenteDB(DB, User.getText());
                    DB1.UpdateCommentDB(DB1, PASSWORD.getText());
                    JOptionPane.showMessageDialog(this, "Registrazione effettuata con successo" , "Login Succesful!",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    new MainFrame();
                    JOptionPane.showMessageDialog(this, "" +Utente + " benvenuto in Wetravel!", "Login Succesful!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}