import org.flywaydb.gradle.task.FlywayMigrateTask
import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

plugins {
    kotlin("plugin.jpa")
    kotlin("plugin.allopen")
    kotlin("plugin.noarg")

    id("org.flywaydb.flyway")
}

noArg {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}

tasks {
    register<FlywayMigrateTask>("flywayMigrateDocker") {
        driver = "com.mysql.cj.jdbc.Driver"
        url = "jdbc:mysql://127.0.0.1:3307/uggae"
        user = "root"
        password = "root123"
    }
}


dependencies {
    val querydslVersion = "5.0.0"

    api("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.querydsl:querydsl-jpa:$querydslVersion:jakarta")
    kapt("com.querydsl:querydsl-apt:$querydslVersion:jakarta")
    kapt("jakarta.annotation:jakarta.annotation-api")
    kapt("jakarta.persistence:jakarta.persistence-api")

    implementation("org.flywaydb:flyway-mysql")
    implementation("org.flywaydb:flyway-core")
    implementation("com.h2database:h2")
    implementation("com.github.f4b6a3:ulid-creator:5.2.3")

//    runtimeOnly("com.h2database:h2")
    runtimeOnly("com.mysql:mysql-connector-j")

    testImplementation("com.h2database:h2")
}
