package demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * @author http://www.wenboxz.com
 *
 */
public class MyServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("----------------�Ự����---------------------");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("-----------------�Ự����------------------");
	}

}
