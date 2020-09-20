package org.palichmos.demo.bot.handler;

import java.sql.SQLException;
import org.idempiere.telegram.model.Session;

public class StartHandler extends CustomBotHandler
{
	@Override
	public int getPriority()
	{
		return 1;
	}

	@Override
	public boolean onEvent(Session session) throws SQLException
	{
		if (session.getUpdate().getMessage().getText().equals(COM_START))
			return true;
		
		return false;
	}

	@Override
	public void doIt(Session session) throws Exception
	{
		sendMessage(session, "Hello world", null);
		
		session.getUser().setCurrentState(STATE_001);
		session.getUser().saveEx();
	}

}