package com.controller;

import java.io.Console;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.entity.person;
import com.service.IPersonService;

@RestController
// @Controller
//@CrossOrigin(origins = { "/**" },methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT}, maxAge = 3600,allowedHeaders = "*")
@CrossOrigin(origins="http://localhost:4200")
public class PersonController {
	@Autowired
	private IPersonService personService;
	/*
	 * restcontroller
	 */
	// @RequestMapping(value = "/person", method = RequestMethod.GET)

	@GetMapping(value = "/persons")
	public ResponseEntity<List<person>> welcome() {
		List<person> listPerson = personService.getAllArticles();
		return new ResponseEntity<List<person>>(listPerson, HttpStatus.OK);
	}

	@GetMapping(value = "/getPerson/{id}")
	public ResponseEntity<person> getPersonById(@PathVariable("id") String id) {
		person personById = personService.getPersonById(id);
		return new ResponseEntity<person>(personById, HttpStatus.OK);
	}

//	 @DeleteMapping(value = "/deletePerson/{id}")
//	 public ResponseEntity<Void> deleteArticle(@PathVariable("id") String id) {
//	 personService.deletePerson(id); // return new
//	 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	 }
	 @DeleteMapping("/delete")
	 public ResponseEntity<Void> deleteArticle(@RequestParam("id") String id) {
	 personService.deletePerson(id); // return new
	 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	 }
	@PutMapping("/update")
	public ResponseEntity<person> updateArticle(@RequestBody person person) {
		personService.updatePerson(person);
		return new ResponseEntity<person>(person, HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<person> addPerson(@RequestBody person pesron) {
		personService.createPerson(pesron);
		return new ResponseEntity<person>(pesron, HttpStatus.OK);
	}

	// // get all persons
	// @RequestMapping(path = "/")
	// public ModelAndView getList(ModelAndView model,HttpServletRequest request) {
	// List<person> listPerson = personService.getAllArticles();
	//// if(request.getParameter("id")!=null) {
	//// person per = personService.getPersonById(request.getParameter("id"));
	//// model.addObject("person", per);
	//// }
	// model.addObject("listPerson", listPerson);
	// model.setViewName("listperson");
	// return model;
	// }
	//
	// @RequestMapping(path = "/save")
	// public ModelAndView addList(@ModelAttribute("person") person person) {
	// try {
	// personService.createPerson(person);
	// return new ModelAndView("redirect:/");
	// }catch(Exception e)
	// {
	// System.out.println("ggggggggggggggggggggggggg"+e.getMessage()+"gggggggggggggggggggggg");
	// return null;
	// }
	//
	// }
	//
	// @RequestMapping(path = "/form")
	// public ModelAndView view(ModelAndView model) {
	// person pers = new person();
	// model.addObject("person", pers);
	// model.setViewName("welcome");
	// return model;
	// }
	//
	// @RequestMapping(path = "/getById")
	// public ModelAndView getById(HttpServletRequest request) {
	// person per = personService.getPersonById(request.getParameter("id"));
	// List<person> listPerson = personService.getAllArticles();
	// ModelAndView model = new ModelAndView();
	// model.addObject("person", per);
	// model.addObject("listPerson", listPerson);
	// model.setViewName("listperson");
	// return model;
	// }
	//
	// @RequestMapping(path = "/delete")
	// public ModelAndView delete(HttpServletRequest request) {
	// personService.deletePerson(request.getParameter("id"));
	// return new ModelAndView("redirect:/");
	// }

	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public void handleEmployeeNotFound() {
		System.out.println("---------------------gggggggggggggggggggg------------------------");
	}

}
