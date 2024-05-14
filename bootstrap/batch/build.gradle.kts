plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}

dependencies {
    implementation(project(":application"))
    implementation(project(":domain"))
    implementation(project(":framework:rds"))
}
