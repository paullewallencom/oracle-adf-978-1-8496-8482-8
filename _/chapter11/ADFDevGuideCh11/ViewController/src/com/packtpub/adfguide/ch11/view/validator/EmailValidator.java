package com.packtpub.adfguide.ch11.view.validator;

import java.util.Collection;
import java.util.Collections;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;

import javax.faces.validator.ValidatorException;

import org.apache.myfaces.trinidad.validator.ClientValidator;

public class EmailValidator implements Validator, ClientValidator {
    Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");

    public EmailValidator() {
        super();
    }
    /**
     *This is used to import the built-in scripts provided by Apache Trinidad.
     *If this function returns null, built in "Validator()" will be used.
     */
    @Override
    public Collection<String> getClientImportNames() {
        return null;
    }

    /**
     * Implementation for ClientValidator::getClientLibrarySource()
     * Gets the URI specifying the location of the js lib resource.
     */
    @Override
    public String getClientLibrarySource(FacesContext context) {

        return context.getExternalContext().getRequestContextPath() + "/resources/js/email.js";
    }

    /**
     * Implementation for ClientValidator::getClientScript()
     * Opportunity for the ClientValidator to return script content.
     */
    @Override
    public String getClientScript(FacesContext context, UIComponent component) {
        return null;
    }
    /**
     * Implementation for ClientValidator::getClientValidation()
     * Called to retrieve the appropriate client
     * validation code(JavaScript method) for the current field
     */
    @Override
    public String getClientValidation(FacesContext context, UIComponent component) {
        return ("new EmailClientValidator()");
    }
    /**
     * Implementation for Validator::validate()
     * This validates the value on server.
     */ 
    @Override
    public void validate(FacesContext facesContext, UIComponent uIComponent, Object object) throws ValidatorException {
        Matcher matcher = emailPattern.matcher(object.toString());
        System.out.println(object.toString() + " - " + matcher.matches());
        if (!matcher.matches()) {
            if (validateEmailBySendingMail()) { //validateEmailBySendingMail() is not shown
                FacesMessage msg = new FacesMessage("Email validation failed", "Invalid Email");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }

        }
    }

    public boolean validateEmailBySendingMail() {
        return true;
    }
}
