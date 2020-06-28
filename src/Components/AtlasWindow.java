package Components;

import Injectors.ComponentsInjector;

import javax.swing.*;

public class AtlasWindow extends JFrame
{
    //nasze okno, na ktorym beda tworzone panele i przyciski i wszystko sie bedzie dzialo
    public AtlasWindow(final int WIDTH, final int HEIGHT, int X_WINDOW_POSITION, int Y_WINDOW_POSITION)
    {
        setSize(WIDTH, HEIGHT); //rozmiar
        setLocation(X_WINDOW_POSITION, Y_WINDOW_POSITION); //umiejscowienie na ekranie
        setResizable(false); //nie mozemy zmieniac rozmiaru ramki
        setUndecorated(true); //bez zadnych ozdobnikow
        requestFocusInWindow();
        setVisible(true); //widoczne
        add(ComponentsInjector.getMenuPanel()); //dodajemy pierwszy panel, czyli menu (to sie wlacza jako pierwsze)
        ComponentsInjector.getMenuPanel().repaint(); //to po prostu jest koniecznie do dzialania

    }

}
