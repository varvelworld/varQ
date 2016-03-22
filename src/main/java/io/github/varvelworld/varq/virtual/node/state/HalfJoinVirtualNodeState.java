package io.github.varvelworld.varq.virtual.node.state;

import java.util.function.Consumer;

/**
 * Created by varvelworld on 2016/3/11.
 */
public class HalfJoinVirtualNodeState extends AbstractVirtualNodeState {
    public HalfJoinVirtualNodeState() {
        super(VirtualNodeStates.HALF_JOIN_IDENTITY);
    }

    @Override
    public void prepareJoin(Consumer<VirtualNodeState> newStateHolder, VirtualNodeStateRootAction action) {
        doEvent(newStateHolder, action, this);
    }

    @Override
    public void prepareDetach(Consumer<VirtualNodeState> newStateHolder, VirtualNodeStateRootAction action) {
        doEvent(newStateHolder, action, this);
    }

    @Override
    public void join(Consumer<VirtualNodeState> newStateHolder, VirtualNodeStateRootAction action) {
        doEvent(newStateHolder, action, VirtualNodeStates.JOINED);
    }

    @Override
    public void detach(Consumer<VirtualNodeState> newStateHolder, VirtualNodeStateRootAction action) {
        doEvent(newStateHolder, action, this);
    }
}
