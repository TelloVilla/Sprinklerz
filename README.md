# Sprinklerz

A Minecraft mod to speed up crop growth

## Info:
Adds 5 tiers of sprinklers to hydrate and grow your crops. Each tier has a configurable hydration radius and growth boost timer.

### Tiers:
- Copper Sprinkler: Radius: 2 Delay: 6000 (ticks)
- Iron Sprinkler: Radius: 2 Delay: 3000 (ticks)
- Gold Sprinkler: Radius: 3 Delay: 1500 (ticks)
- Diamond Sprinkler: Radius: 3 Delay: 1000 (ticks)
- Netherite Sprinkler: Radius: 4 Delay: 750 (ticks)

### Redstone control:
- a direct redstone signal will disable the sprinkler including the hydration and bone meal effect

### Ceiling Sprinklers
- Sprinklers may be placed on ceilings to hydrate crops below but their range is limited by their radius and the max ceiling range

## Config Options:
Delete the config to show new options if missing
- Radius is for hydration and the bone meal effect range (Min: 1, Max: 5)
- Delay is the amount of time in ticks before a growth boost
    - There is about 20 ticks per second depending on the server so for 1 minute it would be (60 sec * 20 ticks) for 1200 ticks
    - delay can be set to 0 to turn off the bone meal effect for that tier only
- Bone meal effect for all tiers can be disabled by setting to false
- Ceiling Range is the max distance from the ceiling to the ground for the bone meal effect for all tiers (also limited by sprinkler radius)

