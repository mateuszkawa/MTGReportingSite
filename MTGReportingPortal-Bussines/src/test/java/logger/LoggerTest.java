package logger;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class LoggerTest {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(LoggingProducer.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Inject
    private Logger log;
	
	@Test
	public void notNullInjection() {
		assertNotNull(log);
	}

}
