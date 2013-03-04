package com.friends.charity.view.template.them;

import java.io.Serializable;

import com.sun.xml.xsom.impl.scd.Iterators.Map;


import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
@Named
@SessionScoped
public class GuestPreferences implements Serializable {

        private String theme = "aristo-rtl"; //default

        public String getTheme() {
                Map<String, String> params = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
                if(((java.util.Map<String, String>) params).containsKey("theme")) {
                        theme = ((java.util.Map<String, String>) params).get("theme");
                }
               
                return theme;
        }

        public void setTheme(String theme) {
                this.theme = theme;
        }
}