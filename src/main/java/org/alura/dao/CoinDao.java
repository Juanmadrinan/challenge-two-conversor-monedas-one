package org.alura.dao;

import java.io.IOException;

public interface CoinDao {
    Double getExchangeRate(String baseCoin) throws IOException, InterruptedException;
}

