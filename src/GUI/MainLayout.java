package GUI;

import javax.swing.*;
import java.awt.*;

public class MainLayout extends JFrame {
    public MainLayout() {
        this.setTitle("TextApplication");
        this.setAlwaysOnTop(true);
        this.setSize(200,200);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initializeComponents();
    }

    public void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 100, 200);
        panel.setBackground(Color.gray);
        JButton readFileButton = new JButton("Read From File");
        readFileButton.setBounds(0,0,80,30);
        panel.add(readFileButton);
        this.add(panel);
    }
}
