package com.googlecode.gwtquery.mobile.client;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.GQuery.document;

import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.js.JsUtils;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Window;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableEvent;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableHandler;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutEvent;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutHandler;

/**
 * EntryPoint to Dev app, it shows an input so as we can load a 
 * remote script with the droid app, instead of it being installed 
 * in the package file.
 * 
 * For instance, you could run the app in superdevmode  and
 * then open the any app in droid or ios and write the url value:
 * http://your-dev-computer/app/app.nocache.js
 * 
 * You could use any js so as you could play with phonegap features without
 * producing nor installing the apk with every change.
 * 
 * @author Manuel Carrasco Moñino
 */
public class MbEntryPoint implements EntryPoint {
  
  final Storage localStorage = Storage.getLocalStorageIfSupported();
  
  private void saveValue(GQuery v) {
    // Ignore when unsupported localstorage or disabled
    try {
      localStorage.setItem(v.id(), v.val());
    } catch (Exception e) {
    }
  }

  private void restoreValue(GQuery v) {
    try {
      String s = localStorage.getItem(v.id());
      if (s != null) {
        v.val(s);
      }
    } catch (Exception e) {
    }
  }
  
  @Override
  public void onModuleLoad() {
    final PhoneGap phoneGap = GWT.create(PhoneGap.class);
    final GQuery i1 = $("<input type='text' id='i1' size='50' value='http://192.168.1.6:8080/target/target-script-min.js' style='font-size: 12px'><br/>");
    final GQuery i2 = $("<input type='text' id='i2' size='50' value='http://192.168.1.6:9876/myapp/myapp.nocache.js' style='font-size: 12px'><br/>");
    final GQuery b1 = $("<button id='b'>Load weinre</Button><br/>");
    final GQuery b2 = $("<button id='b'>Load my app</Button><br/>");
    
    i1.appendTo(document);
    b1.appendTo(document);
    i2.appendTo(document);
    b2.appendTo(document);
    restoreValue(i1);
    restoreValue(i2);
    
    b1.click(new Function() { 
      int c = 0;
      public void f() {
        saveValue(i1);
        $("#ns1" + c++).remove();
        String url = i1.val() + "?" + Duration.currentTimeMillis(); 
        JsUtils.loadScript(url, "ns1" + c);
      }
    });
    
    b2.click(new Function() { 
      int c = 0;
      public void f() {
        saveValue(i2);
        $("#ns2" + c++).remove();
        String url = i2.val() + "?" + Duration.currentTimeMillis(); 
        JsUtils.loadScript(url, "ns1" + c);
      }
    });
    
    phoneGap.addHandler(new PhoneGapAvailableHandler() {
      public void onPhoneGapAvailable(PhoneGapAvailableEvent event) {
      }
    });
    
    phoneGap.addHandler(new PhoneGapTimeoutHandler() {
      public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
        Window.alert("gwt-phonegap timeout");
      }
    });
    
    phoneGap.initializePhoneGap(10000);
  }
}
