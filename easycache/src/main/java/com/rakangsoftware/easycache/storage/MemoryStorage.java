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

package com.rakangsoftware.easycache.storage;

import java.util.HashMap;
import java.util.Map;

public class MemoryStorage implements Storage {

    private Map<String, String> mMap = new HashMap<>();

    @Override
    public void write(final String key, final String value) {
        mMap.put(key, value);
    }

    @Override
    public String read(final String key) {
        return mMap.get(key);
    }
}
