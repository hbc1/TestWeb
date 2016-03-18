package com.hbc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hbc.service.UserService;


@Controller
@RequestMapping(value="/base")
public class BaseController {
	@Resource
	protected UserService userService;
	
	@RequestMapping(value="/send")
	public String send(String folder,String file){
		return "forward:/WEB-INF/"+folder+"/"+file+".jsp";
	}
}
