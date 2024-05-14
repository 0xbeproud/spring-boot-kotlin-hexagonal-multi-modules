import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks {
    withType<BootJar> {
        enabled = false
    }

    withType<Jar> {
        enabled = true
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
}

dependencies {
    implementation(project(":domain"))
}