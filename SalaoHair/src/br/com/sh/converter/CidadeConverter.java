package br.com.sh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sh.dao.endereco.CidadeDAO;
import br.com.sh.main.endereco.Cidade;

@FacesConverter("cidadeConverter")
public class CidadeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor){
		try {
			Long codigo = Long.parseLong(valor);
			CidadeDAO cdao = new CidadeDAO();
			Cidade c = cdao.buscarPorCodigo(codigo);
			return c;
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto){
		try {
			Cidade c = (Cidade) objeto;
			Integer codigo = c.getCodigo();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}
}