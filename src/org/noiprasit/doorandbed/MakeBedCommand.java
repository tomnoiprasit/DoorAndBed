package org.noiprasit.doorandbed;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MakeBedCommand implements CommandExecutor {
	DoorAndBed plugin;
	
	public MakeBedCommand(DoorAndBed doorAndBed) {
		this.plugin = doorAndBed;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String sAlias, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		Location loc = player.getLocation();
		
		BlockFace bf = TomUtililties.yawToFace(loc.getYaw(),false);
		BlockFace bf1 = null;
		BlockFace bf2 = null;
		
		byte beddirection = 0x0;
		
		if(bf==BlockFace.SOUTH) {
			bf1 = BlockFace.NORTH;
			bf2 = BlockFace.EAST;
			beddirection = 0x3;
		} else if(bf==BlockFace.WEST) {
			bf1 = BlockFace.EAST;
			bf2 = BlockFace.SOUTH;
			beddirection = 0x0;
		} else if(bf==BlockFace.NORTH) {
			bf1 = BlockFace.SOUTH;
			bf2 = BlockFace.WEST;
			beddirection = 0x1;
		} else if(bf==BlockFace.EAST) {
			bf1 = BlockFace.WEST;
			bf2 = BlockFace.NORTH;
			beddirection = 0x2;
		}
		Block block = loc.getBlock();
		// right hand side
		block.getRelative(bf1, 1).setTypeIdAndData(26, (byte) (0x0 | beddirection), true); // foot of bed
		block.getRelative(bf1, 1).getRelative(bf2, 1).setTypeIdAndData(26, (byte) (0x8 | beddirection), true); // head of bed

		player.sendMessage("Done");
		return true;
	}
}
