package Buttons;

import Injectors.ComponentsInjector;
//import Workout.Workout;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import static Components.Countdown.countdownTime;

public class MediumTimerButton extends JButton {

    private static final String BUTTON_TEXT = "TIMER";

    public MediumTimerButton(final int X_BUTTON_POSITION, final int Y_BUTTON_POSITION, final int WIDTH, final int HEIGHT)
    {
        setSize(WIDTH, HEIGHT);
        setLocation(X_BUTTON_POSITION, Y_BUTTON_POSITION);
        setText(BUTTON_TEXT);
        setVisible(true);
        setBorderPainted(false);
        setTimer();
    }

    private void setTimer()
    {
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                try {
                    countdownTime(180);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
