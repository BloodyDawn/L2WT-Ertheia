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
package dwo.gameserver.model.skills.base.funcs;

import dwo.gameserver.model.skills.base.conditions.Condition;
import dwo.gameserver.model.skills.stats.Env;
import dwo.gameserver.model.skills.stats.Stats;

/**
 * A Func object is a component of a Calculator created to manage and dynamically calculate the effect of a character property (ex : MAX_HP, REGENERATE_HP_RATE...).
 * In fact, each calculator is a table of Func object in which each Func represents a mathematic function : <BR><BR>
 *
 * FuncPAtkAccuracy -> Math.sqrt(_player.getDEX())*6+_player.getLevel()<BR><BR>
 *
 * When the calc method of a calculator is launched, each mathematic function is called according to its priority <B>_order</B>.
 * Indeed, Func with lowest priority order is executed firsta and Funcs with the same order are executed in unspecified order.
 * The result of the calculation is stored in the value property of an Env class instance.<BR><BR>
 *
 */

public abstract class Func
{
	/** Statistics, that is affected by this function (See L2Character.CALCULATOR_XXX constants) */
	public final Stats stat;

	/**
	 * Order of functions calculation.
	 * Functions with lower order are executed first.
	 * Functions with the same order are executed in unspecified order.
	 * Usually add/substruct functions has lowest order,
	 * then bonus/penalty functions (multiplay/divide) are
	 * applied, then functions that do more complex calculations
	 * (non-linear functions).
	 */
	public final int order;

	/**
	 *  Owner can be an armor, weapon, skill, system event, quest, etc
	 *  Used to remove all functions added by this owner.
	 */
	public final Object funcOwner;

	public final double value;

	/** Function may be disabled by attached condition. */
	public Condition cond;

	/**
	 * Constructor of Func.<BR><BR>
	 */
	protected Func(Stats stat, int order, Object owner)
	{
		this(stat, order, owner, 0.0);
	}

	protected Func(Stats stat, int order, Object owner, double value)
	{
		this.stat = stat;
		this.order = order;
		funcOwner = owner;
		this.value = value;
	}

	/**
	 * Add a condition to the Func.<BR><BR>
	 */
	public void setCondition(Condition pCond)
	{
		cond = pCond;
	}

	/**
	 * Run the mathematic function of the Func.<BR><BR>
	 */
	public abstract void calc(Env env);
}
