## DeluxeMenus-Modern

A soft fork of [the original DeluxeMenus](https://github.com/HelpChat/DeluxeMenus) with a few improvements:

- **Supports MiniMessage in menu items**<br>
  Read further to learn more

- **Designed for Paper 1.16+**<br>
  Does not support environments with no native Adventure support such as Spigot or older Paper

- **Uses a native Adventure API instead of `BukkitAudiences` wrapper**<br>
  May improve performance, especially on modern platforms

- **Uses latest dependencies**<br>
  May improve performance and avoid some bugs

- **Reworked build system**<br>
  Compiles to Java 17 natively and uses the best build conventions

- **Removed update checker**

The goal of this fork is simple — modernize DeluxeMenus without touching too much of the original code, so it stays as
stable as upstream.

> ⚠️ The plugin is still named **DeluxeMenus**, so you can just replace the `.jar` without changing anything.
>
> All configs, all addons etc. everything should be fully compatible

This repository is periodically synced with the upstream project.

## Using MiniMessage to configure items

```yml
material: STONE
modern_use_minimessage: true # put that into an item to enable MM processing
display_name: "<green>This is a special stone"
lore:
    - "<red>test"
    - "<rainbow>test"
    - "<white><shadow:aqua:0.5>test"
    - "<sprite:blocks:block/stone>"
    - "<head:Notch>"
```

![](.github/minimessage_demonstration.webp)
