package Components;

import Injectors.ButtonsInjector;
import Injectors.ComponentsInjector;

import javax.swing.*;
import java.awt.*;

import static Constants.Constants.backgroundColor;

public class MenuPanel extends JPanel
{
    Image img;
    //panel menu,analogicznie jak high level itp
    public MenuPanel (final int WIDTH, final int HEIGHT)
    {
        img = Toolkit.getDefaultToolkit().createImage("/Users/mmatusia/Desktop/PoradnikPrzyszlegoKulturysty/rsz_background.png");
        setSize(WIDTH, HEIGHT);
        repaint();
        setVisible(true);
        setLayout(null);
        addButtonsToPanel();
        repaint();
    }

    protected void paintComponent(Graphics gs)
    {
        Graphics2D g = (Graphics2D) gs;
        super.paintComponent(gs);
        gs.drawImage(img, 0, 0, null);
        repaint();
    }

    private void addButtonsToPanel() {
        try {
            add(ButtonsInjector.getHighLevelButton());
            add(ButtonsInjector.getLowLevelButton());
            add(ButtonsInjector.getMediumLevelButton());
            add(ButtonsInjector.getEndButton());
            add(ButtonsInjector.getREADMEButton());
        } catch(NullPointerException ex) {
            System.out.println("Exception while adding buttons " + ex);
        }
    }

}
