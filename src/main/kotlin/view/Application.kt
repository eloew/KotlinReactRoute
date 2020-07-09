package view

import kotlinx.coroutines.CoroutineScope
import react.*
import react.dom.*

interface ApplicationProps : RProps {
    var coroutineScope: CoroutineScope

}

class ApplicationComponent : RComponent<ApplicationProps, RState>() {
    private val coroutineContext
        get() = props.coroutineScope.coroutineContext

    override fun RBuilder.render() {
        h1 { +"Application.kt" }
        br {  }
        firstComponent {  }
    }

}

external fun require(name: String): dynamic


