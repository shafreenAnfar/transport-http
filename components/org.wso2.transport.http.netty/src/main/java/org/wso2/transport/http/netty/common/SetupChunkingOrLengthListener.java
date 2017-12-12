package org.wso2.transport.http.netty.common;

import org.wso2.transport.http.netty.message.HTTPCarbonMessage;

/**
 * Get notified once chuncking or content-length is inferred.
 */
public interface SetupChunkingOrLengthListener {

    /**
     * Gets notified one the operation is completed.
     * @param httpCarbonMessage after processing
     */
    void onOperationComplete(HTTPCarbonMessage httpCarbonMessage);
}
