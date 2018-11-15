package com.lftechnology.msb.prabhu.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckBalanceResult" type="{WebServices}Return_CHECKBALANCE"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "checkBalanceResult"
})
@XmlRootElement(name = "CheckBalanceResponse")
public class CheckBalanceResponse {

    @XmlElement(name = "CheckBalanceResult", required = true)
    protected ReturnCHECKBALANCE checkBalanceResult;

    /**
     * Gets the value of the checkBalanceResult property.
     *
     * @return possible object is
     * {@link ReturnCHECKBALANCE }
     */
    public ReturnCHECKBALANCE getCheckBalanceResult() {
        return checkBalanceResult;
    }

    /**
     * Sets the value of the checkBalanceResult property.
     *
     * @param value allowed object is
     *              {@link ReturnCHECKBALANCE }
     */
    public void setCheckBalanceResult(ReturnCHECKBALANCE value) {
        this.checkBalanceResult = value;
    }

}
