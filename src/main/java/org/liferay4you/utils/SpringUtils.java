package org.liferay4you.utils;

import org.springframework.web.servlet.ModelAndView;

/**
 * Class with util methods to improve Spring integration
 * @author Yaden
 */
public class SpringUtils {

	/**
	 * Model and Vie factory
	 * @param jspPath
	 * @param viewName
	 * @param viewObject
	 * @return
	 */
	public static ModelAndView createMv(String jspPath, String viewName, String viewObject) {
		return new ModelAndView(jspPath, viewName, viewObject);
	}
	
}
