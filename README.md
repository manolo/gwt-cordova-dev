/*
 * Copyright 2012 Manuel Carrasco Monino (manolo at apache org)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


This project includes a couple of maven modules which produces a droid apk ready to install in any device.

To produce the apk just run:
$ mvn clean package -Pdroid -Psign

And you will get the following pakage
mb-droid/target/mb-droid-1.0.apk


Install the application in your mobile and run it, then you will get two input boxes where you can write your winre server url, and the url for your application main script (normally myapp.nocache.js in the case of gwt).

The main goals of this application are:
 - Debug your DOM and your JS with weinre
 - Load your application from remote servers instead of locally so as you dont need to compile and deploy your app each time
 - Edit JS files and load them in your mobile
 - Run your GWT app from an superdev server. In this case you could recompile your gwt app (using your desktop browser) and reload the app in your device pushing again the appropriate button.



