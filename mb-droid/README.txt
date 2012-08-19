
- To generate debug signed apk run:
$ mvn clean package

- To generate production signed apk run:
$ mvn clean package -Psign

- Generate production key (note that the project comes with a generated test key)
keytool -genkey -v -keystore mb.ks -alias mb-dev -keyalg RSA -keysize 2048 -validity 10000

- Check .apk sign
jarsigner -certs -verbose -verify target/*.apk

- To make fb authetication work, we should run this command in each system which generates the .apk

keytool -exportcert -alias mb-dev -keystore mb.ks | openssl sha1 -binary | openssl base64

- Then you have to put the value in the 'Android key hash' field in the FB App Dashboard

https://developers.facebook.com/apps/xxxxxxxx



        (c) Manuel Carrasco Monino, 2012
