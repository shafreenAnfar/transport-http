package org.wso2.transport.http.netty.message;

/**
 * Notifies listener once the content length is calculated.
 */
public class GetMessageContentLengthFuture {

    private GetMessageContentLengthListener getMessageContentLengthListener;
    private int length = -1;

    public void setContentListener(GetMessageContentLengthListener getMessageContentLengthListener) {
        this.getMessageContentLengthListener = getMessageContentLengthListener;
        if (this.length > -1) {
            this.notifyContentLengthListener(length);
        }
    }

    public void notifyContentLengthListener(int length) {
        if (getMessageContentLengthListener == null) {
            this.length = length;
        } else {
            this.getMessageContentLengthListener.onOperationComplete(length);
        }
    }

    public void removeContentLengthListener() {
        this.getMessageContentLengthListener = null;
    }
}
