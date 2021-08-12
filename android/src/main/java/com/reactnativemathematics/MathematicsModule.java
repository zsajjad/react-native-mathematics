package com.reactnativemathematics;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Map;

@ReactModule(name = MathematicsModule.NAME)
public class MathematicsModule extends ReactContextBaseJavaModule {
    public static final String NAME = "Mathematics";

    public MathematicsModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void calculate(ReadableMap formulae, Promise promise) {
      WritableMap output = Arguments.createMap();;
      for(String key: formulae.toHashMap().keySet()) {
        ReadableMap data = formulae.getMap(key);
        String formula = data.getString("formula");
        ReadableMap values = data.getMap("values");

        Expression e = new ExpressionBuilder(formula)
          .variables(values.toHashMap().keySet())
          .build();

        for(String valueKey: values.toHashMap().keySet()) {
          e.setVariable(valueKey, values.getDouble(valueKey));
        }

        double result = e.evaluate();
        output.putDouble(key, result);
        System.out.println(key);
      }

      promise.resolve(output);
    }

}
