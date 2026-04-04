plugins {
    id("buildlogic.java-17")
    id("buildlogic.fatjar")
    id("buildlogic.plugin-yml")
    id("buildlogic.run-paper")
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") // Paper API
}

dependencies {
    compileOnly(libs.paper.get1().get18())
    implementation(project(projects.deluxeMenusModern.path, "downgraded"))
    implementation(variantOf(libs.jvmdowngrader) { classifier("downgraded-17") })
}

tasks.shadowJar {
    archiveFileName = "${rootProject.name}-1_18.jar"
}

bukkit {
    apiVersion = "1.18"
}

tasks.runServer {
    javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of(21)
    }

    minecraftVersion("1.21.11")
}
