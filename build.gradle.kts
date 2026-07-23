plugins {
    kotlin("jvm") version "2.1.21"
    id("io.qameta.allure") version "2.11.2"
}

allure {
    report {
        version.set("2.19.0")
    }
    adapter {
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set("2.19.0")
            }
        }
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3") // версия JUnit
    testImplementation("com.codeborne:selenide:6.18.0") // версия Selenide
    testImplementation("com.github.javafaker:javafaker:1.0.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("io.qameta.allure:allure-selenide:2.19.0")
    testImplementation("io.rest-assured:rest-assured:5.3.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.2")
    testImplementation("io.qameta.allure:allure-rest-assured:2.29.0")
}

sourceSets {
    test {
        resources.srcDirs("src/test/resources")
    }
}