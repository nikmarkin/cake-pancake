import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
    id("org.openapi.generator")
    id("application")
    kotlin("plugin.serialization") version "1.8.10"
}
application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

group = "cakepancake"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
    google()
    maven {
        url = uri("https://jitpack.io")
    }
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
    }
}
//TODO Убрать версии в переменные
dependencies {
    testImplementation(kotlin("test"))
//    val jacksonVersion: String by project
    val logback_version: String by project
    val exposedVersion: String by project
    val h2Version: String by project
    implementation(kotlin("stdlib-jdk8"))
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
//    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    testImplementation(kotlin("test-junit"))
    implementation("io.ktor:ktor-server-core:2.2.3")
    implementation("io.ktor:ktor-server-netty:2.2.3")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.slf4j:slf4j-simple:1.6.1")
    implementation("org.slf4j:slf4j-api:1.6.1")
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("com.h2database:h2:$h2Version")
    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:2.2.4")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.2.3")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")




}




tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
