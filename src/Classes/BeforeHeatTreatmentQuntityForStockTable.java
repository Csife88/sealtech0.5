package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class BeforeHeatTreatmentQuntityForStockTable {
	
	Connection con = null;
	Statement St = null;
	ResultSet Rs = null;
	
	
	public void beferoHeatTreatment(JTable table) {

		try {

			con = DriverManager.getConnection("jdbc:mysql://database-1.c3byo1nvyfgl.eu-central-1.rds.amazonaws.com/pls", "admin", "Szemes1!");
			St = con.createStatement();
			Rs = St.executeQuery("Select ProductNumber,Quantity from pls.stock where status='" + "Gy�rtott" + "'");
			table.setModel(DbUtils.resultSetToTableModel(Rs));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
