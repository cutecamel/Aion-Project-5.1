/*
 * This file is part of aion-lightning <aion-lightning.com>.
 *
 *  aion-lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-lightning.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionemu.gameserver.skillengine.effect;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.skillengine.model.Effect;
import com.aionemu.gameserver.skillengine.model.HealType;

/**
 * @author kecimis
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DPHealEffect")
public class DPHealEffect extends HealOverTimeEffect {

	@Override
	public void calculate(Effect effect) {
		super.calculate(effect, HealType.DP);
	}

	@Override
	public void onPeriodicAction(Effect effect) {
		super.onPeriodicAction(effect, HealType.DP);
	}

	@Override
	protected int getCurrentStatValue(Effect effect) {
		return ((Player) effect.getEffected()).getCommonData().getDp();
	}

	@Override
	protected int getMaxStatValue(Effect effect) {
		return ((Player) effect.getEffected()).getGameStats().getMaxDp().getCurrent();
	}
}