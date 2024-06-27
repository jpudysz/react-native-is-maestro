# react-native-is-maestro

This React Native library provides a way to detect synchronously if the app is currently running in an E2E test environment with [Maestro](https://maestro.mobile.dev). It can be useful for disabling certain functionality or UI elements that may interfere with the test. To use the library, simply import it and call the `isMaestro()` function.

## Installation

```sh
npm install react-native-is-maestro
yarn add react-native-is-maestro
```

## Auto-linking
```sh
cd ios && pod install
```

## Expo
Works out of the box without any addition config

## Usage
```tsx
import React from 'react'
import { StyleSheet, View, Text } from 'react-native'
import { isMaestro } from 'react-native-is-maestro'

export const App = () => (
    <View style={styles.container}>
        <Text>
            isMaestro detected: {isMaestro() ? 'yes' : 'no'}
        </Text>
    </View>
)

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center'
    }
})
```

## Supported versions

This library is fully compatible with TypeScript and can be used on both iOS and Android platforms. It also supports both old (Paper) and new architecture (Fabric) of React Native.

| Lib version | RN version | Maestro CLI |
|-------------|------------|-------------|
| 1.0         | \>= 0.71   | \>= 1.19    |
| 2.0         | \>= 0.71   | \>= 1.22.1  |
| 3.0         | \>= 0.74   | \>= 1.36.0  |


## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
