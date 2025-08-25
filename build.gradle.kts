plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.sonarqube) // Important: do not use apply false!
    alias(libs.plugins.kover)
}
sonarqube {
    properties {
        val koverReport = allprojects.mapNotNull { project ->
            val reportPath = "${project.projectDir}/build/reports/kover/report.xml"
            if (File(reportPath).exists()) reportPath else null
        }.joinToString(",")
        property("sonar.coverage.jacoco.xmlReportPaths", koverReport)
    }
}
tasks.named("sonar") {
    dependsOn(subprojects.map { it.tasks.named("koverXmlReport") })
}
//
//sonarqube {
//    properties {
//        property("sonar.projectName", "KMP App")
//        property("sonar.projectKey", "kmp-sq_project")
//        property("sonar.organization", "kmp-sq")
//        property("sonar.host.url", "https://sonarcloud.io")
//        property("sonar.token", System.getenv("SONAR_TOKEN"))
//
//        property("sonar.language", "kotlin")
//        property("sonar.sourceEncoding", "UTF-8")
//
//        // Fix: Use more specific paths to avoid overlaps
//        property("sonar.sources", "composeApp/src/commonMain/kotlin,shared/src/commonMain/kotlin")
//        property("sonar.tests", "composeApp/src/commonTest/kotlin,shared/src/commonTest/kotlin")
//
//        // Alternative approach - exclude androidMain specifically if you want to include it
//        // property("sonar.sources", "composeApp/src,shared/src")
//        // property("sonar.exclusions", "**/build/**,**/*.gradle.kts,**/androidTest/**")
//
//        property("sonar.exclusions", "**/build/**,**/*.gradle.kts")
//    }
//}