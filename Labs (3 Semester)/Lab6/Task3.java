import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task3 extends JFrame {
    private JButton exit;
    private JPanel mainPanel;
    private JComboBox[] choice;
    private JTextArea textArea;

    Task3(){
        super("Задание 3");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        creationButton();
        creationTextCombo();
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        mainPanel.add(exit, BorderLayout.SOUTH);
        mainPanel.add(choice[0], BorderLayout.EAST);
        mainPanel.add(choice[1], BorderLayout.WEST);
        setContentPane(mainPanel);
        locateWindow();
        addWindowListener(new MyActionClose());
        addKeyListener(new EscapeAction());
    }

    private void creationButton(){
        exit = new JButton("Вернуться в главное меню");
        exit.setFocusPainted(false);
        exit.addActionListener(new ExitAction());
        exit.addKeyListener(new EscapeAction());
    }

    private void creationTextCombo(){
        String[][] myStr = {{"Times New Roman", "MS Sans Serif", "Courier New"},
                            {"Синий", "Красный", "Черный"}
        };
        choice = new JComboBox[2];
        int k = 0, c = 0;
        for (int i = 0; i < choice.length; i++) {
            choice[i] = new JComboBox();
            choice[i].addItem(myStr[c][k % 3]);
            k++;
            choice[i].addItem(myStr[c][k % 3]);
            k++;
            choice[i].addItem(myStr[c][k % 3]);
            choice[i].addKeyListener(new EscapeAction());
            choice[i].addKeyListener(new EnterAction());
            k++;
            c = 1;
        }
        choice[0].addItemListener(new MyItemFont());
        choice[1].addItemListener(new MyItemColor());
        textArea = new JTextArea();
        textArea.setColumns(50);
        textArea.setRows(30);
        textArea.addKeyListener(new EscapeAction());
    }

    private void locateWindow(){
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth())/2);
        int y = (int) ((screenSize.getHeight() - getHeight())/2);
        setResizable(false);
        setLocation(x, y);
    }

    private Color checkColor(String name){
        if (name.equals("Синий"))
            return Color.blue;
        else
        if (name.equals("Красный"))
            return Color.red;
        else
            return Color.black;
    }

    class EscapeAction extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                dispose();
        }
    }

    class EnterAction extends  KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                textArea.setFont(new Font(choice[0].getSelectedItem().toString(), Font.PLAIN, 20));
                textArea.setForeground(checkColor(choice[1].getSelectedItem().toString()));
            }
        }
    }

    class MyActionClose extends WindowAdapter {
        @Override
        public void windowClosed(WindowEvent e) {
            new MenuLab().setVisible(true);
        }
    }

    class ExitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    class MyItemFont implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            textArea.setFont(new Font(e.getItem().toString(), Font.PLAIN, 20));
        }
    }

    class MyItemColor implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
           textArea.setForeground(checkColor(e.getItem().toString()));
        }
    }
}
