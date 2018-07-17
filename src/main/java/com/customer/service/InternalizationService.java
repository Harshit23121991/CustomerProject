package com.customer.service;

import java.util.List;
import java.util.Map;

import com.customer.exceptions.LanguageNotExistException;
import com.customer.model.Internalization;


/**
 * @author Pavan
 *
 */
public interface InternalizationService {
	public Internalization saveI18n(List<Internalization> i18n); 
	public Internalization updateI18n(Internalization i18n)throws LanguageNotExistException;
	public  List<Internalization> findAllLanguages();
	public Map<String, String> getI18nIdAdnLabelCode(String langName) throws LanguageNotExistException;
}
