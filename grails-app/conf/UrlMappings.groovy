class UrlMappings {
    static mappings = {
      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
	
	  "/someMapping/$id"(
		  controller: 'example',
		  action: 'mapped'
	  )
	
      "/"(view:"/index")
	  "500"(view:'/error')
	}
}
