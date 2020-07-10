package view

import kotlinx.coroutines.CoroutineScope
import kotlinx.html.ButtonType
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import react.router.dom.hashRouter
import react.router.dom.route
import react.router.dom.routeLink
import react.router.dom.switch
import view.components.*

interface ApplicationProps : RProps {
    var coroutineScope: CoroutineScope

}

class ApplicationComponent : RComponent<ApplicationProps, RState>() {
    private val coroutineContext
        get() = props.coroutineScope.coroutineContext

    override fun RBuilder.render() {
        hashRouter {
            nav("navbar navbar-expand-lg navbar-dark bg-primary") {
                a(classes = "navbar-brand") {
                    attrs.onClickFunction = {
                        it.preventDefault()
                    }
                    +"KotlinReactRoute"
                }
                button(classes = "navbar-toggler", type = ButtonType.button) {
                    attrs["data-toggle"] = "collapse"
                    attrs["data-target"] = "#navbarNav"
                    attrs["aria-controls"] = "navbarNav"
                    attrs["aria-expanded"] = "false"
                    attrs["aria-label"] = "Toggle navigation"

                    span("navbar-toggler-icon") { }
                }
                div("collapse navbar-collapse") {
                    attrs["id"] = "navbarNav"
                    ul("navbar-nav mr-auto") {
                        li("nav-item active") { routeLink("/", className = "nav-link") { +"Home" } }
                        li("nav-item") { routeLink("/userList", className = "nav-link") { +"User List" } }
                        li("nav-item") { routeLink("/second", className = "nav-link") { +"Second" } }
                    }
                }
            }

            br {  }

            div("container") {
                switch {
                    // route("/", Home::class, exact = true)
                    route("/userList", FirstComponent::class, exact = true)
                    route("/second", SecondComponent::class, exact = true)
                    route<DetailProps>("/detail/:userName") { props ->
                        detail(props.match.params.userName)
                    }
                }
            }
        }
    }

}

external fun require(name: String): dynamic


