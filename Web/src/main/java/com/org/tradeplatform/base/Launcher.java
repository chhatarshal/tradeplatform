package com.org.tradeplatform.base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.org.tradeplatform.conf.Context;
import com.org.tradeplatform.dao.BaseDao;
import com.org.tradeplatform.model.Entry;

@SpringBootApplication
@ComponentScan("com.org.tradeplatform.dao")
@EntityScan("com.org.tradeplatform.model")
@ComponentScan("com.org.tradeplatform.conf")
public class Launcher  extends SpringBootServletInitializer implements CommandLineRunner{
	
		@Autowired
		private BaseDao baseDao;
	
	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder  application) {
	        return application.sources(Launcher.class);
	    }

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Launcher.class, args);
	}

	
	@Override
	public void run(String... arg0) throws Exception {
		Context.putObject("baseDao", baseDao);
	}
	
	public  BaseDao getBaseDao() {
		return baseDao;
	}


}
