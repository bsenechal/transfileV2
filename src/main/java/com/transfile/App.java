package com.transfile;

import java.sql.SQLException;

import com.transfile.dao.ConfigurationDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Début du batch");
        ConfigurationDao configurationDao = new ConfigurationDao();
        
        try {
			configurationDao.findAllConfigurations();
		} catch (SQLException e) {
			 System.out.println("Erreur !!!!");
			 System.out.println(e.getMessage());
		}
        System.out.println("Fin du batch");
    }
}
