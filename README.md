# Citizenship

## Description
Note: this does not currently build due to a broken dependency on VotingPlugin. I have no plans to fix this.

This was a Spigot plugin designed to automate the "Citizenship" of a Minecraft server. "Citizenship" was a permission based class system, based on parent permission groups, broken down into three tiers:

- Visitor/default - This is the default class assigned to players that have just joined the server. Typically this class would have more restrictive permissions to prevent greifers and people unfamiliar with the rules from having too much power
- Citizen - This class is the next step up from Visitor and would typically contain most of your server population. It would have more relaxed permissions for people that have been on the server, understand the rules, and seem trustworthy. On the server I used this on, we had an application process to obtain citizenship that could only be started a week after the first player joined.
- Veteran - This class is the top tier, typically reserved for people that have been on the server for a while and you trust completely. The permission set would typically be the same as Citizen but with access to a few more cosmetic functions. On the server I used this on, this would be given to players after 1 year of citizenship

## Dependencies
- LuckPerms
- VotingPlugin
- Spigot

## Commands
There are only three commands and you must either have the `citizenship.admin` permission be using the console to use them
- `visitor [player]` - This will set the class of a player to the visitor/default class
- `citizen [player]` - This will set the class of a player to the citizen class
- `veteran [player]` - This will set the class of a player to the veteran class

## Permissions
This plugin uses LuckPerms and the following permissions:
- `citizenship.admin` - This permission is required for a player to use any of the commands for this plugin

The class system assigns a player to a parent permission group as follows:
- visitor - `default`
- citizen - `citizen`
- veteran - `veteran`

Note: It does not actually add permissions to these groups, you will need to do that yourself.

# Building
This project was developed with maven and is relatively simple to build:
```
mvn package
```