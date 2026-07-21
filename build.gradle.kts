plugins {
    kotlin("jvm") version "2.1.21"
}


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
    jvmToolchain(21)
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
}
