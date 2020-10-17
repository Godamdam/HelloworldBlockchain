package com.xingkaichun.helloworldblockchain.core.tools;

import com.xingkaichun.helloworldblockchain.core.model.Block;
import com.xingkaichun.helloworldblockchain.core.model.transaction.Transaction;
import com.xingkaichun.helloworldblockchain.core.model.transaction.TransactionOutput;
import com.xingkaichun.helloworldblockchain.core.model.transaction.TransactionType;
import com.xingkaichun.helloworldblockchain.core.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Transaction工具类
 *
 * @author 邢开春 微信HelloworldBlockchain 邮箱xingkaichun@qq.com
 */
public class TransactionPropertyTool {

    private static final Logger logger = LoggerFactory.getLogger(TransactionPropertyTool.class);


    /**
     * 校验交易的属性是否与计算得来的一致
     * TODO 实际上这个方法可以省略
     */
    public static boolean isTransactionWriteRight(Block block, Transaction transaction) {
        if(!isTransactionTimestampRight(block,transaction)){
            return false;
        }
        if(!isTransactionHashRight(transaction)){
            return false;
        }
        List<TransactionOutput> outputs = transaction.getOutputs();
        if(outputs == null || outputs.size()==0){
            return true;
        }
        for(TransactionOutput transactionOutput:outputs){
            if(!isTransactionOutputHashRight(transaction,transactionOutput)){
                return false;
            }
        }
        return true;
    }

    /**
     * 交易的时间戳是否正确
     */
    public static boolean isTransactionTimestampRight(Block block, Transaction transaction) {
        if(transaction.getTransactionType() == TransactionType.COINBASE){
            //校验：COINBASE交易时间戳是否与区块时间戳相同
            if(transaction.getTimestamp() != block.getTimestamp()){
                logger.debug("COINBASE交易时间戳与区块时间戳不一致");
                return false;
            }
        }else if(transaction.getTransactionType() == TransactionType.NORMAL){

        }else {
            logger.debug("不能识别的交易类型");
            return false;
        }
        return true;
    }

    /**
     * 校验交易的哈希是否正确
     */
    public static boolean isTransactionHashRight(Transaction transaction) {
        String targetTransactionHash = TransactionTool.calculateTransactionHash(transaction);
        return StringUtil.isEquals(targetTransactionHash,transaction.getTransactionHash());
    }

    /**
     * 校验交易输出的哈希是否正确
     */
    public static boolean isTransactionOutputHashRight(Transaction transaction,TransactionOutput output) {
        String targetTransactionOutputHash = TransactionTool.calculateTransactionOutputHash(transaction,output);
        return StringUtil.isEquals(targetTransactionOutputHash,output.getTransactionOutputHash());
    }
}
