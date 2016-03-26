package io.github.varvelworld.varq.virtual.node.state;

/**
 * Created by varvelworld on 2016/3/11.
 */
abstract public class AbstractVirtualNodeState implements VirtualNodeState {
    final private int identity;

    AbstractVirtualNodeState(int identity) {
        this.identity = identity;
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
}
