package io.github.varvelworld.varq;

import io.github.varvelworld.varq.virtual.node.state.VirtualNodeState;
import io.github.varvelworld.varq.virtual.node.state.VirtualNodeStates;

/**
 * an virtual node in consistent hashing
 * Created by varvelworld on 2016/3/10.
 */
public class VirtualNode {
    private long num;    // the number of current virtual node
    private long pre;    // the number of preceded virtual node
    private long next;   // the number of next virtual node
    private VirtualNodeState state = VirtualNodeStates.DETACHED;

    public void prepareJoin() {
        state.prepareJoin(newState -> state = newState);
    }

    public void prepareDetach() {
        state.prepareDetach(newState -> state = newState);
    }


    /** begin of get/set method **/
    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public long getPre() {
        return pre;
    }

    public void setPre(long pre) {
        this.pre = pre;
    }

    public long getNext() {
        return next;
    }

    public void setNext(long next) {
        this.next = next;
    }

    public VirtualNodeState getState() {
        return state;
    }

    public void setState(VirtualNodeState state) {
        this.state = state;
    }
    /** end of get/set method **/
}
