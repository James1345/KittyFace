package kittyface.dom.html;

import kittyface.dom.core.*;

/**
All HTML element interfaces derive from this class. Elements that only expose the HTML core attributes are represented by the base HTMLElement interface. These elements are as follows:
<ul>
<li>special: SUB, SUP, SPAN, BDO</li>
<li>font: TT, I, B, U, S, STRIKE, BIG, SMALL</li>
<li>phrase: EM, STRONG, DFN, CODE, SAMP, KBD, VAR, CITE, ACRONYM, ABBR</li>
<li>list: DD, DT</li>
<li>NOFRAMES, NOSCRIPT</li>
<li>ADDRESS, CENTER</li>
</ul>
Note: The style attribute of an HTML element is accessible through the ElementCSSInlineStyle interface which is defined in the CSS module [DOM Level 2 Style Sheets and CSS].
*/
public interface HTMLElement extends Element {

	private String id;
	public String getId();
	public void setId(String id);
	
	private String title;
	public String getTitle();
	public String setTitle(String title);
	
	private String lang;
	public String getLang();
	public void setLang(String lang);
	
	private String dir;
	public String getDir;
	public void setDir(String dir);
	
	private String className;
	public String getClassName();
	public void setClassName(String className);
	
}