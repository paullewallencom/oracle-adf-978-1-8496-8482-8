package com.packtpub.adfguide.ch5.ui.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichInputFile;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.BlobDomain;

import oracle.jbo.domain.ClobDomain;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class ClobDomainExampleBean {


    public ClobDomainExampleBean() {
    }


    public void onFileUploaded(ValueChangeEvent event) {
        RichInputFile fip = (RichInputFile)event.getSource();
        Reader in = null;
        Writer out = null;
        UploadedFile file = (UploadedFile)event.getNewValue();

        if (file != null && file.getLength() > 0) {
            try {
                FacesContext context = FacesContext.getCurrentInstance();

                BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
                OperationBinding ob = bindings.getOperationBinding("saveUploadedFile");

                ob.getParamsMap().put("content", newClobDomainForInputStream(file.getInputStream()));
                ob.getParamsMap().put("filename", file.getFilename());
                ob.execute();
                if (!ob.getErrors().isEmpty()) {
                    FacesMessage message =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please supply a valid file name to upload",
                                         null);
                    context.addMessage(fip.getId(), message);
                } else {
                    FacesMessage message =
                        new FacesMessage("Successfully uploaded file '" + file.getFilename() + "' (" +
                                         file.getLength() + " bytes)");
                    context.addMessage(null, message);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
    }

    private ClobDomain newClobDomainForInputStream(InputStream in) throws SQLException, IOException {
        ClobDomain b = new ClobDomain();
        Writer out = b.getCharacterOutputStream();
        writeInputStreamToWriter(in, out);
        in.close();
        out.close();
        return b;
    }

    private static void writeInputStreamToWriter(InputStream in, Writer out) throws IOException {
        InputStreamReader isr = new InputStreamReader(in);
        char[] buffer = new char[8192];
        int charsRead = 0;
        while ((charsRead = isr.read(buffer, 0, 8192)) != -1) {
            out.write(buffer, 0, charsRead);
        }
    }

    private BlobDomain newBlobDomainForInputStream(InputStream in) throws SQLException, IOException {
        BlobDomain b = new BlobDomain();
        OutputStream out = b.getBinaryOutputStream();
        writeInputStreamToOutputStream(in, out);
        in.close();
        out.close();
        return b;
    }

    private static void writeInputStreamToOutputStream(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8192];
        int bytesRead = 0;
        while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
    }


}
