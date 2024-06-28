package org.alura.design;


import org.alura.dao.CoinDao;
import org.alura.dao.CoinDaoImplement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Inicio {
    public JPanel panel1;
    private JTextField tuMonedatextField;
    private JComboBox tuMonedaComboBox;
    private JComboBox convertirComboBox;
    private JButton botonCambio;
    private Double date;

    public Double getDate() {
        return date;
    }

    public void setDate(Double date) {
        this.date = date;
    }

    public Inicio() throws IOException, InterruptedException {
        botonCambio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoinDao coinDao = new CoinDaoImplement();
                String coin = (String) tuMonedaComboBox.getSelectedItem();
                String exchangeRate = (String) convertirComboBox.getSelectedItem();
                BigDecimal a;
                try {
                    a = coinDao.getExchangeRate(coin, exchangeRate);
                    System.out.println("a en Inicio: " + a);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                BigDecimal b = new BigDecimal(Double.parseDouble(tuMonedatextField.getText()));
                System.out.println("b en Inicio: " + b);
                BigDecimal result = a.multiply(b);
                result = result.setScale(2, RoundingMode.HALF_UP);
                System.out.println("result en Inicio: " + result);

                JOptionPane.showMessageDialog(null, "El resultado es: " + result);

            }
        });
    }
}
