package org.alura.design;


import org.alura.dao.CoinDao;
import org.alura.dao.CoinDaoImplement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Inicio {
    public JPanel panel1;
    private JTextField tuMonedatextField;
    private JComboBox tuMonedaComboBox;
    private JComboBox convertirComboBox;
    private JButton buttonExchange;
    private Double date;

    public Double getDate() {
        return date;
    }

    public void setDate(Double date) {
        this.date = date;
    }

    public Inicio() throws IOException, InterruptedException {
        CoinDao coinDao = new CoinDaoImplement();
        String coin = (String) tuMonedaComboBox.getSelectedItem();
        String exchangeRate = (String) convertirComboBox.getSelectedItem();

        Double a = coinDao.getExchangeRate(coin);
        System.out.println("a: " + a);
        Double b = coinDao.getExchangeRate(exchangeRate);
        System.out.println("b: " + b);

        buttonExchange.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Double dato = Double.parseDouble(tuMonedatextField.getText());
                double result = (a * dato) * b;

                try {
                    Result dialog = new Result(result);
                    dialog.pack();
                    dialog.setVisible(true);
                    System.exit(0);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
