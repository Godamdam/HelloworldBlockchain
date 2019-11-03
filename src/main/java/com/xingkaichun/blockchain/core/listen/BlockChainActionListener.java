package com.xingkaichun.blockchain.core.listen;

import com.xingkaichun.blockchain.core.model.Block;

/**
 * 监听核心区块链区块增、删的动作
 */
public interface BlockChainActionListener {

    void addOrDeleteBlock(Block block, BlockChainActionEnum blockChainActionEnum);
}