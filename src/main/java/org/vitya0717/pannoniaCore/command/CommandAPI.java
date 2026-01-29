package org.vitya0717.pannoniaCore.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CommandAPI extends Command {

    public CommandAPI(String commandName, List<String> commandAliases, String permission, String description, String usageMessage) {
        super(commandName);
        this.setAliases(commandAliases); // Optional: Add aliases
        this.setPermission(permission); // Optional: Set a permission
        this.setDescription(description);
        this.setUsage(usageMessage);
    }

    public CommandAPI(String commandName, String permission, String description, String usageMessage) {
        super(commandName);
        //this.setAliases(Collections.singletonList("cm")); // Optional: Add aliases
        this.setPermission(permission); // Optional: Set a permission
        this.setDescription(description);
        this.setUsage(usageMessage);
    }

    public CommandAPI(String commandName, String description, String usageMessage) {
        super(commandName);
        //this.setAliases(Collections.singletonList("cm")); // Optional: Add aliases
        //this.setPermission("pannoniacore.chatmodule"); // Optional: Set a permission
        this.setDescription(description);
        this.setUsage(usageMessage);
    }

    public CommandAPI(String commandName, String description) {
        super(commandName);
        //this.setAliases(Collections.singletonList("cm")); // Optional: Add aliases
        //this.setPermission("pannoniacore.chatmodule"); // Optional: Set a permission
        this.setDescription(description);
        //this.setUsage("/chatmodule");
    }


    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        return false;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
        return List.of();
    }
}
