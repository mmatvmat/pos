package Components;

import Injectors.ButtonsInjector;

import javax.swing.*;
import java.awt.*;

import static Constants.Constants.backgroundColor;

public class MediumLevelAtlasPanel extends JPanel
{
    public MediumLevelAtlasPanel (final int WIDTH, final int HEIGHT)
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
            add(ButtonsInjector.getChangePhotoMedium());
            add(ButtonsInjector.getReturnButtonMedium());
            add(ButtonsInjector.getMediumTimerButton());

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
