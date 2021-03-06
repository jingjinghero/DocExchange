
package com.cnpe.p6.udftypeservice;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.3
 * 2020-07-22T15:51:20.986+08:00
 * Generated source version: 3.0.3
 * 
 */
public final class UDFTypePortType_UDFTypePort_Client {

    private static final QName SERVICE_NAME = new QName("http://xmlns.oracle.com/Primavera/P6/WS/UDFType/V1", "UDFTypeService");

    private UDFTypePortType_UDFTypePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = UDFTypeService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        UDFTypeService ss = new UDFTypeService(wsdlURL, SERVICE_NAME);
        UDFTypePortType port = ss.getUDFTypePort();  
        
        {
        System.out.println("Invoking createUDFTypes...");
        java.util.List<com.cnpe.p6.udftypeservice.UDFType> _createUDFTypes_udfType = null;
        try {
            java.util.List<java.lang.Integer> _createUDFTypes__return = port.createUDFTypes(_createUDFTypes_udfType);
            System.out.println("createUDFTypes.result=" + _createUDFTypes__return);

        } catch (IntegrationFault e) { 
            System.out.println("Expected exception: IntegrationFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking updateUDFTypes...");
        java.util.List<com.cnpe.p6.udftypeservice.UDFType> _updateUDFTypes_udfType = null;
        try {
            boolean _updateUDFTypes__return = port.updateUDFTypes(_updateUDFTypes_udfType);
            System.out.println("updateUDFTypes.result=" + _updateUDFTypes__return);

        } catch (IntegrationFault e) { 
            System.out.println("Expected exception: IntegrationFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getFieldLengthUDFType...");
        java.lang.String _getFieldLengthUDFType_field = "";
        try {
            int _getFieldLengthUDFType__return = port.getFieldLengthUDFType(_getFieldLengthUDFType_field);
            System.out.println("getFieldLengthUDFType.result=" + _getFieldLengthUDFType__return);

        } catch (IntegrationFault e) { 
            System.out.println("Expected exception: IntegrationFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getUDFFieldName...");
        int _getUDFFieldName_objectId = 0;
        try {
            java.lang.String _getUDFFieldName__return = port.getUDFFieldName(_getUDFFieldName_objectId);
            System.out.println("getUDFFieldName.result=" + _getUDFFieldName__return);

        } catch (IntegrationFault e) { 
            System.out.println("Expected exception: IntegrationFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking deleteUDFTypes...");
        java.util.List<java.lang.Integer> _deleteUDFTypes_objectId = null;
        try {
            boolean _deleteUDFTypes__return = port.deleteUDFTypes(_deleteUDFTypes_objectId);
            System.out.println("deleteUDFTypes.result=" + _deleteUDFTypes__return);

        } catch (IntegrationFault e) { 
            System.out.println("Expected exception: IntegrationFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking readUDFTypes...");
        java.util.List<com.cnpe.p6.udftypeservice.UDFTypeFieldType> _readUDFTypes_field = null;
        java.lang.String _readUDFTypes_filter = "";
        java.lang.String _readUDFTypes_orderBy = "";
        try {
            java.util.List<com.cnpe.p6.udftypeservice.UDFType> _readUDFTypes__return = port.readUDFTypes(_readUDFTypes_field, _readUDFTypes_filter, _readUDFTypes_orderBy);
            System.out.println("readUDFTypes.result=" + _readUDFTypes__return);

        } catch (IntegrationFault e) { 
            System.out.println("Expected exception: IntegrationFault has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
