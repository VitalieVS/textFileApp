package options.tableOptions;

import models.ListInterface;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowDataTable implements ListInterface {
    String[] columnNames = {"Nume", "Prenume", "Grupa", "Buget", "Media"};
    JTable table;
    JFrame frame;

    public void insertRows() {
        frame = new JFrame("Created Table !");
        JPanel panel = new JPanel();
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        panel.setLayout(new BorderLayout());
        panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
        panel.add(table, BorderLayout.CENTER);

        for (int i = 0; i < textFileList.size(); i++) {
            model.insertRow(i, new Object[]{
                    textFileList.get(i).getId(),
                    textFileList.get(i).getNume(),
                    textFileList.get(i).getPrenume(),
                    textFileList.get(i).getGrupa(),
                    textFileList.get(i).getBursa()
            });
        }

        table.setSelectionModel(new ForcedListSelectionModel());
        table.getTableHeader().setReorderingAllowed(false);
        table.getModel().addTableModelListener(e -> {
            System.out.println(e.getColumn());
            System.out.println(e.getFirstRow());
            System.out.println(table.getValueAt(e.getColumn(), e.getFirstRow()));
            System.out.println("Changed!");
        });
        panel.add(table);
        frame.add(createRefreshButton());
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public JButton createRefreshButton() {
        JButton refreshButton = new JButton("Refresh");
        refreshButton.setSize(new Dimension(80,20));
        refreshButton.setLocation(0, table.getPreferredSize().height + 30);
        refreshButton.addActionListener(e -> {
            frame.dispose();
            new ShowDataTable().insertRows();
        });
        return refreshButton;
    }
}

