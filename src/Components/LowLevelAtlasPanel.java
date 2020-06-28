package Components;

import Injectors.ButtonsInjector;

import javax.swing.*;
import java.awt.*;

import static Constants.Constants.backgroundColor;
import static Injectors.ButtonsValues.FONT;

public class LowLevelAtlasPanel extends JPanel
{
    public LowLevelAtlasPanel (final int WIDTH, final int HEIGHT)
    {
        setSize(WIDTH, HEIGHT);
        setLocation(0,0);
        setVisible(true);
        setBackground(backgroundColor);
        addButtonsToPanel();
        validate();
        repaint();
    }

    private void addButtonsToPanel() {
        try {
            add(ButtonsInjector.getChangePhotoLow());
            add(ButtonsInjector.getReturnButtonLow());
            add(ButtonsInjector.getLowTimerButton());

        } catch(NullPointerException ex) {
            System.out.println("Exception while adding buttons " + ex);
        }
    }

    protected void paintComponent(Graphics gs)
    {
        Graphics2D g = (Graphics2D) gs;
        super.paintComponent(gs);
        repaint();
    }




}
