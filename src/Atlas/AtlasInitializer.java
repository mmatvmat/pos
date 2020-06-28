package Atlas;

import Components.AtlasWindow;
import Injectors.ButtonsInjector;
import Injectors.ComponentsInjector;

import java.awt.*;
import java.io.IOException;

import static Constants.Constants.HEIGHT;
import static Constants.Constants.WIDTH;

public class AtlasInitializer
{
    //tu okreslamy parametry naszego okna
    private static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private static final int X_WINDOW_POSITION = (SCREEN_WIDTH - WIDTH)/2;
    private static final int Y_WINDOW_POSITION = (SCREEN_HEIGHT - HEIGHT)/2;

    private static AtlasWindow window;

    public AtlasInitializer() throws IOException {
        //ladujemy wszystkie komponenty
        loadComponents();
        //tworzymy okno
        window = new AtlasWindow(WIDTH, HEIGHT, X_WINDOW_POSITION, Y_WINDOW_POSITION);
    }

    private void loadComponents(){
        //ladujemy przyciski wszystkie
        ButtonsInjector.loadButtons();
        //inicjalizujemy nasze wszystkie komponenty - czyli panele
        ComponentsInjector.init();
    }

    //metodka, ktora nam zwraca wlasnie to okno - przyda sie, zeby nie zasmiecac kodu gdzie indziej
    //i wszystko bylo przejrzyste
    public static AtlasWindow getAtlasWindow()
    {
        return window;
    }

}
