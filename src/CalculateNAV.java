import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Created by vigohe on 29-04-17.
 */
public class CalculateNAV {

    private Function<String, BigDecimal> priceFinder;

    public BigDecimal computeStockWorth(final String ticker, final int shares){
        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }

    public CalculateNAV(final Function<String,BigDecimal> aPriceFinder) {
        this.priceFinder = aPriceFinder;
    }

    public static void main(String[] args) {
        final CalculateNAV calculateNAV = new CalculateNAV(YahooFinance::getPrice);

        System.out.println(String.format("100 shares of Google worth: $%.2f", calculateNAV.computeStockWorth("GOOG",100)));


    }



}
