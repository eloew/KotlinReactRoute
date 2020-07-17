package view.components

import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import react.router.dom.navLink
import kotlin.browser.window


external interface DetailProps : RProps {
    var userName: String
}

class DetailState : RState {
    var message = ""
}

class DetailComponent<GroupView> : RComponent<DetailProps, DetailState>() {

    init {
        state = DetailState()
    }


    override fun RBuilder.render() {
        h2 { +"DetailComponent.kt" }
        br {  }
        div {
            label { +state.message }
        }
        br {}
        label { +"userName: "}
        label { +props.userName }
        br{}
        br{}
        button(classes = "btn btn-primary") {
            attrs {
                onClickFunction = {
                    //some code to save
                    window.location.hash = "/userList"
                }
            }
            i {
                +"Save"
            }
        }
    }
}

fun RBuilder.detail(userName: String): ReactElement {
    return child(DetailComponent::class) {
        this.attrs.userName = userName
    }
}
