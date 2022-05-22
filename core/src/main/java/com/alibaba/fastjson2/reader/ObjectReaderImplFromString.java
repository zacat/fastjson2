package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;

import java.util.function.Function;

public final class ObjectReaderImplFromString<T>
        extends ObjectReaderBaseModule.PrimitiveImpl<T> {
    final Function<String, T> creator;

    public ObjectReaderImplFromString(Function<String, T> creator) {
        this.creator = creator;
    }

    @Override
    public T readJSONBObject(JSONReader jsonReader, long features) {
        String str = jsonReader.readString();
        if (str == null || str.isEmpty()) {
            return null;
        }

        return creator.apply(str);
    }

    @Override
    public T readObject(JSONReader jsonReader, long features) {
        String str = jsonReader.readString();
        if (str == null) {
            return null;
        }

        return creator.apply(str);
    }
}
