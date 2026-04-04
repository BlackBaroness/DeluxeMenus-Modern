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
    compileOnly(libs.paper.get1().get16())
    implementation(project(projects.deluxeMenusModern.path, "downgraded"))
    implementation(files(rootDir.resolve(".lib").resolve("MiniMessage-4.1.0.jar")))
    implementation(variantOf(libs.jvmdowngrader) { classifier("downgraded-17") })
}

tasks.shadowJar {
    archiveFileName = "${rootProject.name}-1_16.jar"
}

bukkit {
    apiVersion = "1.16"
}

tasks.runServer {
    minecraftVersion("1.16.5")
}
