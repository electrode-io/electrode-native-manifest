## Electrode Native v0.13 changes

**- Update Android plugin hook mechanism**  [#574](https://github.com/electrode-io/electrode-native/pull/574)
All Android plugin hook classes (in `.java` source file associated to each Android supported plugin) are now required to implement `ReactPlugin` interface. Optional plugin configuration class is now required to implement the `ReactPluginConfig` interface.
