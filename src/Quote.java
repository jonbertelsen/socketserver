import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quote
{
    private static List<String> quotes;
    private static Random rnd = new Random();

    public Quote()
    {
        if (quotes == null)
        {
            quotes = new ArrayList<>();
            quotes.add("The greatest glory in living lies not in never falling, but in rising every time we fall. -Nelson Mandela");
            quotes.add("The way to get started is to quit talking and begin doing. -Walt Disney");
            quotes.add("Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking. -Steve Jobs");
            quotes.add("If life were predictable it would cease to be life, and be without flavor. -Eleanor Roosevelt");
            quotes.add("If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough. -Oprah Winfrey");
            quotes.add("If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success. -James Cameron");
            quotes.add("Life is what happens when you're busy making other plans. -John Lennon");
            quotes.add("Spread love everywhere you go. Let no one ever come to you without leaving happier. -Mother Teresa");
            quotes.add("Always remember that you are absolutely unique. Just like everyone else. -Margaret Mead");
            quotes.add("Tell me and I forget. Teach me and I remember. Involve me and I learn. -Benjamin Franklin");
        }
    }

    public String getQuote()
    {
        return quotes.get(rnd.nextInt(10));
    }
}
