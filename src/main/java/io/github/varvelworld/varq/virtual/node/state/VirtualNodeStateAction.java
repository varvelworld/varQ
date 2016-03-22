package io.github.varvelworld.varq.virtual.node.state;

/**
 * Created by varvelworld on 2016/3/12.
 */
@FunctionalInterface
public interface VirtualNodeStateAction {
    void doAction(VirtualNodeState oldState, VirtualNodeState newState, Transformer transformer);
}
