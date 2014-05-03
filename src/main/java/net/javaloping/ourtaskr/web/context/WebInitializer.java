package net.javaloping.ourtaskr.web.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import net.javaloping.ourtaskr.business.context.PersistenceConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author victormiranda
 */
public class WebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext)
			throws ServletException {

		AnnotationConfigWebApplicationContext ctx =
			new AnnotationConfigWebApplicationContext();
		ctx.register(SpringConfig.class);
		ctx.register(PersistenceConfig.class);

		ctx.setServletContext(servletContext);

		Dynamic servlet = servletContext.addServlet("dispatcher",
			new DispatcherServlet(ctx));

		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}



}
