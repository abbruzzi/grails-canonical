/*   Copyright 2010 Jeffrey M. Abbruzzi
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*/
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
