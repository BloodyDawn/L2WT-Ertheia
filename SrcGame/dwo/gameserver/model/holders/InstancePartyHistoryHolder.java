package dwo.gameserver.model.holders;

import java.util.List;

/**
 * L2GOD Team
 * User: ANZO
 * Date: 12.07.12
 * Time: 11:40
 */

public class InstancePartyHistoryHolder
{
	private List<CharacterClassHolder> _charsInParty;
	private int _instanceId;
	private int _instanceUseTime;
	private int _instanceStatus;

	public List<CharacterClassHolder> getCharsInParty()
	{
		return _charsInParty;
	}

	public void setCharsInParty(List<CharacterClassHolder> charsInParty)
	{
		_charsInParty = charsInParty;
	}

	public int getInstanceId()
	{
		return _instanceId;
	}

	public void setInstanceId(int instanceId)
	{
		_instanceId = instanceId;
	}

	public int getInstanceUseTime()
	{
		return _instanceUseTime;
	}

	public void setInstanceUseTime(int instanceUseTime)
	{
		_instanceUseTime = instanceUseTime;
	}

	public int getInstanceStatus()
	{
		return _instanceStatus;
	}

	public void setInstanceStatus(int instanceStatus)
	{
		_instanceStatus = instanceStatus;
	}
}