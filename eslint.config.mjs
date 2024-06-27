import codemaskRules from 'eslint-config-codemask'
import reactNative from 'eslint-plugin-react-native'
import { fixupPluginRules } from '@eslint/compat'

export default [
    ...codemaskRules,
    {
        languageOptions: {
            globals: {
                NodeJS: 'readonly',
                JSX: 'readonly'
            }
        },
        plugins: {
            'react-native': fixupPluginRules(reactNative)
        }
    },
    {
        "ignores": [
            'lib/**',
            'example/.expo/**',
            'example/**/*.js',
            '*.js',
            '*.mjs',
        ]
    }
]
