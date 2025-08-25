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
        
        // Configure source directories more precisely to avoid overlaps
        property("sonar.sources", listOf(
            "shared/src/commonMain/kotlin",
            "composeApp/src/commonMain/kotlin"
        ))
        
        property("sonar.tests", listOf(
            "shared/src/commonTest/kotlin",
            "composeApp/src/commonTest/kotlin"
        ))
        
        // Language settings
        property("sonar.kotlin.source.version", "1.9")
        property("sonar.java.source", "17")
        property("sonar.java.target", "17")
        
        // Exclusions - be more specific to avoid conflicts
        property("sonar.exclusions", listOf(
            "**/build/**",
            "**/generated/**",
            "**/*.pb.kt",
            "**/R.java",
            "**/BuildConfig.java",
            "**/src/androidMain/**", // Exclude Android-specific source sets
            "**/src/iosMain/**",     // Exclude iOS-specific source sets
            "**/src/desktopMain/**"  // Exclude Desktop-specific source sets
        ))
        
        // Coverage exclusions
        property("sonar.coverage.exclusions", listOf(
            "**/test/**",
            "**/androidTest/**",
            "**/*Test*/**",
            "**/src/androidMain/**",
            "**/src/iosMain/**",
            "**/src/desktopMain/**"
        ))
        
        // Disable problematic rules that don't work well with KMP
        property("sonar.kotlin.gradlePluginPackaging.enabled", "false")
        property("sonar.kotlin.detekt.reportPaths", "")
    }
}
