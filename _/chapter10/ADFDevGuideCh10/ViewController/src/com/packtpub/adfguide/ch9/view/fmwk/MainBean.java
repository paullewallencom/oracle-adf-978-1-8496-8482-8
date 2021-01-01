package com.packtpub.adfguide.ch9.view.fmwk;

import java.util.Map;

import java.util.Set;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.NavigationCase;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class MainBean {
    public MainBean() {
    }

    public void handler(ActionEvent actionEvent) {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler configurableNavigationHandler =
            (ConfigurableNavigationHandler)FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        Map<String, Set<NavigationCase>> cases = configurableNavigationHandler.getNavigationCases();
        NavigationCase navigationCase =configurableNavigationHandler.getNavigationCase(FacesContext.getCurrentInstance(), null, "");
        String viewId= navigationCase.getToViewId(facesContext);
    }
}
