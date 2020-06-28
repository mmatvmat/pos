package Injectors;

import java.awt.*;

//tak samo jak w constants - zeby nie popelnic zadnego bledu i zeby kod byl czytelniejszy, tu wrzucamy wartosci
public interface ButtonsValues {
    Color BACKGROUND_NO_ACTION_COLOR = new Color(0, 0 ,0);
    Color BACKGROUND_MOUSE_ENTERED_COLOR = new Color(51, 51 ,51);
    Color FOREGROUND_COLOR = new Color(255, 255, 255);
    Font LEVEL_FONT = new Font("Italic", Font.BOLD, 30);
    Font FONT = new Font("Italic", Font.BOLD, 20);
    int BUTTON_WIDTH = 600;
    int BUTTON_HEIGHT = 300;
    int LEVEL_BUTTON_X_POSITION = 200;
    int LOW_BUTTON_Y_POSITION = 250;
    int MEDIUM_BUTTON_Y_POSITION = 350;
    int HIGH_BUTTON_Y_POSITION = 450;
    int RETURN_BUTTON_Y_POSITION = 20;
    int RETURN_BUTTON_X_POSITION = -5;
    int RETURN_BUTTON_WIDTH = 200;
    int RETURN_BUTTON_HEIGHT = 70;
    int CHANGE_BUTTON_Y = 100;
    int CHANGE_BUTTON_WIDTH = 600;
    int CHANGE_BUTTON_HEIGHT = 600;
    int END_BUTTON_Y_POSITION = 20;
    int END_BUTTON_X_POSITION = 0;
    int END_BUTTON_WIDTH = 150;
    int END_BUTTON_HEIGHT = 50;
    int README_BUTTON_Y_POSITION = 20;
    int README_BUTTON_X_POSITION = 890;
    int README_BUTTON_WIDTH = 150;
    int README_BUTTON_HEIGHT = 50;
    int RETURN_TO_MENU_BUTTON_Y_POSITION = 20;
    int RETURN_TO_MENU_BUTTON_X_POSITION = -5;
    int RETURN_TO_MENU_BUTTON_WIDTH = 200;
    int RETURN_TO_MENU_BUTTON_HEIGHT = 70;

}
