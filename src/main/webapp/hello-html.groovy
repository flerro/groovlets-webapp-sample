
// if present use name parameter from
// query string (eg. ?name=Francesco)
// else use "World"

def name = params.name ?: "World"

// Output some html using the
// built-in Markup builder

html.html {
    head {
        title "Hello from Groovlet!"
    }
    body {
        h1 "Hello, ${name}!"
    }
}