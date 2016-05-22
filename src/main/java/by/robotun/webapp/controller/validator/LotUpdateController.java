package by.robotun.webapp.controller.validator;

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
			Lot lot = userService.getLotById(idLot);
			UpdateLotForm updateLotForm = new UpdateLotForm();
			updateLotForm.setIdLot(idLot);
			updateLotForm.setDescription(lot.getDescription());
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
		if (result.hasErrors()) {
		}
		userService.updateLot(updateLotForm);
		Lot lot = userService.getLotById(updateLotForm.getIdLot());
		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_UPDATE_LOT);
		modelAndView.addObject(ControllerParamConstant.MESSAGE, true);
		modelAndView.addObject(ControllerParamConstant.UPDATE_LOT_FORM, updateLotForm);
		modelAndView.addObject(ControllerParamConstant.LIST_CITIES, guestService.getAllCities());
		modelAndView.addObject(ControllerParamConstant.LOT, lot);
		return modelAndView;
	}

}
