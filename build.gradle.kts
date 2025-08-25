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

        property("sonar.language", "kotlin")
        property("sonar.sourceEncoding", "UTF-8")

        // ✅ Main source sets only (no parent dirs)
        property("sonar.sources",
            "composeApp/src/androidMain/kotlin," +
            "shared/src/commonMain/kotlin"
        )

        // ✅ Test source sets only
        property("sonar.tests",
            "composeApp/src/androidUnitTest/kotlin," +
            "shared/src/commonTest/kotlin"
        )

        // ✅ Exclusions
        property("sonar.exclusions", "**/build/**,**/*.gradle.kts")
    }
}
