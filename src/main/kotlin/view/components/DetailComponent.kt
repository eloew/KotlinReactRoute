package view.components

import react.*
import react.dom.br
import react.dom.h2
import react.dom.label
import react.router.dom.navLink

external interface DetailProps : RProps {
    var userName: String
}


class DetailComponent<GroupView> : RComponent<DetailProps, RState>() {
    override fun RBuilder.render() {
        h2 { +"DetailComponent.kt" }
        br {  }
        label { +"userName: "}
        label { +props.userName }
        br{}
        br{}
        navLink<DetailProps>("/first") {
            +"First"
        }
    }
}

fun RBuilder.detail(userName: String): ReactElement {
    return child(DetailComponent::class) {
        this.attrs.userName = userName
    }
}
