package Buttons;

import Injectors.ComponentsInjector;
//import Workout.Workout;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EndButton extends JButton {

    private static final String BUTTON_TEXT = "ZAKOŃCZ";

    public EndButton(final int X_BUTTON_POSITION, final int Y_BUTTON_POSITION, final int WIDTH, final int HEIGHT)
    {
        setSize(WIDTH, HEIGHT);
        setLocation(X_BUTTON_POSITION, Y_BUTTON_POSITION);
        setText(BUTTON_TEXT);
        setVisible(true);
        setBorderPainted(false);
        changePanels();
    }

    private void changePanels()
    {
        //jesli go klikniemy, to zakonczymy program
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                endWorkout();
            }
        });
    }

    private void endWorkout()
    {
        System.exit(0);

    }

}
