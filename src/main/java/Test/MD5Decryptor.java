package Test;

import data.dao.Database;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import utils.API;
import data.driver.driver;
import data.driver.tidb;
public class MD5Decryptor {

    public static String formatUSD(double tien) {       
        BigDecimal amount = new BigDecimal(String.valueOf(tien));
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        return nf.format(amount);
    }
    

    public static void main(String[] args) {
        Database.getuser().Insert("ctducwebsite", "ctducwebsite@gmail.com", "0000000000", API.getMd5("123456"), "guest");
    }
}
