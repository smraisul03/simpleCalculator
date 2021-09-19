import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class textEditor extends JFrame implements ActionListener {
    JTextArea textArea;
    JLabel fontLabel;
    JScrollPane scrollPane;
    JSpinner fontSpinner;
    JButton colorButton;
    JComboBox fontChooserBox;

    JMenuBar menuBar;
    JMenu fileMenuBar;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;


    textEditor() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Editor");
        this.setSize(500,  500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        fontLabel = new JLabel("Font Size: ");

        fontSpinner = new JSpinner();
        fontSpinner.setPreferredSize(new Dimension(50, 25));
        fontSpinner.setValue(20);
        fontSpinner.addChangeListener(new ChangeListener() {


            public void stateChanged(ChangeEvent e) {
                textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN,(int) fontSpinner.getValue()));

            }

        });

        colorButton = new JButton("Color");
        colorButton.addActionListener(this);

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        fontChooserBox = new JComboBox(fonts);
        fontChooserBox.addActionListener(this);
        fontChooserBox.setSelectedItem("Monospaced");

        menuBar = new JMenuBar();
        fileMenuBar = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenuBar.add(openItem);
        fileMenuBar.add(saveItem);
        fileMenuBar.add(exitItem);
        menuBar.add(fileMenuBar);

        this.setJMenuBar(menuBar);
        this.add(fontLabel);
        this.add(fontSpinner);
        this.add(colorButton);
        this.add(fontChooserBox);
        this.add(scrollPane);
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==colorButton) {
            JColorChooser colorChooser = new JColorChooser();

            Color colorOptions = JColorChooser.showDialog(null, "", Color.black);

            textArea.setForeground(colorOptions);
        }

        if(e.getSource()==fontChooserBox) {
            textArea.setFont(new Font((String)fontChooserBox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));

        }

        if(e.getSource()==openItem) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Text Files", "txt");
            fileChooser.setFileFilter(fileFilter);

            int responseDialog = fileChooser.showOpenDialog(null);

            if (responseDialog == JFileChooser.APPROVE_OPTION) {
                File openFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;

                try {
                    fileIn = new Scanner(openFile);
                    if (openFile.isFile()) {
                        while(fileIn.hasNextLine()) {
                            String fileLine = fileIn.nextLine() + "\n";
                            textArea.append(fileLine);
                        }
                    }

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();

                }
                finally {
                    fileIn.close();

                }


            }

        }

        if(e.getSource()==saveItem) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            int responseDialog = fileChooser.showSaveDialog(null);

            if(responseDialog == JFileChooser.APPROVE_OPTION) {
                File file;
                PrintWriter fileOut = null;

                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    fileOut = new PrintWriter(file);
                    fileOut.println(textArea.getText());

                } catch(FileNotFoundException e1) {
                    e1.printStackTrace();

                }
                finally {
                    fileOut.close();

                }

            }

        }

        if(e.getSource()==exitItem) {
            dispose();

        }

    }

}
