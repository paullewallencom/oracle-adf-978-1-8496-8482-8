package comp.packtpub.adfguide.ch9.view;

import javax.faces.convert.ConverterException;

public class CustomUrlParameterConverter implements oracle.adf.controller.UrlParameterConverter {
    public CustomUrlParameterConverter() {
        super();
    }

    /**
     * @param value  the value to be converted into an object representation.
     * @return  the object representation of the value.
     */
    @Override
    public Object getAsObject(String value) {
        System.out.println("getAsObject-" + value);
        // If the specified value is null or zero-length, return null
        if (value == null || value.trim().length() < 1) {
            return null;
        }
        try {
            return (Integer.valueOf(value.trim()));
        } catch (Exception e) {
            throw new ConverterException(e);
        }
      
    }

    /**
     * @param value  the object to be converted into a string representation.
     * @return the string representation of the value.
     */
    @Override
    public String getAsString(Object value) {
        System.out.println("getAsString-" + value);
        // If the specified value is null, return a empty String
        if (value == null) {
            return "";
        }
        // If the incoming value is still return as is
        if (value instanceof String) {
            return (String)value;
        }

        try {
            return (Integer.toString(((Number)value).intValue()));
        } catch (Exception e) {
            throw new ConverterException(e);
        }

    }
}
