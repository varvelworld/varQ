package io.github.varvelworld.varq;

import io.github.varvelworld.varq.virtual.node.state.VirtualNodeState;
import io.github.varvelworld.varq.virtual.node.state.VirtualNodeStateContext;
import io.github.varvelworld.varq.virtual.node.state.VirtualNodeStates;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

/**
 * an virtual node in consistent hashing
 * TODO
 * Created by varvelworld on 2016/3/10.
 */
public class VirtualNode implements Watcher {
    final private String path;
    final private long num;    // the number of current virtual node
    private VirtualNodeStateContext stateContext;
    private Long pre;    // the number of preceded virtual node
    private VirtualNodeStateContext preStateContext;
    private ZooKeeper zooKeeper;

    public VirtualNode(ZooKeeper zooKeeper, String path, long num) throws KeeperException, InterruptedException {
        zooKeeper.create(path + "/" + num
                , new byte[]{Integer.valueOf(VirtualNodeStates.DETACHED.getIdentity()).byteValue()}
                , ZooDefs.Ids.OPEN_ACL_UNSAFE
                , CreateMode.EPHEMERAL);

        this.num = num;
        VirtualNodeState initState = VirtualNodeStates.getStateByIdentity(
                Integer.parseInt(new String(zooKeeper.getData(path + "/" + num, this, new Stat()))));
        this.stateContext = new VirtualNodeStateContext(initState
                , (oldState, newState, transformer) -> {
                    try {
                        if(VirtualNodeStates.DETACHED.equals(oldState)
                                && VirtualNodeStates.HALF_JOIN.equals(newState)) {
                            zooKeeper.setData(path + "/" + num
                                    , new byte[]{Integer.valueOf(VirtualNodeStates.HALF_DETACH.getIdentity()).byteValue()}
                                    , -1); // FIXME 忽略版本
                        }
                        else if(VirtualNodeStates.HALF_JOIN.equals(oldState)
                                && VirtualNodeStates.JOINED.equals(newState)) {
                            // TODO 获取前节点,信息,并watch
                        }
                        transformer.doTransformState();
                    } catch (KeeperException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
        });
        this.zooKeeper = zooKeeper;
        this.path = path;
    }

    public void doJoin() {
        stateContext.prepareJoin(); // 准备加入
    }

    public void doDetach() {
        stateContext.prepareDetach(); // 准备推出
    }

    /** begin of get/set method **/

    public long getNum() {
        return num;
    }

    public Long getPre() {
        return pre;
    }

    public VirtualNodeState getState() {
        return this.stateContext.getState();
    }

    /** end of get/set method **/


    @Override
    public void process(WatchedEvent event) {
        try {
            if(Event.EventType.NodeDataChanged.equals(event.getType())) {
                VirtualNodeState nowState =
                        VirtualNodeStates.getStateByIdentity(
                                Integer.parseInt(new String(zooKeeper.getData(path + "/" + num, this, new Stat()))));
                if(VirtualNodeStates.JOINED.equals(nowState)) {
                    stateContext.join();
                }
                else if(VirtualNodeStates.DETACHED.equals(nowState)) {
                    stateContext.detach();
                }
            }

        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
