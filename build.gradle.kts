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

dependencies {
    implementation(kotlin("stdlib-js"))
    testCompile("junit", "junit", "4.12")

    //React, React DOM + Wrappers
    implementation("org.jetbrains:kotlin-react:16.13.0-pre.94-kotlin-1.3.70")
    implementation("org.jetbrains:kotlin-react-dom:16.13.0-pre.94-kotlin-1.3.70")
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.5")

    implementation(npm("react-router-dom", "4.3.1"))
    implementation(npm("@jetbrains/kotlin-react-router-dom", "4.3.1-pre.91"))

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
kotlin.target.browser { }
kotlin.target.nodejs { }
