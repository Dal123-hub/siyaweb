package com.broadinfo.controller;


import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.broadinfo.BusinessUtils.FuctionsClass;
import com.broadinfo.BusinessUtils.VerifyRecaptcha;
import com.broadinfo.controller.dto.UserInfoDto;
import com.broadinfo.service.UserService;
import com.broadinfo.usermodel.UserInfo;
import com.broadinfo.userrepo.UserRepo;

@Controller
public class AdminController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserService userService;

	@Autowired
	FuctionsClass fcall;

	@GetMapping("/admin")
	public String getAdmin(Model model) {

		model.addAttribute("userInfo", new UserInfo());
		return "login";
	}

	@GetMapping("/menu")
	public String  getpage() {

		return "menupage";
	}
	@GetMapping("/register")
	public String  getUserReg(Model model) {

		model.addAttribute("user", new UserInfo());
		return "userregister";
	}

	@PostMapping("/menupage")
	public String getMenuPage(@Valid @ModelAttribute("userInfo")  UserInfoDto user, BindingResult result ,
			 HttpSession session,@RequestParam("g-recaptcha-response") String gcode, Model model) throws IOException {

		if(result.hasErrors()) {

			model.addAttribute("userInfo", user);
			return "login";
		}

		if(VerifyRecaptcha.verify(gcode)) {

		UserInfo u = userService.searchUser(user.getUname(), user.getUpass());

		if(u != null) {
			session.setAttribute("activeUser", user.getUname());
			session.setMaxInactiveInterval(3000);
			return "redirect:/menu";
		}else {

			model.addAttribute("message", "User not found");

		 }
		}else {

			model.addAttribute("message", "Please verify recaptcha");

		}

		return "login";

	}

	@PostMapping("/userregister")
	public String getRegister(@Valid @ModelAttribute("user") UserInfoDto user,BindingResult result,
			Model model,RedirectAttributes rmodel) {

		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return "userregister";
		}
		if(!user.getUpass().equals( user.getRpass())) {
			model.addAttribute("notmatch", "Password and retype password not match");
			return "userregister";
		}

		UserInfo u = userService.searchUser(user.getUname(), user.getUpass());

		if(u != null) {

			model.addAttribute("notmatch",fcall.setMessage());
			return "userregister";
		}

		userService.save(user);
		rmodel.addFlashAttribute("sucess", "User sucessfull register you can procced login");
		return "redirect:/admin";
	}

	@GetMapping("/dispuser")
	public String dispUser(Model model, HttpSession session) {

		model.addAttribute("userList",userRepo.findAll());

		return "userdisp";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int uid, HttpSession session) {
		userRepo.deleteById(uid);
		return "redirect:/dispuser";
	}

	@GetMapping("/imageupload")
	public String getImagePage() {

		return "imageupload";
	}

	@PostMapping("/upload")
	public String imageUpload(@RequestParam("file") MultipartFile file , Model model, HttpSession session) throws IOException {

		if(!file.isEmpty()) {
			FileOutputStream cout = new FileOutputStream("src/main/resources/static/assets/"+file.getOriginalFilename());
		cout.write(file.getBytes());
		cout.close();
		model.addAttribute("msg", "Image uploaded");
		return "imageupload";

		}
		model.addAttribute("msg", "Image not uploaded");
		return "imageupload";
	}
}
