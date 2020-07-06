package com.example

class UrlMappings {

    static mappings = {

        // tag::urlMappingsWithResources[]
        "/api/products"(resources: "product")
        // end::urlMappingsWithResources[]
        get "/api/contacts/v1/$id"(controller: 'contact', action: 'showv1')
        get "/api/contacts/v2/$id"(controller: 'contact', action: 'showv2')
        get "/api/contacts/v3/$id"(controller: 'contact', action: 'showv3')
        get "/api/contacts/v4/$id"(controller: 'contact', action: 'showv4')
        delete "/api/contacts/$id(.$format)?"(controller: 'contact', action:"delete")
        get "/api/contacts(.$format)?"(controller: 'contact', action:"index")
        get "/api/contacts/$id(.$format)?"(controller: 'contact', action:"show")
        post "/api/contacts(.$format)?"(controller: 'contact', action:"save")
        put "/api/contacts/$id(.$format)?"(controller: 'contact', action:"update")
        patch "/api/contacts/$id(.$format)?"(controller: 'contact', action:"patch")

        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")


        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
