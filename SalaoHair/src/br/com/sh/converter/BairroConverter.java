package br.com.sh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sh.dao.endereco.BairroDAO;
import br.com.sh.main.endereco.Bairro;

@FacesConverter("bairroConverter")
public class BairroConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor){
		try {
			int codigo = Integer.parseInt(valor);
			BairroDAO bdao = new BairroDAO();
			Bairro b = bdao.buscarPorCodigo(codigo);
			return b;
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto){
		try {
			Bairro b = (Bairro) objeto;
			Integer codigo = b.getCodigo();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}
}