package Components;

import Injectors.ButtonsInjector;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class Countdown {

    //timerek Madrego
    public static void countdownTime(int time) throws IOException {

        //nasz plik z sygnalem dzwiekowym
        String gongFile = "C:\\Users\\marta\\Desktop\\wersja z komentarzami\\PoradnikPrzyszlegoKulturysty\\sound.au";
        //wczytywanie tego pliku do programu
        InputStream in = new FileInputStream(gongFile);
        AudioStream audioStream = new AudioStream(in);

        //tworzenie timera
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
            int i = time;

            public void run()
            {
                System.out.println(i--);
                //jesli czas timera dobiegnie konca, to ma byc slychac nasz sygnal
                if (this.i < 0)
                {
                    timer.cancel();
                    AudioPlayer.player.start(audioStream);
                }
            }
        }, 0L, 1000L);

        //jesli klikniemy przycisk zmiany zdjecia - czyli nacisniemy na zdjecie z cwiczeniem, to nasz timer sie zeruje
        //zeby go znowu wlaczyc, to musimy znowu kliknac na przycisk timer
        ButtonsInjector.getChangePhotoLow().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ButtonsInjector.getChangePhotoLow().isEnabled()) {
                    timer.cancel();
                }
            }
        });

        ButtonsInjector.getChangePhotoMedium().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ButtonsInjector.getChangePhotoMedium().isEnabled()) {
                    timer.cancel();
                }
            }
        });

        ButtonsInjector.getChangePhotoHigh().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ButtonsInjector.getChangePhotoHigh().isEnabled()) {
                    timer.cancel();
                }
            }
        });

    }

}
