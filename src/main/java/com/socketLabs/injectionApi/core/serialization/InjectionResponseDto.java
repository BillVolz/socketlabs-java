package com.socketLabs.injectionApi.core.serialization;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class InjectionResponseDto {

    /** The resulting response ErrorCode of the Injection Api send request */
    @JsonProperty("ErrorCode")
    private String errorCode;

    /**
    * A unique key generated by the Injection API if an unexpected error occurs during the SocketLabsClient send request.
    * This unique key can be used by SocketLabs support to troubleshoot the issue.
    */
    @JsonProperty("TransactionReceipt")
    private String transactionReceipt;

    /** An array of MessageResultDto objects that contain the status of each message sent. */
    @JsonProperty("MessageResults")
    private List<MessageResultDto> messageResults;

    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getTransactionReceipt() {
        return transactionReceipt;
    }
    public void setTransactionReceipt(String transactionReceipt) {
        this.transactionReceipt = transactionReceipt;
    }

    public List<MessageResultDto> getMessageResults() {
        return messageResults;
    }
    public void setMessageResults(List<MessageResultDto> messageResults) {
        this.messageResults = messageResults;
    }
}
