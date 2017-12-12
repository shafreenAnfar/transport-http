/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.transport.http.netty.common;

import org.wso2.transport.http.netty.message.HTTPCarbonMessage;

/**
 * Holds a future result of Chuncking for Length.
 */
public class SetupChunkingOrLengthFuture {

    private SetupChunkingOrLengthListener setupChunkingOrLengthListener;
    private HTTPCarbonMessage httpCarbonMessage;

    public void setSetupChunkingOrLengthListener(SetupChunkingOrLengthListener setupChunkingOrLengthListener) {
        this.setupChunkingOrLengthListener = setupChunkingOrLengthListener;
        if (httpCarbonMessage != null) {
            this.notifyChunkingOrLengthListener(httpCarbonMessage);
        }
    }

    public void notifyChunkingOrLengthListener(HTTPCarbonMessage httpCarbonMessage) {
        if (setupChunkingOrLengthListener == null) {
            this.httpCarbonMessage = httpCarbonMessage;
        } else {
            this.setupChunkingOrLengthListener.onOperationComplete(httpCarbonMessage);
        }
    }

    public void removeChunkingOrLengthListener() {
        this.setupChunkingOrLengthListener = null;
    }
}
