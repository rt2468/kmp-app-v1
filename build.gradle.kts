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
        
        // Source directories
        property("sonar.sources", "composeApp/src/main,shared/src/commonMain")
        property("sonar.tests", "composeApp/src/test,shared/src/commonTest")
        
        // Kotlin-specific settings
        property("sonar.kotlin.source.version", "1.9")
        
        // Exclude build directories
        property("sonar.exclusions", "**/build/**")
    }
}
