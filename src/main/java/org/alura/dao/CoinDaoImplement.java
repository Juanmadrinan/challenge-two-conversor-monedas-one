package org.alura.dao;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.alura.models.ExchangeRateModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class CoinDaoImplement implements CoinDao {
    private static final String APIKEY = "4b48a13bb3b863e8af0a9c04";

    @Override
    public BigDecimal getExchangeRate(String baseCoin, String exchangeCoin) throws IOException, InterruptedException {
        String URL = "https://v6.exchangerate-api.com/v6/"+APIKEY+"/latest/"+baseCoin;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println("json: " + json);

        Gson gson = new Gson();
        ExchangeRateModel monedaBase = gson.fromJson(json, ExchangeRateModel.class);
        System.out.println("monedaBase: " + monedaBase);

        /*List<Double> array = new ArrayList<>();*/

        /*array.add(monedaBase.getConversionRates().get(baseCoin));*/
        /*System.out.println("array: " + array.get(0).getClass().getSimpleName());*/

        //Paso la Clave de la moneda -> "USD" y me devuelve el valor de la moneda en USD
        BigDecimal conversion = new BigDecimal(monedaBase.getConversionRates().get(exchangeCoin));
        System.out.println("Double: " + conversion);

        return conversion;
    }
}
