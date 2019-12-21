package com.experts.core.biller.statemachine.api;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import javax.inject.Named;


@Named("InitialBaseActor")
@Scope("prototype")
public class InitialBaseActor extends UntypedAbstractActor {

    @Autowired
    @Qualifier("dbSaverActor")
    private ActorRef childDbSaverActor;

    @Override
    public void onReceive(Object msg) throws Exception {
        childDbSaverActor.tell(msg, getSelf());
    }
}
