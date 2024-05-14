import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.flywaydb:flyway-mysql:10.12.0")
    }
}

plugins {
    kotlin("jvm")
    kotlin("kapt")

    id("org.springframework.boot") apply false
    id("io.spring.dependency-management") apply false
    kotlin("plugin.spring") apply false
    kotlin("plugin.jpa") apply false

    id("org.jlleitschuh.gradle.ktlint") version "12.1.1" apply false
    id("org.flywaydb.flyway") version "10.12.0" apply false
}

allprojects {
    group = "com.beproud"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    apply {
        plugin("org.jlleitschuh.gradle.ktlint")
//        plugin("org.jlleitschuh.gradle.ktlint-idea")
    }
}

subprojects {
    apply {
        plugin("kotlin")
        plugin("kotlin-spring")
        plugin("kotlin-kapt")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")

        plugin("org.jetbrains.kotlin.plugin.spring")
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter")
        kapt("org.springframework.boot:spring-boot-configuration-processor")

        implementation(kotlin("reflect"))
        implementation(kotlin("stdlib-jdk8"))

        implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

//    configurations {
//        compileOnly {
//            extendsFrom(configurations.annotationProcessor.get())
//        }
//    }
}

//
// java {
//    sourceCompatibility = JavaVersion.VERSION_17
// }

// dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-actuator")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.springframework.boot:spring-boot-starter-graphql")
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
//    implementation("org.springframework.boot:spring-boot-starter-security")
//    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("org.flywaydb:flyway-core")
//    implementation("org.flywaydb:flyway-mysql")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    runtimeOnly("com.h2database:h2")
//    runtimeOnly("com.mysql:mysql-connector-j")
//    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("org.springframework:spring-webflux")
//    testImplementation("org.springframework.graphql:spring-graphql-test")
//    testImplementation("org.springframework.security:spring-security-test")
// }
