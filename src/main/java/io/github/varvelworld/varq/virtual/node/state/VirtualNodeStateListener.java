package io.github.varvelworld.varq.virtual.node.state;

/**
 * Created by varvelworld on 2016/3/12.
 */
@FunctionalInterface
public interface VirtualNodeStateListener {
    void action(VirtualNodeState oldState, VirtualNodeState newState, StateTransformer transformer);
}
