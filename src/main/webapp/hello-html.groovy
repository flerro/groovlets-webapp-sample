
// if present use name parameter from
// query string (eg. ?name=Francesco)
// else use "World"

def name = params.name ?: "World"

// output some html

html.html {
    head {
        title "Hello from Groovlet!"
    }
    body {
        h1 "Hello, ${name}!"
    }
}