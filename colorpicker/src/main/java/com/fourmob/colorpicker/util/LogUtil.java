/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fourmob.colorpicker.util;

import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

/**
 * for printing the error message.
 */
public class LogUtil {

    private LogUtil() {
    }

    /**
     * Print error log.
     *
     * @param tag log tag
     * @param message log message
     */
    public static void error(String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0, tag);
        HiLog.error(label, message);
    }

    /**
     * Print debug log.
     *
     * @param tag log tag
     * @param msg log message
     */
    public static void debug(String tag, String msg) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0, tag);
        HiLog.debug(label, msg);
    }

    /**
     * Print warn log.
     *
     * @param tag log tag
     * @param msg log message
     */
    public static void warn(String tag, String msg) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0, tag);
        HiLog.warn(label, msg);
    }
}
