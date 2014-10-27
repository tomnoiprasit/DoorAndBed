package org.noiprasit.doorandbed;
import org.bukkit.plugin.java.JavaPlugin;

public final class DoorAndBed extends JavaPlugin {

	public void onEnable() {
		getCommand("makedoor").setExecutor(new MakeDoorCommand(this));
		getCommand("makebed").setExecutor(new MakeBedCommand(this));
	}
}
