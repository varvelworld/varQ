package io.github.varvelworld.varq.virtual.node.state;

/**
 * Created by varvelworld on 2016/3/11.
 */
public class HalfJoinVirtualNodeState extends AbstractVirtualNodeState {
    public HalfJoinVirtualNodeState() {
        super(VirtualNodeStates.HALF_JOIN_IDENTITY);
    }

    @Override
    public VirtualNodeState prepareJoin() {
        return this;
    }

    @Override
    public VirtualNodeState prepareDetach() {
        return this;
    }

    @Override
    public VirtualNodeState join() {
        return VirtualNodeStates.JOINED;
    }

    @Override
    public VirtualNodeState detach() {
        return this;
    }
}
