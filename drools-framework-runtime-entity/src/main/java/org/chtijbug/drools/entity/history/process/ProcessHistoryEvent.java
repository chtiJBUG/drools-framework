/*
 * Copyright 2014 Pymma Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.chtijbug.drools.entity.history.process;

import org.chtijbug.drools.entity.DroolsProcessInstanceObject;
import org.chtijbug.drools.entity.history.HistoryEvent;

import java.util.Date;

/**
 * @author nheron
 */
public class ProcessHistoryEvent extends HistoryEvent {

    protected DroolsProcessInstanceObject processInstance;

    public ProcessHistoryEvent() {

    }

    public ProcessHistoryEvent(Long eventID, Long ruleBaseId, int sessionId) {
        super(eventID, new Date(), TypeEvent.BPMN);
        this.setRuleBaseID(ruleBaseId);
        this.setSessionId(sessionId);
    }

    public DroolsProcessInstanceObject getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(DroolsProcessInstanceObject processInstance) {
        this.processInstance = processInstance;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
