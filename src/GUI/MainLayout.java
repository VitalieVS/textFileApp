package GUI;

import javax.swing.*;
import java.awt.*;

public class MainLayout extends JFrame {
    public MainLayout() {
        this.setTitle("TextApplication");
        this.setAlwaysOnTop(true);
        this.setPreferredSize(new Dimension(100, 200));
        this.setVisible(true);
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
