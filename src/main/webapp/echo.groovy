import groovy.json.JsonSlurper

// Handling post request:
// eg.
//    curl -X POST -H "Content-Type:application/json" -d '{"name": "Francesco"}' \
//          http://localhost:8080/groovlets-webapp-sample/echo.groovy
//
// Output =>
//  {
//    "echo": {
//        "original": {
//            "name": "Francesco"
//          }
//     }
//  }

response.contentType = 'application/json'

try {
    // Access headers, with context bound variable

    if (headers['Content-Type'] != "application/json") {
        throw new RuntimeException("Please use 'application/json' header")
    }

    def jsonContent = request.reader.text

    def content = null
    if (jsonContent) {
        content = new JsonSlurper()
                    .parseText(jsonContent)
    }

    // output some JSON
    json."echo" {
        "original" content
    }

} catch (Exception ex) {
   json."echo" {
        "error" "${ex.message}"
    }
}

