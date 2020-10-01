import java.io.IOException;

public class InvalidStringValueExeption extends IOException
{
    public static final String MSG_PREFIX = "Invalid String Value";

    InvalidStringValueExeption (String value, int line, int column)
    {
        super(String.format("%s \"%s\". Line: %d Column: %d", MSG_PREFIX, value, line, column));
    }
}
