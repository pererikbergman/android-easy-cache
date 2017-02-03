/*
 * Copyright 2017 Per-Erik Bergman (bergman@uncle.se)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rakangsoftware.easycache;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class EasyCache {

    private static EasyCache sInstance = new EasyCache();

    private Config mConfig;

    private EasyCache() {
    }

    public Config getConfig() {
        return mConfig;
    }

    private static EasyCache getInstance() {
        return sInstance;
    }

    public static void init(Config config) {
        getInstance().mConfig = config;
    }

    public static final void write(String key, Object o) {
        validate();
        getInstance().mConfig.getStorage().write(key, new Gson().toJson(o));
    }

    public static <K> K read(String key, Type type) {
        validate();
        String str = getInstance().getConfig().getStorage().read(key);
        return new Gson().fromJson(str, type);
    }

    private static void validate() {
        if (getInstance().getConfig() == null) {
            throw new IllegalStateException("init(...) needs to be called before using this method.");
        }
    }


}
