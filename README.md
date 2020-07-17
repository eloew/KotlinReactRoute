# KotlinReactRoute

## Sample app using kotlin-react-router-dom



./gradlew run<br/><br/>
Error in browser:<br/>
Error: Cannot find module 'kotlin-react-router-dom'
<br/><br/>
Noticed that build/js/node_modules does not have kotlin-react-router-dom
<br/>
Solution:<br/>
Incorection imports. Changed to:
* implementation("org.jetbrains:kotlin-react-router-dom:$reactRouterDomVersion-$kotlinWrappersVersion")
* implementation(npm("react-router-dom", reactRouterDomVersion))
<br/><br/>References<br/>
* [slack-kotlinlang-react](https://kotlinlang.slack.com/archives/C5ZTZ6ER0/p1594290494103300)
* [Anyone get the react router working?...withRouter](https://kotlinlang.slack.com/archives/C5ZTZ6ER0/p1564879364011300)
* [ojaynico/kotlin-js-react-gradle](https://github.com/ojaynico/kotlin-js-react-gradle/tree/c1c82b8054346a83e2aefe262521038d275630c9)
* [felipehjcosta/chat-app](https://github.com/felipehjcosta/chat-app/tree/d8504c6e42ac209965aef52a38ed8c5efee52bb4)
