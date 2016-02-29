package br.com.sh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sh.dao.endereco.EstadoDAO;
import br.com.sh.main.endereco.Estado;

@FacesConverter("estadoConverter")
public class EstadoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor){
		try {
			Long codigo = Long.parseLong(valor);
			EstadoDAO edao = new EstadoDAO();
			Estado e = edao.buscarPorCodigo(codigo);
			return e;
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto){
		try {
			Estado e = (Estado) objeto;
			Integer codigo = e.getCodigo();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}
}