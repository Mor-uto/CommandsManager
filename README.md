# CommandsManager
a bukkit/spigot CommandsManager to make it easy when making commands

## Registration

just make a `new CommandsManager(this);` in your main plugin's class in the onEnable method

## Usage

make a new class that extends Command class provided in this code
then implement the execute method thats required for the thing to work
and then annotate the class with @CommandInfo and put inside it the command's name

so an exmaple would look like this

```java
package me.moruto.github.commands;

import me.moruto.github.utils.CommandsManager.Command;
import me.moruto.github.utils.CommandsManager.CommandInfo;
import org.bukkit.entity.Player;

@CommandInfo(name = "test")
public class test extends Command {
   public void execute(Player player, String[] args) {
      sendMessageBranded(player, "&9Hi this thing works");
   }
}
```

## Command Utils

`sendMessageBranded`

its a method for commands only that provides u with a color translator
so u use it like this

```java
sendMessageBranded(player, "&aa message with color codes :D");
```
