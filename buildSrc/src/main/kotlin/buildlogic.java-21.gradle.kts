plugins {
    java
    id("io.freefair.lombok")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.withType<JavaCompile>() {
    options.release = 21
}
