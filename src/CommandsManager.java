public class CommandsManager {
    public final ArrayList<Class<? extends Command>> commands = new ArrayList<>();
    private final JavaPlugin plugin;

    public void registerCommand(String name, Class<? extends Command> clazz) {
        commands.put(name, clazz);
    }
    
    public CommandsManager(final JavaPlugin plugin) {
        this.plugin = plugin;
        manageCommands();
    }

    private void manageCommands() {
        for (Class<? extends Command> clazz : commands) {
            try {
                Constructor<? extends Command> constructor = clazz.getDeclaredConstructor();
                Command commandInstance = constructor.newInstance();
                String commandName = commandInstance.name;
                plugin.getCommand(commandName).setExecutor(commandInstance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
