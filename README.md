# Electrode Native - Master Manifest

Please read the documentation for more information: https://native.electrode.io/reference/index-3

## Which directory should I use for a new plugin configuration ?

If you are introducing a new plugin configuration, choosing the right directory in which to store the configuration might look puzzling at first.

To know which directory to use for a new plugin configuration, just go through the following bullet points from top to bottom.

- Does your plugin configuration use `replaceInFile` directive for Android ?  
Use `ern_v0.34.0+`

- Does your plugin configuration use `setBuildSettings` directive for iOS ?  
Use `ern_v0.33.0+`

- Does your plugin configuration use `permissions` directive for Android ?  
Use `ern_v0.14.0+`

- Otherwise  
Use `ern_v0.13.0+`

Picking the right directory will make sure that your plugin configuration is made available to the maximum possible range of `ern` client versions, while guaranteeing that it won't be exposed to incompatible `ern` client versions.

## Changelog of plugin configuration directives 

### Electrode Native v0.14 changes

**- Introduce a new Android plugin directive : `permissions`.**  [#606](https://github.com/electrode-io/electrode-native/pull/606)
This directive takes an array of strings representing the [Android permissions](https://developer.android.com/guide/topics/permissions/overview) to inject in the Container. This can be used in case a plugin requires specific permissions in order to properly operate.

### Electrode Native v0.33 changes

**- Introduce a new iOS plugin directive : `setBuildSettings`.**  [#1196](https://github.com/electrode-io/electrode-native/pull/1196)
This directive allows to update build settings in the plugin pbxproj or any pbxproj part of the plugin package.

### Electrode Native v0.34 changes

**- Add support of `replaceInFile` directive for Android**  [#1197](https://github.com/electrode-io/electrode-native/pull/1197)
This directive allows to replace content in any files included in the Container.
