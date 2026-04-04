plugins {
    java
    id("com.gradleup.shadow")
}

tasks.jar {
    enabled = false
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

tasks.shadowJar {
    mergeServiceFiles()

    exclude(
        "META-INF/proguard/**",
        "META-INF/maven/**",
        "META-INF/coverage/**",
        "unicode/**",
        "license/**",
        "*LICENSE*",
    )

    projectDir.resolve("relocations.txt").forEachLine {
        if (it.isNotBlank()) {
            relocate(it, "com.extendedclip.deluxemenus.__relocated__.$it")
        }
    }
}
