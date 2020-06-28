package Components;

import Injectors.ButtonsInjector;

import javax.swing.*;
import java.awt.*;


public class READMEPanel extends JPanel
{
    Image img;
    public READMEPanel (final int WIDTH, final int HEIGHT)
    {
        img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\marta\\Desktop\\wersja z komentarzami\\PoradnikPrzyszlegoKulturysty\\opis2.png");
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
            add(ButtonsInjector.getReturnToMenuButton());
        } catch(NullPointerException ex) {
            System.out.println("Exception while adding buttons " + ex);
        }
    }

}
