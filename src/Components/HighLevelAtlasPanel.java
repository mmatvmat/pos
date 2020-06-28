package Components;

import Injectors.ButtonsInjector;

import javax.swing.*;
import java.awt.*;

import static Constants.Constants.backgroundColor;

public class HighLevelAtlasPanel extends JPanel
{
    //panel dla poziomu trudnego (analogiczny dla medium i low)
    public HighLevelAtlasPanel(final int WIDTH, final int HEIGHT)
    {
        //ustalamy wymiary itp dla panelu
        setSize(WIDTH, HEIGHT);
        setLocation(0,0);
        setVisible(true);
        setBackground(backgroundColor);
        addButtonsToPanel();
        validate();
        repaint();
    }

    //dodajemy przyciski - timer, zmiana zdjecia (czyli zdjecie cwiczenia), powrot do menu
    private void addButtonsToPanel() {
        try {
            add(ButtonsInjector.getChangePhotoHigh());
            add(ButtonsInjector.getReturnButtonHigh());
            add(ButtonsInjector.getHighTimerButton());


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
