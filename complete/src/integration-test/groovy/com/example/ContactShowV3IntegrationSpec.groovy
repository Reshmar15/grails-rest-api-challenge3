package com.example

import grails.testing.mixin.integration.Integration
import grails.testing.spock.OnceBefore
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.http.uri.UriBuilder
import org.skyscreamer.jsonassert.JSONAssert
import spock.lang.Specification

@Integration
class ContactShowV3IntegrationSpec extends Specification {
    BlockingHttpClient client

    @OnceBefore
    void init() {
        String baseUrl = "http://localhost:$serverPort"
        this.client  = HttpClient.create(baseUrl.toURL()).toBlocking()
    }

    def "test collection _links appear in JSON"() {
        when:
        HttpRequest request = HttpRequest.GET(UriBuilder.of('/api/contacts/v3/1')
                .queryParam('lang', 'en')
                .build())
        HttpResponse<String> resp = client.exchange(request, String)
        def expectedJsonString = """
        {
            _links: {
                self: {
                    href: "http://localhost:${serverPort}/api/contacts?id=1",
                  //  hreflang: "en",
                  //  type: "application/hal+json"
                },
                customer: {
                    href: "http://localhost:${serverPort}/api/customers?id=1",
                  //  hreflang: "en",
                  //  type: "application/hal+json"
                }
            },
            id: "0A12321",
            contactNo: 876543322,
            date: "2-08-2017",


        }
        """
        JSONAssert.assertEquals(expectedJsonString, resp.body().toString(), false)

        then:
        notThrown AssertionError
    }
}
