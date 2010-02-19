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
class CanonicalTagLib {
	static namespace = 'canonical'
	static final URI_ATTRIBUTE = 'canonical.uri'
	static final EXCLUDE_ATTRIBUTE = 'canonical.exclude'
		
	def show = { attrs, body ->
		def link
		
		// override auto-resolution with a specific uri if provided
		def uri = request[URI_ATTRIBUTE]
		if (uri) {
			link = uri = g.createLink(absolute:true, uri:uri)
		} else if (controllerName && actionName) {
			// otherwise resolve using reverse mapping
		    // first clearing 'excluded' params
			request[EXCLUDE_ATTRIBUTE].each { 
				params.remove(it)
			}
			// sort the params so they are always in the same order,
			// thus 'canonical'
			def sortedParams = params.empty ? params : new TreeMap(params)
			link = g.createLink(absolute:true, controller:controllerName, action:actionName, params:sortedParams) 
		}
		if (link) {
			out << '<link rel="canonical" href="' + link + '"/>'
		}
	}
	
	def set = { attrs, body ->
		// set uri in request attribute for later use in canonical tag output
	    request[URI_ATTRIBUTE] = attrs.uri
	}
	
	def exclude = { attrs, body ->
		// add list of excluded output to current list:
		// this means exclude can be called multiple times to build up a list
		// (e.g. once from a layout for global excluded, and from a specific page
		// for request-specific excludes)
		request[EXCLUDE_ATTRIBUTE] = attrs.params += request[EXCLUDE_ATTRIBUTE]
	}

}
