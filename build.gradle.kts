plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    //alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.sonarqube) apply true
}

// SonarQube configuration
sonarqube {
    properties {
        property("sonar.projectName", "KMP App")
        property("sonar.projectKey", "kmp-sq_project")
        property("sonar.organization", "kmp-sq")
        property("sonar.host.url", "https://sonarcloud.io")

        // Kotlin project specifics
        property("sonar.language", "kotlin")

        // ✅ Only include Android + Shared (skip iOS)
        property("sonar.sources", "composeApp/src,shared/src")

        // Optional: if tests are in same folders, they’ll be auto-detected.
        property("sonar.tests", "composeApp/src,shared/src")

        // Encoding and exclusions
        property("sonar.sourceEncoding", "UTF-8")
        property("sonar.exclusions", "**/build/**,**/*.gradle.kts")

        property("sonar.language", "kotlin")
        property("sonar.sourceEncoding", "UTF-8")

        // ✅ Sources (main code only)
        property("sonar.sources", "composeApp/src/androidMain/kotlin,shared/src/commonMain/kotlin")

        // ✅ Tests (test code only)
        property("sonar.tests", "composeApp/src/androidUnitTest/kotlin,shared/src/commonTest/kotlin")

        // ✅ Exclude build and gradle
        property("sonar.exclusions", "**/build/**,**/*.gradle.kts")
      
    }
}
