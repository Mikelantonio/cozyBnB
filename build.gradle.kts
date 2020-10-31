import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {

	val kotlin = "1.3.72"
	val springBoot = "2.3.5.RELEASE"

	id("org.springframework.boot") version "$springBoot"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "$kotlin"
	kotlin("plugin.spring") version "$kotlin"

	kotlin("kapt") version "$kotlin"
	kotlin("plugin.allopen") version "$kotlin"
	kotlin("plugin.noarg") version "$kotlin"
	kotlin("plugin.jpa") version "$kotlin"
}

val versionMajor = 0
val versionMinor = 1
val versionPatch = 0

group = "dev.trizio"
version = "${versionMajor}.${versionMinor}.${versionPatch}"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {

	val mysql = "8.0.20"
	val jackson4Kotlin = "2.11.0"
	val hibernate = "5.4.17.Final"
	val swagger = "2.9.2"
	val flyway = "6.4.4"
	val queryDslVersion = "4.3.1"
	val springBoot = "2.3.5.RELEASE"

	//query annotation lib
	kapt("com.querydsl:querydsl-apt:$queryDslVersion:jpa")

	//kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jackson4Kotlin")

	//spring framework
	implementation("org.springframework.boot:spring-boot-starter-web:$springBoot")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBoot")
	implementation("org.springframework.boot:spring-boot-starter-validation:$springBoot")
	implementation("org.springframework.boot:spring-boot-starter-security:$springBoot")

	//mysql
	implementation("mysql:mysql-connector-java:$mysql")
	implementation("org.hibernate:hibernate-core:$hibernate")
	implementation("com.querydsl:querydsl-jpa:$queryDslVersion")
	implementation("org.flywaydb:flyway-core:$flyway")

	//documentation
	implementation("io.springfox:springfox-swagger2:$swagger")
	implementation("io.springfox:springfox-swagger-ui:$swagger")

	//test
	testImplementation("org.springframework.boot:spring-boot-starter-test:$springBoot") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}

}

allOpen {
	annotation("javax.persistence.Entity")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
