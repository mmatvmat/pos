package Buttons;

import Injectors.ButtonsInjector;
import Injectors.ComponentsInjector;
//import Workout.Workout;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import static Components.Countdown.countdownTime;

public class HighTimerButton extends JButton {

    private static final String BUTTON_TEXT = "TIMER";
    //analogicznie low i medium
    public HighTimerButton(final int X_BUTTON_POSITION, final int Y_BUTTON_POSITION, final int WIDTH, final int HEIGHT)
    {
        setSize(WIDTH, HEIGHT);
        setLocation(X_BUTTON_POSITION, Y_BUTTON_POSITION);
        setText(BUTTON_TEXT);
        setVisible(true);
        setBorderPainted(false);
        setTimer();
    }

    //gdy klikniemy na przycisk timer, to wlacza nam sie odliczanie - np. dla poziomu trudnego to 180s
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