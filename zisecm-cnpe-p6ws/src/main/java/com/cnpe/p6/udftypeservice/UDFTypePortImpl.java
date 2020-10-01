
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.cnpe.p6.udftypeservice;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.3
 * 2020-07-22T15:51:21.018+08:00
 * Generated source version: 3.0.3
 * 
 */

@javax.jws.WebService(
                      serviceName = "UDFTypeService",
                      portName = "UDFTypePort",
                      targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFType/V1",
                      wsdlLocation = "http://10.30.7.78:8206/p6ws/services/UDFTypeService?wsdl",
                      endpointInterface = "com.cnpe.p6.udftypeservice.UDFTypePortType")
                      
public class UDFTypePortImpl implements UDFTypePortType {

    private static final Logger LOG = Logger.getLogger(UDFTypePortImpl.class.getName());

    /* (non-Javadoc)
     * @see com.cnpe.p6.udftypeservice.UDFTypePortType#createUDFTypes(java.util.List<com.cnpe.p6.udftypeservice.UDFType>  udfType )*
     */
    public java.util.List<java.lang.Integer> createUDFTypes(java.util.List<com.cnpe.p6.udftypeservice.UDFType> udfType) throws IntegrationFault    { 
        LOG.info("Executing operation createUDFTypes");
        System.out.println(udfType);
        try {
            java.util.List<java.lang.Integer> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new IntegrationFault("IntegrationFault...");
    }

    /* (non-Javadoc)
     * @see com.cnpe.p6.udftypeservice.UDFTypePortType#updateUDFTypes(java.util.List<com.cnpe.p6.udftypeservice.UDFType>  udfType )*
     */
    public boolean updateUDFTypes(java.util.List<com.cnpe.p6.udftypeservice.UDFType> udfType) throws IntegrationFault    { 
        LOG.info("Executing operation updateUDFTypes");
        System.out.println(udfType);
        try {
            boolean _return = false;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new IntegrationFault("IntegrationFault...");
    }

    /* (non-Javadoc)
     * @see com.cnpe.p6.udftypeservice.UDFTypePortType#getFieldLengthUDFType(java.lang.String  field )*
     */
    public int getFieldLengthUDFType(java.lang.String field) throws IntegrationFault    { 
        LOG.info("Executing operation getFieldLengthUDFType");
        System.out.println(field);
        try {
            int _return = 0;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new IntegrationFault("IntegrationFault...");
    }

    /* (non-Javadoc)
     * @see com.cnpe.p6.udftypeservice.UDFTypePortType#getUDFFieldName(int  objectId )*
     */
    public java.lang.String getUDFFieldName(int objectId) throws IntegrationFault    { 
        LOG.info("Executing operation getUDFFieldName");
        System.out.println(objectId);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new IntegrationFault("IntegrationFault...");
    }

    /* (non-Javadoc)
     * @see com.cnpe.p6.udftypeservice.UDFTypePortType#deleteUDFTypes(java.util.List<java.lang.Integer>  objectId )*
     */
    public boolean deleteUDFTypes(java.util.List<java.lang.Integer> objectId) throws IntegrationFault    { 
        LOG.info("Executing operation deleteUDFTypes");
        System.out.println(objectId);
        try {
            boolean _return = false;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new IntegrationFault("IntegrationFault...");
    }

    /* (non-Javadoc)
     * @see com.cnpe.p6.udftypeservice.UDFTypePortType#readUDFTypes(java.util.List<com.cnpe.p6.udftypeservice.UDFTypeFieldType>  field ,)java.lang.String  filter ,)java.lang.String  orderBy )*
     */
    public java.util.List<com.cnpe.p6.udftypeservice.UDFType> readUDFTypes(java.util.List<com.cnpe.p6.udftypeservice.UDFTypeFieldType> field,java.lang.String filter,java.lang.String orderBy) throws IntegrationFault    { 
        LOG.info("Executing operation readUDFTypes");
        System.out.println(field);
        System.out.println(filter);
        System.out.println(orderBy);
        try {
            java.util.List<com.cnpe.p6.udftypeservice.UDFType> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new IntegrationFault("IntegrationFault...");
    }

}