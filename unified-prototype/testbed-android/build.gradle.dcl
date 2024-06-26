plugins {
    id("org.gradle.experimental.android-application")
}

androidApplication {
    namespace = "com.example.myapplication"
    compileSdk = 33
}

// changed a little to not interfere with non declarative plugin
declarativeDependencies {
    implementation("com.google.guava:guava:32.1.2-jre")
    implementation("org.apache.commons:commons-lang3:3.13.0")
}