package com.jspiders.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.dto.UserDTO;
import com.jspiders.springmvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/home")
	protected String getHomePage(HttpSession httpSession) {
		UserDTO authenticatedUser = (UserDTO) httpSession.getAttribute("authenticatedUser");
		if (authenticatedUser != null)
			return "home";
		else
			return "login";
	}

	@RequestMapping(path = "/sign-up-page")
	protected String getSignUpPage() {
		return "sign_up";
	}

	@RequestMapping(path = "/add-user", method = RequestMethod.POST)
	protected String addUser(@RequestParam(name = "username") String name, @RequestParam(name = "email") String email,
			@RequestParam(name = "mobile") long mobile, @RequestParam(name = "password") String password,
			ModelMap modelMap) {
		boolean userAdded = userService.addUser(name, email, mobile, password);
		if (userAdded) {
			modelMap.addAttribute("message", "User added");
			return "login";
		} else {
			modelMap.addAttribute("message", "Something went wrong");
			return "sign_up";
		}
	}

	@RequestMapping(path = "/login-page")
	protected String getLoginPage() {
		return "login";
	}

	@RequestMapping(path = "/auth-user", method = RequestMethod.POST)
	protected String authUser(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, ModelMap modelMap, HttpSession httpSession) {
		UserDTO authenticatedUser = userService.authUser(email, password);
		if (authenticatedUser != null) {
			httpSession.setAttribute("authenticatedUser", authenticatedUser);
			httpSession.setMaxInactiveInterval(30 * 24 * 60 * 60);
			return "home";
		} else {
			modelMap.addAttribute("message", "Invalid email or password");
			return "login";
		}
	}

	@RequestMapping(path = "/logout")
	protected String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "login";
	}
	
	@RequestMapping(path = "/edit-user")
	protected String editUser(@RequestParam(name = "id") int id, ModelMap modelMap, HttpSession httpSession) {
	    UserDTO authenticatedUser = (UserDTO) httpSession.getAttribute("authenticatedUser");
	    if (authenticatedUser != null) {
	        UserDTO user = userService.findUserById(id);
	        modelMap.addAttribute("user", user);
	        return "edit_user";
	    } else {
	        return "login";
	    }
	}

	@RequestMapping(path = "/update-user", method = RequestMethod.POST)
	protected String updateUser(@RequestParam(name = "id") int id,
	                            @RequestParam(name = "username") String username,
	                            @RequestParam(name = "email") String email,
	                            @RequestParam(name = "mobile") long mobile,
	                            @RequestParam(name = "password") String password,
	                            ModelMap modelMap) {
	    boolean userUpdated = userService.updateUser(id, username, email, mobile, password);
	    if (userUpdated) {
	        modelMap.addAttribute("message", "User updated successfully.");
	    } else {
	        modelMap.addAttribute("message", "Error updating user.");
	    }
	    return "home";
	}

	@RequestMapping(path = "/delete-user")
	protected String deleteUser(@RequestParam(name = "id") int id, ModelMap modelMap, HttpSession httpSession) {
	    UserDTO authenticatedUser = (UserDTO) httpSession.getAttribute("authenticatedUser");
	    if (authenticatedUser != null) {
	        boolean userDeleted = userService.deleteUser(id);
	        if (userDeleted) {
	            modelMap.addAttribute("message", "User deleted successfully.");
	        } else {
	            modelMap.addAttribute("message", "Error deleting user.");
	        }
	        return "home";
	    } else {
	        return "login";
	    }
	}


}