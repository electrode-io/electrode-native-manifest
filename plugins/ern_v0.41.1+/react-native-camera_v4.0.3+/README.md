# react-native-camera plugin

Plugin configuration for [react-native-camera](https://github.com/react-native-community/react-native-camera)

## Android

This configuration is using the `general` product flavor of this native module (using google `play-services-vision` under the hood).

The required `android.permission.CAMERA` is defined in the configuration and will be injected by default.

**If you need to enable the video recording feature of this plugin** you can either add the following permissions in your application `AndroidManifest.xml`

```java
  <uses-permission android:name="android.permission.RECORD_AUDIO"/>
  <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
  ```

Alternatively, you can also override this configuration in your own manifest to add the additional permissions to the `permissions` array of the plugin configuration.

## iOS

The container Podfile is stored in manifest and is templatized (mustache) so that it can be tweaked. [For example here is the Podfile in public manifest for RN 0.64.0+](https://github.com/electrode-io/electrode-native-manifest/blob/62a5bfffffb1d07562be87719f35260c033a057a/plugins/ern_v0.45.0%2B/react-native_v0.64.0%2B/Podfile)

As you can see, one can add extra pod spec sources, extra podfile statements or even extra pods to it.

In case of react-native-camera, what you care about is [extraPods](https://github.com/electrode-io/electrode-native-manifest/blob/62a5bfffffb1d07562be87719f35260c033a057a/plugins/ern_v0.45.0%2B/react-native_v0.64.0%2B/Podfile#L47-L49) that can be used by plugins to inject extra pod declarations to the Podfile. [This is documented in our doc](https://native.electrode.io/reference/index-2/native-modules#ios) but for example you can see one such use in [this plugin configuration](https://github.com/electrode-io/electrode-native-manifest/blob/62a5bfffffb1d07562be87719f35260c033a057a/plugins/ern_v0.45.0%2B/react-native-permissions_v2.2.0%2B/config.json#L6-L12).

So if all is needed is to add this line let's say
`pod 'react-native-camera', path: '../node_modules/react-native-camera', subspecs: [ 'FaceDetectorMLKit' ]`
You can do it directly in react-native-camera plugin configuration (should be done in their override manifest because we don't want everyone to get these extra pods as its optional, so they'll have to copy react-native-camera config from this public manifest in their own manifest and modify it there), by adding this extra config line to `ios` block
```
"extraPods": [  
  "pod 'react-native-camera', path: 'node_modules/react-native-camera', subspecs: [ 'FaceDetectorMLKit' ]"
]
```
Note that the path to node modules should not include the ../ here.

Then the `iOS` block would something like this

```
 "ios": {
    "extraPods": [
      "pod 'react-native-camera', path: 'node_modules/react-native-camera', subspecs: [ 'BarcodeDetectorMLKit' ]"
    ],
    "copy": [
      {
        "dest": "{{{projectName}}}/Libraries/RNCamera",
        "source": "ios/*"
      }
    ],
    "pbxproj": {
      "addHeaderSearchPath": [
        "\"$(SRCROOT)/{{{projectName}}}/Libraries/RNCamera/**\""
      ],
      "addProject": [
        {
          "group": "Libraries",
          "path": "RNCamera/RNCamera.xcodeproj",
          "staticLibs": [
            {
              "name": "libRNCamera.a",
              "target": "RNCamera"
            }
          ]
        }
      ]
    }
  }
```


Also please keep in mind that there may be fringe cases where extraPods , extraPodspecsSources, and extraPodfileStatements are not enough to customize the Podfile (should not be the case here). In this case, it is also possible to copy the react native plugin configuration / podfile from public manifest to team override manifest and directly change it there. 

This should however only be done as last resort if current customization options of ERN are not enough.