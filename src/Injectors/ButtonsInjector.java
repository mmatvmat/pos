package Injectors;

import Buttons.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonsInjector implements ButtonsValues
{
    private static JButton[] buttons;

    //tworzymy wszystkie przyciski - wybor poziomow, zmiana zdjec dla kazdego poziomu, opis programu, zakonczenie
    //programu, powrot do menu dla kazdego poziomu, timer dla kazdego poziomu
    public static void loadButtons() {
        buttons = new JButton[15];
        buttons[0] = new HighLevelButton(
                LEVEL_BUTTON_X_POSITION, HIGH_BUTTON_Y_POSITION, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttons[1] = new MediumLevelButton(
                LEVEL_BUTTON_X_POSITION, MEDIUM_BUTTON_Y_POSITION, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttons[2] = new LowLevelButton(
                LEVEL_BUTTON_X_POSITION, LOW_BUTTON_Y_POSITION, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttons[3] = new ChangePhotoLow(
                LEVEL_BUTTON_X_POSITION, CHANGE_BUTTON_Y, CHANGE_BUTTON_WIDTH, CHANGE_BUTTON_HEIGHT);
        buttons[4] = new ChangePhotoMedium(
                LEVEL_BUTTON_X_POSITION, CHANGE_BUTTON_Y, CHANGE_BUTTON_WIDTH, CHANGE_BUTTON_HEIGHT);
        buttons[5] = new ChangePhotoHigh(
                LEVEL_BUTTON_X_POSITION, CHANGE_BUTTON_Y, CHANGE_BUTTON_WIDTH, CHANGE_BUTTON_HEIGHT);
        buttons[6] = new READMEButton(
                README_BUTTON_X_POSITION, README_BUTTON_Y_POSITION, README_BUTTON_WIDTH, README_BUTTON_HEIGHT);
        buttons[7] = new EndButton(
                END_BUTTON_X_POSITION, END_BUTTON_Y_POSITION, END_BUTTON_WIDTH, END_BUTTON_HEIGHT);
        buttons[8] = new ReturnButtonLow(
                RETURN_BUTTON_X_POSITION, RETURN_BUTTON_Y_POSITION, RETURN_BUTTON_WIDTH, RETURN_BUTTON_HEIGHT);
        buttons[9] = new ReturnToMenuButton(
                RETURN_TO_MENU_BUTTON_X_POSITION, RETURN_TO_MENU_BUTTON_Y_POSITION, RETURN_TO_MENU_BUTTON_WIDTH, RETURN_TO_MENU_BUTTON_HEIGHT);
        buttons[10] = new LowTimerButton(
                README_BUTTON_X_POSITION, README_BUTTON_Y_POSITION, README_BUTTON_WIDTH, README_BUTTON_HEIGHT);
        buttons[11] = new MediumTimerButton(
                README_BUTTON_X_POSITION, README_BUTTON_Y_POSITION, README_BUTTON_WIDTH, README_BUTTON_HEIGHT);
        buttons[12] = new HighTimerButton(
                README_BUTTON_X_POSITION, README_BUTTON_Y_POSITION, README_BUTTON_WIDTH, README_BUTTON_HEIGHT);
        buttons[13] = new ReturnButtonMedium(
                RETURN_BUTTON_X_POSITION, RETURN_BUTTON_Y_POSITION, RETURN_BUTTON_WIDTH, RETURN_BUTTON_HEIGHT);
        buttons[14] = new ReturnButtonHigh(
                RETURN_BUTTON_X_POSITION, RETURN_BUTTON_Y_POSITION, RETURN_BUTTON_WIDTH, RETURN_BUTTON_HEIGHT);

        setButtonsCommonValues();
    }

    //ustalamy wyglad przyciskow - jest petla, bo dla czesci przyciskow ten wyglad sie powtarza
    private static void setButtonsCommonValues() {
        try {
            for( int i = 0; i < buttons.length - 9; i++)
            {
                buttons[i].setBackground(BACKGROUND_NO_ACTION_COLOR);
                buttons[i].setForeground(FOREGROUND_COLOR);
                buttons[i].setFont(LEVEL_FONT);
                setButtonHoverAction(buttons[i]);
            }
            for(int j = buttons.length - 9; j < buttons.length; j++)
            {
                buttons[j].setBackground(BACKGROUND_NO_ACTION_COLOR);
                buttons[j].setForeground(FOREGROUND_COLOR);
                buttons[j].setFont(FONT);
                setButtonHoverAction(buttons[j]);
            }

            //try catch - taka fajna sprawa, ktora probuje wywolac metode, a jesli nie wyjdzie, to wypisuje
            //nam dlaczego sie nie udalo wywolac tej metody
        } catch(NullPointerException ex) {
            System.out.println("Exception while setting button common values " + ex);
        }
    }

    //ustalenie, co sie dzieje, jak przycisniemy klawisz na myszce
    private static void setButtonHoverAction(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(BACKGROUND_MOUSE_ENTERED_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(BACKGROUND_NO_ACTION_COLOR);
            }
        });
    }

    //pobieramy wartosci wszystkich przyciskow, zeby je potem wykorzystac
    public static JButton getHighLevelButton()
    {
        return buttons[0];
    }

    public static JButton getMediumLevelButton()
    {
        return buttons[1];
    }

    public static JButton getLowLevelButton()
    {
        return buttons[2];
    }

    public static JButton getChangePhotoLow()
    {
        return buttons[3];
    }

    public static JButton getREADMEButton()
    {
        return buttons[6];
    }

    public static JButton getEndButton()
    {
        return buttons[7];
    }

    public static JButton getReturnButtonLow()
    {
        return buttons[8];
    }

    public static JButton getReturnToMenuButton()
    {
        return buttons[9];
    }

    public static JButton getLowTimerButton()
    {
        return buttons[10];
    }

    public static JButton getMediumTimerButton()
    {
        return buttons[11];
    }

    public static JButton getHighTimerButton()
    {
        return buttons[12];
    }

    public static JButton getReturnButtonMedium()
    {
        return buttons[13];
    }

    public static JButton getReturnButtonHigh()
    {
        return buttons[14];
    }
    public static JButton getChangePhotoMedium()
    {
        return buttons[4];
    }
    public static JButton getChangePhotoHigh()
    {
        return buttons[5];
    }


}
