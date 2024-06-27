import { Image, View, Text, StyleSheet } from 'react-native'
import 'react-native-reanimated'
import { isMaestro } from 'react-native-is-maestro'

const RootLayout = () => (
    <View style={styles.container}>
        <Image
            style={styles.logo}
            source={require('../assets/images/react-logo.png')}
        />
        <Text>
            isMaestro detected: {isMaestro() ? 'yes' : 'no'}
        </Text>
    </View>
)

export default RootLayout

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
    },
    logo: {
        height: 200,
        width: 200
    }
})
