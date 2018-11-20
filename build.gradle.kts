import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion

plugins {
    kotlin("jvm").version("1.3.10")
}

repositories {
    jcenter()
}

allprojects {
    apply<KotlinPlatformJvmPlugin>()

    repositories {
        jcenter()
    }

    dependencies {
        compile(kotlin("stdlib-jdk8", getKotlinPluginVersion()))
    }

    tasks.withType<KotlinJvmCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs += listOf("-progressive")
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

