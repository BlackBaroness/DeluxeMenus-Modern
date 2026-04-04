import net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission

plugins {
    id("xyz.jpenilla.run-paper")
}

tasks.runServer {
    downloadPlugins {
        url("https://cdn.modrinth.com/data/lKEzGugV/versions/UmbIiI5H/PlaceholderAPI-2.12.2.jar")
    }

    jvmArgs = jvmArgs.plus(
        arrayOf(
            "-DIReallyKnowWhatIAmDoingISwear",
            "-DPaper.IgnoreJavaVersion=true",
            "-Dcom.mojang.eula.agree=true",
            "-Dfile.encoding=UTF-8",
        )
    )
}
