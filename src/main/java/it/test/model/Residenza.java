//
// Questo file � stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andr� persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.04.05 alle 04:49:13 PM CEST 
//


package it.test.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ASL" type="{http://flussi.mds.it/flsassdom_1}codASL"/>
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
    "asl"
})
@XmlRootElement(name = "Residenza")
public class Residenza {

    @XmlElement(name = "ASL", required = true)
    protected String asl;

    /**
     * Recupera il valore della propriet� asl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASL() {
        return asl;
    }

    /**
     * Imposta il valore della propriet� asl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASL(String value) {
        this.asl = value;
    }

}
