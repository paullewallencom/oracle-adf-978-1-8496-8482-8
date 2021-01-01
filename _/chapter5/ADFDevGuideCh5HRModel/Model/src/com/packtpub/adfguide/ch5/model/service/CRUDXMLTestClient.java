package com.packtpub.adfguide.ch5.model.service;


import java.io.IOException;

import java.net.URL;

import java.util.HashMap;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.XMLInterface;
import oracle.jbo.client.Configuration;

import oracle.xml.parser.v2.DOMParser;
import oracle.xml.parser.v2.XMLNode;
import oracle.xml.parser.v2.XMLParseException;
import oracle.xml.parser.v2.XSLException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import org.xml.sax.SAXException;

public class CRUDXMLTestClient {
    public CRUDXMLTestClient() {
        super();
    }

    public static void main(String[] args) throws IOException,
                                                  XMLParseException,
                                                  SAXException, XSLException {
        String amDef = "com.packtpub.adfguide.ch5.model.service.HRServiceAppModule";
        String config = "HRServiceAppModuleLocal";
        ApplicationModule am =
            Configuration.createRootApplicationModule(amDef, config);
        ViewObject vo = am.findViewObject("Departments");
        Key k = new Key(new Object[] { 10 }); // customer jchen
        Row deptRow = vo.findByKey(k, 1)[0];
        /**
         * The depthcount parameter represents to what level the rendering should recurse.
         * A depthcount  of zero (0) means do not traverse any View Links while rendering.
         * One (1) means traverse the View Links on this object but no View Links thereafter,
         * and so on.
         */
        printXML("Step 1: Dept Row With employees ",deptRow.writeXML(-1, XMLInterface.XML_OPT_ALL_ROWS));

       /**
        * Dynamically modify the View Definition
        */
        HashMap viewDefMap = new HashMap();
        viewDefMap.put("com.packtpub.adfguide.ch5.model.view.DepartmentVO",
                       new String[] { "DepartmentId", "DepartmentName" });
        printXML("Step 2 : Modified Dept Definition ",vo.writeXML(-1, viewDefMap));
        /**
         * Create/Update Nodes
         */
        Element xmlToRead = getInsertUpdateDeleteXMLGram();
        printXML("Step 3 : XML input file data - ",xmlToRead);
        vo.readXML(xmlToRead, -1);
        printXML("Step 4 : Merged VO based on xml input ", vo.writeXML(0,
                                  XMLInterface.XML_OPT_ALL_ROWS | XMLInterface.XML_OPT_ASSOC_CONSISTENT));
        am.getTransaction().commit();
        Configuration.releaseRootApplicationModule(am, true);
    }

    private static void printXML(String step, Node n) throws IOException {
        System.out.println("------------------"+ step +" : Result----------------------------");
        ((XMLNode)n).print(System.out);
    }

    private static Element getInsertUpdateDeleteXMLGram() throws XMLParseException,
                                                                 SAXException,
                                                                 IOException {

        String xmlurl = "test.xml";
        URL xmlURL = CRUDXMLTestClient.class.getResource(xmlurl);
        DOMParser dp = new DOMParser();
        dp.parse(xmlURL);
        return dp.getDocument().getDocumentElement();
    }
}
