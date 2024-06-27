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
        },
        rules: {
            '@typescript-eslint/no-unsafe-return': 'off',
            '@typescript-eslint/ban-ts-comment': 'off',
            'no-underscore-dangle': 'off'
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
