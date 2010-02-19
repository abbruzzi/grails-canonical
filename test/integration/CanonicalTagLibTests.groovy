import grails.test.GroovyPagesTestCase

class CanonicalTagLibTests extends GroovyPagesTestCase {
	
	void testSetUri() {
		def set = '<canonical:set uri="/test/me" />'
		applyTemplate(set, null)
		def show = '<canonical:show />'
		assertEquals '<link rel="canonical" href="http://localhost:8080/test/me"/>', 
				applyTemplate(show, null)
	}

	// Need to investigate options around configuration of the MockHttpServletRequest
	// in order to write meaningful tests with input as a URL and output as the
	// result of the canonical:show call: tests should show that an array of
	// different URLs result in the same canonical tag
}
