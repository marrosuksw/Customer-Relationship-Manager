plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	id ("application")
	id ("org.openjfx.javafxplugin") version "0.1.0"

}

group = "com.java"
version = "0.0.1-SNAPSHOT"

buildscript {
	repositories {
		maven {
			setUrl("https://plugins.gradle.org/m2/")
		}
	}
	dependencies {
		classpath("org.openjfx:javafx-plugin:0.1.0")
	}
}
apply(plugin = "org.openjfx.javafxplugin")


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
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	compileOnly("org.projectlombok:lombok")
	implementation("org.openjfx:javafx:11")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
