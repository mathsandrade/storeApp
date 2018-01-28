/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.SaleDAO;
import Data.Pool;
import Models.Sale;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class SaleService {
    
    private Connection connection;

    public SaleService() {
    }
    
    public void printReport(Date initialDate, Date endDate){
            SaleDAO saleDAO = getDao();
            
            List<Sale> sales = saleDAO.getSales(initialDate, endDate);
            System.out.println("-----------Report--------------");
            System.out.println("Store:     CreditCard:     Total:");
            for (Sale sale : sales) {
                System.out.println(format(sale));
            }       
    }
    
    public static String format(Sale sale){
        StringBuilder string = new StringBuilder();
        //string.append("Report: \nStore:");
        string.append(sale.getStore().getName());
        //string.append(" - CreditCard: ");
        string.append("      "+sale.getCreditCard().getName());
        //string.append(" - Total: ");
        string.append("             "+sale.getValue());
        return string.toString();
    }
    
    public SaleDAO getDao() {
        connection = Pool.get();
        return new SaleDAO(connection);
    }

    public void releaseDao(SaleDAO dao) {
        if (dao != null) {
            if (connection != null) {
                Pool.release(connection);
            }
            dao = null;
        }
    }
}
