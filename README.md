

## Why does this exist?
The latest version of Immersive Portals for 1.20.1 doesn't support Sodium 0.5.11 for who knows what reason
so i wasted some time looking up if anyone had forked it to work. I gave up on searching and just forked Mysticpasta1's version that only seems to support Sodium 0.6.0 and changed some parts so it works on 0.5.11.

## Installation
I am a bit of a lazy dumbass so you still need to use **fabric_loader_dependencies.json** to avoid errors on launch.

1. Download [Immersive Portals 3.3.9.5-iris1.7](https://github.com/BooshSource/ImmersivePortalsMinor/releases/tag/v3.3.9.5-iris1.7)
2. Place in mods folder
3. Go to Configs folder and make a **fabric_loader_dependencies.json** that says
```json
{
  "version": 1,
  "overrides": {
    "sodium": {
      "-breaks": {
        "minecraft": "",
        "immersive_portals": "IGNORED"
      }
    }
  }
}
```
4. Play the game and hopefully have fun :) 


## normal readme below
### Immersive Portals Mod

It's a Minecraft mod that provides see-through portals and seamless teleportation. It also can create "Non-Euclidean" (Uneuclidean) space effect.

![immptl.png](https://i.loli.net/2021/09/30/chHMG45dsnZNqep.png)

[On CurseForge](https://www.curseforge.com/minecraft/mc-mods/immersive-portals-mod)     [On Modrinth](https://modrinth.com/mod/immersiveportals)     [Website](https://qouteall.fun/immptl/)

This mod changes a lot of underlying Minecraft mechanics. This mod allows the client to load multiple dimensions at the same time and synchronize remote world information(blocks/entities) to client. It can render portal-in-portals. The portal rendering is roughly compatible with some versions of Sodium and Iris. The portal can transform player scale and gravity direction.  [Implementation Details](https://qouteall.fun/immptl/wiki/Implementation-Details)

(This is the Fabric version of Immersive Portals. [The Forge version](https://github.com/iPortalTeam/ImmersivePortalsModForForge))

## API

This mod also provides some API for:

* Manage see-through portals
* Dynamically add dimensions
* Synchronize remote chunks to client
* Render the world into GUI
* Other utilities

[API description](https://qouteall.fun/immptl/wiki/API-for-Other-Mods.html).

## How to run this code
https://fabricmc.net/wiki/tutorial:setup

## Other

[Wiki](https://qouteall.fun/immptl/wiki/)

[Discord Server](https://discord.gg/BZxgURK)

[Support qouteall on Patreon](https://www.patreon.com/qouteall)

