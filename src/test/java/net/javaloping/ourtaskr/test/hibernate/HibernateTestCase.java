package net.javaloping.ourtaskr.test.hibernate;

import net.javaloping.ourtaskr.business.model.Category;
import net.javaloping.ourtaskr.business.model.Dashboard;
import net.javaloping.ourtaskr.business.model.Status;
import net.javaloping.ourtaskr.business.model.Ticket;
import net.javaloping.ourtaskr.business.model.TicketComment;
import net.javaloping.ourtaskr.business.model.User;
import net.javaloping.ourtaskr.business.model.UserPreferences;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * @author victormiranda
 */

public class HibernateTestCase {

	private SessionFactory sessionFactory;
	private Session session = null;
	private Transaction tx = null;

	@Before
	public void setUp() {
		Configuration configuration = new Configuration();

		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Dashboard.class);
		configuration.addAnnotatedClass(Status.class);
		configuration.addAnnotatedClass(Category.class);
		configuration.addAnnotatedClass(UserPreferences.class);
		configuration.addAnnotatedClass(Ticket.class);
		configuration.addAnnotatedClass(TicketComment.class);

		Properties props = new Properties();

		props.put("hibernate.dialect",
			"org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.connection.driver_class",
			"com.mysql.jdbc.Driver");
		props.put("hibernate.connection.username", "root");
		props.put("hibernate.connection.password", "paco");
		props.put("hibernate.show_sql", "false");
		props.put("hibernate.connection.url",
			"jdbc:mysql://localhost/hibernate_tests");
		props.put("hibernate.hbm2ddl.import_files_sql_extractor",
			"org.hibernate.tool.hbm2ddl.MultipleLinesSqlCommandExtractor");
		props.put("hibernate.hbm2ddl.auto", "create");

		configuration.setProperties(props);

		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
	}

	@Test
	public void testFetchUser() {
		User u = (User) session.get(User.class,Long.valueOf(1l));
		Assert.assertTrue("victor".equals(u.getName()));
	}

	@Test
	public void testFetchDashboard() {
		Dashboard d = (Dashboard) session.get(Dashboard.class,Long.valueOf(1l));
		Assert.assertTrue("My dash".equals(d.getName()));
	}

	@Test
	public void testGetTicketsByDashboard() {
		Dashboard d = (Dashboard) session.get(Dashboard.class,Long.valueOf(1l));
		Set<Ticket> tickets = d.getTickets();
		Assert.assertTrue(tickets.size() >= 1);
	}

	@Test
	public void testGetStatusesByDashboard() {
		Dashboard d = (Dashboard) session.get(Dashboard.class,Long.valueOf(1l));

		Assert.assertTrue(d.getStatuses().size() == 4);
	}

	@Test
	public void testGetDashboardsByUser() {
		User u = (User) session.get(User.class,Long.valueOf(1l));
		Set<Dashboard> dashboardsUser = u.getDashboards();
		Assert.assertTrue(dashboardsUser.size() == 1);
	}

	@After
	public void after() {
		tx.commit();
		session.close();
		sessionFactory.close();
	}

}
