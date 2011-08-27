package kittyface.dom.core;

/**
DOM operations only raise exceptions in "exceptional" circumstances, i.e., when an operation is impossible to perform (either for logical reasons, because data is lost, or because the implementation has become unstable). In general, DOM methods return specific error values in ordinary processing situations, such as out-of-bound errors when using NodeList.

Implementations should raise other exceptions under other circumstances. For example, implementations should raise an implementation-dependent exception if a null argument is passed when null was not expected.

Some languages and object systems do not support the concept of exceptions. For such systems, error conditions may be indicated using native error reporting mechanisms. For some bindings, for example, methods may return error codes similar to those listed in the corresponding method descriptions.
*/
public class DOMException extends Exception {

	private short code;
	 
	public DOMException(short code){
		this.code = code;
	}
	 
	// ExceptionCode
	public final short INDEX_SIZE_ERR = 1;
	public final short DOMSTRING_SIZE_ERR = 2;
	public final short HIERARCHY_REQUEST_ERR = 3;
	public final short WRONG_DOCUMENT_ERR = 4;
	public final short INVALID_CHARACTER_ERR = 5;
	public final short NO_DATA_ALLOWED_ERR = 6;
	public final short NO_MODIFICATION_ALLOWED_ERR = 7;
	public final short NOT_FOUND_ERR = 8;
	public final short NOT_SUPPORTED_ERR = 9;
	public final short INUSE_ATTRIBUTE_ERR = 10;
	// Introduced in DOM Level 2:
	public final short INVALID_STATE_ERR = 11;
	// Introduced in DOM Level 2:
	public final short SYNTAX_ERR = 12;
	// Introduced in DOM Level 2:
	public final short INVALID_MODIFICATION_ERR = 13;
	// Introduced in DOM Level 2:
	public final short NAMESPACE_ERR = 14;
	// Introduced in DOM Level 2:
	public final short INVALID_ACCESS_ERR = 15;
	// Introduced in DOM Level 3:
	public final short VALIDATION_ERR = 16;
	// Introduced in DOM Level 3:
	public final short TYPE_MISMATCH_ERR = 17;
}