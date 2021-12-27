package com.company;

import com.company.GUI.AttrazioniFrame;
import com.company.GUI.CommentiFrame;
import com.company.GUI.LOGIN;
import com.company.GUI.ModenaFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        SwingUtilities.invokeLater(LOGIN::new);
    }
}
