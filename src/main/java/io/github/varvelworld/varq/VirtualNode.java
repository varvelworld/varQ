package io.github.varvelworld.varq;

import io.github.varvelworld.varq.virtual.node.state.VirtualNodeState;
import io.github.varvelworld.varq.virtual.node.state.VirtualNodeStateContext;
import io.github.varvelworld.varq.virtual.node.state.VirtualNodeStates;

/**
 * an virtual node in consistent hashing
 * Created by varvelworld on 2016/3/10.
 */
public class VirtualNode {
    final private long num;    // the number of current virtual node
    final private long pre;    // the number of preceded virtual node
    private VirtualNodeStateContext stateContext;
    private VirtualNodeStateContext preStateContext;

    public VirtualNode(long num, long pre) {
        this.num = num;
        this.pre = pre;
    }

    /** begin of get/set method **/

    public long getNum() {
        return num;
    }

    public long getPre() {
        return pre;
    }

    public VirtualNodeState getState() {
        return this.stateContext.getState();
    }

    /** end of get/set method **/
}
