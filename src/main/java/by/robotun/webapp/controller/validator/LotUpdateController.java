package by.robotun.webapp.controller.validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.controller.ControllerParamConstant;
import by.robotun.webapp.controller.URLMapping;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.Person;
import by.robotun.webapp.form.UpdateLotForm;
import by.robotun.webapp.form.validator.UpdateLotFormValidator;
import by.robotun.webapp.service.IGuestService;
import by.robotun.webapp.service.IUserService;
import by.robotun.webapp.service.ServiceParamConstant;

@Controller
@RequestMapping("/user/updateLot")
public class LotUpdateController {

	@Autowired
	private UpdateLotFormValidator updateLotFormValidator;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IGuestService guestService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView updateLot(@RequestParam(value = "id", required = false) Integer idLot, Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		int idUser = guestService.getIdOwnerLot(idLot);
		ModelAndView modelAndView = null;
		if(idUser == person.getId()) {
			modelAndView = new ModelAndView(URLMapping.JSP_UPDATE_LOT);
			DateFormat dateFormat = new SimpleDateFormat(ServiceParamConstant.FORMAT_DATE_WITHOUT_TIME);
			Lot lot = userService.getLotById(idLot);
			UpdateLotForm updateLotForm = new UpdateLotForm();
			updateLotForm.setBudget(String.valueOf(lot.getBudget()));
			updateLotForm.setIdLot(idLot);
			updateLotForm.setDescription(lot.getDescription());
			//изменить после добавления скроллера времени на страницу updateLot
			updateLotForm.setEndDate(dateFormat.format(lot.getEndDate()));
			updateLotForm.setIdCategory(lot.getIdCategory());
			updateLotForm.setIdCity(lot.getIdCity());
			updateLotForm.setIdSubcategory(lot.getIdSubcategory());
			updateLotForm.setIsCall(lot.getIsCall());
			updateLotForm.setName(lot.getName());
			modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
			modelAndView.addObject(ControllerParamConstant.UPDATE_LOT_FORM, updateLotForm);
			modelAndView.addObject(ControllerParamConstant.LOT, lot);
		} else {
			modelAndView = new ModelAndView(URLMapping.JSP_ERROR_404);
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView updateLotValidation(@ModelAttribute(ControllerParamConstant.UPDATE_LOT_FORM) UpdateLotForm updateLotForm,
		BindingResult result, HttpSession httpSession) throws Exception {
		updateLotFormValidator.validate(updateLotForm, result);
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_UPDATE_LOT);
		if (!result.hasErrors()) {
			userService.updateLot(updateLotForm);
			modelAndView.addObject(ControllerParamConstant.MESSAGE, true);
		}
		Lot lot = userService.getLotById(updateLotForm.getIdLot());
		modelAndView.addObject(ControllerParamConstant.UPDATE_LOT_FORM, updateLotForm);
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.LOT, lot);
		return modelAndView;
	}

}
