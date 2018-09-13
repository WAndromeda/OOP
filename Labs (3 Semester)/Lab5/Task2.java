import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task2 extends JFrame {
    private String pathStr;
    private JPanel mainPanel;
    private JButton exit;
    private MyJPanel myJPanel;

    Task2(String pathStr){
        super("Задание 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pathStr = pathStr;
        creationButton();
        myJPanel = new MyJPanel();
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(exit, BorderLayout.SOUTH);

        mainPanel.add(myJPanel);
        setContentPane(mainPanel);
        locateWindow();
        addWindowListener(new MyActionClose());
    }

    private void locateWindow(){
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth())/2);
        int y = (int) ((screenSize.getHeight() - getHeight())/2);
        if (myJPanel.isFlag())
            setResizable(true);
        else
            setResizable(false);
        setLocation(x, y);
    }

    private void creationButton(){
        exit = new JButton("Вернуться в главное меню");
        exit.setFocusPainted(false);
        exit.addActionListener(new ExitAction());
    }

    class MyJPanel extends JPanel {
        private JMenu menu;
        private JMenuBar menuBar;
        private JMenuItem menuItem;
        private BufferedImage image;
        private JLabel label;
        private boolean flag = true, flagLabel = false;

        MyJPanel() {
            creatingMenu();
            setLayout(new BorderLayout());
            add(menuBar, BorderLayout.NORTH);
            setBorder(BorderFactory.createLineBorder(Color.black));
            File file = new File(pathStr);
            if (!file.exists()){
                flag = false;
                flagLabel = true;
                label = new JLabel("<html>Картинка потерялась, но не волнуйтесь,<br> мы уже отправились на её поиски</html>");
                label.setFont(new Font("Times New Roman", Font.PLAIN, 30));
                add(label);
                JOptionPane.showMessageDialog(this, "Был указан неверный адрес к изображению",
                        "Ошибка пути файла", JOptionPane.WARNING_MESSAGE);
            }else {
                try {
                    image = ImageIO.read(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void setBufferedImage(BufferedImage bufferedImage) {
            this.image = bufferedImage;
            flag = true;
            setPreferredSize(getPreferredSize());
            repaint();
            if (flagLabel){
                remove(label);
                flagLabel = false;
            }
        }

        private void creatingMenu(){
            menuItem = new JMenuItem("Выберите изображение");
            menuItem.addActionListener(new ChooseImage());
            menu = new JMenu("Выбор файла");
            menu.add(menuItem);
            menuBar = new JMenuBar();
            menuBar.add(menu);
        }

        public boolean isFlag() {
            return flag;
        }

        @Override
        public Dimension getPreferredSize() {
            if (flag)
                return new Dimension(image.getWidth(), image.getHeight() + menuBar.getHeight()+5);
            else
                return super.getPreferredSize();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (flag)
                g.drawImage(image.getScaledInstance(image.getWidth(), image.getHeight(), 0),
                        (getWidth() - image.getWidth())/2, (getHeight() - image.getHeight() + menuBar.getHeight())/2+1, this);
        }
    }

    class MyActionClose extends WindowAdapter {
        @Override
        public void windowClosed(WindowEvent e) {
            new MenuLab(pathStr).setVisible(true);
        }
    }

    class ExitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    class ChooseImage implements ActionListener{
        JFileChooser fileChooser = new JFileChooser();
        @Override
        public void actionPerformed(ActionEvent e) {
            BufferedImage image;
            int k = fileChooser.showDialog(null, "Выберите изображение");
            if (k == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (file.exists()) {
                    try {
                        image = ImageIO.read(file);
                        myJPanel.setBufferedImage(image);
                        locateWindow();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else
                    JOptionPane.showMessageDialog(null, "Был указан неверный адрес к изображению", "Ошибка пути файла", JOptionPane.WARNING_MESSAGE);
            }        }
    }
}
