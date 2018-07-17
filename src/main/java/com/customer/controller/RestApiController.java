package com.customer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.exceptions.LanguageNotExistException;
import com.customer.model.Internalization;
import com.customer.service.InternalizationService;


@RestController
@RequestMapping(value = "/")
public class RestApiController {
	
	@Autowired
	private InternalizationService i18nService;
	
	@GetMapping(value = "getcustomername")
	public String getCustomerName() {
		return "Harshit";
	}
	
	@GetMapping(value = "i18n")
	public List<Internalization> getAllLanguages() {
		return i18nService.findAllLanguages();
	}

	@GetMapping(value = "labelcodeandlang", params = { "langName" })
	public Map<String, String> findLanguageByid(@RequestParam("langName") String langName) throws LanguageNotExistException {
		return i18nService.getI18nIdAdnLabelCode(langName);
	}

	@PostMapping(value = "i18n")
	public Internalization saveI18n(@RequestBody List<Internalization> i18n )throws LanguageNotExistException {
	   return i18nService.saveI18n(i18n);
	}

	@PutMapping(value = "i18n")
	public Internalization updateI18n(@RequestBody Internalization i18n) throws LanguageNotExistException {
	   return i18nService.updateI18n(i18n);
  }

}
