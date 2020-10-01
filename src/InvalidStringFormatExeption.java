import java.io.IOException;

public class InvalidStringFormatExeption extends IOException
{
    public static final String MSG_PREFIX = "Invalid String Value";

    InvalidStringFormatExeption (String msg, int line, int column)
    {
        super(String.format("%s. %s. Line: %d Column: %d", MSG_PREFIX, msg, line, column));
    }
}
