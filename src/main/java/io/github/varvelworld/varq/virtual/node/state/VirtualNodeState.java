package io.github.varvelworld.varq.virtual.node.state;

import java.util.function.Consumer;

/**
 * the state of virtual node
 * Created by varvelworld on 2016/3/10.
 */
public interface VirtualNodeState {
    void prepareJoin(Consumer<VirtualNodeState> newStateHolder, VirtualNodeStateRootAction action);
    void prepareDetach(Consumer<VirtualNodeState> newStateHolder, VirtualNodeStateRootAction action);
    void join(Consumer<VirtualNodeState> newStateHolder, VirtualNodeStateRootAction action);
    void detach(Consumer<VirtualNodeState> newStateHolder, VirtualNodeStateRootAction action);
}