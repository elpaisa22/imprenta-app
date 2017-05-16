
package org.ambar.appl.frontend.helpers;

import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.webflow.context.servlet.ServletExternalContext;
import org.springframework.webflow.engine.RequestControlContext;

/**
 * <p>
 * 	Clase encargada de manejar el upload de archivos.
 * </p>
 *
 * @author Ecclesia
 *
 */
public class UploadFileHandler implements Serializable {

	private static final long serialVersionUID = 7795082747106254116L;

	private byte[] fileContent;
	private File file;
	private String workDirectory;
	private String user;

	// Nombre de archivo origen
	private String fileNameClient;
	// Nombre de archivo almacenado en el servidor
	private String fileNameServer;

	/**
	 * Inicializacion del objeto
	 * */
	public void init(String pWorkDirectory, String pUser){
		if (!StringUtils.isEmpty(pWorkDirectory)) {
			this.workDirectory = pWorkDirectory;
		} else {
			this.workDirectory = null;
		}
		this.user = pUser;
	}

	/**
	 * Retorna el contenido del archivo pFileName en formato String.
	 * @param pFileName Nombre del Archivo
	 * @param pRequestContext Request Context de SWF
	 * */
	public void setUploadedFile(String pFileName, RequestControlContext pRequestContext) {

	    CommonsMultipartFile multipartFile = this.getMultipartFile(pFileName, pRequestContext);
	    DiskFileItem fileItem = (DiskFileItem) multipartFile.getFileItem();

	    if (fileItem.getSize() == 0) {
	    	this.file = null;
	    } else {
	    	this.fileContent = fileItem.get();

		    // Guardo el nombre original del file
		    this.fileNameClient = FilenameUtils.getName(fileItem.getName());

	        this.fileNameServer =  this.getStrTimeStamp() + "_" + this.fileNameClient;

		    // Al nombre del file se le concatena fecha + usuario
		    this.file = new File(FilenameUtils.concat(this.getWorkDirectorySecure(), this.fileNameServer));
		    try {
		    	new File(this.getWorkDirectorySecure()).mkdirs();
				fileItem.write(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	}

	/**
	 * Obtiene el time stamp.
	 * */
	private String getStrTimeStamp() {
		// Guardo el nombre del file almacenado en el servidor
	    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.toString().replace(".","_").replace(":", "_");
	}

	/**
	 * Retorna el nombre de usuario. Si no fue inicializado retornamos vacío.
	 * @return {@link String} Nombre de Usuario
	 * */
	private String getUserSecure() {
		if (this.user == null) {
			user = StringUtils.EMPTY;
		}
		return user;
	}

	/**
	 * Retorna el directorio de trabajo. Si no fue inicializado el directorio temporal.
	 * @return {@link String} Directorio de trabajo.
	 * */
	public String getWorkDirectorySecure() {
		if (this.workDirectory == null) {
			workDirectory = System.getProperty("java.io.tmpdir");
		}
		return workDirectory;
	}

	/**
	 * Retorna el archivo pFileName.
	 * @return {@link String} Contenido del archivo
	 * */
	public String getFileContent() {

		String result;
		try {
			result = new String(this.fileContent, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			result = null;
		}

		return result;
	}

	/**
	 * @return Retorna el valor del atributo file.
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Retorna el archivo multipart con nombre pFileName.
	 * @param pFileName Nombre del Archivo
	 * @param pRequestContext Request Context de SWF
	 * @return {@link CommonsMultipartFile} Multipart File
	 */
	private CommonsMultipartFile getMultipartFile(String pFileName, RequestControlContext pRequestContext) {
		ServletExternalContext context = (ServletExternalContext) pRequestContext.getExternalContext();
	    DefaultMultipartHttpServletRequest nativeRequest =
	    		new DefaultMultipartHttpServletRequest((HttpServletRequest) context.getNativeRequest());

	    DefaultMultipartHttpServletRequest effectiveRequest =
	    		(DefaultMultipartHttpServletRequest) nativeRequest.getRequest();

	    return (CommonsMultipartFile) effectiveRequest.getFile(pFileName);
	}
	
	/**
	 * @return Retorna el nombre del archivo en el servidor.
	 */
	public String getFileNameServer(){
		if (this.file == null) {
			return StringUtils.EMPTY;
		}
		return this.file.getName();
	}

	/**
	 * @return Retorna el valor del atributo fileNameClient.
	 */
	public String getFileNameClient() {
		return fileNameClient;
	}
	
	/**
	 * @return Retorna si el archivo existe.
	 */
	public boolean existeFile() {
		if (StringUtils.isEmpty(this.getFileNameServer())) {
			return false;
		}
		File file = new File(this.getWorkDirectorySecure() + this.getFileNameServer());
		return file.exists() && file.isFile();
	}
	
}
