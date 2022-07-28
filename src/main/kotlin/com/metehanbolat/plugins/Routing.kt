package com.metehanbolat.plugins

import com.metehanbolat.routes.getHero
import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*

fun Application.configureRouting() {

    routing {
        getHero()

        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}
