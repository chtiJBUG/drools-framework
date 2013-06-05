package org.chtijbug.drools.entity.history.session;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Date: 05/06/13
 * Time: 12:09
 * To change this template use File | Settings | File Templates.
 */
public class SessionCreatedEvent extends SessionEvent {
    public SessionCreatedEvent(int eventID, Date dateEvent,  int sessionId) {
        super(eventID, dateEvent, sessionId);
    }
}
