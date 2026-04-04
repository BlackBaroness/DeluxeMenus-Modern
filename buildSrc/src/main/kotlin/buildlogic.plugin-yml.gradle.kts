import net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission

plugins {
    id("de.eldoria.plugin-yml.bukkit")
}

bukkit {
    name = "DeluxeMenus"
    prefix = rootProject.name
    main = "com.extendedclip.deluxemenus.DeluxeMenus"
    authors = listOf("HelpChat", "BlackBaroness")
    description = "All in one inventory menu system. Modernized."
    website = "https://github.com/BlackBaroness/DeluxeMenus-Modern"

    softDepend = listOf(
        "PlaceholderAPI",
        "Vault",
        "HeadDatabase",
        "CraftEngine",
        "ItemsAdder",
        "Nexo",
        "Oraxen",
        "ExecutableItems",
        "ExecutableBlocks",
        "Score",
        "SimpleItemGenerator",
        "MMOItems",
    )

    commands {
        create("deluxemenus") {
            description = "DeluxeMenus main commands"
            aliases = listOf("dm", "deluxemenu", "dmenu")
        }
    }

    permissions {
        create("deluxemenus.admin") {
            description = "admin commands"
            default = Permission.Default.OP
        }
        create("deluxemenus.open") {
            description = "open a menu with /dm open <menu>"
            default = Permission.Default.OP
        }
        create("deluxemenus.open.others") {
            description = "open a menu with /dm open <menu> <player>"
            default = Permission.Default.OP
        }
        create("deluxemenus.open.bypass") {
            description = "attempt to open a menu for a viewer skipping view requirement checking for the player"
            default = Permission.Default.OP
        }
        create("deluxemenus.menu.*") {
            description = "permission for all menus"
            default = Permission.Default.OP
        }
        create("deluxemenus.openrequirement.bypass.*") {
            description = "Allows the viewer to bypass all menu open requirements"
            default = Permission.Default.OP
        }
        create("deluxemenus.placeholdersfor") {
            description = "permission to parse menu placeholders with /dm open <menu> p:<player>"
            default = Permission.Default.OP
        }
        create("deluxemenus.placeholdersfor.exempt") {
            description =
                "exempt from placeholders being parsed when targeted with /dm open <menu p:<player> for players with this permission"
            default = Permission.Default.OP
        }
    }
}
