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

import org.w3c.dom.DOMException;

/**
 * This interface extends the <code>NodeEditVAL</code> interface with 
 * additional methods for document editing. An object implementing this 
 * interface must also implement <code>CharacterData</code> interface. When 
 * validating <code>CharacterData</code> nodes, the <a href='#NodeEditVAL-nodeValidity'>NodeEditVAL.nodeValidity</a> operation must find the nearest parent node in order to do this; if no 
 * parent node is found, <a href='#VAL-Interfaces-NodeEditVAL-VAL_UNKNOWN'>VAL_UNKNOWN </a> is returned. In addition, when <a href='#VAL-Interfaces-NodeEditVAL-VAL_INCOMPLETE'>VAL_INCOMPLETE </a> is passed in as an argument to the <code>NodeEditVAL.nodeValidity</code> 
 * operation to operate on such nodes, the operation considers all the text 
 * and not just some of it. 
 * <p>See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Val-20040127'>Document Object Model (DOM) Level 3 Validation Specification</a>.
 */
public interface CharacterDataEditVAL extends NodeEditVAL {
    /**
     * Determines if character data is only whitespace.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short isWhitespaceOnly();

    /**
     * Determines if character data can be set.
     * @param arg Argument to be set.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short canSetData(String arg);

    /**
     * Determines if character data can be appended.
     * @param arg Data to be appended.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short canAppendData(String arg);

    /**
     * Determines if character data can be replaced.
     * @param offset Offset.
     * @param count Replacement.
     * @param arg Argument to be set.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     * @exception DOMException
     *   INDEX_SIZE_ERR: Raised if the specified offset is negative or greater 
     *   than the number of 16-bit units in data, or if the specified count 
     *   is negative. 
     */
    public short canReplaceData(int offset, 
                                int count, 
                                String arg)
                                throws DOMException;

    /**
     * Determines if character data can be inserted.
     * @param offset Offset.
     * @param arg Argument to be set.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     * @exception DOMException
     *   INDEX_SIZE_ERR: Raised if the specified offset is negative or greater 
     *   than the number of 16-bit units in data. 
     */
    public short canInsertData(int offset, 
                               String arg)
                               throws DOMException;

    /**
     * Determines if character data can be deleted.
     * @param offset Offset.
     * @param count Number of 16-bit units to delete.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     * @exception DOMException
     *   INDEX_SIZE_ERR: Raised if the specified offset is negative or greater 
     *   than the number of 16-bit units in data, or if the specified count 
     *   is negative. 
     */
    public short canDeleteData(int offset, 
                               int count)
                               throws DOMException;

}
