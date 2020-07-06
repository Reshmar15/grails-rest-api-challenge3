package com.example

import grails.rest.*

@Resource(readOnly = true, uri='/api/customers') //<1>
class Customer {

    String firstName
    String lastName

//    Address address

    static hasMany = [ contacts: Contact ]

    static constraints = {
        contacts nullable: true
    }
}
