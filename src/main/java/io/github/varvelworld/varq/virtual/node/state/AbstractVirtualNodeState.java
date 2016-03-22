package io.github.varvelworld.varq.virtual.node.state;

import java.util.function.Consumer;

/**
 * Created by varvelworld on 2016/3/11.
 */
abstract public class AbstractVirtualNodeState implements VirtualNodeState {
    final private int identity;

    public AbstractVirtualNodeState(int identity) {
        this.identity = identity;
    }

    public int getIdentity() {
        return identity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractVirtualNodeState that = (AbstractVirtualNodeState) o;

        return identity == that.identity;
    }

    @Override
    public int hashCode() {
        return identity;
    }

    protected void doEvent(Consumer<VirtualNodeState> newStateHolder
            , VirtualNodeStateRootAction action, VirtualNodeState newState) {
        action.doAction(this, newState, () -> newStateHolder.accept(newState));
    }
}
