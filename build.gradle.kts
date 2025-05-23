plugins {
    kotlin("jvm") version "2.2.0-Beta2"
    id("com.gradleup.shadow") version "8.3.0"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "lu.kolja"
version = "1.0.0-alpha"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots") {
        name = "spigot-repo"
    }
}

dependencies {
    val lamp_version: String by project

    compileOnly("org.spigotmc:spigot-api:1.21-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compileOnly("org.bstats:bstats-bukkit:3.0.2")
    implementation("io.github.revxrsal:lamp.common:$lamp_version")
    implementation("io.github.revxrsal:lamp.bukkit:$lamp_version")
}

tasks {
    runServer {
        // Configure the Minecraft version for our task.
        // This is the only required configuration besides applying the plugin.
        // Your plugin's jar (or shadowJar if present) will be used automatically.
        minecraftVersion("1.21")
    }
}

val targetJavaVersion = 21
kotlin {
    jvmToolchain(targetJavaVersion)

    compilerOptions {
        //experimental features
        freeCompilerArgs.add("-Xwhen-guards")
        freeCompilerArgs.add("-Xmulti-dollar-interpolation")
    }
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.shadowJar {
    relocate("com.bstats", "${project.group}.${project.name}")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}
