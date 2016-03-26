package io.github.varvelworld.varq.virtual.node.state;

/**
 * Created by varvelworld on 2016/3/11.
 */
public class DetachedVirtualNodeState extends AbstractVirtualNodeState {

    public DetachedVirtualNodeState() {
        super(VirtualNodeStates.DETACHED_IDENTITY);
    }

    @Override
    public VirtualNodeState prepareJoin() {
        return VirtualNodeStates.HALF_JOIN;
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
        return this;
    }
}
