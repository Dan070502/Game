import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cells extends JButton {
    private  int x;
    private  int y;
    public int getMyX(){
        return x;
    }
    public int getMyY(){
        return y;
    }
    public Cells(int x, int y, Color color){
        setBackground(color);
        setForeground(Color.black);
        this.x=x;
        this.y=y;
        setVisible(true);
        addActionListener(actionEvent -> {



        Cells button = (Cells) actionEvent.getSource();
        PlayShelf playShelf = (PlayShelf) button.getParent();
        if(button.getBackground() == Color.darkGray){
            return;
        }
        if(!playShelf.isClicked()){
            if(!(button.getBackground()==Color.gray)){
                 button.setText("Нажатая");

                playShelf.setClicked(true);
                playShelf.clickedButton =button;
            }
        }else{
                int buttonX = button.getmyX();
                int buttonY = button.getmyY();
                int playShelfX = playShelf.clickedButton.getMyX();
                int playShelfY = playShelf.clickedButton.getMyY();
                if(button.getBackground()==Color.gray &&((Math.abs(buttonX-playShelfX)==1 && Math.abs(buttonY-playShelfY)==0)||(Math.abs(buttonY-playShelfY)==1)&& Math.abs(buttonX-playShelfX)==0)){
                    Color temporaryColor = button.getBackground();
                    button.setBackground(playShelf.clickedButton.getBackground());
                    playShelf.clickedButton.setBackground(temporaryColor);

                    int temporaryInt = playShelf.cellsSetup[buttonX][buttonY];
                    playShelf.cellsSetup[buttonX][buttonY] = playShelf.cellsSetup[playShelfX][playShelfY];
                    playShelf.cellsSetup[playShelfX][playShelfY]=temporaryInt;

                    playShelf.clickedButton.setText("");
                    playShelf.setClicked(false);
                    playShelf.checkForWin();
                }
                if(buttonX ==playShelfX && buttonY==playShelfY) {
                    playShelf.clickedButton.setText("");
                    playShelf.setClicked(false);
                }
                }
            });

    }

    private int getmyY() {
        return y;
    }

    private int getmyX() {

        return x;
    }


}

