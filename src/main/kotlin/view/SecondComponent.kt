package view

import kotlinx.coroutines.CoroutineScope
import react.*
import react.dom.*

class SecondComponent<GroupView> : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        h2 { +"SecondComponent.kt" }
    }
}

fun RBuilder.secondComponent(handler: RProps.() -> Unit): ReactElement {
    return child(SecondComponent::class) {
        this.attrs(handler)
    }
}
