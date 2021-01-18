package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainLayout extends JFrame {
    private File file;
    public MainLayout() {
        this.setTitle("TextApplication");
        this.setAlwaysOnTop(true);
        this.setSize(300, 200);
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
        readFileButton.setBounds(0, 0, 80, 30);
        readFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(readFileButton);
        this.add(panel);
    }

    public boolean createFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new TXTFilter());
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            return true;
        } else {
            return false;
        }

    }
}
