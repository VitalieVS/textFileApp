package GUI;

import filter.TXTFilter;
import filter.Utils;
import models.ListInterface;
import options.TXTFileReader;
import options.tableOptions.ShowDataTable;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainLayout extends JFrame implements ListInterface {
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
        panel.add(createReadButton());
        panel.add(createShowButton());
        this.add(panel);
    }

    public JButton createReadButton() {
        JButton readFileButton = new JButton("Read From File");
        readFileButton.setBounds(0, 0, 80, 30);
        readFileButton.addActionListener(e -> {
            if (createFileChooser() && Utils.getExtension(file).equals(Utils.txt)) {
                TXTFileReader reader = new TXTFileReader(file);
                reader.readFile();
            }
        });
        return readFileButton;
    }

    public JButton createShowButton() {
        JButton showButton = new JButton("Show Data");
        showButton.setBounds(40, 40, 80, 30);
        showButton.addActionListener(e -> {
            if (Utils.getExtension(file).equals(Utils.txt)) {
                ShowDataTable tableData = new ShowDataTable();
                tableData.insertRows();
        }
        });
        return showButton;
    }

    public boolean createFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new TXTFilter());
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            return true;
        } else {
            return false;
        }
    }
}
