
package com.cnpe.p6.activityservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ReadAllActivitiesByWBS complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReadAllActivitiesByWBS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WBSObjectId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Field" type="{http://xmlns.oracle.com/Primavera/P6/WS/Activity/V1}ActivityFieldType" maxOccurs="unbounded"/>
 *         &lt;element name="Filter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadAllActivitiesByWBS", propOrder = {
    "wbsObjectId",
    "field",
    "filter",
    "orderBy"
})
public class ReadAllActivitiesByWBS {

    @XmlElement(name = "WBSObjectId")
    protected int wbsObjectId;
    @XmlElement(name = "Field", required = true)
    @XmlSchemaType(name = "string")
    protected List<ActivityFieldType> field;
    @XmlElement(name = "Filter")
    protected String filter;
    @XmlElement(name = "OrderBy")
    protected String orderBy;

    /**
     * 获取wbsObjectId属性的值。
     * 
     */
    public int getWBSObjectId() {
        return wbsObjectId;
    }

    /**
     * 设置wbsObjectId属性的值。
     * 
     */
    public void setWBSObjectId(int value) {
        this.wbsObjectId = value;
    }

    /**
     * Gets the value of the field property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the field property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActivityFieldType }
     * 
     * 
     */
    public List<ActivityFieldType> getField() {
        if (field == null) {
            field = new ArrayList<ActivityFieldType>();
        }
        return this.field;
    }

    /**
     * 获取filter属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilter() {
        return filter;
    }

    /**
     * 设置filter属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilter(String value) {
        this.filter = value;
    }

    /**
     * 获取orderBy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 设置orderBy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderBy(String value) {
        this.orderBy = value;
    }

}
