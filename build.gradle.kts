plugins {
    kotlin("jvm") version "2.2.10"
    `maven-publish`
}

group = "llc.redstone"
version = "1.1.0"

java {
    withSourcesJar()
    val javaVersion: JavaVersion = JavaVersion.VERSION_21
    targetCompatibility = javaVersion
    sourceCompatibility = javaVersion
}

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = project.group.toString()
            artifactId = "SystemsData"
            version = project.version.toString()
        }
    }
    repositories {
        maven {
            name = "releasesRepo"
            url = uri("https://repo.redstone.llc/releases")
            credentials {
                username = property("releasesRepoUsername") as String
                password = property("releasesRepoPassword") as String
            }
        }
    }
}