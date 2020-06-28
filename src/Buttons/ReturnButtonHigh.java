package Buttons;

import Injectors.ComponentsInjector;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReturnButtonHigh extends JButton {

    private static final String BUTTON_TEXT = "POWRÓT";

    //analogicznie low i medium
    public ReturnButtonHigh(final int X_BUTTON_POSITION, final int Y_BUTTON_POSITION, final int WIDTH, final int HEIGHT)
    {
        setSize(WIDTH, HEIGHT);
        setLocation(X_BUTTON_POSITION, Y_BUTTON_POSITION);
        setText(BUTTON_TEXT);
        setVisible(true);
        setBorderPainted(false);
        changePanels();
    }

    //po wcisnieciu wracamy do menu
    private void changePanels()
    {
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                returnToMenu();
            }
        });
    }

    private void returnToMenu()
    {
        ComponentsInjector.setMenuPanel();
    }

}
