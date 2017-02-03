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

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceStorage implements Storage {

    private final Context mContext;
    private final String  mPreferenceFileKey;

    public SharedPreferenceStorage(final Context context) {
        mContext = context.getApplicationContext();
        mPreferenceFileKey = "com.rakangsoftware.easycache.storage";
    }

    public SharedPreferenceStorage(final Context context, final String preferenceFileKey) {
        mContext = context;
        mPreferenceFileKey = preferenceFileKey;
    }

    @Override
    public void write(final String key, final String value) {
        getSharedPreferences(mContext).edit().putString(key, value).apply();
    }

    @Override
    public String read(final String key) {
        return getSharedPreferences(mContext).getString(key, null);
    }

    private SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(
                mPreferenceFileKey,
                Context.MODE_PRIVATE
        );
    }

}
