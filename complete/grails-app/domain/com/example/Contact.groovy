package com.example

class Contact {

    String contactId

    Long contactNo

    Date contactsAddedOn = new Date()


    static belongsTo = [ customer: Customer ]

    static constraints = {
    }

    static mapping = {
        table 'CUS_CONTACTS'
    }

}
