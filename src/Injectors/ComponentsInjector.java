package Injectors;

import Atlas.AtlasInitializer;
import Components.*;

public class ComponentsInjector
{
    //okreslamy wymiary naszych paneli
    private static int PANELS_WIDTH = 1024;
    private static int PANELS_HEIGHT = 768;
    private static MenuPanel menuPanel;
    private static HighLevelAtlasPanel highLevelAtlasPanel;
    private static LowLevelAtlasPanel lowLevelAtlasPanel;
    private static MediumLevelAtlasPanel mediumLevelatlasPanel;
    private static READMEPanel readmePanel;

    public static void init()
    {
        //tworzymy kazdy z paneli
        menuPanel = new MenuPanel(PANELS_WIDTH, PANELS_HEIGHT);
        highLevelAtlasPanel = new HighLevelAtlasPanel(PANELS_WIDTH, PANELS_HEIGHT);
        lowLevelAtlasPanel = new LowLevelAtlasPanel(PANELS_WIDTH, PANELS_HEIGHT);
        mediumLevelatlasPanel = new MediumLevelAtlasPanel(PANELS_WIDTH, PANELS_HEIGHT);
        readmePanel = new READMEPanel(PANELS_WIDTH, PANELS_HEIGHT);
    }

    //wszystkie sety - po prostu tworzy sie tu dany panel - dodaje sie go do okna, na ktorym ma to byc
    //wyswietlane
    public static void setHighLevelAtlasPanel()
    {
        try
        {
            AtlasInitializer.getAtlasWindow().getContentPane().removeAll();
            AtlasInitializer.getAtlasWindow().add(highLevelAtlasPanel);
            AtlasInitializer.getAtlasWindow().repaint();
        }
        catch (Exception ex)
        {
            System.out.println("Error while adding main panel " + ex);
        }
    }

    public static void setLowLevelAtlasPanel()
    {
        try
        {
            AtlasInitializer.getAtlasWindow().getContentPane().removeAll();
            AtlasInitializer.getAtlasWindow().add(lowLevelAtlasPanel);
            AtlasInitializer.getAtlasWindow().repaint();
        }
        catch (Exception ex)
        {
            System.out.println("Error while adding main panel " + ex);
        }
    }

    public static void setMediumLevelAtlasPanel()
    {
        try
        {
            AtlasInitializer.getAtlasWindow().getContentPane().removeAll();
            AtlasInitializer.getAtlasWindow().add(mediumLevelatlasPanel);
            AtlasInitializer.getAtlasWindow().repaint();
        }
        catch (Exception ex)
        {
            System.out.println("Error while adding main panel " + ex);
        }
    }

    public static void setMenuPanel()
    {
        try
        {
            AtlasInitializer.getAtlasWindow().getContentPane().removeAll();
            AtlasInitializer.getAtlasWindow().add(menuPanel);
            AtlasInitializer.getAtlasWindow().repaint();
        }
        catch (Exception ex)
        {
            System.out.println("Error while adding menu panel " + ex);
        }
    }

    public static void setREADMEPanel()
    {
        try
        {
            AtlasInitializer.getAtlasWindow().getContentPane().removeAll();
            AtlasInitializer.getAtlasWindow().add(readmePanel);
            AtlasInitializer.getAtlasWindow().repaint();
        }
        catch (Exception ex)
        {
            System.out.println("Error while adding menu panel " + ex);
        }
    }

    public static HighLevelAtlasPanel getHighLevelAtlasPanel()
    {
        return highLevelAtlasPanel;
    }

    public static LowLevelAtlasPanel getLowLevelAtlasPanel()
    {
        return lowLevelAtlasPanel;
    }

    public static MediumLevelAtlasPanel getMediumLevelatlasPanel()
    {
        return mediumLevelatlasPanel;
    }

    public static MenuPanel getMenuPanel()
    {
        return menuPanel;
    }

}
