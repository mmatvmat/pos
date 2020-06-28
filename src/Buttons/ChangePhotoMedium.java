package Buttons;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import static Components.Countdown.countdownTime;
import static Constants.Constants.IMAGE_URLS;

public class ChangePhotoMedium extends JButton {

    int index = 0;
    public ChangePhotoMedium(final int X_BUTTON_POSITION, final int Y_BUTTON_POSITION, final int WIDTH, final int HEIGHT)
    {
        setSize(WIDTH, HEIGHT);
        setLocation(X_BUTTON_POSITION, Y_BUTTON_POSITION);
        setIcon(new ImageIcon("C:\\Users\\marta\\Desktop\\wersja z komentarzami\\PoradnikPrzyszlegoKulturysty\\Obrazki\\1.png"));
        setVisible(true);
        setBorderPainted(false);
        changePhoto();
    }

    private void changePhoto()
    {
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
