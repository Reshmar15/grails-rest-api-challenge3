package com.example

import grails.plugin.json.view.test.JsonViewTest
import org.skyscreamer.jsonassert.JSONAssert
import grails.test.hibernate.HibernateSpec

class ContactShowV1Spec extends HibernateSpec implements JsonViewTest {

    def "test json output uses custom id instead of database id"() {
        setup:

        def customers = BootStrap.fixtureCustomers()
        def contacts  = BootStrap.fixtureContact( customers)

        when:
        def contact = contacts.first()
        def result = render(view: "/contact/show_v1", model:[contact: Contact])

        then:
        result.json.id == '0A12321'

        when:
        def expectedJsonString = '''
        {
            id: "0A12321",
            contactNo: 13.54,
            date: "2-08-2017",

            customer: {
                id: 1
            }
        }
        '''
        JSONAssert.assertEquals(expectedJsonString, result.jsonText, false)

        then:
        notThrown AssertionError
    }
}
