package io.github.varvelworld.varq.virtual.node.state;

/**
 * Created by varvelworld on 2016/3/11.
 */
public class HalfDetachVirtualNodeState extends AbstractVirtualNodeState {
    public HalfDetachVirtualNodeState() {
        super(VirtualNodeStates.HALF_DETACH_IDENTITY);
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
        return this;
    }

    @Override
    public VirtualNodeState detach() {
        return VirtualNodeStates.DETACHED;
    }
}
