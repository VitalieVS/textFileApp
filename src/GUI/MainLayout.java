package GUI;

import filter.TXTFilter;
import filter.Utils;

import javax.swing.*;
import java.awt.*;
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
        readFileButton.addActionListener(e -> {
            if (createFileChooser() && Utils.getExtension(file).equals(Utils.txt)) {
                System.out.println("Work");
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
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            return true;
        } else {
            return false;
        }
    }
}
