import React from 'react'
import { StyleSheet, View, Text } from 'react-native'
import { isMaestro } from 'react-native-is-maestro'

export const App = () => (
    <View style={styles.container}>
        <Text>isMaestro detected: {isMaestro() ? 'yes' : 'no'}</Text>
    </View>
)

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center'
    }
})
