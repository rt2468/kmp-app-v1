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
        
        // Use arrays instead of comma-separated strings to avoid casting issues
        property("sonar.sources", listOf(
            "composeApp/src/commonMain",
            "composeApp/src/androidMain", 
            "shared/src/commonMain",
            "shared/src/androidMain"
        ))
        
        property("sonar.tests", listOf(
            "composeApp/src/commonTest",
            "composeApp/src/androidTest",
            "shared/src/commonTest",
            "shared/src/androidTest"
        ))
        
        // Language settings
        property("sonar.kotlin.source.version", "1.9")
        property("sonar.java.source", "17")
        property("sonar.java.target", "17")
        
        // Exclusions
        property("sonar.exclusions", listOf(
            "**/build/**",
            "**/generated/**",
            "**/*.pb.kt",
            "**/R.java",
            "**/BuildConfig.java"
        ))
        
        // Coverage exclusions
        property("sonar.coverage.exclusions", listOf(
            "**/test/**",
            "**/androidTest/**",
            "**/*Test*/**"
        ))
        
        // Disable problematic rules that don't work well with KMP
        property("sonar.kotlin.gradlePluginPackaging.enabled", "false")
        property("sonar.kotlin.detekt.reportPaths", "")
    }
}
