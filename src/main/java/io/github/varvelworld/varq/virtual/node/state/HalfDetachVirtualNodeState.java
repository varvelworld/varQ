package io.github.varvelworld.varq.virtual.node.state;

import java.util.function.Consumer;

/**
 * Created by varvelworld on 2016/3/11.
 */
public class HalfDetachVirtualNodeState extends AbstractVirtualNodeState {
    public HalfDetachVirtualNodeState() {
        super(VirtualNodeStates.HALF_DETACH_IDENTITY);
    }

    @Override
    public void prepareJoin(Consumer<VirtualNodeState> newStateHolder, VirtualNodeStateRootAction action) {
        doEvent(newStateHolder, action, VirtualNodeStates.HALF_JOIN);
    }

    @Override
    public void prepareDetach(Consumer<VirtualNodeState> newStateHolder, VirtualNodeStateRootAction action) {
        doEvent(newStateHolder, action, this);
    }

    @Override
    public void join(Consumer<VirtualNodeState> newStateHolder, VirtualNodeStateRootAction action) {
        doEvent(newStateHolder, action, this);
    }

    @Override
    public void detach(Consumer<VirtualNodeState> newStateHolder, VirtualNodeStateRootAction action) {
        doEvent(newStateHolder, action, VirtualNodeStates.DETACHED);
    }
}
