package com.customer.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.exceptions.LanguageNotExistException;
import com.customer.model.Internalization;
import com.customer.repository.InternalizationRepository;
import com.customer.service.InternalizationService;
import static com.customer.utility.Constants.*;

/**
 * @author Pavan
 *
 */
@Service
public class InternalizationServiceImpl implements InternalizationService {

	@Autowired
	private InternalizationRepository internalizationRepository;

	@Override
	public List<Internalization> findAllLanguages() {
		return internalizationRepository.findAll();
	}

	@Override
	public Map<String, String> getI18nIdAdnLabelCode(String langName) throws LanguageNotExistException {
		Map<String, String> labelAndLangmap = new HashMap<String, String>();
		String label = null;
		String value = null;
		if (langName != null && !(EMPTY_STRING.equals(langName)) && langName.equals(LANG_ENGLISH)) {
			List<Object[]> labelAndLangList = internalizationRepository.getLabelCodeAndEngLanguage();
			for (Object[] labelAndLang : labelAndLangList) {
				label = (String) labelAndLang[0];
				value = (String) labelAndLang[1];
				labelAndLangmap.put(label, value);
			}
			return labelAndLangmap;
		} else if (langName != null && !(EMPTY_STRING.equals(langName)) && langName.equals(LANG_GERMAN)) {
			List<Object[]> labelAndLangList = internalizationRepository.getLabelCodeAndGerLanguage();
			for (Object[] labelAndLang : labelAndLangList) {
				label = (String) labelAndLang[0];
				value = (String) labelAndLang[1];
				labelAndLangmap.put(label, value);
			}
			return labelAndLangmap;
		} else if (langName != null && !(EMPTY_STRING.equals(langName)) && langName.equals(LANG_FRENCH)) {
			List<Object[]> labelAndLangList = internalizationRepository.getLabelCodeAndFreLanguage();
			for (Object[] labelAndLang : labelAndLangList) {
				label = (String) labelAndLang[0];
				value = (String) labelAndLang[1];
				labelAndLangmap.put(label, value);
			}
			return labelAndLangmap;
		} else if (langName != null && !(EMPTY_STRING.equals(langName)) && langName.equals(LANG_SPANISH)) {
			List<Object[]> labelAndLangList = internalizationRepository.getLabelCodeAndSpaLanguage();
			for (Object[] labelAndLang : labelAndLangList) {
				label = (String) labelAndLang[0];
				value = (String) labelAndLang[1];
				labelAndLangmap.put(label, value);
			}
			return labelAndLangmap;
		} else
			throw new LanguageNotExistException();
	}

	@Override
	public Internalization saveI18n(List<Internalization> i18nList) {
		Internalization i = null;
		for (Internalization i18n : i18nList) {
			i18n.setIsDelete(0L);
			i18n.setIsActive(1L);
			i18n.setCreatedBy(1L);
			i = internalizationRepository.save(i18n);
		}
		return i;
	}

	@Override
	public Internalization updateI18n(Internalization i18n) throws LanguageNotExistException {
		Optional<Internalization> OptionalInternalizationDomain = internalizationRepository.findById(i18n.getI18nId());
		if (!OptionalInternalizationDomain.isPresent()) {
			throw new LanguageNotExistException();
		}
		Internalization internalizationDomain = OptionalInternalizationDomain.get();
		if (internalizationDomain.getI18nId() != null) {
			i18n.setIsDelete(internalizationDomain.getIsDelete());
			i18n.setIsActive(internalizationDomain.getIsActive());
			i18n.setCreatedBy(internalizationDomain.getCreatedBy());
			Internalization internalization = internalizationRepository.save(i18n);
			return internalization;
		}
		return internalizationDomain;
	}

}
