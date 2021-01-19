package com.mert.controller;

import java.util.List;


/**
 * Created by Yasin Mert on 25.02.2017.
 */
import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mert.model.User;
import com.mert.service.RoleService;
import com.mert.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {


	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	//toast ui grid test 
//	@RequestMapping(value = "/all-test" , method = RequestMethod.POST)
//	public @ResponseBody ModelAndView gridTest(User search) {  //User model 로 데이터 매칭 바인딩
//		System.out.println("all-test실행");
//		System.out.println(search.getName() + "name 변수가전달됌22");
//		ModelAndView modelAndView = new ModelAndView();
//		//POINT=7 http://stackoverflow.com/questions/22364886/neither-bindingresult-nor-plain-target-object-for-bean-available-as-request-attr
//
//		modelAndView.addObject("mode", "MODE_return");
//		modelAndView.addObject("user_data", search.getName());
////		modelAndView.addObject("auth", getUser());
////		modelAndView.addObject("control", getUser().getRole().getRole());
//		modelAndView.setViewName("user");
//		
//		System.out.println(modelAndView.getModel());
//		return modelAndView;
//	}
	@RequestMapping(value = "/all-test", method = RequestMethod.GET)
	public @ResponseBody List<User> searchGet(User vo) throws Exception {
		System.out.println(vo.getName() + "name 변수가전달22");
		
//		HashMap  User2 = new HashMap();
//		List go  = new ArrayList();
//		User2.put("id", "bbb");
//		User2.put("email", "test");
//		go.add(User2);
//	    User2 = new HashMap();
//		User2.put("id", "bbb2");
//		User2.put("email", "tes2t");
//		
//		
//		go.add(User2);
		System.out.println(userService.findAll());
//		
		return userService.findAll();
	}
	
	@PostMapping(value = "/all-test-update")
	public   @ResponseBody String UpdateRow(@RequestBody String VO) throws Exception {

		System.out.println(VO+ "update 데이터 처리 ");
		//json object 담는거 구현 해야함
		JSONParser jsonParse = new JSONParser(); //JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다. 
		JSONObject jsonObj = (JSONObject) jsonParse.parse(VO);
		
		JSONArray personArray = (JSONArray) jsonObj.get("updatedRows");
		
		for(int i=0; i < personArray.size(); i++) {
			JSONObject personObject = (JSONObject) personArray.get(i);

			System.out.println(personObject.get("email") + "데이터가 들어옴");
		}

		return "ABC";
	}


		
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView allUsers() {
		System.out.println("all실행");
		ModelAndView modelAndView = new ModelAndView();
		//POINT=7 http://stackoverflow.com/questions/22364886/neither-bindingresult-nor-plain-target-object-for-bean-available-as-request-attr
		modelAndView.addObject("users", userService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		modelAndView.setViewName("user");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/users/all");
		user.setPassword(userService.findUser(user.getId()).getPassword());
		user.setActive(userService.findUser(user.getId()).getActive());
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		userService.save(user);
		return modelAndView;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateUser(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("rule", new User());
		modelAndView.addObject("user", userService.findUser(id));
		modelAndView.addObject("roles", roleService.findAll());
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		modelAndView.setViewName("user");
		return modelAndView;
	}
 
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/users/all");
		modelAndView.addObject("rule", new User());
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		userService.delete(id);
		return modelAndView;
	}

	private User getUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return user;
	}
}







