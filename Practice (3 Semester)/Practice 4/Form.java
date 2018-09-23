import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Form extends JFrame {
    private Font font = new Font("Times New Roman", Font.PLAIN, 30);
    private JPanel mainPanel;
    private JButton[] buttons;
    private JLabel[] labels;

    Form(){
        super("Практическая работа 4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFont(font);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
        creatingObjects();
        panelAdd();
        setContentPane(mainPanel);
        locateWindow();
        requestFocusInWindow();
    }

    private void creatingObjects(){
        labels = new JLabel[3];
        buttons = new JButton[2];
        labels[0] = new JLabel("Result: 0 X 0");
        labels[1] = new JLabel("Last Scorer: N/A");
        labels[2] = new JLabel("Winner: DRAW");
        buttons[0] = new JButton("AC Milan");
        ButtonAction a = new ButtonAction();
        buttons[0].addActionListener(a);
        buttons[1] = new JButton("Real Madrid");
        buttons[1].addActionListener(a);
    }

        private void panelAdd(){
        int k = 0;
        JPanel[] panels = new JPanel[2];

        panels[0] = new JPanel(new FlowLayout());
        panels[0].add(buttons[0]);
        panels[0].add(buttons[1]);
        mainPanel.add(panels[0], BorderLayout.SOUTH);
        panels[1] = new JPanel();
        panels[1].setLayout(new BoxLayout(panels[1], BoxLayout.Y_AXIS));
        panels[1].add(Box.createVerticalStrut(30));
        JPanel anotherPanelsAbc = new JPanel();
        anotherPanelsAbc.setLayout(new BoxLayout(anotherPanelsAbc, BoxLayout.X_AXIS));
        anotherPanelsAbc.add(Box.createHorizontalStrut(50));
        anotherPanelsAbc.add(labels[0]);
        anotherPanelsAbc.add(Box.createHorizontalStrut(50));
        panels[1].add(anotherPanelsAbc);
        panels[1].add(Box.createVerticalStrut(30));
        JPanel anotherPanels = new JPanel();
        anotherPanels.setLayout(new BoxLayout(anotherPanels, BoxLayout.X_AXIS));
        anotherPanels.add(Box.createHorizontalStrut(20));
        anotherPanels.add(labels[1]);
        anotherPanels.add(Box.createHorizontalStrut(20));
        anotherPanels.add(labels[2]);
        anotherPanels.add(Box.createHorizontalStrut(50));
        panels[1].add(anotherPanels);
        panels[1].add(Box.createVerticalStrut(30));
        mainPanel.add(panels[1]);
        }

        private void locateWindow(){
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth())/2);
        int y = (int) ((screenSize.getHeight() - getHeight())/2);
        setResizable(false);
        setLocation(x, y);
    }

    class ButtonAction implements ActionListener{
        private int[] result = new int[2];
        private boolean flag = false, creation = false;
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!flag) {
                if (!creation){
                    creation = true;
                    result[0] = 0;
                    result[1] = 0;
                }
                if (e.getSource() == buttons[0]) {
                    result[0]++;
                    labels[0].setText("Result: " + result[0] + " X " + result[1]);
                    labels[1].setText("Last Scorer: AC Milan");
                } else {
                    result[1]++;
                    labels[0].setText("Result: " + result[0] + " X " + result[1]);
                    labels[1].setText("Last Scorer: Real Madrid");
                }
                if (result[0] == 5) {
                    flag = true;
                    labels[2].setText("Winner: AC Milan");
                    pack();
                } else if (result[1] == 5) {
                    flag = true;
                    labels[2].setText("Winner: Real Madrid");
                    pack();
                }
            }
        }
    }
}
