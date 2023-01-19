import React, { useEffect, useState } from 'react'
import { StyleSheet, View, Text } from 'react-native'
import { isMaestro } from 'react-native-is-maestro'

export default function App() {
    const [result, setResult] = useState<boolean>()

    useEffect(() => {
        setResult(isMaestro())
    }, [])

    return (
        <View style={styles.container}>
            <Text>is Maestro detected: {result ? 'yes' : 'no'}</Text>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center'
    },
    box: {
        width: 60,
        height: 60,
        marginVertical: 20
    }
})
