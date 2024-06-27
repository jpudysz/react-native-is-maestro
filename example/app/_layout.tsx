import { Image, View, StyleSheet } from 'react-native'
import 'react-native-reanimated'
// import { isMaestro } from 'react-native-is-maestro'

const RootLayout = () => (
    <View>
        <Image
            style={styles.reactLogo}
            source={require('../assets/images/react-logo.png')}
        />
        {/*<Text>*/}
        {/*    isMaestro detected: {isMaestro() ? 'yes' : 'no'}*/}
        {/*</Text>*/}
    </View>
)

export default RootLayout

const styles = StyleSheet.create({
    reactLogo: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
    },
    logo: {
        height: 200,
        width: 200
    }
})
