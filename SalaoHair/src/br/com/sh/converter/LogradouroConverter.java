package br.com.sh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sh.dao.endereco.LogradouroDAO;
import br.com.sh.main.endereco.Logradouro;

@FacesConverter("logradouroConverter")
public class LogradouroConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			int codigo = Integer.parseInt(valor);
			LogradouroDAO ldao = new LogradouroDAO();
			Logradouro l = ldao.buscarPorCodigo(codigo);
			return l;
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		try {
			Logradouro l = (Logradouro) objeto;
			Integer codigo = l.getCodigo();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}
}