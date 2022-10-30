import javax.swing.*;
import java.awt.*;

import static javax.swing.text.StyleConstants.setIcon;

public class HeadColor extends JPanel {
    public HeadColor(Color color) {
        setBackground(color);
        setBorder(BorderFactory.createMatteBorder(0, 0, 10, 0, Color.white));
        setVisible(true);
    }
}

