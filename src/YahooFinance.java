import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

/**
 * Created by vigohe on 29-04-17.
 */
public class YahooFinance {
    public static BigDecimal getPrice(final String ticker) {

        try {
            final URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s="+ticker);

            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
            final String[] data = reader.lines().skip(1).peek(System.out::println).map(s -> s.split(",")).findFirst().get();

            return new BigDecimal(data[data.length-1]);

        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
