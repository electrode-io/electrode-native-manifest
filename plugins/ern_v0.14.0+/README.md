## Electrode Native v0.14 changes

**- Introduce a new Android plugin directive : `permissions`.**  [#606](https://github.com/electrode-io/electrode-native/pull/606)  
This directive takes an array of strings representing the [Android permissions](https://developer.android.com/guide/topics/permissions/overview) to inject in the Container. This can be used in case a plugin requires specific permissions in order to properly operate.
