import javax.swing.*;
import java.awt.*;
public class MainGame extends JFrame {
    public MainGame(){
        super("Game");
        getContentPane().add(new PlayShelf());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1100,800);
        setVisible(true);
        setLocationRelativeTo(null);

    }
    public static void main(String[] args){
        new MainGame();
    }
}
