plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	id ("application")
	id ("org.openjfx.javafxplugin") version "0.1.0"
	id ("com.github.johnrengelman.shadow") version "6.1.0"

}

group = "com.java"
version = "0.0.1-SNAPSHOT"

buildscript {
	repositories {
		maven {
			setUrl("https://plugins.gradle.org/m2/")
		}
		gradlePluginPortal()
	}
	dependencies {
		classpath("org.openjfx:javafx-plugin:0.1.0")
		classpath ("com.github.johnrengelman:shadow:8.1.1")
	}
}
apply(plugin = "org.openjfx.javafxplugin")
apply(plugin = "com.github.johnrengelman.shadow")
apply(plugin = "java")

java {
	sourceCompatibility = JavaVersion.VERSION_18
}
javafx {
	modules("javafx.controls", "javafx.fxml")
	version = "17"
	modules("javafx.controls", "javafx.fxml")
}

repositories {
	mavenCentral()

}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly ("com.mysql:mysql-connector-j")
	implementation("org.springframework.boot:spring-boot-starter-web:3.3.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	compileOnly("org.projectlombok:lombok")
	implementation("org.openjfx:javafx:11")
	implementation("com.jfoenix:jfoenix:9.0.10")
	implementation("org.kordamp.ikonli:ikonli-win10-pack:12.3.1")
	implementation("org.kordamp.ikonli:ikonli-javafx:12.3.1")
	implementation("org.kordamp.ikonli:ikonli-zondicons-pack:12.3.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
