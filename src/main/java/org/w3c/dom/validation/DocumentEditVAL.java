/*
 * Copyright (c) 2004 World Wide Web Consortium,
 *
 * (Massachusetts Institute of Technology, European Research Consortium for
 * Informatics and Mathematics, Keio University). All Rights Reserved. This
 * work is distributed under the W3C(r) Software License [1] in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * [1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 */

package org.w3c.dom.validation;

import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.NameList;

/**
 * This interface extends the <code>NodeEditVAL</code> interface with 
 * additional methods for document editing. An object implementing this 
 * interface must also implement the <code>Document</code> interface.
 * <p>See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Val-20040127'>Document Object Model (DOM) Level 3 Validation Specification</a>.
 */
public interface DocumentEditVAL extends NodeEditVAL {
    /**
     * An attribute specifying whether the validity of the document is 
     * continuously enforced. When the attribute is set to <code>true</code>
     * , the implementation may raise certain exceptions, depending on the 
     * situation (see the following). This attribute is <code>false</code> 
     * by default. 
     */
    public boolean getContinuousValidityChecking();
    /**
     * An attribute specifying whether the validity of the document is 
     * continuously enforced. When the attribute is set to <code>true</code>
     * , the implementation may raise certain exceptions, depending on the 
     * situation (see the following). This attribute is <code>false</code> 
     * by default. 
     * @exception DOMException
     *   NOT_SUPPORTED_ERR: Raised if the implementation does not support 
     *   setting this attribute to <code>true</code>. 
     * @exception ExceptionVAL
     *   NO_SCHEMA_AVAILABLE_ERR: Raised if this attribute is set to 
     *   <code>true</code> and a schema is unavailable. 
     * @exception DOMException
     *   VALIDATION_ERR: Raised if an operation makes this document not 
     *   compliant with the <code>VAL_INCOMPLETE</code> validity type or the 
     *   document is invalid, and this attribute is set to <code>true</code>
     *   . 
     */
    public void setContinuousValidityChecking(boolean continuousValidityChecking)
                                  throws DOMException, ExceptionVAL, DOMException;

    /**
     *  This allows the setting of the error handler, as described in the [<a href='http://www.w3.org/TR/2003/CR-DOM-Level-3-Core-20031107'>DOM Level 3 Core</a>]
     *  <code>DOMConfiguration</code> interface. An object implementing this 
     * <code>DocumentEditVAL</code> interface and the [<a href='http://www.w3.org/TR/2003/CR-DOM-Level-3-Core-20031107'>DOM Level 3 Core</a>]
     *  <code>Document</code> interface, which also has a 
     * <code>domConfig</code> attribute, needs to only implement this 
     * attribute once. 
     */
    public DOMConfiguration getDomConfig();

    /**
     *  Returns list of all element information item names of global 
     * declaration, belonging to the specified namespace. 
     * @param namespaceURI <code>namespaceURI</code> of namespace. For DTDs, 
     *   this is <code>null</code>.
     * @return List of all element information item names belonging to the 
     *   specified namespace or <code>null</code> if no schema is available. 
     */
    public NameList getDefinedElements(String namespaceURI);

    /**
     * Validates the document against the schema, e.g., a DTD or an W3C XML 
     * schema or another. Any attempt to modify any part of the document 
     * while validating results in implementation-dependent behavior. In 
     * addition, the validation operation itself cannot modify the document, 
     * e.g., for default attributes. This method makes use of the error 
     * handler, as described in the [<a href='http://www.w3.org/TR/2003/CR-DOM-Level-3-Core-20031107'>DOM Level 3 Core</a>]
     *  <code>DOMConfiguration</code> interface, with all errors being 
     * <code>SEVERITY_ERROR</code> as defined in the <code>DOMError</code> 
     * interface. 
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short validateDocument();

}
