

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static javax.swing.text.StyleConstants.setIcon;

public class PlayShelf extends JPanel {

    private boolean clicked = false;

    public Cells clickedButton = new Cells(-1,-1, Color.black);

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
    private static final int N = 5;
    private List<Integer> set = new ArrayList<>(Arrays.asList(0,0,0,0,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4));

    private List<Integer> headersSet = new ArrayList<>(Arrays.asList(2,3,4));
    private int[] headersSetup = new int[N];
    public int[][] cellsSetup = new int[N][N];
    List<Color> colorList = new ArrayList<>(Arrays.asList(Color.gray, Color.darkGray, Color.pink.darker(), Color.orange.darker(), Color.cyan.darker() ));
    public PlayShelf() {//для распределения кнопок ввиде сетки
        Random random = new Random();
        setLayout(new GridLayout(N+1, N));//аспределяет кнопки по всему полю 6 на 5 так как заголовок

        for(int i = 0; i < N; i++) {//заголовок
            if(i % 2 == 1) {

                add(new HeadColor(Color.white));
            } else {
                int r = random.nextInt(headersSet.size());
                int rset = headersSet.get(r);
                add(new HeadColor(colorList.get(rset)));

                headersSetup[i] = rset;
                headersSet.remove(r);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(j % 2 == 1 && i % 2 == 0) {
                    add(new Cells(i, j, Color.darkGray));
                    cellsSetup[i][j] = 1;
                } else {
                    int randint = random.nextInt(set.size());
                    int rset = set.get(randint);
                    Color color = colorList.get(rset);
                    add(new Cells(i, j, color));
                    cellsSetup[i][j] = rset;
                    set.remove(randint);
                }
            }
        }

        setVisible(true);
    }

    public void checkForWin() {
        boolean win = true;
        for (int i = 0; i < N; i+=2) {
            for(int j = 0; j < N; j++) {
                win = win && headersSetup[i] == cellsSetup[j][i];
            }
        }
        if (win) {
            try {
                JFrame winFrame = new JFrame("ПОБЕДА!!!");
                BufferedImage image = ImageIO.read(new File("победа.png"));
                Image scaledImage = image.getScaledInstance(1100, 900, Image.SCALE_DEFAULT);
                Icon icon = new ImageIcon(scaledImage);
                JLabel winLabel = new JLabel(icon);
                winFrame.add(winLabel);
                winFrame.setVisible(true);
                winFrame.setSize(800,600);
                winFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                winFrame.setLocationRelativeTo(null);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

}
