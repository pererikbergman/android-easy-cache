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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.rakangsoftware.easycache.Config;
import com.rakangsoftware.easycache.EasyCache;
import com.rakangsoftware.easycache.storage.SharedPreferenceStorage;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Config config = new Config();
        config.setStorage(new SharedPreferenceStorage(this));
        EasyCache.init(config);

        EasyCache.write("key", new Test("t", "d"));
        Test str = EasyCache.read("key", Test.class);
        Log.d(TAG, "onCreate: str = " + str);

        List<Test> testList = new ArrayList<>();
        testList.add(new Test("t1", "d1"));
        testList.add(new Test("t2", "d2"));
        testList.add(new Test("t3", "d3"));
        EasyCache.write("keyList", testList);
        Type       listType = new TypeToken<List<Test>>() {}.getType();
        List<Test> list     = EasyCache.read("keyList", listType);
        Log.d(TAG, "onCreate: list = " + list.size());
;
    }
}
