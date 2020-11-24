package com.github.kongpf8848.rxhttp;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.disposables.Disposable;

public class RxHttpTagManager {

    private Map<Object,Disposable> map= new ConcurrentHashMap<>(16);

    private static RxHttpTagManager instance;

    public static RxHttpTagManager getInstance() {
        if (instance == null) {
            synchronized (RxHttpTagManager.class) {
                if (instance == null) {
                    instance = new RxHttpTagManager();
                }
            }
        }
        return instance;
    }

    public void addTag(Object tag, Disposable disposable){
        if(tag!=null) {
            map.put(tag, disposable);
        }
    }

    public void removeTag(Object tag){
        if(tag!=null) {
            map.remove(tag);
        }
    }

    public void cancelTag(Object tag){
        if(tag!=null) {
            if (map.containsKey(tag)) {
                dispose(map.get(tag));
                removeTag(tag);
            }
        }
        else{
            Set<Map.Entry<Object,Disposable>> entrySet=map.entrySet();
            for(Map.Entry<Object,Disposable> entry:entrySet){
                dispose(entry.getValue());
            }
            map.clear();

        }
    }

    private void dispose( Disposable disposable){
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
