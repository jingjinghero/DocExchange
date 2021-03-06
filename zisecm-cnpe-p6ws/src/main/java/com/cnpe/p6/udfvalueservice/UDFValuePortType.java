package com.cnpe.p6.udfvalueservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.3
 * 2020-07-08T18:50:45.063+08:00
 * Generated source version: 3.0.3
 * 
 */
@WebService(targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1", name = "UDFValuePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface UDFValuePortType {

    @WebResult(name = "Return", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
    @RequestWrapper(localName = "UpdateUDFValues", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1", className = "com.cnpe.p6.udfvalueservice.UpdateUDFValues")
    @WebMethod(operationName = "UpdateUDFValues", action = "UpdateUDFValues")
    @ResponseWrapper(localName = "UpdateUDFValuesResponse", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1", className = "com.cnpe.p6.udfvalueservice.UpdateUDFValuesResponse")
    public boolean updateUDFValues(
        @WebParam(name = "UDFValue", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
        java.util.List<com.cnpe.p6.udfvalueservice.UDFValue> udfValue
    ) throws IntegrationFault;

    @WebResult(name = "UDFValue", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
    @RequestWrapper(localName = "ReadUDFValues", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1", className = "com.cnpe.p6.udfvalueservice.ReadUDFValues")
    @WebMethod(operationName = "ReadUDFValues", action = "ReadUDFValues")
    @ResponseWrapper(localName = "ReadUDFValuesResponse", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1", className = "com.cnpe.p6.udfvalueservice.ReadUDFValuesResponse")
    public java.util.List<com.cnpe.p6.udfvalueservice.UDFValue> readUDFValues(
        @WebParam(name = "Field", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
        java.util.List<com.cnpe.p6.udfvalueservice.UDFValueFieldType> field,
        @WebParam(name = "Filter", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
        java.lang.String filter,
        @WebParam(name = "OrderBy", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
        java.lang.String orderBy
    ) throws IntegrationFault;

    @WebResult(name = "CalculatedUDFValue", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
    @RequestWrapper(localName = "ReadCalculatedUDFValues", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1", className = "com.cnpe.p6.udfvalueservice.ReadCalculatedUDFValues")
    @WebMethod(operationName = "ReadCalculatedUDFValues", action = "ReadCalculatedUDFValues")
    @ResponseWrapper(localName = "ReadCalculatedUDFValuesResponse", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1", className = "com.cnpe.p6.udfvalueservice.ReadCalculatedUDFValuesResponse")
    public java.util.List<com.cnpe.p6.udfvalueservice.ReadCalculatedUDFValuesResponse.CalculatedUDFValue> readCalculatedUDFValues(
        @WebParam(name = "Field", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
        java.util.List<com.cnpe.p6.udfvalueservice.CalculatedUDFValueFieldType> field,
        @WebParam(name = "UDFTypeObjectId", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
        java.util.List<java.lang.Integer> udfTypeObjectId,
        @WebParam(name = "ProjectObjectId", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
        java.util.List<java.lang.Integer> projectObjectId
    ) throws IntegrationFault;

    @WebResult(name = "Return", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
    @RequestWrapper(localName = "DeleteUDFValues", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1", className = "com.cnpe.p6.udfvalueservice.DeleteUDFValues")
    @WebMethod(operationName = "DeleteUDFValues", action = "DeleteUDFValues")
    @ResponseWrapper(localName = "DeleteUDFValuesResponse", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1", className = "com.cnpe.p6.udfvalueservice.DeleteUDFValuesResponse")
    public boolean deleteUDFValues(
        @WebParam(name = "ObjectId", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
        java.util.List<com.cnpe.p6.udfvalueservice.DeleteUDFValues.ObjectId> objectId
    ) throws IntegrationFault;

    @WebResult(name = "Return", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
    @RequestWrapper(localName = "getFieldLengthUDFValue", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1", className = "com.cnpe.p6.udfvalueservice.GetFieldLengthUDFValue")
    @WebMethod(action = "getFieldLengthUDFValue")
    @ResponseWrapper(localName = "getFieldLengthUDFValueResponse", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1", className = "com.cnpe.p6.udfvalueservice.GetFieldLengthUDFValueResponse")
    public int getFieldLengthUDFValue(
        @WebParam(name = "Field", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
        java.lang.String field
    ) throws IntegrationFault;

    @WebResult(name = "ObjectId", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
    @RequestWrapper(localName = "CreateUDFValues", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1", className = "com.cnpe.p6.udfvalueservice.CreateUDFValues")
    @WebMethod(operationName = "CreateUDFValues", action = "CreateUDFValues")
    @ResponseWrapper(localName = "CreateUDFValuesResponse", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1", className = "com.cnpe.p6.udfvalueservice.CreateUDFValuesResponse")
    public java.util.List<com.cnpe.p6.udfvalueservice.CreateUDFValuesResponse.ObjectId> createUDFValues(
        @WebParam(name = "UDFValue", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/UDFValue/V1")
        java.util.List<com.cnpe.p6.udfvalueservice.UDFValue> udfValue
    ) throws IntegrationFault;
}
