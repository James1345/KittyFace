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
import org.w3c.dom.Attr;
import org.w3c.dom.NameList;

/**
 * This interface extends the <code>NodeEditVAL</code> interface with 
 * additional methods for guided document editing. An object implementing 
 * this interface must also implement the <code>Element</code> interface. 
 * <p> This interface also has attributes that are a <code>NameList</code> of 
 * elements or attributes which can appear in the specified context. Some 
 * schema languages, i.e., <a href='http://www.w3.org/TR/xmlschema-1/#Wildcards'>W3C XML schema</a>, define wildcards which provide for validation of attribute and element 
 * information items dependent on their namespace names but independent of 
 * their local names. 
 * <p>To expose wildcards, the <code>NameList</code> returns the values that 
 * represent the <a href='http://www.w3.org/TR/xmlschema-1/#namespace_constraint'> namespace 
 * constraint</a>: 
 * <ul>
 * <li> <code>{namespaceURI, name}</code> is <code>{null, ##any}</code> if <em>any</em>; 
 * </li>
 * <li> <code>{namespaceURI, name}</code> is 
 * <code>{namespace_a, ##other}</code> if <em>not and a namespace name (namespace_a)</em>; 
 * </li>
 * <li> <code>{namespaceURI, name}</code> is <code>{null, ##other}</code> if <em>not and absent</em>; 
 * </li>
 * <li> Pairs of <code>{namespaceURI, name}</code> with values 
 * <code>{a_namespaceURI | null, null}</code> if <em>a set whose members are either namespace names or absent</em>. 
 * </li>
 * </ul>
 * <p>See also the <a href='http://www.w3.org/TR/2004/REC-DOM-Level-3-Val-20040127'>Document Object Model (DOM) Level 3 Validation Specification</a>.
 */
public interface ElementEditVAL extends NodeEditVAL {
    // ContentTypeVAL
    /**
     * The content model does not allow any <a href='http://www.w3.org/TR/REC-xml#dt-content'>content</a>. If the schema is a W3C XML schema, this corresponds to the 
     * <code>empty</code> content type; and if the schema is a DTD, this 
     * corresponds to the <code>EMPTY</code> content model. 
     */
    public static final short VAL_EMPTY_CONTENTTYPE     = 1;
    /**
     * The content model contains unordered child information item(s), i.e., 
     * element, processing instruction, unexpanded entity reference, 
     * character, and comment information items as defined in the <a href='http://www.w3.org/TR/xml-infoset/'>XML Information Set</a>. If the schema is a DTD, this corresponds to the <code>ANY</code> content 
     * model. 
     */
    public static final short VAL_ANY_CONTENTTYPE       = 2;
    /**
     * The content model contains a sequence of ordered <a href='http://www.w3.org/TR/xml-infoset/#infoitem.element'>element 
     * information items</a> optionally interspersed with character data. If the schema is a W3C XML 
     * schema, this corresponds to the <code>mixed</code> content type. 
     */
    public static final short VAL_MIXED_CONTENTTYPE     = 3;
    /**
     * The content model contains a sequence of <a href='http://www.w3.org/TR/xml-infoset/#infoitem.element'>element 
     * information items</a> optionally separated by whitespace. If the schema is a DTD, this is the 
     * <code>element content</code> content model; and if the schema is a 
     * W3C XML schema, this is the <code>element-only</code> content type. 
     */
    public static final short VAL_ELEMENTS_CONTENTTYPE  = 4;
    /**
     * The content model contains <a href='http://www.w3.org/TR/xml-infoset/#infoitem.character'> character 
     * information items</a>. If the schema is a W3C XML schema, then the element has a content type 
     * of <code>VAL_SIMPLE_CONTENTTYPE</code> if the type of the element is 
     * a <code>simple type definition</code>, or the type of the element is 
     * a <code>complexType</code> whose <code>{content type}</code> is a 
     * <code>simple type definition</code>. 
     */
    public static final short VAL_SIMPLE_CONTENTTYPE    = 5;

    /**
     * A <code>NameList</code>, as described in [<a href='http://www.w3.org/TR/2003/CR-DOM-Level-3-Core-20031107'>DOM Level 3 Core</a>]
     * , of all possible element information items or <a href='#VAL-Interfaces-ElementEditVAL'>wildcards</a> that can appear as children of this element, or <code>null</code> if this 
     * element has no context or schema. Duplicate pairs of {namespaceURI, 
     * name} are eliminated. 
     */
    public NameList getAllowedChildren();

    /**
     * A <code>NameList</code>, as described in [<a href='http://www.w3.org/TR/2003/CR-DOM-Level-3-Core-20031107'>DOM Level 3 Core</a>]
     * , of all possible element information items or <a href='#VAL-Interfaces-ElementEditVAL'>wildcards</a> that can appear as a first child of this element, or <code>null</code> if 
     * this element has no context or schema. Duplicate pairs of 
     * {namespaceURI, name} are eliminated. 
     */
    public NameList getAllowedFirstChildren();

    /**
     * A <code>NameList</code>, as described in [<a href='http://www.w3.org/TR/2003/CR-DOM-Level-3-Core-20031107'>DOM Level 3 Core</a>]
     * , of all possible element information items that can appear as a 
     * parent this element, or <code>null</code> if this element has no 
     * context or schema. 
     */
    public NameList getAllowedParents();

    /**
     * A <code>NameList</code>, as described in [<a href='http://www.w3.org/TR/2003/CR-DOM-Level-3-Core-20031107'>DOM Level 3 Core</a>]
     * , of all element information items or <a href='#VAL-Interfaces-ElementEditVAL'>wildcards</a> that can be inserted as a next sibling of this element, or 
     * <code>null</code> if this element has no context or schema. Duplicate 
     * pairs of {namespaceURI, name} are eliminated. 
     */
    public NameList getAllowedNextSiblings();

    /**
     * A <code>NameList</code>, as described in [<a href='http://www.w3.org/TR/2003/CR-DOM-Level-3-Core-20031107'>DOM Level 3 Core</a>]
     * , of all element information items or <a href='#VAL-Interfaces-ElementEditVAL'>wildcards</a> that can be inserted as a previous sibling of this element, or 
     * <code>null</code> if this element has no context or schema. 
     */
    public NameList getAllowedPreviousSiblings();

    /**
     * A <code>NameList</code>, as described in [<a href='http://www.w3.org/TR/2003/CR-DOM-Level-3-Core-20031107'>DOM Level 3 Core</a>]
     * , of all possible attribute information items or <a href='#VAL-Interfaces-ElementEditVAL'>wildcards</a> that can appear as attributes of this element, or <code>null</code> if 
     * this element has no context or schema. Duplicate pairs of 
     * {namespaceURI, name} are eliminated. 
     */
    public NameList getAllowedAttributes();

    /**
     * A <code>NameList</code>, as described in [<a href='http://www.w3.org/TR/2003/CR-DOM-Level-3-Core-20031107'>DOM Level 3 Core</a>]
     * , of required attribute information items that must appear on this 
     * element, or <code>null</code> if this element has no context or 
     * schema. 
     */
    public NameList getRequiredAttributes();

    /**
     * The content type of an element as defined <a href='#ElementEditVAL-ContentTypeVAL'>above</a>. 
     */
    public short getContentType();

    /**
     *  Determines if the text content of this node and its descendants can be 
     * set to the string passed in. 
     * @param possibleTextContent Possible text content string.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short canSetTextContent(String possibleTextContent);

    /**
     * Determines if the value for specified attribute can be set.
     * @param attrname Name of attribute.
     * @param attrval Value to be assigned to the attribute.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short canSetAttribute(String attrname, 
                                 String attrval);

    /**
     * Determines if an attribute node can be added. 
     * @param attrNode <code>Node</code> in which the attribute can possibly 
     *   be set.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short canSetAttributeNode(Attr attrNode);

    /**
     * Determines if the attribute with given namespace and qualified name can 
     * be created if not already present in the attribute list of the 
     * element. If the attribute with the same qualified name and 
     * namespaceURI is already present in the element's attribute list, it 
     * tests whether the value of the attribute and its prefix can be set to 
     * the new value. 
     * @param namespaceURI <code>namespaceURI</code> of namespace.
     * @param qualifiedName Qualified name of attribute.
     * @param value Value to be assigned to the attribute.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short canSetAttributeNS(String namespaceURI, 
                                   String qualifiedName, 
                                   String value);

    /**
     * Verifies if an attribute by the given name can be removed.
     * @param attrname Name of attribute.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short canRemoveAttribute(String attrname);

    /**
     * Verifies if an attribute by the given local name and namespace can be 
     * removed.
     * @param namespaceURI The namespace URI of the attribute to remove.
     * @param localName Local name of the attribute to be removed.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short canRemoveAttributeNS(String namespaceURI, 
                                      String localName);

    /**
     * Determines if an attribute node can be removed.
     * @param attrNode The <code>Attr</code> node to remove from the 
     *   attribute list.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short canRemoveAttributeNode(Node attrNode);

    /**
     * Determines if <code>name</code> is defined in the schema. This only 
     * applies to global declarations. This method is for non-namespace 
     * aware schemas. 
     * @param name Name of element.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short isElementDefined(String name);

    /**
     * Determines if <code>name</code> in this namespace is defined in the 
     * current context. Thus not only does this apply to global declarations
     * . but depending on the content, this may also apply to local 
     * definitions. This method is for namespace aware schemas. 
     * @param namespaceURI <code>namespaceURI</code> of namespace.
     * @param name Name of element.
     * @return  A <a href='#NodeEditVAL-validationState'>validation state</a> constant. 
     */
    public short isElementDefinedNS(String namespaceURI, 
                                    String name);

}
