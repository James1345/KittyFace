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

import org.w3c.dom.Node;
import org.w3c.dom.DOMStringList;

/**
 * This interface is similar to the [<a href='http://www.w3.org/TR/2003/CR-DOM-Level-3-Core-20031107'>DOM Level 3 Core</a>]
 *  <code>Node</code> interface, with methods for guided document editing.
 * <p>See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Val-20040127'>Document Object Model (DOM) Level 3 Validation Specification</a>.
 */
public interface NodeEditVAL {
    // validationType
    /**
     * Check if the node is  well-formed.
     */
    public static final short VAL_WF                    = 1;
    /**
     * Check if the node is namespace well-formed. 
     */
    public static final short VAL_NS_WF                 = 2;
    /**
     * Check if the node's immediate children are those expected by the 
     * content model. This node's trailing required children could be 
     * missing. It includes <code>VAL_NS_WF</code>. 
     */
    public static final short VAL_INCOMPLETE            = 3;
    /**
     *  Check if the node's entire subtree are those expected by the content 
     * model. It includes <code>VAL_NS_WF</code>. 
     */
    public static final short VAL_SCHEMA                = 4;

    // validationState
    /**
     *  True if the node is valid with regards to the operation, or if the 
     * operation can be done. 
     */
    public static final short VAL_TRUE                  = 5;
    /**
     *  False if the node is invalid with regards to the operation, or if the 
     * operation cannot be done. 
     */
    public static final short VAL_FALSE                 = 6;
    /**
     *  The validity of the node is unknown. 
     */
    public static final short VAL_UNKNOWN               = 7;

    /**
     *  The default value specified in an attribute or an element declaration 
     * or <code>null</code> if unspecified. If the schema is a W3C XML 
     * schema, this is the canonical lexical representation of the default 
     * value. 
     */
    public String getDefaultValue();

    /**
     *  A <code>DOMStringList</code>, as described in [<a href='http://www.w3.org/TR/2003/CR-DOM-Level-3-Core-20031107'>DOM Level 3 Core</a>]
     * , of distinct values for an attribute or an element declaration or 
     * <code>null</code> if unspecified. If the schema is a W3C XML schema, 
     * this is a list of strings which are lexical representations 
     * corresponding to the values in the [value] property of the 
     * enumeration component for the type of the attribute or element. It is 
     * recommended that the canonical lexical representations of the values 
     * be used. 
     */
    public DOMStringList getEnumeratedValues();

    /**
     * Determines whether the <code>Node.insertBefore</code> operation would 
     * make this document not compliant with the <code>VAL_INCOMPLETE</code> 
     * validity type. 
     * @param newChild <code>Node</code> to be inserted.
     * @param refChild Reference <code>Node</code>.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short canInsertBefore(Node newChild, 
                                 Node refChild);

    /**
     *  Determines whether the <code>Node.removeChild</code> operation would 
     * make this document not compliant with the <code>VAL_INCOMPLETE</code> 
     * validity type. 
     * @param oldChild <code>Node</code> to be removed.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short canRemoveChild(Node oldChild);

    /**
     *  Determines whether the <code>Node.replaceChild</code> operation would 
     * make this document not compliant with the <code>VAL_INCOMPLETE</code> 
     * validity type. 
     * @param newChild New <code>Node</code>.
     * @param oldChild <code>Node</code> to be replaced.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short canReplaceChild(Node newChild, 
                                 Node oldChild);

    /**
     *  Determines whether the <code>Node.appendChild</code> operation would 
     * make this document not compliant with the <code>VAL_INCOMPLETE</code> 
     * validity type. 
     * @param newChild <code>Node</code> to be appended.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short canAppendChild(Node newChild);

    /**
     * Determines if the node is valid relative to the <a href='#NodeEditVAL-validationType'>validation type</a> specified in <code>valType</code>. This operation doesn't normalize 
     * before checking if it is valid. To do so, one would need to 
     * explicitly call a normalize method. The difference between this 
     * method and the <a href='#VAL-Interfaces-DocumentEditVAL-validateDocument'>
     * DocumentEditVAL.validateDocument</a> method is that the latter method only checks to determine whether the 
     * entire document is valid. 
     * @param valType Flag to indicate the <a href='#NodeEditVAL-validationType'>validation type</a> checking to be done. 
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short nodeValidity(short valType);

}
