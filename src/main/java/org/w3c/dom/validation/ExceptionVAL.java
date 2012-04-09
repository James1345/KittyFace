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

/**
 *  Some Validation operations may throw an <code>ExceptionVAL</code> as 
 * described in their descriptions. 
 * <p>See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Val-20040127'>Document Object Model (DOM) Level 3 Validation Specification</a>.
 */
public class ExceptionVAL extends RuntimeException {
    public ExceptionVAL(short code, String message) {
       super(message);
       this.code = code;
    }
    public short   code;
    // ExceptionVALCode
    /**
     *  This error occurs when the operation cannot complete due to an 
     * unavailable schema. 
     */
    public static final short NO_SCHEMA_AVAILABLE_ERR   = 71;

}
