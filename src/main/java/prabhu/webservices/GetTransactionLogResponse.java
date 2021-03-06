
package prabhu.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetTransactionLogResult" type="{WebServices}ArrayOfReturn_TransactionLog" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getTransactionLogResult"
})
@XmlRootElement(name = "GetTransactionLogResponse")
public class GetTransactionLogResponse {

    @XmlElement(name = "GetTransactionLogResult")
    protected ArrayOfReturnTransactionLog getTransactionLogResult;

    /**
     * Gets the value of the getTransactionLogResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfReturnTransactionLog }
     *     
     */
    public ArrayOfReturnTransactionLog getGetTransactionLogResult() {
        return getTransactionLogResult;
    }

    /**
     * Sets the value of the getTransactionLogResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfReturnTransactionLog }
     *     
     */
    public void setGetTransactionLogResult(ArrayOfReturnTransactionLog value) {
        this.getTransactionLogResult = value;
    }

}
