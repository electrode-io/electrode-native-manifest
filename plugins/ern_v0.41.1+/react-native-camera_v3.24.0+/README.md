# react-native-camera plugin

Plugin configuration for [react-native-camera](https://github.com/react-native-community/react-native-camera)


This configuration is using the `general` product flavor of this native module (using google `play-services-vision` under the hood).

The required `android.permission.CAMERA` is defined in the configuration and will be injected by default.

**If you need to enable the video recording feature of this plugin** you can either add the following permissions in your application `AndroidManifest.xml`

```java
  <uses-permission android:name="android.permission.RECORD_AUDIO"/>
  <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
  ```

Alternatively, you can also override this configuration in your own manifest to add the additional permissions to the `permissions` array of the plugin configuration.

**If you want to use the MLKit flavor rather than the general one** then you should override this configuration in your own manifest and replace the [`config.json`])(./config.json) file with the [`config-mlkit.json`](./config-mlkit.json) file.

**If you need other versions of listed dependencies** then you should override this configuration in your own manifest and update the versions at your convenience.