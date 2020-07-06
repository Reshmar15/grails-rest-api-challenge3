package com.example

import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->
        log.info "Loading database..."



       List<Customer> customers = fixtureCustomers()

        fixtureContact(customers)

    }

    static List<Contact> fixtureContact(List<Customer> customers) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')
        def contacts = [
                [contactId: "0A12321", contactNo: 876543322, customer: customers[0],  contactsAddedOn: simpleDateFormat.parse('2017-02-08 10:10:36')],
                [contactId: "0A16546", contactNo: 6433556777, customer: customers[0]],
                [contactId: "0A27345", contactNo: 603556777, customer: customers[1]],
                [contactId: "0A78129", contactNo: 987654433 ],
                [contactId: "0F35439", contactNo: 67543333 ],
                [contactId: "0F35523", contactNo: 60007800, customer: customers[3]]
        ].collect { new Contact(it) }
        contacts.collect { contact ->
            Contact.withTransaction {
                contact.save()
            }
        }
    }

    static List<Customer> fixtureCustomers() {
        def customers = [
                [firstName: "Peter", lastName: "River" ],
                [firstName: "Ann", lastName: "Hughes" ],
                [firstName: "Rogelio", lastName: "Alvarado" ],
                [firstName: "Leona", lastName: "Pittman" ]
        ].collect { new Customer(it)}
        customers.collect { customer ->
            Customer.withTransaction {
                customer.save()
            }
        }
    }


    def destroy = {
    }
}
