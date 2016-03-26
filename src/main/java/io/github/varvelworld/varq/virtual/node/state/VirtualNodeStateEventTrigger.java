package io.github.varvelworld.varq.virtual.node.state;

/**
 * each method return new state for each event
 * Created by luzhonghao on 16/3/27.
 */
public interface VirtualNodeStateEventTrigger {
    VirtualNodeState prepareJoin();
    VirtualNodeState prepareDetach();
    VirtualNodeState join();
    VirtualNodeState detach();
}
