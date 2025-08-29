//import org.jetbrains.intellij.platform.gradle.TestFrameworkType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun gradleProperties(key: String) = providers.gradleProperty(key)

group = gradleProperties("courseGroup").get()
version = gradleProperties("courseVersion").get()

plugins {
//    id("org.jetbrains.intellij.platform") version "2.1.0"
    java
    id("java-library")
    val kotlinVersion = "2.0.21"
    id("org.jetbrains.kotlin.jvm") version kotlinVersion apply false
}

//dependencies {
//    intellijPlatform {
//        intellijIdeaCommunity("2024.2.4")
//        pluginVerifier()
//        zipSigner()
//        instrumentationTools()
//
//        testFramework(TestFrameworkType.Platform)
//    }
//}

allprojects {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven {
            // To be able to use the Kotlin test framework for the tests - https://github.com/jetbrains-academy/kotlin-test-framework
            url = uri("https://packages.jetbrains.team/maven/p/kotlin-test-framework/kotlin-test-framework")
        }

//        intellijPlatform {
//            defaultRepositories()
//        }
    }
}

tasks {
    wrapper {
        gradleVersion = gradleProperties("gradleVersion").get()
    }
}

// Configure dependencies for all gradle modules
configure(subprojects) {
    apply {
        plugin("java")
        plugin("kotlin")
    }

    // Include dependencies
    dependencies {
        val junit4Version = "4.13.2"
        val junitBomVersion = "5.11.3"
        val testSystemVersion = "2.1.3"

        // JetBrains Academy Test System
        implementation("org.jetbrains.academy.test.system:java-psi:$testSystemVersion")
        implementation("org.jetbrains.academy.test.system:common:$testSystemVersion")
        implementation("org.jetbrains.academy.test.system:core:$testSystemVersion")

        // JUnit BOM
        implementation(platform("org.junit:junit-bom:$junitBomVersion")) {
            because("Platform, Jupiter, and Vintage versions should match")
        }

        // JUnit Jupiter
        testImplementation("org.junit.jupiter:junit-jupiter")

        // JUnit Vintage
        testImplementation("junit:junit:$junit4Version")
        testRuntimeOnly("org.junit.vintage:junit-vintage-engine") {
            because("allows JUnit 3 and JUnit 4 tests to run")
        }

        // JUnit Suites
        testImplementation("org.junit.platform:junit-platform-suite")

        // JUnit Platform Launcher + Console
        testRuntimeOnly("org.junit.platform:junit-platform-launcher") {
            because("allows tests to run from IDEs that bundle older version of launcher")
        }
        testRuntimeOnly("org.junit.platform:junit-platform-console") {
            because("needed to launch the JUnit Platform Console program")
        }

        testImplementation("org.ini4j:ini4j:0.5.4")
    }

    val jvmVersion = gradleProperties("jvmVersion").get()

    tasks {
        withType<KotlinCompile> {
            compilerOptions {
                // freeCompilerArgs = listOf("-Xjsr305=strict") // deprecated
                jvmTarget = JvmTarget.fromTarget(jvmVersion)
            }
        }
        withType<JavaCompile> {
            // sourceCompatibility = jvmVersion
            // targetCompatibility = jvmVersion
        }

        // This part is necessary for the JetBrains Academy plugin
        withType<Test> {
            useJUnitPlatform()

            outputs.upToDateWhen { false }

            addTestListener(object : TestListener {
                override fun beforeSuite(suite: TestDescriptor) {}
                override fun beforeTest(testDescriptor: TestDescriptor) {}
                override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {
                    if (result.resultType == TestResult.ResultType.FAILURE) {
                        val message = result.exception?.message ?: "Wrong answer"
                        val lines = message.split("\n")
                        println("#educational_plugin FAILED + ${lines[0]}")
                        lines.subList(1, lines.size).forEach { line ->
                            println("#educational_plugin$line")
                        }
                        // we need this to separate output of different tests
                        println()
                    }
                }

                override fun afterSuite(suite: TestDescriptor, result: TestResult) {}
            })
        }
    }
}

// We have to store tests inside test folder directly
configure(subprojects.filter { it.name != "common" }) {
    sourceSets {
        getByName("main").java.srcDirs("src")
        getByName("test").java.srcDirs("test")
    }

    dependencies {
        implementation(project(":common"))
    }

    tasks.register<Exec>("run") {
        // Just do nothing to avoid the edu plugin errors
    }
}

//configure(subprojects.filter { it.name.endsWith("Practice") || it.name.endsWith("task") }) {
//    plugins.apply("org.jetbrains.intellij.platform")
//
//    dependencies {
//        val testSystemVersion = "2.1.3"
//        testImplementation("org.jetbrains.academy.test.system:java-psi:$testSystemVersion")
//        testImplementation("org.jetbrains.academy.test.system:common:$testSystemVersion")
//        testImplementation("org.jetbrains.academy.test.system:core:$testSystemVersion")
//    }
//}
