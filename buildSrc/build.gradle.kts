plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(plugin(libs.plugins.lombok))
    implementation(plugin(libs.plugins.shadow))
    implementation(plugin(libs.plugins.pluginYml.bukkit))
    implementation(plugin(libs.plugins.runTask.paper))
}

fun plugin(plugin: Provider<PluginDependency>): Provider<String> =
    plugin.map { "${it.pluginId}:${it.pluginId}.gradle.plugin:${it.version}" }
