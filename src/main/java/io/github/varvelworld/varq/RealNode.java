package io.github.varvelworld.varq;

import java.util.TreeSet;

/**
 * the real node of consistent hashing, it contains some virtual node
 * Created by varvelworld on 2016/3/10.
 */
public class RealNode {
    private TreeSet<VirtualNode> virtualNodes;

    public TreeSet<VirtualNode> getVirtualNodes() {
        return virtualNodes;
    }

    public void setVirtualNodes(TreeSet<VirtualNode> virtualNodes) {
        this.virtualNodes = virtualNodes;
    }
}
