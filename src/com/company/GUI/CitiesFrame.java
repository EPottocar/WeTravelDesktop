package com.company.GUI;

import com.company.GUI.Modena.ModenaFrame;

import javax.swing.*;

public class CitiesFrame extends JFrame{
    private JPanel CitiesFrame;
    private JButton Città1;
    private JButton Città2;

    public CitiesFrame() {
        super("WeTravel");
        setContentPane(CitiesFrame);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1500, 800);

        Città1.addActionListener(e -> {
            setVisible(false);
            SwingUtilities.invokeLater(ModenaFrame::new);
        });
        Città2.addActionListener(e -> {
            setVisible(false);
        });
    }

}
