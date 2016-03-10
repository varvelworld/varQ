package io.github.varvelworld.varq.virtual.node.state;

/**
 * the state of virtual node
 * Created by varvelworld on 2016/3/10.
 */
public interface VirtualNodeState {
    VirtualNodeState prepareJoin();
    VirtualNodeState prepareDetach();
    VirtualNodeState join();
    VirtualNodeState detach();
}