package br.com.sh.util;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class FacesUtil {

	public static void addMsgInfo(String msg){
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		Flash flash = ec.getFlash();
		flash.setKeepMessages(true);
		fc.addMessage(null, fm);
		
	}
	
	public static void addMsgError(String msg){
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		Flash flash = ec.getFlash();
		flash.setKeepMessages(true);
		fc.addMessage(null, fm);
		
	}
	
	public static String getParam(String nome){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		Map<String, String> parametros = ec.getRequestParameterMap();
		
		String valor = parametros.get(nome);
		
		return valor;
	}
}