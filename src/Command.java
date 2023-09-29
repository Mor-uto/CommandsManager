public abstract class Command implements CommandExecutor {
    public String name;

    public Command() {
        this.name = getClass().getAnnotation(CommandInfo.class).name();

        if (name == null || name == "") name = getClass().getName().toLowerCase();
    }

    public abstract void execute(Player player, String[] args);

    public void sendMessageBranded(Player player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            execute(player, args);
        }

        return true;
    }
}
