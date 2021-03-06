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
package dwo.gameserver.handler.effects;

import dwo.gameserver.model.skills.effects.EffectTemplate;
import dwo.gameserver.model.skills.effects.L2Effect;
import dwo.gameserver.model.skills.stats.Env;

/**
 * @author mkizub
 */
public class ImmobileBuff extends Buff
{
	public ImmobileBuff(Env env, EffectTemplate template)
	{
		super(env, template);
	}

	// Special constructor to steal this effect
	public ImmobileBuff(Env env, L2Effect effect)
	{
		super(env, effect);
	}

	@Override
	public boolean onStart()
	{
		getEffected().setIsImmobilized(true);
		return super.onStart();
	}

	@Override
	public void onExit()
	{
		getEffected().setIsImmobilized(false);
		super.onExit();
	}
}
