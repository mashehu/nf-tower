/*
 * Copyright (c) 2019, Seqera Labs.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * This Source Code Form is "Incompatible With Secondary Licenses", as
 * defined by the Mozilla Public License, v. 2.0.
 */

package io.seqera.tower.exchange.trace

import groovy.transform.CompileStatic
import groovy.transform.ToString
import io.seqera.tower.enums.TraceProcessingStatus
import io.seqera.tower.exchange.BaseResponse
/**
 * Model a workflow trace complete response
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */

@CompileStatic
@ToString(includeNames = true, includePackage = false)
class TraceCompleteResponse implements BaseResponse {

    TraceProcessingStatus status
    String message
    String workflowId

    static TraceCompleteResponse ofSuccess(String workflowId) {
        new TraceCompleteResponse(status: TraceProcessingStatus.OK, workflowId: workflowId)
    }

    static TraceCompleteResponse ofError(String message) {
        new TraceCompleteResponse(status: TraceProcessingStatus.KO, message: message)
    }

}
