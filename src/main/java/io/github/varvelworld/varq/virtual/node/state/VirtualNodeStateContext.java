package io.github.varvelworld.varq.virtual.node.state;

import java.util.function.UnaryOperator;

/**
 * Created by luzhonghao on 16/3/27.
 */
public class VirtualNodeStateContext implements VirtualNodeStateEventTrigger {

    private VirtualNodeState state;
    private VirtualNodeStateListener listener;

    public VirtualNodeStateContext(VirtualNodeState state, VirtualNodeStateListener listener) {
        this.state = state;
        this.listener = listener;
    }

    public VirtualNodeState getState() {
        return state;
    }

    public void setState(VirtualNodeState state) {
        this.state = state;
    }

    private VirtualNodeState doEvent(UnaryOperator<VirtualNodeState> eventOp) {
        VirtualNodeState newState = eventOp.apply(this.state);
        listener.action(this.state, newState, () -> this.state = newState);
        if(this.state != newState) {
            this.state = newState; // if listener() not invoke do state transform, do it
        }
        return this.state;
    }

    synchronized public VirtualNodeState prepareJoin() {
        return doEvent(VirtualNodeStateEventTrigger::prepareJoin);
    }

    synchronized public VirtualNodeState prepareDetach() {
        return doEvent(VirtualNodeStateEventTrigger::prepareDetach);
    }

    synchronized public VirtualNodeState join() {
        return doEvent(VirtualNodeStateEventTrigger::join);
    }

    synchronized public VirtualNodeState detach() {
        return doEvent(VirtualNodeStateEventTrigger::detach);
    }
}
