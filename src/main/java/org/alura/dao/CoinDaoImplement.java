package org.alura.dao;

import com.google.gson.Gson;
import org.alura.models.ExchangeRateModel;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CoinDaoImplement implements CoinDao {
    private static final String URL = "https://v6.exchangerate-api.com/v6/4b48a13bb3b863e8af0a9c04/latest/USD";
    private static final String APIKEY = "4b48a13bb3b863e8af0a9c04";

    @Override
    public Double getExchangeRate(String baseCoin) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new Gson();
        ExchangeRateModel monedaBase = gson.fromJson(json, ExchangeRateModel.class);

        return monedaBase.getConversionRates().get(baseCoin);
    }
}
