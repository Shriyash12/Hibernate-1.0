/**This is first Hibernate program to save hard coded input into the product table of the database
 * 
 */
package com.shri.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shri.entity.Product;

/**
 * @author Shriyash
 * @version 1.0
 */
public class SavaObjTest {

	public static void main(String[] args) {

		// Activate Hibernate Framework.
		Configuration cfg = new Configuration();

		// Specify Hibernate filename and location.
		cfg.configure("/com/shri/config/hibernate.cfg.xml");

		// Create Hibernate Session Factory Object.
		SessionFactory factory = cfg.buildSessionFactory();

		// Create Session Object.
		Session ses = factory.openSession();

//Prepare Entity class object Having Data tobe stored.
		Product pro = new Product();
		pro.setPid(1001);
		pro.setPname("ABC");
		pro.setPrice(25.32);
		pro.setQty(2.0);
		pro.setStatus("Available");

		// Save Object
		Transaction tx = null;
		boolean flag = false;

		try {
			tx = ses.beginTransaction(); // internally calls con.setAutoCommit(false);
			ses.save(pro);
			flag = true;
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			// Perform Tx Management

			if (flag) {
				tx.commit(); // It internally calls con.commit
				System.out.println("Object Saved Successfully!");

			} else {
				tx.rollback(); // It Internally calls con.rolllback();
				System.out.println("Object Not Saved!");
			}
		} // Finally

		// Close Hibernate connections
		ses.close();
		factory.close();
	}

}

/*
 * Object Saved Successfully!
 * 
SQL> select * from product;

       PID PNAME                     PRICE        QTY STATUS
---------- -------------------- ---------- ---------- ------------------------------
      1001 ABC                       25.32          2 Available
*/
 