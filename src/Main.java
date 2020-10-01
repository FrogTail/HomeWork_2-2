// Java 2, HomeWork 2 by FrogTail

import java.io.IOException;

public class Main
{
    private static final String DEFAULT_STRING = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    private static final String WRONG_FORMAT_STRING = "10 3 1 2 2 3 2 2\n5 6 7 1\n300 3 1 0\n";
    private static final String WRONG_VALUES_STRING = "10 3 1 2\n2 3 DDD 2\n5 6 7 1\n300 3 1 0";

    public static void main (String[] args)
    {

        String currentTry = WRONG_VALUES_STRING;
        System.out.println("Изначальная строка:\n" + currentTry);

        try
        {
            String[][] strings = stringToArray(currentTry);
            printStringArray(strings);


            int[][] ints = stringsToInts(strings);
            printIntArray(ints);
        }
        catch (IOException e)
        {
            System.out.println("\n[stringsToInts]: " +e.getMessage());
        }
    }


    // Переделываем строку в массив
    public static String[][] stringToArray (String string) throws InvalidStringFormatExeption
    {
        int sizeX = 4;
        int sizeY = 4;

        String[][] array = new String[sizeY][sizeX];

        int i=0;

        for (int y=0; y<sizeY; y++)
        {
            for (int x=0; x<sizeX; x++)
            {
                StringBuilder currentPart = new StringBuilder("");

                while (i<string.length())
                {
                    char c = string.charAt(i);
                    i++;

                    if (c == ' ')
                    {
                        if (currentPart.length() == 0)
                            throw new InvalidStringFormatExeption("Value is expected",y+1,x+1);
                        else if (x == sizeX-1)
                            throw new InvalidStringFormatExeption("End of line is expected",y+1,x+1);
                        else
                            break;
                    }
                    else if (c == '\n')
                    {
                        if (x != sizeX-1)
                            throw new InvalidStringFormatExeption("More values in line are expected",y+1,x+1);
                        else if (y == sizeY-1)
                            throw new InvalidStringFormatExeption("Nothing more is expected",y+1,x+1);
                        else
                            break;
                    }
                    else
                        currentPart.append(c);
                }

                array[y][x] = currentPart.toString();
            }
        }
        return array;
    }


    // Конверт двумерного массива строк в двумерный массив интов
    public static int[][] stringsToInts (String strings[][]) throws InvalidStringValueExeption
    {
        int[][] ints = new int[strings.length][strings[0].length];

        for (int y=0; y<strings.length; y++)
        {
            for (int x=0; x<strings[y].length; x++)
            {
                try
                {
                    ints[y][x] = Integer.parseInt(strings[y][x]);
                }
                catch (NumberFormatException e)
                {
                    throw new InvalidStringValueExeption(strings[y][x],y+1,x+1);
                }
            }
        }

        return ints;
    }


    // Функция для проверки - печатаем двумерный массив строк
    public static void printStringArray (String[][] array)
    {
        System.out.println("\nПечатаем двумерный массив строк:");

        for (int y=0; y<array.length; y++)
        {
            for (int x=0; x<array[y].length; x++)
            {
                System.out.printf("%s ", array[y][x]);
            }
            System.out.println();
        }
    }


    // Функция для проверки - печатаем двумерный массив интов
    public static void printIntArray (int[][] array)
    {
        System.out.println("\nПечатаем двумерный массив интов:");

        for (int y=0; y<array.length; y++)
        {
            for (int x=0; x<array[y].length; x++)
            {
                System.out.printf("%d ", array[y][x]);
            }
            System.out.println();
        }
    }
}
