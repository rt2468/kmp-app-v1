plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.sonarqube) apply true
}

sonarqube {
    properties {
        property("sonar.projectName", "KMP App")
        property("sonar.projectKey", "kmp-sq_project")
        property("sonar.organization", "kmp-sq")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.token", System.getenv("SONAR_TOKEN"))

        property("sonar.language", "kotlin")
        property("sonar.sourceEncoding", "UTF-8")

        // ✅ Only main source directories
        property(
            "sonar.sources",
            "composeApp/src/androidMain/kotlin,shared/src/commonMain/kotlin"
        )

        // ✅ Only test directories
        property(
            "sonar.tests",
            "composeApp/src/androidUnitTest/kotlin,shared/src/commonTest/kotlin"
        )

        // ✅ Exclusions
        property("sonar.exclusions", "**/build/**,**/*.gradle.kts")
    }
}
