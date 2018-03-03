package com.org.tradeplatform.base.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.tradeplatform.dao.impl.BaseDaoImpl;


@RestController
public class TestController {
	
	
	@RequestMapping("/test")
	public List<Object> getAllVal() {
	return null;
	}

}
