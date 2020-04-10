# Electrode Native - Master Manifest

Please read the [documentation][1] for more information.

## Which directory should I use for a new plugin configuration

If you are introducing a new plugin configuration, choosing the right directory
in which to store the configuration might look puzzling at first.

To know which directory to use for a new plugin configuration, just go through
the following bullet points from top to bottom.

- Does your plugin configuration needs to support React Native >= 0.61.0 ?\
Use `ern_v0.41.0+`

- Does your plugin configuration use `features` directive for Android, or `applyPatch` directive?\
Use `ern_v0.39.0+`

- Does your plugin configuration use `replaceInFile` directive for Android?\
Use `ern_v0.34.0+`

- Does your plugin configuration use `setBuildSettings` directive for iOS?\
Use `ern_v0.33.0+`

- Does your plugin configuration use `permissions` directive for Android?\
Use `ern_v0.14.0+`

- Otherwise\
Use `ern_v0.13.0+`

Picking the right directory will make sure that your plugin configuration is
made available to the maximum possible range of `ern` client versions, while
guaranteeing that it won't be exposed to incompatible `ern` client versions.

## Changelog of plugin configuration directives

### Electrode Native v0.14 changes

**Adds a new Android plugin directive: `permissions`:** [#606][3]\
This directive takes an array of strings representing the [Android permissions][2]
to inject in the Container. This can be used in case a plugin requires specific
permissions in order to properly operate.

### Electrode Native v0.33 changes

**Adds a new iOS plugin directive: `setBuildSettings`:** [#1196][4]\
This directive allows to update build settings in the plugin pbxproj or any
pbxproj part of the plugin package.

### Electrode Native v0.34 changes

**Adds a new Android plugin directive: `replaceInFile`:** [#1197][5]\
This directive allows to replace content in any files included in the Container.

### Electrode Native v0.41 changes

**Adds support for React Native >= 0.61.0:** [#1542][6]\

[1]: https://native.electrode.io/reference/index-3
[2]: https://developer.android.com/guide/topics/permissions/overview
[3]: https://github.com/electrode-io/electrode-native/pull/606
[4]: https://github.com/electrode-io/electrode-native/pull/1196
[5]: https://github.com/electrode-io/electrode-native/pull/1197
[6]: https://github.com/electrode-io/electrode-native/pull/1542
