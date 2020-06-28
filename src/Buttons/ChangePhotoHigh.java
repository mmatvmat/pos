package Buttons;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import static Constants.Constants.IMAGE_URLS;
//change photo wszedzie tak samo
public class ChangePhotoHigh extends JButton {

    int index = 0;
    public ChangePhotoHigh(final int X_BUTTON_POSITION, final int Y_BUTTON_POSITION, final int WIDTH, final int HEIGHT)
    {
        //parametry przycisku
        setSize(WIDTH, HEIGHT);
        setLocation(X_BUTTON_POSITION, Y_BUTTON_POSITION);
        setIcon(new ImageIcon("C:\\Users\\marta\\Desktop\\wersja z komentarzami\\PoradnikPrzyszlegoKulturysty\\Obrazki\\1.png"));
        setVisible(true);
        setBorderPainted(false);
        changePhoto();
        repaint();
    }

    private void changePhoto()
    {
        //jesli klikniemy na zdjecie, to zmieni nam sie zdecie
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                ImageIcon img = new ImageIcon(IMAGE_URLS[index+1]);
                setIcon(img);
                if(index == 7)
                {
                    index = 0;
                }
                index++;
            }
        });
    }




}
