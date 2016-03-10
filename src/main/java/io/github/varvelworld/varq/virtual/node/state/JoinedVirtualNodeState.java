package io.github.varvelworld.varq.virtual.node.state;

/**
 * Created by varvelworld on 2016/3/11.
 */
public class JoinedVirtualNodeState extends AbstractVirtualNodeState {
    public JoinedVirtualNodeState() {
        super(VirtualNodeStates.JOINED_IDENTITY);
    }

    @Override
    public VirtualNodeState prepareJoin() {
        return this;
    }

    @Override
    public VirtualNodeState prepareDetach() {
        return VirtualNodeStates.HALF_DETACH;
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
