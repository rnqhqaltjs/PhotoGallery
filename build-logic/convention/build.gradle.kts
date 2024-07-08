plugins {
    `kotlin-dsl`
}

group = "com.example.photogallery.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.android.gradle.plugin)
    implementation(libs.kotlin.plugin)
    implementation(libs.ksp.gradle.plugin)
    implementation(libs.detekt.plugin)
    implementation(libs.javapoet.plugin)
    implementation(libs.navigation.safeargs.plugin)
    implementation(libs.kotlinx.kover.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "photogallery.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidHilt") {
            id = "photogallery.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "photogallery.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("androidBenchmark") {
            id = "photogallery.android.benchmark"
            implementationClass = "AndroidBenchmarkConventionPlugin"
        }
        register("androidApplicationJacoco") {
            id = "photogallery.android.application.jacoco"
            implementationClass = "AndroidApplicationJacocoConventionPlugin"
        }
        register("androidLibraryJacoco") {
            id = "photogallery.android.library.jacoco"
            implementationClass = "AndroidLibraryJacocoConventionPlugin"
        }
        register("androidLibrary") {
            id = "photogallery.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "photogallery.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("gitHooks") {
            id = "photogallery.git.hooks"
            implementationClass = "GitHooksConventionPlugin"
        }
        register("detekt") {
            id = "photogallery.detekt"
            implementationClass = "DetektConventionPlugin"
        }
    }
}