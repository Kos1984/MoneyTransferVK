plugins {
    kotlin("jvm") version "1.8.10"
    jacoco
}

group = "ru.netology"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.2")

}



kotlin {
    jvmToolchain(8)
}