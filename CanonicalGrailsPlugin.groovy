class CanonicalGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.2.1 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/**",
            "grails-app/controllers/ExampleController.groovy"
    ]

    // TODO Fill in these fields
    def author = "Jeff Abbruzzi"
    def authorEmail = "jeff@abbruzzi.com"
    def title = "Canonical Tagging Plugin for SEO"
    def description = '''\\
    	Enables auto-resolution of canonical link metadata for SEO optimization.
    	Addition of a single taglib call to a master layout will add SEO-friendly
    	canonical URL metadata to your pages, relying on Grails UrlMappings to
    	derive a single absolute canonical URL for any request. Query parameters are sorted,
    	and can individual parameters can optionally be excluded from the canonical URL
    	globally and for specific requests (for example, a session parameter
    	or marketing-related tracking parameters.) Finally, auto-resolution can be overriden
    	at the request-level with a specific URI if and when needed.
    	See (google blog) for details on this practice.
    '''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/canonical"

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before 
    }

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
