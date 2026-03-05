plugins {
    kotlin("jvm") version "2.2.21"
    `maven-publish`
}

group = "llc.redstone"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.benwoodworth.knbt:knbt:0.11.9")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = project.group.toString()
            artifactId = "SystemsAPI"
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