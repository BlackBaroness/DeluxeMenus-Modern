plugins {
    id("buildlogic.java-17")
    id("buildlogic.fatjar")
    id("buildlogic.plugin-yml")
    alias(libs.plugins.runTask.paper)
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") // Paper API
}

dependencies {
    compileOnly(libs.paper.get1().get18())
    implementation(project(projects.deluxeMenusModern.path, "downgradedElements"))
    implementation("xyz.wagyourtail.jvmdowngrader:jvmdowngrader-java-api:1.3.6:downgraded-17")
}

tasks.shadowJar {
    archiveFileName = "${rootProject.name}-1_18.jar"
}

bukkit {
    apiVersion = "1.18"
}

tasks.runServer {
    minecraftVersion("1.18.2")

    jvmArgs = jvmArgs.plus(
        arrayOf(
            "-DIReallyKnowWhatIAmDoingISwear",
            "-DPaper.IgnoreJavaVersion=true",
            "-Dcom.mojang.eula.agree=true",
            "-Dfile.encoding=UTF-8",
        )
    )
}
