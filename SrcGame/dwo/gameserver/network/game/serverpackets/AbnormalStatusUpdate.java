/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package dwo.gameserver.network.game.serverpackets;

import javolution.util.FastList;

import java.util.List;

/**
 *  Проверил: Bacek
 *  Дата: 06.05.12
 *  Протокол: 463 (  Glory Days )
 */

public class AbnormalStatusUpdate extends L2GameServerPacket
{
	private List<Effect> _effects;

	public AbnormalStatusUpdate()
	{
		_effects = new FastList<>();
	}

	public void addEffect(int skillId, int level, int duration, int time)
	{
		if(skillId == 2031 || skillId == 2032 || skillId == 2037 || skillId == 26025 || skillId == 26026)
		{
			return;
		}

		_effects.add(new Effect(skillId, level, duration, time));
	}

	@Override
	protected void writeImpl()
	{
		writeH(_effects.size());
		for(Effect temp : _effects)
		{
			writeD(temp._skillId);
			writeH(temp._level);
			writeD(temp._duration);
			writeH(temp._time);
		}
	}

	private static class Effect
	{
		protected int _skillId;
		protected int _level;
		protected int _duration;
		protected int _time;

		public Effect(int pSkillId, int pLevel, int pDuration, int time)
		{
			_skillId = pSkillId;
			_level = pLevel;
			_duration = pDuration;
			_time = time;
		}
	}
}
