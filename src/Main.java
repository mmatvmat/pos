import Atlas.AtlasInitializer;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //wywołanie initializera, ktory tworzy glowne okno, na ktorym beda tworzone panele oraz inicjalizuje wszystkie
        //przyciski - bez tego program nie ruszy
        AtlasInitializer windowInitializer = new AtlasInitializer();
    }

}
