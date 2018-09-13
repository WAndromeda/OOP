import javax.swing.*;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (args.length > 0)
                    new MenuLab(args[0]).setVisible(true);
                else
                    new MenuLab().setVisible(true);
            }
        });
    }
}
