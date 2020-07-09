package view

import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import react.router.dom.route

class FirstComponent<GroupView> : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        h2 { +"FirstComponent.kt" }
        button {
            attrs {
                onClickFunction = {
                     route("/", SecondComponent::class, exact = true)
                }
            }
            i {
                +"Second"
            }
        }
    }
}

fun RBuilder.firstComponent(handler: RProps.() -> Unit): ReactElement {
    return child(FirstComponent::class) {
        this.attrs(handler)
    }
}
