package by.web.store.controller.validator;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.web.store.controller.ControllerParamConstant;
import by.web.store.controller.URLMapping;
import by.web.store.domain.Person;
import by.web.store.domain.User;
import by.web.store.form.AddProductForm;
import by.web.store.form.AddUserForm;
import by.web.store.service.IPrivateService;

@Controller
@RequestMapping("/private/user/main/add-product")
public class AddProductController {
	
	@Autowired
	IPrivateService privateService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView addProduct(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_USER_ADD_PRODUCT);
		AddProductForm addProductForm = new AddProductForm();
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		modelAndView.addObject(ControllerParamConstant.LOGIN, person.getLogin());
		modelAndView.addObject(ControllerParamConstant.FORM_ADD_PRODUCT, addProductForm);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addProductValid(
			@ModelAttribute(ControllerParamConstant.FORM_ADD_PRODUCT) AddProductForm addProductForm)
			throws Exception {
//		privateService.addUser(user);
		ModelAndView modelAndView = new ModelAndView(URLMapping.REDIRECT_USER_MAIN);
		return modelAndView;
	}

}
