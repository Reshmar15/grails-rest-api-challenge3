package com.example

import grails.plugin.json.view.test.JsonViewTest
import grails.test.hibernate.HibernateSpec
import org.skyscreamer.jsonassert.JSONAssert

class ContactShowV4Spec extends HibernateSpec implements JsonViewTest {

    def "test customer users _embedded appear in JSON"() {
        setup:
        mappingContext.addPersistentEntity(Customer)

        //def (Category clothing, Category furniture, Category tools) = BootStrap.fixtureCategories()
      //  def products = BootStrap.fixtureProducts(clothing, furniture, tools)
        def customers = BootStrap.fixtureCustomers()
        def contacts  = BootStrap.fixtureContacts(customers)

        when:
        def contact = contacts.first()
        def result = render(view: "/contact/show_v4", model:[contact: Contacts])

        then:
        result.json._embedded
    }
}
