package org.alura.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface CoinDao {
    BigDecimal getExchangeRate(String baseCoin, String exchangeCoin) throws IOException, InterruptedException;
}

