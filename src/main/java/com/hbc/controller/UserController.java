package com.hbc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbc.model.User;

@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController {
	@Resource
	private HttpSession session;
	
	@RequestMapping(value="/login")
	public String login(User user){
		// 判断登陆是否成功
		System.out.println(user);
		user = userService.login(user);
		System.out.println("xxxxxxxxxxxxx");
		if(user!=null){
			session.setAttribute("user", user);
			String goURL = (String) session.getAttribute("goURL");
			if(goURL!=null){
				return "redirect:"+goURL;
			}else{
				return "redirect:/index.jsp";
			}
		}else{
			session.setAttribute("UserError", "登陆失败！");
			return "redirect:/ulogin.jsp";
		}
	}
	
	@RequestMapping(value="register")
	public String register(User user){
		System.out.println("register");
		System.out.println(user);
		userService.save(user);
		return "redirect:/ulogin.jsp";
	}
	
	@RequestMapping(value="/checkUser")
	@ResponseBody
	public boolean checkUser(String useLogin){
		return  userService.checkUser(useLogin);
		
	}
	
	@RequestMapping(value="/loginOut")
	public String loginOut(){
		System.out.println("login out ");
		session.removeAttribute("user");
		session.removeAttribute("userError");
		return "redirect:/ulogin.jsp";
	}
}
