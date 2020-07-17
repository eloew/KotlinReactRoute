plugins {
    id("org.jetbrains.kotlin.js") version "1.3.72"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    jcenter()
}

val reactRouterDomVersion = "5.1.2"
val kotlinWrappersVersion = "pre.110-kotlin-1.3.72"

dependencies {
    implementation(kotlin("stdlib-js"))
    testCompile("junit", "junit", "4.12")

    val reactVersion = "16.13.1"
    implementation("org.jetbrains:kotlin-react:$reactVersion-$kotlinWrappersVersion")

    implementation(npm("react", reactVersion))
    implementation("org.jetbrains:kotlin-react-dom:$reactVersion-$kotlinWrappersVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.5")

    val reactRouterDomVersion = "5.1.2"
    implementation("org.jetbrains:kotlin-react-router-dom:$reactRouterDomVersion-$kotlinWrappersVersion")

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
kotlin.target.browser { }
kotlin.target.nodejs { }
kotlin.target.useCommonJs()
