plugins {
    id("buildlogic.java-21")
    alias(libs.plugins.jvmdowngrader)
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") // Paper API
    maven("https://repo.extendedclip.com/releases/") // PlaceholderAPI
    maven("https://jitpack.io") // Vault
    maven("https://repo.momirealms.net/releases/") // CraftEngine
    maven("https://maven.devs.beer/") // ItemsAdder
    maven("https://nexus.phoenixdevt.fr/repository/maven-public/") // MMOItems, MythicLib
    maven("https://repo.nexomc.com/releases") // Nexo
    maven("https://repo.oraxen.com/releases") // Oraxen
    maven("https://nexus.velocitypowered.com/repository/maven-public/") // authlib
}

dependencies {
    compileOnly(libs.paper.get1().get21())
    compileOnly(libs.annotations)
    compileOnly(libs.placeholderapi) { isTransitive = false }
    compileOnly(libs.vault) { isTransitive = false }
    compileOnly(libs.headDatabase) { isTransitive = false }
    compileOnly(libs.itemsAdder) { isTransitive = false }
    compileOnly(libs.mmoItems) { isTransitive = false }
    compileOnly(libs.mythicLib) { isTransitive = false }
    compileOnly(libs.oraxen) { isTransitive = false }
    compileOnly(libs.simpleItemGenerator) { isTransitive = false }
    compileOnly(libs.authlib) { isTransitive = false }
    compileOnly(libs.nexo) { isTransitive = false }
    compileOnly(libs.craftEngine.core) { isTransitive = false }
    compileOnly(libs.craftEngine.bukkit) { isTransitive = false }
    compileOnly(libs.minimessage) { isTransitive = false }
    compileOnly(files(rootDir.resolve(".lib").resolve("ExecutableBlocks-API.jar")))
    compileOnly(files(rootDir.resolve(".lib").resolve("SCore-API.jar")))

    implementation(libs.nashorn)
    implementation(libs.bstats)
}

jvmdg {
    downgradeTo = JavaVersion.VERSION_17
}

configurations.create("downgraded") {
    isCanBeConsumed = true
    isCanBeResolved = false
    extendsFrom(configurations.implementation.get())

    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
        attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.LIBRARY))
        attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
        attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE, objects.named(LibraryElements.JAR))
    }

    outgoing.artifact(tasks.downgradeJar)
}

tasks.register("printVersion") {
    doLast {
        println(version)
    }
}

allprojects {
    version = "1.14.2-MODERN-${System.getenv()["BUILD_ID"] ?: "DEV"}"
}
