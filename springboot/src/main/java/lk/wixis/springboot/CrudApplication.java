package lk.wixis.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;



@SpringBootApplication
public class CrudApplication  {
	//implement CommandLineRunner
	private static final Logger log = LoggerFactory.getLogger(CrudApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	@Override
//	public void run(String... args) throws Exception {
//		log.info("Create Tables");
//
//		jdbcTemplate.execute("DROP TABLE user IF EXISTS");
//		jdbcTemplate.execute("CREATE TABLE user(" +
//				" VARCHAR (10), name VARCHAR(30),address VARCHAR(25),password VARCHAR(10))");
//
//	}
}
