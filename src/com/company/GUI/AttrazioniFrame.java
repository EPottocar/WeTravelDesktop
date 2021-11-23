package com.company.GUI;

import com.company.Database;

import javax.swing.*;

public class AttrazioniFrame extends JFrame{
    String Text;
    private JPanel panel1;
    private JLabel Image1;
    private String image1;
    private JTextArea Descript;
    private JButton Impostazioni;
    private JButton Indietro;
    private JLabel Image2;
    private String image2;

    public AttrazioniFrame(String s){
        super("Modena-" +s);
        Database DB = new Database("Città", "Modena", "" +s);
        Text = DB.GetFromDB(DB);
        Descript.setText(Text);
        if (s.equals("Duomo")) {
            image1 = "/Users/edoardopottocar/IdeaProjects/WeTravelDesktop/out/production/WeTravelDesktop/com/company/Img/Duomo-Facciata.jpeg";
            image2 = "/Users/edoardopottocar/IdeaProjects/WeTravelDesktop/out/production/WeTravelDesktop/com/company/Img/Duomo-interno.jpeg";
            Image1.setIcon(new ImageIcon(image1));
            Image2.setIcon(new ImageIcon(image2));
        }
        if (s.equals("Ghirlandina")) {
            image1 = "/Users/edoardopottocar/IdeaProjects/WeTravelDesktop/out/production/WeTravelDesktop/com/company/Img/ghirlandina.jpeg";
            image2 = "/Users/edoardopottocar/IdeaProjects/WeTravelDesktop/out/production/WeTravelDesktop/com/company/Img/Ghirlandina2.jpeg";
            Image1.setIcon(new ImageIcon(image1));
            Image2.setIcon(new ImageIcon(image2));
        }
        if (s.equals("PalazzoDucale")) {
            image1 = "/Users/edoardopottocar/IdeaProjects/WeTravelDesktop/out/production/WeTravelDesktop/com/company/Img/PalazzoDucale.jpeg";
            image2 = "/Users/edoardopottocar/IdeaProjects/WeTravelDesktop/out/production/WeTravelDesktop/com/company/Img/PalazzoDucale-interno.jpeg";
            Image1.setIcon(new ImageIcon(image1));
            Image2.setIcon(new ImageIcon(image2));
        }
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