import { NativeModules, Platform } from 'react-native'

const LINKING_ERROR =
    `The package 'react-native-is-maestro' doesn't seem to be linked. Make sure: \n\n` +
    Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
    '- You rebuilt the app after installing the package\n' +
    '- You are not using Expo Go\n'

// @ts-expect-error
const isTurboModuleEnabled = global.__turboModuleProxy != null

const IsMaestroModule = isTurboModuleEnabled ? require('./NativeIsMaestro').default : NativeModules.IsMaestro

const IsMaestro = IsMaestroModule
    ? IsMaestroModule
    : new Proxy(
          {},
          {
              get() {
                  throw new Error(LINKING_ERROR)
              }
          }
      )

export function isMaestro(): boolean {
    return IsMaestro.isMaestro()
}
