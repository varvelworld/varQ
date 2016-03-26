package io.github.varvelworld.varq.virtual.node.state;

import java.util.function.UnaryOperator;

/**
 * Created by luzhonghao on 16/3/27.
 */
public class VirtualNodeStateContext implements VirtualNodeStateEventTrigger {

    private VirtualNodeState state = VirtualNodeStates.DETACHED;
    private VirtualNodeStateListener listener;

    public VirtualNodeStateContext(VirtualNodeStateListener listener) {
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

    public VirtualNodeState prepareJoin() {
        return doEvent(VirtualNodeStateEventTrigger::prepareJoin);
    }

    public VirtualNodeState prepareDetach() {
        return doEvent(VirtualNodeStateEventTrigger::prepareDetach);
    }

    public VirtualNodeState join() {
        return doEvent(VirtualNodeStateEventTrigger::join);
    }

    public VirtualNodeState detach() {
        return doEvent(VirtualNodeStateEventTrigger::detach);
    }
}
