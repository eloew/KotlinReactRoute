package view.components

import react.*
import react.dom.*
import react.router.dom.*

class UserListComponentState : RState {
    var message: String = ""

}
//TODO: Study https://github.com/ojaynico/kotlin-js-react-gradle/tree/c1c82b8054346a83e2aefe262521038d275630c9
class UserListComponent<GroupView> : RComponent<RProps, UserListComponentState>() {
    override fun RBuilder.render() {
        h2 { +"UserListComponent.kt" }
        label { +state.message }

        //https://github.com/cschow-ucsd/ReeeWaste/search?q=navLInk&unscoped_q=navLInk
        navLink<DetailProps>("/detail/Eric") {
            +"Detail: Eric"
        }
        br{}
        navLink<DetailProps>("/detail/Jacob") {
            +"Detail: Jacob"
        }
    }
}

fun RBuilder.firstComponent(handler: RProps.() -> Unit): ReactElement {
    return child(UserListComponent::class) {
        this.attrs(handler)
    }
}
