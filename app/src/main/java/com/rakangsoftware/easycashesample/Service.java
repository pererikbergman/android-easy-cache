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

package com.rakangsoftware.easycashesample;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.rakangsoftware.easycache.Config;
import com.rakangsoftware.easycache.EasyCache;
import com.rakangsoftware.easycache.storage.SharedPreferenceStorage;

import java.lang.reflect.Type;
import java.util.List;

public class Service {

    private static final Type TYPE_USER_LIST = new TypeToken<List<Test>>() {}.getType();

    public Service(Context context) {
        Config config = new Config();
        config.setStorage(new SharedPreferenceStorage(context));
        EasyCache.init(config);
    }

    public void fetchAllUsers(Callback<List<User>> callback) {
        List<User> users = EasyCache.read("users", TYPE_USER_LIST);
        if (users != null && !users.isEmpty()){
            callback.onSuccess(users);
        }
        //.. Do your network call and send a second callback when result is received.

    }

    public interface Callback<K> {
        void onSuccess(K data);

        void onFail(Throwable throwable);
    }
}
