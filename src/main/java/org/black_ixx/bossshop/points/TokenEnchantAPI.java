package org.black_ixx.bossshop.points;

import org.black_ixx.bossshop.BossShop;
import org.black_ixx.bossshop.managers.ClassManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

import com.vk2gpz.tokenenchant.TokenEnchant;

public class TokenEnchantAPI extends IPointsAPI {
	private TokenEnchant pp;
	private BossShop plugin;

	public TokenEnchantAPI() {
		super("TokenEnchant");

		plugin = ClassManager.manager.getPlugin();
		Plugin tokenEnchant = plugin.getServer().getPluginManager().getPlugin("TokenEnchant");
		if (tokenEnchant != null) {
			pp = ((TokenEnchant) tokenEnchant);
		}
	}

	@Override
	public int getPoints(OfflinePlayer player) {
		return pp.getTokens(player);
	}

	@Override
	public int setPoints(OfflinePlayer player, int points) {
		pp.setTokens(player, points);
		return getPoints(player);
	}

	@Override
	public int takePoints(OfflinePlayer player, int points) {
		pp.removeTokens(player, points);
		return getPoints(player);
	}

	@Override
	public int givePoints(OfflinePlayer player, int points) {
		pp.addTokens(player, points);
		return getPoints(player);
	}

}
