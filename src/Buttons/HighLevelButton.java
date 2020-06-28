package Buttons;

import Injectors.ComponentsInjector;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static Injectors.ButtonsValues.FONT;
import static Injectors.ButtonsValues.LEVEL_BUTTON_X_POSITION;

public class HighLevelButton extends JButton {

    private static final String BUTTON_TEXT = "TRUDNY";

    //analogicznie medium i low
    public HighLevelButton(final int X_BUTTON_POSITION, final int Y_BUTTON_POSITION, final int WIDTH, final int HEIGHT)
    {
        setSize(WIDTH, HEIGHT);
        setLocation(X_BUTTON_POSITION, Y_BUTTON_POSITION);
        setText(BUTTON_TEXT);
        setVisible(true);
        setBorderPainted(false);
        changePanels();
        repaint();
    }

    private void changePanels()
    {
        //jak klikniemy, to wlacza nam sie panel z trudnym poziomem
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                startWorkout();
            }
        });
    }



    private void startWorkout()
    {
        ComponentsInjector.setHighLevelAtlasPanel();
    }

}
