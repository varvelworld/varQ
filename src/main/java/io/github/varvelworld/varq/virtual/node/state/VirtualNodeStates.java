package io.github.varvelworld.varq.virtual.node.state;

/**
 * Created by varvelworld on 2016/3/11.
 */
final public class VirtualNodeStates {
    static final int DETACHED_IDENTITY = 0;
    static final int HALF_JOIN_IDENTITY = 1;
    static final int JOINED_IDENTITY = 2;
    static final int HALF_DETACH_IDENTITY = 3;

    public final static VirtualNodeState DETACHED = new DetachedVirtualNodeState();
    public final static VirtualNodeState HALF_JOIN = new HalfJoinVirtualNodeState();
    public final static VirtualNodeState JOINED = new JoinedVirtualNodeState();
    public final static VirtualNodeState HALF_DETACH = new HalfDetachVirtualNodeState();
}
