package view

import kotlinx.coroutines.CoroutineScope
import kotlinx.html.ButtonType
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import react.router.dom.*
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
                    route("/", exact = true) {
                        br{}
                        br{}
                        navLink<RProps>("/userList") {
                            +"User List"
                        }
                    }
                    route("/userList", UserListComponent::class, exact = true)
                    route("/second", SecondComponent::class, exact = true)
                    route<DetailProps>("/detail/:userName") { props ->
                        detail(props.match.params.userName)
                    }
                    redirect(from = "/detail/:userName", to = "/userList")
                }
            }
        }
    }

}

external fun require(name: String): dynamic


