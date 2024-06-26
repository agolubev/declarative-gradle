plugins {
    `kotlin-dsl`
}

description = "Implements the declarative Android DSL prototype"

dependencies {
    implementation(project(":plugin-common"))
    implementation(libs.android.agp.application)
    implementation(libs.android.kotlin.android)
}

gradlePlugin {
    plugins {
        create("android-plugin") {
            id = "org.gradle.experimental.android-application"
            implementationClass = "org.gradle.api.experimental.android.StandaloneAndroidApplicationPlugin"
        }
    }
}

// Compile against Java 17 since Android requires Java 17 at minimum
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}