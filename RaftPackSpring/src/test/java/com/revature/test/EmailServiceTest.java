package com.revature.test;
import static org.junit.Assert.assertNotNull;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.revature.service.EmailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
public class EmailServiceTest {

	
	
		private static final Logger log = LoggerFactory.getLogger(EmailService.class);
		@Autowired
		EmailService email;
		@Test
		public void testEmail() throws InterruptedException{
		log.debug("Testing Email...");
		assertNotNull(email);
		long start = new Date().getTime();
		email.send("user@gmail.com", "user@gmail.com", "New Document Add",
		"A new document was added to the collection.");
		long end = new Date().getTime();
		long time = (end - start)/1000;
		log.debug("Sending email done. Took: " + time + " seconds.");
		}
	}


