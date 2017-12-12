package org.wso2.transport.http.netty.message;

/**
 * Get notified when content length is calculated.
 */
public interface GetMessageContentLengthListener {

    /**
     * Get notified when the content length is calculated.
     * @param length of the content
     */
    void onOperationComplete(int length);
}
