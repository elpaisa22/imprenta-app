/**
 * appl-frontend-web [8/10/2014 18:29:40]
 */
package org.ambar.appl.frontend.controllers.reports;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Insertar descripción funcional.</p>
 * @author Sebastian
 * @see <<Insertar clases relacionadas>>
 */
@Controller
public class ReportSimplePdfJasperReportController {
	
	
	
	/**
	 * 
	 * @param pRequest Request
	 * @param pResponse Response
	 * @return {@link ModelAndView} Vista resultado
	 * */
	@RequestMapping(value = "/simpleReportPdf", method = RequestMethod.GET)
	public ModelAndView comprobantePagoPdf(HttpServletRequest pRequest,
			                               HttpServletResponse pResponse) {

		//Seteo de parametros
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		//Se crea un datasource vacio para que no retorne errores
		JRBeanArrayDataSource jRBeanCollectionDataSource = new JRBeanArrayDataSource(new Object[]{});
		parameterMap.put("datasource", jRBeanCollectionDataSource);

		//Setea el formato del reporte
		parameterMap.put("format", "pdf");

        //simplejasperreport esta declarado en el archivo views.properties
        ModelAndView modelAndView = new ModelAndView("simplejasperreport", parameterMap);

        return modelAndView;
	}

}
