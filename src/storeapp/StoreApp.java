/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeapp;

import Services.SaleService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Matheus
 */
public class StoreApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SaleService servico = new SaleService();
        
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        Date dataInicial = new GregorianCalendar(2017, 00, 01).getTime();
        Date dataFinal = new GregorianCalendar(2017, 01, 01).getTime();
        
        servico.printReport(dataInicial, dataFinal);
    }
    
}
