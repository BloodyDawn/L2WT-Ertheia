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
package dwo.gameserver.network.game.clientpackets;

import dwo.gameserver.model.actor.instance.L2PcInstance;

public class RequestPrivateStoreManageSell extends L2GameClientPacket
{
	@Override
	protected void readImpl()
	{
		// TODO: implement me properly
		//readD();
		//readQ();
	}

	@Override
	protected void runImpl()
	{
		L2PcInstance player = getClient().getActiveChar();
		if(player == null)
		{
			return;
		}

		// Player shouldn't be able to set stores if he/she is alike dead (dead or fake death)
		if(player.isAlikeDead())
		{
			player.sendActionFailed();
			return;
		}

		if(player.getOlympiadController().isParticipating())
		{
			player.sendActionFailed();
		}
	}

	@Override
	public String getType()
	{
		return "[C] 73 RequestPrivateStoreManageSell";
	}

	@Override
	protected boolean triggersOnActionRequest()
	{
		return false;
	}
}
