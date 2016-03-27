package io.github.varvelworld.varq.virtual.node.state;


/**
 * the state of virtual node, it is immutable object
 * Created by varvelworld on 2016/3/10.
 */
public interface VirtualNodeState extends VirtualNodeStateEventTrigger {
    int getIdentity();
}