package com.cnpe.p6.authenticationservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.3
 * 2020-07-08T18:50:36.306+08:00
 * Generated source version: 3.0.3
 * 
 */
@WebService(targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1", name = "AuthenticationServicePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface AuthenticationServicePortType {

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "ReadSessionPropertiesResponse", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1", partName = "result")
    @WebMethod(operationName = "ReadSessionProperties", action = "urn:ReadSessionProperties")
    public ReadSessionPropertiesResponse readSessionProperties(
        @WebParam(partName = "params", name = "ReadSessionProperties", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1")
        java.lang.Object params
    ) throws IntegrationFault;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "ReadDatabaseInstancesResponse", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1", partName = "result")
    @WebMethod(operationName = "ReadDatabaseInstances", action = "urn:ReadDatabaseInstances")
    public ReadDatabaseInstancesResponse readDatabaseInstances(
        @WebParam(partName = "params", name = "ReadDatabaseInstances", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1")
        java.lang.Object params
    ) throws IntegrationFault;

    @WebResult(name = "Return", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1")
    @RequestWrapper(localName = "Login", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1", className = "com.cnpe.p6.authenticationservice.Login")
    @WebMethod(operationName = "Login", action = "urn:Login")
    @ResponseWrapper(localName = "LoginResponse", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1", className = "com.cnpe.p6.authenticationservice.LoginResponse")
    public java.lang.Boolean login(
        @WebParam(name = "UserName", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1")
        java.lang.String userName,
        @WebParam(name = "Password", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1")
        java.lang.String password,
        @WebParam(name = "DatabaseInstanceId", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1")
        java.lang.Integer databaseInstanceId
    ) throws IntegrationFault;

    @WebResult(name = "Return", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1")
    @RequestWrapper(localName = "UpdateSessionProperties", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1", className = "com.cnpe.p6.authenticationservice.UpdateSessionProperties")
    @WebMethod(operationName = "UpdateSessionProperties", action = "urn:UpdateSessionProperties")
    @ResponseWrapper(localName = "UpdateSessionPropertiesResponse", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1", className = "com.cnpe.p6.authenticationservice.UpdateSessionPropertiesResponse")
    public java.lang.Boolean updateSessionProperties(
        @WebParam(name = "IgnoreNullComplexFields", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1")
        java.lang.Boolean ignoreNullComplexFields
    );

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "LogoutResponse", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1", partName = "result")
    @WebMethod(operationName = "Logout", action = "urn:Logout")
    public LogoutResponse logout(
        @WebParam(partName = "params", name = "Logout", targetNamespace = "http://xmlns.oracle.com/Primavera/P6/WS/Authentication/V1")
        java.lang.Object params
    );
}
