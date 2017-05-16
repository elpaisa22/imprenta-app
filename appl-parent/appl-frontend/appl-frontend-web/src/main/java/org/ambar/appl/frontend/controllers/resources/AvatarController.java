package org.ambar.appl.frontend.controllers.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ambar.core.parameters.ParameterHelper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AvatarController {
	
	@Resource(name = "parameters")
	private ParameterHelper parameterHelper;

	/**
	 * @param pParameterHelper Establece el valor del atributo parameterHelper.
	 */
	public void setParameterHelper(ParameterHelper pParameterHelper) {
		parameterHelper = pParameterHelper;
	}

	/**
	 * 
	 * @param pRequest Request
	 * @param pResponse Response
	 * @return {@link ModelAndView} Vista resultado
	 * @throws IOException 
	 * */
	@RequestMapping(value = "/avatar-img/{img:.+}", method = RequestMethod.GET)
	public void image(@PathVariable String img,
			            HttpServletRequest pReq,
			            HttpServletResponse pResp) throws IOException {

		ServletContext cntx = pReq.getServletContext();
		// Get the absolute path of the image
		String filename = img;
		String workDirectory = parameterHelper.getDirectory("default_dir_avatars", System.getProperty("java.io.tmpdir"));
		filename = FilenameUtils.concat(workDirectory, filename);

		// retrieve mimeType dynamically
		String mime = cntx.getMimeType(filename);
		if (mime == null) {
			pResp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		pResp.setContentType(mime);
		File file = new File(filename);
		pResp.setContentLength((int)file.length());

		FileInputStream in = new FileInputStream(file);
		OutputStream out = pResp.getOutputStream();

		// Copy the contents of the file to the output stream
		byte[] buf = new byte[1024];
		int count = 0;
		while ((count = in.read(buf)) >= 0) {
			out.write(buf, 0, count);
		}
		out.close();
		in.close();
	}
}
