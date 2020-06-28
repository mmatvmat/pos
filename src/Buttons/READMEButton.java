package Buttons;

import Injectors.ComponentsInjector;
//import Workout.Workout;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class READMEButton extends JButton {

    private static final String BUTTON_TEXT = "OPIS";

    public READMEButton(final int X_BUTTON_POSITION, final int Y_BUTTON_POSITION, final int WIDTH, final int HEIGHT)
    {
        setSize(WIDTH, HEIGHT);
        setLocation(X_BUTTON_POSITION, Y_BUTTON_POSITION);
        setText(BUTTON_TEXT);
        setVisible(true);
        setBorderPainted(false);
        changePanels();
    }

    //po kliknieciu tego przycisku wlacza nam sie panel, gdzie jest opis, jak wykonywac cwiczenia
    private void changePanels()
    {
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                READMEWorkout();
            }
        });
    }

    private void READMEWorkout()
    {
        ComponentsInjector.setREADMEPanel();

    }

}
