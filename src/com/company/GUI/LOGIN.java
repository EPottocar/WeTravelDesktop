package com.company.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LOGIN extends JFrame implements ActionListener {
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


        /* JFrame methods called */
        setContentPane(p3);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == INVIOButton) {
            String user = User.getText();
            String pass = PASSWORD.getText();
            if (user.equals("Admin") && pass.equals("EdoardoBaha")) {
                String[] opzioni = {"Modifica Attrazione", "Aggiungi Attrazione", "Modifica Città", "Aggiungi Città"};

                s = (String) JOptionPane.showInputDialog(this, "Scegli azione",
                        "Selezione", JOptionPane.PLAIN_MESSAGE, null, opzioni, "Seleziona");
                setVisible(false);
                new DBmanagerFrame(s);
            }
            else{
                JOptionPane.showMessageDialog(this, "Benvenuto in Wetravel!", "Login Succesful!",
                        JOptionPane.INFORMATION_MESSAGE);

                setVisible(false);
                SwingUtilities.invokeLater(MainFrame::new);
            }

        }


    }
}

