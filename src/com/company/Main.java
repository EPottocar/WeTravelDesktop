package com.company;

import com.company.GUI.LOGIN;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        SwingUtilities.invokeLater(LOGIN::new);
    }
}
