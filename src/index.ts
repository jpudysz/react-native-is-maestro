import { NativeModules } from 'react-native'

type IsMaestroNativeModule = {
    isMaestro(): boolean
}

const IsMaestroModule = NativeModules?.IsMaestro as IsMaestroNativeModule

if (!IsMaestroModule) {
    throw new Error('react-native-is-maestro is not installed')
}

export const isMaestro = (): boolean => IsMaestroModule.isMaestro()
