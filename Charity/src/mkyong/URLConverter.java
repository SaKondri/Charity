package mkyong;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.mkyong.URLConverter")
public class URLConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		String HTTP = "http://";
		StringBuilder url = new StringBuilder();

		// if not start with http://, then add it
		if (!value.startsWith(HTTP, 0)) {
			url.append(HTTP);
		}
		url.append(value);

		URLBookmark urlBookmark = new URLBookmark(url.toString());

		return urlBookmark;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return value.toString();
	}

}
