package com.xingkaichun.helloworldblockchain.netcore.transport.dto;


import java.io.Serializable;
import java.util.List;

/**
 * 交易
 * 属性含义参考 com.xingkaichun.helloworldblockchain.core.model.Transaction
 *
 * @author 邢开春 微信HelloworldBlockchain 邮箱xingkaichun@qq.com
 */
public class TransactionDTO implements Serializable {

    //交易时间戳
    private long timestamp;
    //交易输入
    private List<TransactionInputDTO> inputs;
    //交易输出
    private List<TransactionOutputDTO> outputs;




    //region get set

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<TransactionInputDTO> getInputs() {
        return inputs;
    }

    public void setInputs(List<TransactionInputDTO> inputs) {
        this.inputs = inputs;
    }

    public List<TransactionOutputDTO> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<TransactionOutputDTO> outputs) {
        this.outputs = outputs;
    }

    //endregion
}